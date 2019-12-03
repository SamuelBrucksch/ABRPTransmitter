package g4rb4g3.at.abrptransmitter.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import g4rb4g3.at.abrptransmitter.MainActivity;

public class ButtonReceiver extends BroadcastReceiver {
  private static int mCalls = 0;
  private static long mLastCall = 0;

  @Override
  public void onReceive(final Context context, Intent intent) {
    if (System.currentTimeMillis() - mLastCall > 2000) {
      mCalls = 0;
    }
    mLastCall = System.currentTimeMillis();
    mCalls++;
    if (mCalls == 2) {
      mCalls = 0;
      Intent i = new Intent(context, MainActivity.class);
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP); // do not start new task but use existing instead
      context.startActivity(i);
    }
  }
}
