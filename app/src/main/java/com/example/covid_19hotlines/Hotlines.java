package com.example.covid_19hotlines;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Hotlines extends AppCompatActivity {

    private RecyclerView hotlineRecyclerView;
    private HotlineAdapter hotlineAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotlines);

        hotlineRecyclerView = findViewById(R.id.rview);
        hotlineRecyclerView.setHasFixedSize(true);

        hotlineAdapter = new HotlineAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,
                false);
        fillStateHotlines();

        hotlineRecyclerView.setLayoutManager(linearLayoutManager);
        hotlineRecyclerView.setAdapter(hotlineAdapter);
        hotlineRecyclerView.setNestedScrollingEnabled(false);

    }


    public void fillStateHotlines(){
        String state = getIntent().getStringExtra("state").trim();
        String [] stateHotlines;
        switch (state){
            case "Abia" :
                 String[] abiaHotlines = {"07002242362", "0700ABIADOC"};
                 stateHotlines = abiaHotlines;
                hotlineAdapter.setHotlinesAdapterItem(stateHotlines);
                break;
            case "Adamawa" :
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
        

    }

}
