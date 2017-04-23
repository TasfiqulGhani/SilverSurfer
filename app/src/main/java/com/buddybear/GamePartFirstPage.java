package com.buddybear;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GamePartFirstPage extends AppCompatActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    ImageButton setting_btn;
    String data = "";
    int select = 1;
    Button editText;
    Button plus, minus;
    int flag = 0;
    TextView txt ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part_first_page);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setTypeface(font);
        TextView tv1 = (TextView) findViewById(R.id.newTxt);
        tv1.setTypeface(font);

        setting_btn = (ImageButton) findViewById(R.id.settings_button);


        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(GamePartFirstPage.this, setting_page.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(GamePartFirstPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin2 = (RelativeLayout) findViewById(R.id.linBottomTwo);
        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(GamePartFirstPage.this, TodoFirstPage.class);

                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        BottomOne=(Button)findViewById(R.id.bottomone);
        BottomTwo=(Button)findViewById(R.id.bottomtwo);
        BottomThree=(Button)findViewById(R.id.bottomthree);


        Button btn = (Button) findViewById(R.id.button);
        plus = (Button)findViewById(R.id.button_plus);
        minus = (Button)findViewById(R.id.button_minus);
        editText = (Button)findViewById(R.id.editText);
        txt= (TextView)findViewById(R.id.textView);




        BottomOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(GamePartFirstPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        BottomTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(GamePartFirstPage.this, TodoFirstPage.class);

                startActivity(k);
                overridePendingTransition(0, 0);
                finish();

            }
        });



        editText.setText(select+"");
        // btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.as));
        //  btn.setBackgroundResource(as);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (select < 20) {
                    select++;
                    editText.setText(select + "");
                } else {
                    Toast.makeText(GamePartFirstPage.this, "20 küsimust on maksimaalne arve",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (select > 1) {
                    select--;
                    editText.setText(select + "");
                } else {
                    Toast.makeText(GamePartFirstPage.this, "Palun valige vähemalt üks",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(GamePartFirstPage.this,GamePartSecondPage.class);
                i.putExtra("key_name2",select+"");
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

    }

}
