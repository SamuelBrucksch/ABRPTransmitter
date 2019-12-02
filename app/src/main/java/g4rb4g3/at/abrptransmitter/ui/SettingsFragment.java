package g4rb4g3.at.abrptransmitter.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import g4rb4g3.at.abrptransmitter.ABetterRoutePlanner;
import g4rb4g3.at.abrptransmitter.R;

public class SettingsFragment extends Fragment {

    public static final String PREFERENCES_NAME = "preferences";
    public static final String PREFERENCES_TOKEN = "abrp_token";
    public static final String PREFERENCES_TRANSMIT_DATA = "transmit_data";

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.settings, container, false);

        final SharedPreferences sp = getActivity().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        final TextView textViewToken = view.findViewById(R.id.tv_abrp_token);
        textViewToken.setText(sp.getString(PREFERENCES_TOKEN, ""));
        textViewToken.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                // save after every text change so we do not need save button
                SharedPreferences.Editor sped = sp.edit();
                sped.putString(PREFERENCES_TOKEN, textViewToken.getText().toString());
                sped.apply();
            }
        });

        final CheckBox checkBoxTransmitData = view.findViewById(R.id.cb_transmit);
        checkBoxTransmitData.setChecked(sp.getBoolean(PREFERENCES_TRANSMIT_DATA, false));
        checkBoxTransmitData.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // save after every toggle of checkbox so we do not need save button
                SharedPreferences.Editor sped = sp.edit();
                sped.putBoolean(PREFERENCES_TRANSMIT_DATA, isChecked);
                sped.apply();
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
