package com.gitzblitz.motivationalapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


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

        quoteCardView.setBackgroundResource(R.color.light_blue_900)
        return view
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
