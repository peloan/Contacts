package com.example.loan.contacts;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        ViewPager viewPager=(ViewPager)findViewById(R.id.pager);
        setupViewPagerAndFragment(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void setupViewPagerAndFragment(ViewPager viewPager)
    {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        //Thêm tab 1 nà
        adapter.addFragment(new Fragment1(), "CONTACTS");
        //tab 2
        adapter.addFragment(new Fragment(), "APPS");
        //tab 3
        adapter.addFragment(new Fragment3(), "PHOTO");
        viewPager.setAdapter(adapter);


    }
}
