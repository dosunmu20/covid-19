package com.example.covid_19hotlines;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnStateClickListener {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    List<String> listofStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);

        adapter = new MyAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,
                false);
        fillStates();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

        public void fillStates(){

        String[] states = {"Abia", "Adamawa", "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno",
                "Cross River", "Delta", "Ebonyi", "Edo", "Ekiti", "Enugu", "Gombe", "Imo",
                "Jigawa", "Kaduna", "Kano", "Katsina", "Kebbi", "Kogi", "Kwara", "Lagos",
                "Nasarawa", "Niger", "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba",
                "Yobe", "Zamfara", "Abuja"};
             listofStates = Arrays.asList(states);


        adapter.setAdapterItem(listofStates);

        }


    @Override
    public void onStateClick(int position) {
        Toast.makeText(getApplicationContext(), "Item Clicked", Toast.LENGTH_SHORT).show();
//        final String state = listofStates.get(position);
//        Intent intent = new Intent(this, Hotlines.class);
//        intent.putExtra("state", state);
//        startActivity(intent);
    }
}
