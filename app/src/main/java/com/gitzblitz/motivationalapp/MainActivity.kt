package com.gitzblitz.motivationalapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.gitzblitz.motivationalapp.controller.AppController
import com.gitzblitz.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInfo("https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20")
    }

    fun getInfo(url: String) {
        val quoteRequest = JsonArrayRequest(Request.Method.GET, url, Response.Listener { response: JSONArray ->
            try {

                for (i in 0 until response.length()) {
                    var quoteObject = response.getJSONObject(i)
                    var quote = Quote(quoteObject.getString("quote"), quoteObject.getString("name"))

                                    Log.d("Quotes:", quote.author)

                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
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
