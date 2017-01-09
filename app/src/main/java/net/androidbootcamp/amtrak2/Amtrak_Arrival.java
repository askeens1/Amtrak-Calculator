package net.androidbootcamp.amtrak2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Amtrak_Arrival extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amtrak__arrival);
        TextView Arrival_Time = (TextView) findViewById(R.id.textView3);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intMin = sharedPref.getInt("key1", 0);
        int intHour = sharedPref.getInt("key2", 0);
        int intTotalMinutes = sharedPref.getInt("key3", 0);

        int finalArrivalTimeHours;
        int finalArrivalTimeMinutes;

        finalArrivalTimeHours = ((intHour * 60 + intTotalMinutes) / 60)%24;

        finalArrivalTimeMinutes =(intMin + intTotalMinutes) % 60;

        java.text.DecimalFormat currency = new java.text.DecimalFormat("###,###.##");

        java.text.DecimalFormat currency2 = new java.text.DecimalFormat("###,###.##");

        Arrival_Time.setText("Arrival Time: " + (currency.format(finalArrivalTimeHours)) + (currency2.format(finalArrivalTimeMinutes)));

        if (1440 < (intHour * 60 + intMin + intTotalMinutes)) {
            image.setImageResource(R.drawable.notredeye);
        } else {
            image.setImageResource(R.drawable.redeye);
    }
}}


