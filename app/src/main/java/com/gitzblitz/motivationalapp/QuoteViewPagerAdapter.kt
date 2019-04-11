package com.gitzblitz.motivationalapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class QuoteViewPagerAdapter(fm: FragmentManager, fragments: List<QuoteFragment>):FragmentPagerAdapter(fm) {

     var fragmentList: List<QuoteFragment> = fragments

    override fun getItem(position: Int): Fragment {
        return this.fragmentList[position]
    }

    override fun getCount(): Int {
      return  this.fragmentList.size
    }
}