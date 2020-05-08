package com.envidual.rtfview.components

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.cardview.widget.CardView
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class CardWrapper(
    private val wrapped: RTFBuild,
    private val color: Int,
    private val radius: Float
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val result = wrapped.build(tokens)
        //result.layoutParams = result.layoutParams.also { it.height = WRAP_CONTENT }


        val card = CardView(result.context)
        card.radius = radius
        card.setCardBackgroundColor(color)
        card.addView(result)
        return card
    }

}