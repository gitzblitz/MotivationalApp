package com.gitzblitz.motivationalapp.controller

import com.gitzblitz.motivationalapp.model.Quote

/**
 * Created by george.ngethe on 28/03/2018.
 */
class QuoteData {
  lateinit var  quoteArrayList: ArrayList<Quote >

  fun getQuotes(): Unit {
      val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"
  }
}