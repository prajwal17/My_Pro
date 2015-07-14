package com.example.prajwal.my_pro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b= (Button) findViewById(R.id.button);
        ImageView img= (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.myanimation);
        img.startAnimation(animation1);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button)
        {
            Toast.makeText(getApplicationContext(),"Balance your life",Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.button)
        {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        }
    }
}
