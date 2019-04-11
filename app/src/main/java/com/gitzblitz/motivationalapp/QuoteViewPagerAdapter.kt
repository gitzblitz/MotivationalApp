package com.gitzblitz.motivationalapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.gitzblitz.motivationalapp.model.Quote

class QuoteViewPagerAdapter(fm: FragmentManager, fragments: ArrayList<Fragment>):FragmentPagerAdapter(fm) {

     var fragmentList: ArrayList<Fragment> = fragments

    override fun getItem(position: Int): Fragment {
        return this.fragmentList[position]
    }

    override fun getCount(): Int {
      return  this.fragmentList.size
    }
}