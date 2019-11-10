package g4rb4g3.at.abrptransmitter.abrp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.Arrays;

import cz.msebera.android.httpclient.Header;
import g4rb4g3.at.abrptransmitter.ABetterRoutePlanner;
import g4rb4g3.at.abrptransmitter.abrp.gson.DoubleTypeAdapter;
import g4rb4g3.at.abrptransmitter.abrp.gson.GsonRoutePlan;

public class RoutePlan {

    private static final String ABETTERROUTEPLANNER_URL = "https://api.iternio.com/1/tlm/get_latest_plan?";

    private static AsyncHttpClient asyncHttpClient;

    private IRoutePlan listener;
    private Gson gson;

    public RoutePlan() {
        asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.setTimeout(5000);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()));
        gson = builder.create();
    }

    public void addListener(IRoutePlan listener) {
        this.listener = listener;
    }

    public void removeListener() {
        this.listener = null;
    }

    private void parsePlanResponse(byte[] responseBody) {
        try {
            GsonRoutePlan gsonRoute = gson.fromJson(Arrays.toString(responseBody), GsonRoutePlan.class);
            listener.planReady(gsonRoute);
        } catch(Exception e) {
            Log.d(ABetterRoutePlanner.TAG, "Failed to parse JSON: " + e.toString());
            listener.planFailed();
        }
    }

    public void requestPlan(String userToken) {
        StringBuilder url = new StringBuilder(ABETTERROUTEPLANNER_URL)
                .append(ABetterRoutePlanner.ABETTERROUTEPLANNER_URL_TOKEN)
                .append("=").append(userToken)
                .append("&")
                .append(ABetterRoutePlanner.ABETTERROUTEPLANNER_URL_API_KEY)
                .append("=")
                .append(ABetterRoutePlanner.ABETTERROUTEPLANNER_API_KEY);

        asyncHttpClient.get(url.toString(), new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                parsePlanResponse(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e(ABetterRoutePlanner.TAG, String.valueOf(statusCode), error);
                listener.planFailed();
            }

            @Override
            public boolean getUseSynchronousMode() {
                return false;
            }
        });
    }
}
