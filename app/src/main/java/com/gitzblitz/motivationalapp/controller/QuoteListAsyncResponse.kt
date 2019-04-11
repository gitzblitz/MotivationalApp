package com.gitzblitz.motivationalapp.controller

import com.gitzblitz.motivationalapp.model.Quote

interface QuoteListAsyncResponse {

    fun processFinished(quotes: ArrayList<Quote>)
}
