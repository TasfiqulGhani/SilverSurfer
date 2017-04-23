package com.buddybear;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewsFeedFirstPage extends AppCompatActivity {

    Button TopOne,TopTwo,TopThree,BottomOne,BottomTwo,BottomThree;
    ImageButton setting_btn;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_first_page);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        setting_btn = (ImageButton) findViewById(R.id.settings_button);

        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(NewsFeedFirstPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });


        TopOne=(Button)findViewById(R.id.topone);
        TopTwo=(Button)findViewById(R.id.toptwo);
        TopThree=(Button)findViewById(R.id.topthree);


        RelativeLayout lin2 = (RelativeLayout) findViewById(R.id.linBottomTwo);
        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(NewsFeedFirstPage.this, TodoFirstPage.class);

                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        RelativeLayout lin3 = (RelativeLayout) findViewById(R.id.linBottomThree);
        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(NewsFeedFirstPage.this, GamePartFirstPage.class);
               // startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        BottomOne=(Button)findViewById(R.id.bottomone);
        BottomTwo=(Button)findViewById(R.id.bottomtwo);
        BottomThree=(Button)findViewById(R.id.bottomthree);


        BottomThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(NewsFeedFirstPage.this, GamePartFirstPage.class);
              //  startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        BottomTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(NewsFeedFirstPage.this, TodoFirstPage.class);
                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });



    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ThreeFragment(), "Home");
        adapter.addFragment(new OneFragment(), "Instructions");
        adapter.addFragment(new TwoFragment(), "Videos");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
