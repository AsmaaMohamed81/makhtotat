package com.makhtotat.ok.makhtotat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Nabza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nabza);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/boahmed.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf

        TextView   textread=(TextView)findViewById(R.id.nabza);



        StringBuilder text=new StringBuilder();

        try {
            InputStream input = getAssets().open("nabza.txt");
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            try {
                String line;
                while ((line=br.readLine())!=null){
                    text.append(line+"\n");
                }

            }
            catch (IOException e){}
        } catch (IOException e) {
            e.printStackTrace();
        }

        textread.setText(text);
    }



}
