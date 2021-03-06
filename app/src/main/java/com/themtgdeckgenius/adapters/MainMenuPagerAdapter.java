package com.themtgdeckgenius.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.themtgdeckgenius.fragments.MainMenuItemsFragment;
import com.themtgdeckgenius.pocketbudget.MainMenuActivity;

public class MainMenuPagerAdapter
        extends FragmentPagerAdapter
        implements
        ViewPager.OnPageChangeListener{

    private MainMenuActivity gMainMenuActivityContext;
    private FragmentManager gFragmentManager;

    public MainMenuPagerAdapter(MainMenuActivity context, FragmentManager fm){
        super(fm);
        this.gFragmentManager = fm;
        this.gMainMenuActivityContext = context;
    }

    @Override
    public Fragment getItem(int position){
        position = MainMenuActivity.getRealPosition(position);
        MainMenuActivity.MAIN_MENU_FRAGMENTS frag = MainMenuActivity.MAIN_MENU_FRAGMENTS.getFragmentFromPosition(position);
        String action = gMainMenuActivityContext.getString(frag.getTitleId());

        return MainMenuItemsFragment.newInstance(gMainMenuActivityContext, action, frag);
    }

    @Override
    public int getCount(){
        return MainMenuActivity.PAGES * MainMenuActivity.LOOPS;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels){
    }

    @Override
    public void onPageSelected(int position){
    }

    @Override
    public void onPageScrollStateChanged(int state){
    }

}
