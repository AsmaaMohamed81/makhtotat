package com.makhtotat.ok.makhtotat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class allmkktota extends AppCompatActivity {
    List<Maktotat> Alist_Search = new ArrayList<>();
    EditText esarch;
    Button g,all;
    List<Maktotat> movies = new ArrayList<>();
    RecyclerView v;

    static int m;

    int j = IndianMoviesAdapter.position;

    public static int moviesStories[] = {
            15, 8, 225, 81, 84,
            8, 91, 55, 11, 22,
            13, 158, 19, 135, 336
            , 59, 9, 188, 44, 81
            ,173,155,13,23,159
            ,14,36,107,15,75
            ,88,70,21,45,185
            ,60,146,111,46,137
            ,329,63,58,196,88
            ,56,40,10,165,183
            ,162,23,20,170,46
            ,10,12,172,177,181
            ,177,179};

    static  String [] movienames =names.a;
    String[] posters = urlsrecycle.img;

    static boolean flag = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allmkktota);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/boahmed.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf


        esarch = (EditText) findViewById(R.id.Esearch);
        g = (Button) findViewById(R.id.g);

        all = (Button)findViewById(R.id.gg);

        v = (RecyclerView) findViewById(R.id.recyclerView);

Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < moviesStories.length; i++) {

            Maktotat movie =
                    new Maktotat(movienames[i], moviesStories[i], posters[i]);

            movies.add(movie);


        }
    }
});
        thread.start();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        IndianMoviesAdapter adapter = new IndianMoviesAdapter(movies, this, this);
        recyclerView.setAdapter(adapter);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                   for (int i = 0; i < moviesStories.length; i++) {

                       Maktotat movie =
                               new Maktotat(movienames[i], moviesStories[i], posters[i]);

                       movies.add(movie);


                   }

                   RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                   recyclerView.setLayoutManager(new LinearLayoutManager(allmkktota.this));
                   IndianMoviesAdapter adapter = new IndianMoviesAdapter(movies, allmkktota.this, allmkktota.this);
                   recyclerView.setAdapter(adapter);


            }
        });


    }

    public void search(View view) {

        flag=false;


        Alist_Search.clear();
        String item_search = esarch.getText().toString().trim();


        for (int i = 0; i < movienames.length; i++) {
            String item = movienames[i].toString();

            if (item.contains(item_search)) {

                Maktotat movie =
                        new Maktotat(movienames[i], moviesStories[i], posters[i]);
                Alist_Search.add(movie);

                m = i;


//                movies.add(movie);


            }
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        IndianMoviesAdapter adapter = new IndianMoviesAdapter(Alist_Search, this, this);
        recyclerView.setAdapter(adapter);

    }




}
