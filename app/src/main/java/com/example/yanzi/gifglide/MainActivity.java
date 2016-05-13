package com.example.yanzi.gifglide;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

public class MainActivity extends AppCompatActivity {
    Button load_glide;
    Button load_noglide;
    FrameLayout gif_parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        gif_parent = (FrameLayout)findViewById(R.id.gif_parent);
        load_glide = (Button)findViewById(R.id.load_glide);
        load_noglide = (Button)findViewById(R.id.load_noglide);
        load_glide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGifByGlide();
            }
        });
        load_noglide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGifByAndroidGifDrawable();
            }
        });
    }

    private void showGifByGlide(){
        gif_parent.removeAllViews();
        ImageView imageView = new ImageView(getApplicationContext());
        gif_parent.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        Glide.with(getApplicationContext())
                .load(R.drawable.demo)

                .into(imageView);
    }

    private void showGifByAndroidGifDrawable(){
        gif_parent.removeAllViews();

        ImageView imageView = new ImageView(getApplicationContext());

        gif_parent.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        GifDrawable gifDrawable = null;
        try {
            gifDrawable = new GifDrawable(getResources(), R.drawable.demo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImageDrawable(gifDrawable);

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
