package com.gitzblitz.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.gitzblitz.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

/**
 * Created by george.ngethe on 28/03/2018.
 */
class QuoteData {
    lateinit var quoteArrayList: ArrayList<Quote>

    fun getQuotes(callback: QuoteListAsyncResponse): Unit {
        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"

        val quoteRequest = JsonArrayRequest(Request.Method.GET, url, Response.Listener { response: JSONArray ->
            try {

                for (i in 0 until response.length()) {
                    var quoteObject = response.getJSONObject(i)
                    var quote = Quote(quoteObject.getString("quote"), quoteObject.getString("name"))
//                  Log.d("Quotes:", quote.author)
                    quoteArrayList.add(quote)

                }


            } catch (e: JSONException) {
                e.printStackTrace()
            }
            if (true) callback.processFinished(quoteArrayList)
        }, Response.ErrorListener { error: VolleyError ->
            try {
                Log.d("Error", "Not Working")
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        })
        AppController.instance?.addToRequestQueue(quoteRequest)
    }
}