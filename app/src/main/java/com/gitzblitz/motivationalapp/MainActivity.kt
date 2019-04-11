package com.gitzblitz.motivationalapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gitzblitz.motivationalapp.controller.QuoteData
import com.gitzblitz.motivationalapp.controller.QuoteListAsyncResponse
import com.gitzblitz.motivationalapp.model.Quote
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewPagerAdapter: QuoteViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewPagerAdapter  = QuoteViewPagerAdapter(supportFragmentManager, getFragments())

        viewPager.adapter = quoteViewPagerAdapter
    }

    private fun getFragments(): List<QuoteFragment> {
         var fragmentList: ArrayList<QuoteFragment> = arrayListOf()

        QuoteData().getQuotes(object : QuoteListAsyncResponse {
            override fun processFinished(quotes: ArrayList<Quote>) {

                for (i in 0 until quotes.size) {
                    var quoteFragment = QuoteFragment.newInstance(
                            quotes[i].quote, quotes[i].author)
                    fragmentList.add(quoteFragment)
                }
                quoteViewPagerAdapter.notifyDataSetChanged()

            }
        })

        return fragmentList
    }
}
