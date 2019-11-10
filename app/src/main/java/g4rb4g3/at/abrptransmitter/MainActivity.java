package g4rb4g3.at.abrptransmitter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
  }

  @Override
  protected void onResume() {
    super.onResume();

    final SharedPreferences sp = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

    final TextView textViewToken = findViewById(R.id.tv_abrp_token);
    textViewToken.setText(sp.getString(PREFERENCES_TOKEN, ""));

    final CheckBox cbTrsansmitData = findViewById(R.id.cb_transmit);
    cbTrsansmitData.setChecked(sp.getBoolean(PREFERENCES_TRANSMIT_DATA, false));

    Button btSave = findViewById(R.id.save);
    btSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SharedPreferences.Editor sped = sp.edit();
        sped.putString(PREFERENCES_TOKEN, textViewToken.getText().toString());
        sped.putBoolean(PREFERENCES_TRANSMIT_DATA, cbTrsansmitData.isChecked());
        sped.commit();

        Toast.makeText(getApplicationContext(), getText(R.string.saved), Toast.LENGTH_LONG).show();
      }
    });
  }
}
