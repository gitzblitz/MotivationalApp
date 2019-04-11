package com.gitzblitz.motivationalapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_quote.*


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

        quoteTextView.text = quote
        quoteAuthor.text = author

        quoteCardView.setBackgroundResource(R.color.yellow_400)
        return view
    }

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
