package com.envidual.rtfview.components

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.*
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

open class LabelComponent(
    private val context: Context,
    private val color: Int,
    private val indent: Int
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val view = AppCompatTextView(context)
        view.text = buildString(tokens)
        return view
    }

    private fun buildString(tokens: List<Token>): SpannableString {
        val completeText = tokens.joinToString { it.content }
        val result = SpannableString(completeText)

        var index = 0
        for (token in tokens) {
            val end = token.content.length - 1
            val types = token.tags.map { it.type }
            val spans = mutableListOf<Any>(LeadingMarginSpan.Standard(0, 2))

            when {
                types.contains("U") -> spans += UnderlineSpan()
                types.containsAll(listOf("I", "B")) -> spans += StyleSpan(Typeface.BOLD_ITALIC)
                types.contains("I") -> spans += StyleSpan(Typeface.ITALIC)
                types.contains("B") -> spans += StyleSpan(Typeface.BOLD)
            }

            spans.forEach { result.setSpan(it, index, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) }

            index += token.content.length
        }

        listOf(
            TabStopSpan.Standard(indent),
            ForegroundColorSpan(color)
        ).forEach {
            result.setSpan(it, 0, completeText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        return result
    }

}