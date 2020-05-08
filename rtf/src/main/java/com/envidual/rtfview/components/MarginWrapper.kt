package com.envidual.rtfview.components

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.appcompat.widget.LinearLayoutCompat
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class MarginWrapper(
    private val wrapped: RTFBuild,
    private val top: Int? = null,
    private val bottom: Int? = null,
    private val left: Int? = null,
    private val right: Int? = null,
    private val start: Int? = null,
    private val end: Int? = null
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val view = wrapped.build(tokens)
        view.layoutParams = view.layoutParams.let {
            when (it) {
                null -> ViewGroup.MarginLayoutParams(MATCH_PARENT, WRAP_CONTENT)
                is ViewGroup.MarginLayoutParams ->  ViewGroup.MarginLayoutParams(it)
                else -> ViewGroup.MarginLayoutParams(it)
            }
        }.apply {
            top?.let { topMargin = it }
            bottom?.let { bottomMargin = it }
            left?.let { leftMargin = it }
            right?.let { rightMargin = it }
            start?.let { marginStart = it }
            end?.let { marginEnd = it }
        }
        return view
    }

}