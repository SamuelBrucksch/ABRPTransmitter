package g4rb4g3.at.abrptransmitter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFERENCES_NAME = "preferences";
    public static final String PREFERENCES_TOKEN = "abrp_token";
    public static final String PREFERENCES_TRANSMIT_DATA = "transmit_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sp = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        final TextView textViewToken = findViewById(R.id.tv_abrp_token);
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

        final CheckBox checkBoxTransmitData = findViewById(R.id.cb_transmit);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
