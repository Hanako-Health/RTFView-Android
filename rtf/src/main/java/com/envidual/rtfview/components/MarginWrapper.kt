package com.envidual.rtfview.components

import android.view.View
import android.view.ViewGroup
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
        val params = ViewGroup.MarginLayoutParams(view.layoutParams)

        top?.let { params.topMargin = it }
        bottom?.let { params.bottomMargin = it }
        left?.let { params.leftMargin = it }
        right?.let { params.rightMargin = it }
        start?.let { params.marginStart = it }
        end?.let { params.marginEnd = it }

        view.layoutParams = params
        return view
    }

}