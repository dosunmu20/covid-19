package com.example.covid_19hotlines;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Hotlines extends AppCompatActivity implements HotlineAdapter.HotlineListener, View.OnClickListener{

    private RecyclerView hotlineRecyclerView;
    private HotlineAdapter hotlineAdapter;
    String [] stateHotlines;
    TextView backArrow;
    AppCompatTextView hotlineHeading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotlines);

        hotlineRecyclerView = findViewById(R.id.stateHotlineRV);
        backArrow = findViewById(R.id.backArrow);
        hotlineHeading = findViewById(R.id.hotlineHeading);

        hotlineAdapter = new HotlineAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,
                false);
        fillStateHotlines();
//        hotlineHeading.setText(getIntent().getStringExtra("state") + "State COVID-19 Helplines");

        hotlineRecyclerView.setLayoutManager(linearLayoutManager);
        hotlineRecyclerView.setAdapter(hotlineAdapter);
        hotlineRecyclerView.setNestedScrollingEnabled(false);

        backArrow.setOnClickListener(this);

    }


    @SuppressLint("SetTextI18n")
    public void fillStateHotlines(){
        String state = getIntent().getStringExtra("state");


            switch (state) {
                case "Abia":
                    stateHotlines = new String[]{"07002242362", "0700ABIADOC"};
                    break;
                case "Adamawa":
                    stateHotlines = new String[]{"08031230359", "07080601139"};
                    break;
                case "Benue":
                    stateHotlines = new String[]{"09018602439", "07025031214"};
                    break;
                case "Abuja":
                    stateHotlines = new String[]{"08099936312", "07080631500"};
                    break;
                case "Kogi":
                    stateHotlines = new String[]{"0704485619", "07088292249", "08095227003", "070433402122"};
                    break;
                case "Kwara":
                    stateHotlines = new String[]{"09062010001", "09062010002"};
                    break;
                case "Niger":
                    stateHotlines = new String[]{"08038246018", "0903093642", "08077213070"};
                    break;
                case "Plateau":
                    stateHotlines = new String[]{"07032864444", "08035422711", "08065486416", "08035779917"};
                    break;
                case "Kaduna":
                    stateHotlines = new String[]{"08035871662", "08025088304", "08032401473","08037808191"};
                    break;
                case "Kano":
                    stateHotlines = new String[]{"08039704476", "08037038597", "09093995444","09093995333"};
                    break;
                case "Katsina":
                    stateHotlines = new String[]{"09035037114", "09047092428"};
                    break;
                case "Sokoto":
                    stateHotlines = new String[]{"08032311116", "08022069567", "08035074228"};
                    break;
                case "Zamfara":
                    stateHotlines = new String[]{"08035871662", "08025088304", "08032401473","08037808191"};
                    break;
                case "Bauchi":
                    stateHotlines = new String[]{"08032717887", "08059600898", "08033698036","08036911698"};
                    break;
                case "Borno":
                    stateHotlines = new String[]{"08088159881", "08009999999"};
                    break;
                case "Gombe":
                    stateHotlines = new String[]{"08103371257"};
                    break;
                case "Taraba":
                    stateHotlines = new String[]{"08032501165", "08065508675"};
                    break;
                case "Yobe":
                    stateHotlines = new String[]{"08131834764", "07041116027"};
                    break;
                case "Akwa Ibom":
                    stateHotlines = new String[]{"09045575515", "07035211919", "08028442194"};
                    break;
                case "Bayelsa":
                    stateHotlines = new String[]{"08039216821", "07019304970", "08151693570"};
                    break;
                case "Cross River":
                    stateHotlines = new String[]{"09036281412", "08031230021"};
                    break;
                case "Delta":
                    stateHotlines = new String[]{"08033521961", "08035078541", "08030758179"};
                    break;
                case "Edo":
                    stateHotlines = new String[]{"08084096723", "08064258163"};
                    break;
                case "River":
                    stateHotlines = new String[]{"08056109538", "08031888093", "08033124313"};
                    break;
                case "Ondo":
                    stateHotlines = new String[]{"080COVID19", "08002684319", "0700COVID19","07002684319", "07001COVID19"};
                    break;
                case "Ogun":
                    stateHotlines = new String[]{"08188978392", "08188978392"};
                    break;
                case "Oyo":
                    stateHotlines = new String[]{"08038210122", "08023229267", "08073431342"};
                    break;
                case "Osun":
                    stateHotlines = new String[]{"08035025692", "08033908772"};
                    break;
                case "Ekiti":
                    stateHotlines = new String[]{"09062970434", "09062970435", "112"};
                    break;
                case "Lagos":
                    stateHotlines = new String[]{"080000CORONA", "08023169485", "08033565529"};
                    break;
                case "Anambra":
                    stateHotlines = new String[]{"08030953771", "08117567363", "08145434416"};
                    break;
                case "Enugu":
                    stateHotlines = new String[]{"08182555550", "117", "112"};
                    break;
                case "Ebonyi":
                    stateHotlines = new String[]{"09020332489"};
                    break;
                case "Imo":
                    stateHotlines = new String[]{"08099555577", "07087110839"};
                    break;
                default:
                    stateHotlines = new String[]{"080097000010"};

            }



        hotlineAdapter.setHotlinesAdapterItem(stateHotlines);
        hotlineHeading.setText(state + " State COVID-19 Helplines");

    }



    @Override
    public void onClickHotlineItem(int positon) {
        if (Build.VERSION.SDK_INT >= 23 ){

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                return;
            }
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + stateHotlines[positon]));
            startActivity(callIntent);
        } else {

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + stateHotlines[positon]));
            startActivity(callIntent);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
