package com.gitzblitz.motivationalapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.concurrent.ThreadLocalRandom


/**
 * A simple [Fragment] subclass.
 *
 */
class QuoteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_quote, container, false)

        var quote = arguments?.get("quote").toString()
        var author = arguments?.get("author").toString()
        val quoteText = view.findViewById<TextView>(R.id.quoteTextView)
        val authorText = view.findViewById<TextView>(R.id.quoteAuthor)
        val quoteCardView = view.findViewById<CardView>(R.id.quoteCardView)

        quoteText.text = quote
        authorText.text = author

        val colors = intArrayOf(R.color.blue_500, R.color.red_500, R.color.green_500, R.color.cyan_500, R.color.pink_500, R.color.teal_500, R.color.amber_500, R.color.deep_orange_500)
        quoteCardView.setBackgroundResource(getRandomColor(colors))
        return view
    }


    internal fun getRandomColor(colors: IntArray):Int {
        var color: Int
        val quotesArrayLength = colors.size

        val randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLength)
        color = colors[randomNum]

        return color
    }

    companion object {

        fun newInstance(quote: String, author: String): QuoteFragment {

            val fragment = QuoteFragment()
            val bundle = Bundle()
            bundle.apply {
                putString("quote", quote)
                putString("author", author)
            }

            fragment.arguments = bundle

            return fragment
        }
    }


}
