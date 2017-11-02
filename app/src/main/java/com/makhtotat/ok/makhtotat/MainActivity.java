package com.makhtotat.ok.makhtotat;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button makhtota , nabza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/boahmed.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf


        makhtota= (Button)findViewById(R.id.makhtota);
        nabza = (Button)findViewById(R.id.nabza);

        makhtota.setTypeface(Typeface.SERIF);
        nabza.setTypeface(Typeface.SERIF);




        makhtota.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,allmkktota.class);
                startActivity(i);

            }
        });

        nabza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Nabza.class);
                startActivity(i);

            }
        });


    }
}
