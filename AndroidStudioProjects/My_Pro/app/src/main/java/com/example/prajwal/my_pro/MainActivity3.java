package com.example.prajwal.my_pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity3 extends Activity {

    int[] images={R.drawable.image1,R.drawable.anantha,R.drawable.ardhachakra,R.drawable.ardhamatseyendra,
            R.drawable.astavakra,R.drawable.baddakona,R.drawable.baka,R.drawable.bala,
            R.drawable.dhanu,R.drawable.dimba,R.drawable.ekapadavipareetadhanda,R.drawable.ekapadkaundinya,
            R.drawable.ekapadashirsa,R.drawable.gandaberunda,R.drawable.garuda,R.drawable.hala,R.drawable.hanuma,
            R.drawable.janushirasa,R.drawable.karna,R.drawable.katichakra,R.drawable.kona,
            R.drawable.kukkuta,R.drawable.kurma,R.drawable.makara,R.drawable.makaraadhomukhasvana,R.drawable.marjaria,
            R.drawable.matsya,R.drawable.mayura,R.drawable.nataraj,R.drawable.nauka,R.drawable.nava,R.drawable.omkara,
            R.drawable.padma,R.drawable.padmabaka,R.drawable.padmashirsa,R.drawable.paschim,R.drawable.paschimnamaskara,
            R.drawable.pawanamukta,R.drawable.poornachakra,R.drawable.poornadhanu,R.drawable.poorvottana,R.drawable.prasaritapadahasta,
            R.drawable.rajakapota,R.drawable.salambabhujanga,R.drawable.sarvanga,R.drawable.sasaka,R.drawable.sava,
            R.drawable.setubanda,R.drawable.shirsha,R.drawable.suptabaddha,R.drawable.suptabeka,R.drawable.tada,
            R.drawable.tittiba,R.drawable.trikona,R.drawable.ustra,R.drawable.utkata,R.drawable.vajra,R.drawable.vasistha,
            R.drawable.vimana,R.drawable.viparitakaranimudra,R.drawable.virabhadra,R.drawable.vruksha,R.drawable.vrustika,
            R.drawable.yogadanda};
    //String[] images={"https://www.dropbox.com/s/7fl85zldmkwb74x/ananthasana.jpg?dl=0","https://www.dropbox.com/home/myimages?preview=astavakra.jpeg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent=getIntent();
        if(intent!=null)
        {
            String name=intent.getStringExtra("Name");
            int position=intent.getIntExtra("position", 99);

            ImageView myImage= (ImageView) findViewById(R.id.image);

            myImage.setImageResource(images[position]);
            TextView myText= (TextView) findViewById(R.id.text);
            myText.setText("way to perform " + name);

        }

    }



}
