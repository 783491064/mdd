package com.example.bjc.mymvp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bjc.mymvp.book.BookHomeFragment;
import com.example.bjc.mymvp.move.MovieHomeFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tlb);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        viewPager = (ViewPager) findViewById(R.id.vp);
        setUpWithViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tl);
        if(tabLayout !=null){
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.setupWithViewPager(viewPager);
        }
        initListener();
    }

    /**
     *
     * @param viewPager
     */
    private void setUpWithViewPager(ViewPager viewPager) {
        HomePagerAdapter homeAdapter=new HomePagerAdapter(getSupportFragmentManager());
        homeAdapter.addFragments(new MovieHomeFragment(),getResources().getString(R.string.home_move));
        homeAdapter.addFragments(new BookHomeFragment(),getResources().getString(R.string.home_book));
        viewPager.setAdapter(homeAdapter);
    }

    /**
     * 控件的点击监听
     */
    private void initListener() {
        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Snackbar.make(v,"点击了浮动按钮",Snackbar.LENGTH_INDEFINITE).setAction("Action",null).show();
                break;
        }
    }
    static class HomePagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments=new ArrayList<>();
        ArrayList<String> titles=new ArrayList<>();

        public HomePagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public void addFragments(Fragment fragment,String title){
            fragments.add(fragment);
            titles.add(title);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
