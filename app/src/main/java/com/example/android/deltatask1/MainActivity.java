package com.example.android.deltatask1;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.VolumeShaper;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Configuration config;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout l14= (LinearLayout) findViewById(R.id.liv);
        LinearLayout l13= (LinearLayout) findViewById(R.id.ag);

        l13.setVisibility(View.GONE);
        l14.setVisibility(View.GONE);
    }
    int lives=0,age=0,wins=0,loss=0,guess=0;
    String[] col = {"#00FF00","#96FF00","#96FA38","#97F264","#AAF582","#FF9696","#FF7878","#FF6464","#FF3232","#FF0000"};
    @Override
    public void onConfigurationChanged (Configuration newConfig)
    {config=newConfig;
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_2);
            TextView e = (TextView) findViewById(R.id.livecount);
            e.setText(" x " + lives);
            if(guess!=0) {
                RelativeLayout r20 = (RelativeLayout) findViewById(R.id.back2);
                r20.setBackgroundColor(Color.parseColor(col[guess / 10]));
            }
        }
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT&&f==0) {
            setContentView(R.layout.activity_main_2);
            TextView e = (TextView) findViewById(R.id.livecount);
            e.setText(" x " + lives);
            if(guess!=0)
            {EditText r = (EditText) findViewById(R.id.guess);

                r.setBackgroundColor(Color.parseColor("#363636"));

                LinearLayout l20 = (LinearLayout) findViewById(R.id.back);
                l20.setBackgroundColor(Color.parseColor(col[guess / 10]));

                ImageView l201 = (ImageView) findViewById(R.id.liveback);
                l201.setVisibility(View.GONE);
            }
        }
        super.onConfigurationChanged(newConfig);
    }


    public void setage(View view)
    {
        EditText e = (EditText) findViewById(R.id.age);
        age=Integer.parseInt(e.getText().toString());
        TextView t = (TextView) findViewById(R.id.ageshow);
        t.setText(""+age);
        LinearLayout l11 = (LinearLayout) findViewById(R.id.agelay);
        LinearLayout l13= (LinearLayout) findViewById(R.id.ag);
        l13.setVisibility(View.VISIBLE);
        l11.setVisibility(View.GONE);
    }
    public void setlives(View view)
    {
        EditText e = (EditText) findViewById(R.id.lives);
        lives=Integer.parseInt(e.getText().toString());
        TextView t = (TextView) findViewById(R.id.liveshow);
        t.setText(""+lives);
        LinearLayout l12 = (LinearLayout) findViewById(R.id.liveslay);
        LinearLayout l14= (LinearLayout) findViewById(R.id.liv);
        l14.setVisibility(View.VISIBLE);
        l12.setVisibility(View.GONE);

    }
    public void startclick(View view)
        {
            setContentView(R.layout.activity_main_2);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
            TextView e = (TextView) findViewById(R.id.livecount);
            e.setText(" x "+lives);
    }
    public void guesscheck(View view)
    {EditText e = (EditText) findViewById(R.id.guess);

     guess=Integer.parseInt(e.getText().toString());
     guess=Math.abs(age-guess);

     config=getResources().getConfiguration();
     if(config.orientation==Configuration.ORIENTATION_PORTRAIT) {
         ImageView l201 = (ImageView) findViewById(R.id.liveback);
         l201.setVisibility(View.GONE);
         e.setBackgroundColor(Color.parseColor("#363636"));
         LinearLayout l20 = (LinearLayout) findViewById(R.id.back);
         l20.setBackgroundColor(Color.parseColor(col[guess / 10]));
     }
     else if(config.orientation==Configuration.ORIENTATION_LANDSCAPE)
     {
         RelativeLayout r20 = (RelativeLayout) findViewById(R.id.back2);
                 r20.setBackgroundColor(Color.parseColor(col[guess/10]));
     }
        TextView v = (TextView) findViewById(R.id.livecount);
        v.setText(" x "+--lives);

        if(guess==0) {f = 1;
            result(1);

        }
        else if(lives==0)
        {f = 1;
            result(0);

        }
    }
    public void result(int decree)
    { setContentView(R.layout.activity_main_3);
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
      TextView t = (TextView) findViewById(R.id.last);

        if(decree==1)
    {TextView W = (TextView) findViewById(R.id.winshow);
     W.setText(""+(++wins));
        TextView L = (TextView) findViewById(R.id.lossshow);
        L.setText(""+(loss));
        t.setText("Won");
        t.setTextColor(Color.parseColor("#2196F3"));
    }
        else
        {TextView L = (TextView) findViewById(R.id.lossshow);
            L.setText(""+(++loss));
            TextView W = (TextView) findViewById(R.id.winshow);
            W.setText(""+(wins));
            t.setText("Lost");
            t.setTextColor(Color.parseColor("#FF3D00"));
        }
    }
    public void playagain(View view)
    {setContentView(R.layout.activity_main);
     guess=0;
     f=0;
    }
}
