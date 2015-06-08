package com.example.sj.rating_webview_seek_bar;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    RatingBar ratingbr;
    Button btn;
    WebView web1;
    SeekBar seekbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratings();

        web1= (WebView)findViewById(R.id.webView);
        web1.loadUrl("http://www.google.co.in");

        seekbr=(SeekBar)findViewById(R.id.seekBar);
        seekbr.setOnSeekBarChangeListener(this);
    }

    public void onProgressChanged(SeekBar sekBar, int progress, boolean fromUser)
    {

        Toast.makeText(getApplicationContext(),"Seekbar Progress:" + progress, Toast.LENGTH_LONG).show();
    }

    public void onStartTrackingTouch(SeekBar sekBar)
    {
        Toast.makeText(getApplicationContext(),"Seekbar Progress Started:", Toast.LENGTH_SHORT).show();
    }

    public void onStopTrackingTouch(SeekBar sekBar)
    {
        Toast.makeText(getApplicationContext(),"Seekbar Progress Stopped:", Toast.LENGTH_SHORT).show();
    }

    public void ratings(){

        ratingbr=(RatingBar)findViewById(R.id.ratingBar);
        btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String rating= String.valueOf(ratingbr.getRating());
                Toast.makeText(getApplicationContext(), rating ,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
