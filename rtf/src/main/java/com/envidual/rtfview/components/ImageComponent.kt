package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token
import com.sherlockshi.widget.AspectRatioImageView

class ImageComponent(
    private val callback: RTFCallback
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val v = AspectRatioImageView(callback.ctxt)
        v.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        v.setWidthRatio(16)
        v.setHeightRatio(9)
        callback.event(tokens.first(), v)
        return v
    }

}