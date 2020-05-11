package com.envidual.rtfview.components

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.cardview.widget.CardView
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class CardWrapper(
    private val callback: RTFCallback,
    private val wrapped: RTFBuild
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        var card = CardView(callback.ctxt)
        val style = callback.style(tokens.first(), card)
        if (style != null) card = CardView(callback.ctxt, null, style)
        card.addView(wrapped.build(tokens))
        return card
    }

}