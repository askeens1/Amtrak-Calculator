package net.androidbootcamp.amtrak2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intMin;
    int intHour;
    int intTotalMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText minutes = (EditText)findViewById(R.id.editText2);
        final EditText hours = (EditText)findViewById(R.id.editText);
        final EditText total_minutes = (EditText)findViewById(R.id.editText3);
        Button button = (Button)findViewById(R.id.button);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intMin = Integer.parseInt(minutes.getText().toString());
                intHour = Integer.parseInt(hours.getText().toString());
                intTotalMinutes = Integer.parseInt(total_minutes.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intMin);
                editor.putInt("key2", intHour);
                editor.putInt("key3", intTotalMinutes);
                editor.commit();
                if (intMin > 59) {
                    startActivity(new Intent(MainActivity.this, Over_Minutes.class));
                } else if (intHour > 23) {
                    startActivity(new Intent(MainActivity.this, Over_Hours.class));
                } else if (intHour <= 23 & intMin <= 59) {
                    startActivity(new Intent(MainActivity.this, Amtrak_Arrival.class));
                }



            }
        });

    }
}


