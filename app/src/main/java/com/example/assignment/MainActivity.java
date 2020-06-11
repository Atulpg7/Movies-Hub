package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Urls of Movies posters
    final String url1="https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_SX300.jpg";
    final String url2="https://m.media-amazon.com/images/M/MV5BZjJiNjU4NmYtMTA5OS00N2QyLTgxNDMtMmM4OGE5N2RjYzllXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg";
    final String url3="https://m.media-amazon.com/images/M/MV5BOGE4NzU1YTAtNzA3Mi00ZTA2LTg2YmYtMDJmMThiMjlkYjg2XkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg";
    final String url4="https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg";
    final String url5="https://m.media-amazon.com/images/M/MV5BMTQ3MDM1MDU2NF5BMl5BanBnXkFtZTgwMzM3OTIzNzE@._V1_SX300.jpg";
    final String url6="https://m.media-amazon.com/images/M/MV5BMjE1NjQ5ODc2NV5BMl5BanBnXkFtZTgwOTM5ODIxNjE@._V1_SX300.jpg";
    final String url7="https://m.media-amazon.com/images/M/MV5BODA1ZTJjODQtNzZmYi00YThmLTg5N2MtODUwNGFiYjRkNzBlXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg";

    //Customised adapter for showing movies in recycle view
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
        titleList.add("Movies Hub Originals");
        titleList.add("Bollywood Hits");
        titleList.add("TV Comedies");
        titleList.add("New Releases");


        //Adding Movies Poster
        movieList.add(url1);
        movieList.add(url2);
        movieList.add(url3);
        movieList.add(url4);
        movieList.add(url5);
        movieList.add(url6);
        movieList.add(url7);



        // Setting adapter in recycle view
        adapter=new CustomAdapterMain(this,titleList,movieList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
