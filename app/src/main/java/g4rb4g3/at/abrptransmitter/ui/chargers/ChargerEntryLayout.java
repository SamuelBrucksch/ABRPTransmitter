package g4rb4g3.at.abrptransmitter.ui.chargers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import g4rb4g3.at.abrptransmitter.R;
import g4rb4g3.at.abrptransmitter.goingelectric.ChargerLocation;

public class ChargerEntryLayout extends LinearLayout {

    public ChargerEntryLayout(Context context, boolean isBackgroundColorEnabled, final ChargerLocation entry, Location currentPosition) {
        super(context);

        if (isBackgroundColorEnabled) {
            setBackgroundColor(Color.rgb(220, 220, 220));
        }

        setGravity(Gravity.CENTER);
        setTextAlignment(TEXT_ALIGNMENT_CENTER);

        TextView name = new TextView(context);
        name.setPadding(5, 5, 5, 5);
        name.setGravity(Gravity.CENTER);
        name.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        name.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        name.setText(Html.fromHtml("<a href=\"https:" + entry.getUrl() + "\">" + entry.getName() + (entry.isFaulty() ? " (!)" : "") + "</a>"));
        name.setWidth(0);
        name.setMovementMethod(LinkMovementMethod.getInstance());
        addView(name, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.35f));

        TextView network = new TextView(context);
        network.setPadding(5, 5, 5, 5);
        network.setGravity(Gravity.CENTER);
        network.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        network.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        network.setText(entry.getNetwork());
        network.setWidth(0);
        addView(network, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.20f));

        TextView ccsCount = new TextView(context);
        ccsCount.setPadding(5, 2, 5, 2);
        ccsCount.setGravity(Gravity.CENTER);
        ccsCount.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        ccsCount.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        ccsCount.setText(entry.getCcsStalls() > 0 ? entry.getCcsStalls() + "\n" + entry.getCcsPower() : "");
        ccsCount.setWidth(0);
        addView(ccsCount, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.125f));

        TextView type2Count = new TextView(context);
        type2Count.setPadding(5, 2, 5, 2);
        type2Count.setGravity(Gravity.CENTER);
        type2Count.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        type2Count.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        type2Count.setText(entry.getType2Stalls() > 0 ? entry.getType2Stalls() + "\n" + entry.getType2Power() : "");
        type2Count.setWidth(0);
        addView(type2Count, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.125f));

        DecimalFormat df = new DecimalFormat("##.# km");
        TextView distance = new TextView(context);
        distance.setPadding(5, 5, 5, 5);
        distance.setGravity(Gravity.CENTER);
        distance.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        distance.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        distance.setText(df.format(entry.getDistanceTo(currentPosition)));
        distance.setWidth(0);
        addView(distance, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.10f));

        // TODO correct action?
        Button toNavi = new Button(context, null, R.attr.buttonStyleSmall);
        toNavi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.hkmc.intent.action.ACTION_ROUTE_SEARCH");
                intent.putExtra("com.hkmc.navi.EXTRA_LATITUDE", entry.getLatitude() + "");
                intent.putExtra("com.hkmc.navi.EXTRA_LONGITUDE", entry.getLongitude()+ "");
                intent.putExtra("com.hkmc.navi.EXTRA_KEYWORD", entry.getName());
                v.getContext().sendBroadcast(intent);
                intent = new Intent();
                intent.setAction("com.hkmc.telematics.gis.action.FROM_BROWSER_TO_NAVI");
                v.getContext().sendBroadcast(intent);
            }
        });
        toNavi.setPadding(5, 5, 5, 5);
        toNavi.setGravity(Gravity.CENTER);
        toNavi.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        toNavi.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        toNavi.setText("Navi");
        toNavi.setWidth(0);
        toNavi.setAllCaps(false);
        addView(toNavi, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.09f / 2.6f));
    }
}
