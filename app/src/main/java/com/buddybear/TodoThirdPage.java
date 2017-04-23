package com.buddybear;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class TodoThirdPage extends AppCompatActivity {

    ImageButton setting_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_third_page);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setTypeface(font);

        TextView tv1 = (TextView) findViewById(R.id.textView3);
        String winner = getIntent().getStringExtra("percent");


            tv1.setText("Bingoo !");
            tv.setText("You are good to go !");





        Button fb = (Button) findViewById(R.id.facebookBTN);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFB();
            }
        });

        Button tweet = (Button) findViewById(R.id.twitterBTN);
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTwitter();
            }
        });

        setting_btn = (ImageButton) findViewById(R.id.settings_button);


        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(TodoThirdPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });





    }

    public void callFB(){
        String urlToShare = "I am at beach ! :D";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
// intent.putExtra(Intent.EXTRA_SUBJECT, "Foo bar"); // NB: has no effect!
        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);

// See if official Facebook app is found
        boolean facebookAppFound = false;
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                intent.setPackage(info.activityInfo.packageName);
                facebookAppFound = true;
                break;
            }
        }

// As fallback, launch sharer.php in a browser
        if (!facebookAppFound) {
            String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + urlToShare;
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
        }

        startActivity(intent);
    }
    public void callTwitter(){
        String tweetUrl = String.format("I am at beach ! :D",
                urlEncode("Tweet text"),
                urlEncode("http://kiusamisestvabaks.ee/soberkaruapp/"));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));

// Narrow down to official Twitter app, if available:
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                intent.setPackage(info.activityInfo.packageName);
            }
        }

        startActivity(intent);
    }

    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {

            throw new RuntimeException("URLEncoder.encode() failed for " + s);
        }
    }



}