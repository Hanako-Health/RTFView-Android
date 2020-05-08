package com.envidual.rtfview.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token
import com.santalu.aspectratioimageview.AspectRatioImageView

class ImageComponent(
    private val callback: RTFCallback,
    private val context: Context
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val v = AspectRatioImageView(context)
        v.ratio = 16f / 9f
        callback.event(tokens.first(), v)
        return v
    }

}