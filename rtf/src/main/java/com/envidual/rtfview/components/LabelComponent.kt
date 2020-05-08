package com.envidual.rtfview.components

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.*
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.appcompat.widget.AppCompatTextView
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token
import com.envidual.rtfview.model.contains

open class LabelComponent(
    private val callback: RTFCallback,
    private val indent: Int
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val view = AppCompatTextView(callback.ctxt)
        val text = tokens.joinToString("") { it.content }
        val spannable = SpannableString(text)
        val flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

        var index = 0
        for (token in tokens) {
            val end = index + token.content.length

            callback.style(token, view)?.also {
                spannable.setSpan(TextAppearanceSpan(callback.ctxt, it), index, end, flag)
            }
            if (token.contains("U")) spannable.setSpan(UnderlineSpan(), index, end, flag)
            if (token.contains("I")) spannable.setSpan(StyleSpan(Typeface.ITALIC), index, end, flag)
            if (indent > 0) {
                spannable.setSpan(LeadingMarginSpan.Standard(0, indent), index, end, flag)
                spannable.setSpan(TabStopSpan.Standard(indent), index, end, flag)
            }

            index += token.content.length
        }


        view.text = spannable
        return view
    }

}