package g4rb4g3.at.abrptransmitter.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import g4rb4g3.at.abrptransmitter.ABetterRoutePlanner;

public class NaviGpsChangedReceiver extends BroadcastReceiver {
  public static final String EXTRA_LAT = "com.hkmc.telematics.gis.extra.LAT";
  public static final String EXTRA_LON = "com.hkmc.telematics.gis.extra.LON";
  public static final String EXTRA_ALT = "com.hkmc.telematics.gis.extra.ALT";

  public static Location getLastPosition() {
    return lastPosition;
  }

  private static Location lastPosition = new Location("");

  @Override
  public void onReceive(Context context, Intent intent) {
    double lat = intent.getDoubleExtra(EXTRA_LAT, 0);
    double lon = intent.getDoubleExtra(EXTRA_LON, 0);
    double alt = intent.getDoubleExtra(EXTRA_ALT, 0);

    if (lat == 0 && lon == 0 && alt == 0) return;

    lastPosition.setLatitude(lat);
    lastPosition.setLongitude(lon);
    lastPosition.setAltitude(alt);

    ABetterRoutePlanner.applyAbrpSettings(context);
    ABetterRoutePlanner.updateGps(lastPosition);
  }
}
