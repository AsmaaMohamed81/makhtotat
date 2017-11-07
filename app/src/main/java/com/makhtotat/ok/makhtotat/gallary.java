package com.makhtotat.ok.makhtotat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import ooo.oxo.library.widget.TouchImageView;

public class gallary extends AppCompatActivity {
    Button next, back, about, dowen, first, end;
    TouchImageView img;
    int i;
    String ss1, ss2, ss3;
    int j = IndianMoviesAdapter.position;



    IndianMovie movie;


    ArrayList<String> gllary = new ArrayList<String>();
    int n = 0;
    int fir = 0;

    public static int v = 0;
    public static   int save = 0;

    ArrayList<String> URLm = new ArrayList<>();
 static    int y;
    String urll = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/boahmed.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf



        Urls url = new Urls();
        url.url();
       /* if(allmkktota.flag==false) {
             urll = Urls.uu.get(allmkktota.m);

        }else { urll = Urls.uu.get(j);}*/

        Intent intent = getIntent();



for ( y=0;y<names.a.length;y++){
    if (names.a[y].equals(intent.getStringExtra("title"))){
        urll = Urls.uu.get(y);
        v=y+1;
        save=y;


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
        about = (Button) findViewById(R.id.about);

        first = (Button) findViewById(R.id.first);
        end = (Button) findViewById(R.id.end);

        dowen = (Button) findViewById(R.id.dwnload);


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


        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 0;
                Picasso.with(getApplicationContext()).load(gllary.get(n)).into(img);


            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = allmkktota.moviesStories[j] - 1;
                Picasso.with(getApplicationContext()).load(gllary.get(n)).into(img);


            }
        });

        dowen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(gallary.this, "تم الحفظ", Toast.LENGTH_SHORT).show();
                Picasso.with(getApplicationContext()).load(gllary.get(n)).into(targetg);

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //  Toast.makeText(gallary.this,v+ "", Toast.LENGTH_SHORT).show();

                Intent n = new Intent(gallary.this, com.makhtotat.ok.makhtotat.View.class);
                startActivity(n);


            }
        });
    }

//    private Target target = new Target() {
//        @Override
//        public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    File sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//                    File folder = new File(sd, "/Picasso/");
//                    if (!folder.exists()) {
//                        if (!folder.mkdir()) {
//                            Log.e("ERROR", "Cannot create a directory!");
//                        } else {
//                            folder.mkdir();
//                        }
//                    }
//
//                    File[] fileName = {new File(folder, "one.jpg"), new File(folder, "two.jpg")};
//
//                    for (int i=0; i<fileName.length; i++) {
//
//                        if (!fileName[i].exists()) {
//                            try {
//                                fileName[i].createNewFile();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//
//                            try {
//                                FileOutputStream outputStream = new FileOutputStream(String.valueOf(fileName[i]));
//                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//                                outputStream.close();
//
//                            } catch (FileNotFoundException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                    }
//
//                }
//            }).start();
//
//        }
//
//        @Override
//        public void onBitmapFailed(Drawable errorDrawable) {
//
//        }
//
//        @Override
//        public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//        }
//    };

    private Target targetg = new Target() {
        @Override
        public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
            new Thread(new Runnable() {
                @Override
                public void run() {

int ii = 0;
                    Calendar calendar = Calendar.getInstance();


                    File filepath = Environment.getExternalStorageDirectory();
                    File filee = null;
                    File file = null;

                    File myImageFile = new File(filepath.getAbsolutePath(), "/مخطوطات/");
                    for (int i =0 ; i <names.a.length ; i++) {
                        filee = new File(myImageFile + "/ " + names.a[save] + "/");

                        filee.mkdirs();

                    }
                    file = new File(filee, "imge_" + n + ".png");

                    // Create a name for the saved image
                    //File file = new File(filee, "myimage.png");


                    try {
                        file.createNewFile();

                        FileOutputStream ostream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG,100,ostream);
                        ostream.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {}

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {}
    };

}
