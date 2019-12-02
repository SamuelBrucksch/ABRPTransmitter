package g4rb4g3.at.abrptransmitter.goingelectric;

import android.location.Location;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import g4rb4g3.at.abrptransmitter.gson.GSONDoubleTypeAdapter;
import g4rb4g3.at.abrptransmitter.gson.goingelectric.GoingElectricGSON;

public class GoingElectric {

    private static final String GOINGELECTRIC_URL = "https://api.goingelectric.de/chargepoints?";
    public static final String GOINGELECTRIC_URL_API_KEY = "key";
    public static final String GOINGELECTRIC_URL_API_LAT = "lat";
    public static final String GOINGELECTRIC_URL_API_LNG = "lng";
    public static final String GOINGELECTRIC_URL_API_RADIUS = "radius";
    public static final String GOINGELECTRIC_URL_API_ORDERBY = "orderby";
    public static final String GOINGELECTRIC_URL_API_PLUGTYPE = "plugs";
    public static final String GOINGELECTRIC_API_KEY = "INSERT YOU API KEY HERE";

    private static AsyncHttpClient asyncHttpClient;

    private List<IChargers> listeners = new ArrayList<>();
    private Gson gson;

    private static GoingElectric instance;

    public static GoingElectric getInstance() {
        if (instance == null) {
            instance = new GoingElectric();
        }
        return instance;
    }

    private GoingElectric() {
        asyncHttpClient = new AsyncHttpClient(true, 80, 443);
        asyncHttpClient.setTimeout(5000);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new GSONDoubleTypeAdapter()));
        gson = builder.create();
    }

    public void addListener(IChargers listener) {
        this.listeners.add(listener);
    }

    public void removeListener(IChargers listener) {
        this.listeners.remove(listener);
    }

    private void parseChargersResponse(byte[] responseBody) {
        try {
            GoingElectricGSON goingElectricResult = gson.fromJson(new String(responseBody), GoingElectricGSON.class);
            for (IChargers listener : listeners) {
                listener.chargersReady(goingElectricResult);
            }
        } catch (Exception e) {
            Log.d("ABRPTransmitter", "Failed to parse JSON: " + e.toString());
            for (IChargers listener : listeners) {
                listener.chargersFailed();
            }
        }
    }

    public void requestChargers(String plugs, Location currentPosition) {
        StringBuilder url = new StringBuilder(GOINGELECTRIC_URL)
                .append(GOINGELECTRIC_URL_API_KEY)
                .append("=")
                .append(GOINGELECTRIC_API_KEY)
                .append("&")
                .append(GOINGELECTRIC_URL_API_LAT)
                .append("=")
                .append(currentPosition.getLatitude())
                .append("&")
                .append(GOINGELECTRIC_URL_API_LNG)
                .append("=")
                .append(currentPosition.getLongitude())
                .append("&")
                .append(GOINGELECTRIC_URL_API_RADIUS)
                .append("=")
                .append(25) // TODO configurable
                .append("&")
                .append(GOINGELECTRIC_URL_API_ORDERBY)
                .append("=")
                .append("distance");

        if (plugs != null) {
            url.append("&").append(GOINGELECTRIC_URL_API_PLUGTYPE).append("=");
            url.append(plugs);
        }

        Log.d("ABRPTransmitter", url.toString());
        asyncHttpClient.get(url.toString(), new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                parseChargersResponse(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("ABRPTransmitter", String.valueOf(statusCode), error);
                for (IChargers listener : listeners) {
                    listener.chargersFailed();
                }
            }

            @Override
            public boolean getUseSynchronousMode() {
                return false;
            }

        });
    }
}
