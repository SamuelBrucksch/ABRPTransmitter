package g4rb4g3.at.abrptransmitter.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import g4rb4g3.at.abrptransmitter.R;
import g4rb4g3.at.abrptransmitter.goingelectric.ChargerLocation;
import g4rb4g3.at.abrptransmitter.goingelectric.GoingElectric;
import g4rb4g3.at.abrptransmitter.goingelectric.IChargers;
import g4rb4g3.at.abrptransmitter.gson.goingelectric.ChargelocationGSON;
import g4rb4g3.at.abrptransmitter.gson.goingelectric.GoingElectricGSON;
import g4rb4g3.at.abrptransmitter.receiver.NaviGpsChangedReceiver;
import g4rb4g3.at.abrptransmitter.ui.chargers.ChargerEntryLayout;

public class ChargeFragment extends Fragment implements IChargers {

    private SharedPreferences sharedPrefs;
    private View view;

    private final String PREFERENCES_CCS_ENABLED = "ccsEnabled";
    private final String PREFERENCES_TYPE2_ENABLED = "type2Enabled";

    public static ChargeFragment newInstance() {
        return new ChargeFragment();
    }

    public void requestChargers(String plugs) {
        Toast.makeText(getContext(), "Requesting chargers", Toast.LENGTH_SHORT).show();
        GoingElectric.getInstance().requestChargers(plugs, NaviGpsChangedReceiver.getLastPosition());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GoingElectric.getInstance().removeListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.chargers, container, false);
        GoingElectric.getInstance().addListener(this);
        ImageButton b = view.findViewById(R.id.refreshButton);
        final CheckBox ccs = view.findViewById(R.id.ccsCheckbox);
        final CheckBox type2 = view.findViewById(R.id.type2Checkbox);

        final SharedPreferences sharedPrefs = getActivity().getSharedPreferences(SettingsFragment.PREFERENCES_NAME, Context.MODE_PRIVATE);
        boolean ccsEnabled = sharedPrefs.getBoolean(PREFERENCES_CCS_ENABLED, true);
        boolean type2Enabled = sharedPrefs.getBoolean(PREFERENCES_TYPE2_ENABLED, true);
        ccs.setChecked(ccsEnabled);
        type2.setChecked(type2Enabled);

        ccs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // save after every toggle of checkbox so we do not need save button
                SharedPreferences.Editor sped = sharedPrefs.edit();
                sped.putBoolean(PREFERENCES_CCS_ENABLED, isChecked);
                sped.apply();
            }
        });
        type2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // save after every toggle of checkbox so we do not need save button
                SharedPreferences.Editor sped = sharedPrefs.edit();
                sped.putBoolean(PREFERENCES_TYPE2_ENABLED, isChecked);
                sped.apply();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestChargers(ccs.isChecked() && type2.isChecked() ? "CCS,Typ2" : ccs.isChecked() ? "CCS" : type2.isChecked() ? "Typ2" : null);
            }
        });
        return this.view;
    }

    private ChargerEntryLayout createChargeLayout(ChargelocationGSON chargelocation, boolean toggle) {
        ChargerLocation chargerLocation = new ChargerLocation(chargelocation);
        return new ChargerEntryLayout(view.getContext(), toggle, chargerLocation, NaviGpsChangedReceiver.getLastPosition());
    }

    @Override
    public void chargersReady(GoingElectricGSON chargers) {
        Toast.makeText(getContext(), "Success!", Toast.LENGTH_SHORT).show();

        LinearLayout tl = view.findViewById(R.id.chargeTable);
        tl.removeAllViews(); // if chargers already existed

        List<ChargelocationGSON> chargeLocations = chargers.getChargelocations();
        boolean toggle = false;
        for (ChargelocationGSON chargeLocation : chargeLocations) {
            tl.addView(createChargeLayout(chargeLocation, toggle));
            toggle = !toggle;
        }
    }

    @Override
    public void chargersFailed() {
        Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();
    }
}
