package com.example.ok.makhtotat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ooo.oxo.library.widget.TouchImageView;

public class gallary extends AppCompatActivity {
    Button next, back, dwon;
    TouchImageView img;
    int i;
    String ss1, ss2, ss3;
    int j = IndianMoviesAdapter.position;



    IndianMovie movie;


    ArrayList<String> gllary = new ArrayList<String>();
    int n = 0;
  public static   int v = 0;

    ArrayList<String> URLm = new ArrayList<>();
 static    int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/boahmed.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf



        Urls url = new Urls();
        url.url();
        String urll="";
       /* if(allmkktota.flag==false) {
             urll = Urls.uu.get(allmkktota.m);

        }else { urll = Urls.uu.get(j);}*/

        Intent intent = getIntent();



for ( y=0;y<names.a.length;y++){
    if (names.a[y].equals(intent.getStringExtra("title"))){
        urll = Urls.uu.get(y);
        v=y+1;


    }
}

        try {


            for (i = 1; i < 10; i++) {

                gllary.add(urll + "DSC0000" + i + ".JPG");

            }


            for (i = 10; i < 99; i++) {

                gllary.add(urll + "DSC000" + i + ".JPG");

            }
            for (i = 99; i < 399; i++) {

                gllary.add(urll + "DSC00" + i + ".JPG");

            }


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }



        next = (Button) findViewById(R.id.next);
        dwon = (Button) findViewById(R.id.download);

        back = (Button) findViewById(R.id.back);
        img = (TouchImageView) findViewById(R.id.web);

        Picasso.with(getApplicationContext()).load(gllary.get(n)).into(img);


        try {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    new Thread(new Runnable() {
                        public void run() {
                            // a potentially  time consuming task

                            img.post(new Runnable() {
                                public void run() {

                                    //img.setImageURI(Uri.parse(gllary.get(n)));
                                    Picasso.with(getApplicationContext()).load(gllary.get(n+1)).into(img);
                                    //dwon.setText(gllary.get(n+1));


                                    if (n < allmkktota.moviesStories[j]-2){
                                        n++;}else {

                                        Toast tost=  Toast.makeText(gallary.this, "انتهت الصور", Toast.LENGTH_SHORT);
                                        View b = tost.getView();
                                        b.setBackgroundColor(Color.parseColor("#4E2F17"));
                                        tost.setGravity(Gravity.CENTER,0,0);
                                        tost.show();


                                    }
                                }
                            });
                        }
                    }).start();


                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // img.setImageURI(Uri.parse(gllary.get(n)));
                Picasso.with(getApplicationContext()).load(gllary.get(n)).into(img);
              //  dwon.setText(gllary.get(n));

                if (n > 0)
                    n--;
            }
        });

        dwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //  Toast.makeText(gallary.this,v+ "", Toast.LENGTH_SHORT).show();

                Intent n = new Intent(gallary.this, com.example.ok.makhtotat.View.class);
                startActivity(n);


            }
        });
    }

}
