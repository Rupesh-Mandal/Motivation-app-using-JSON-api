package com.kali.motivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.kali.motivation.R;
import com.kali.motivation.adapter.QuoteViewPagerAdapter;
import com.kali.motivation.data.QuoteData;
import com.kali.motivation.fragment.QuoteFragment;
import com.kali.motivation.inteface.QuoteListAsyncResponse;
import com.kali.motivation.modle.Quoet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        quoteViewPagerAdapter=new QuoteViewPagerAdapter(getSupportFragmentManager(),getFragment());
        viewPager.setAdapter(quoteViewPagerAdapter);

    }


    private List<Fragment> getFragment() {
        List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuote(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quoet> quoets) {
                for (int i = 0; i< quoets.size(); i++) {
                    QuoteFragment quoteFragment = new QuoteFragment().newInstance(quoets.get(i).getQuote(),quoets.get(i).getAuthor());
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdapter.notifyDataSetChanged();
            }
        });

        return fragmentList;
    }
}