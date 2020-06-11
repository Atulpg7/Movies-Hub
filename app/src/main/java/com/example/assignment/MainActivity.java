package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Urls of Movies posters
    final String url1="https://shorturl.at/vwAQV";
    final String url2="https://shorturl.at/FGHS6";
    final String url3="https://shorturl.at/egsJY";
    final String url4="https://shorturl.at/abeO1";
    final String url5="https://shorturl.at/dmAHW";

    //Customised adapter for showing movvvies in recycle view
    CustomAdapterMain adapter;

    //Recycle view for movies
    RecyclerView recyclerView;

    //arrayLists for title and Movies Lists. (Dummy Data for now)
    ArrayList<String> titleList=new ArrayList<>();
    ArrayList<String> movieList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Getting reference and Setting layout manager for recycler view
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        manager.setSmoothScrollbarEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(manager);


        //Adding Titles
        titleList.add("Kids' TV");
        titleList.add("Trending Now");
        titleList.add("Top 10 in India Today");
        titleList.add("Popular on Movies Hub");
        titleList.add("US TV Shows");


        //Adding Movies Poster
        movieList.add(url1);
        movieList.add(url2);
        movieList.add(url3);
        movieList.add(url4);
        movieList.add(url5);



        // Setting adapter in recycle view
        adapter=new CustomAdapterMain(this,titleList,movieList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
