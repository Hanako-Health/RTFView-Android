package com.envidual.rtfview.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.LinearLayoutCompat
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class ButtonWrapper(
    private val context: Context,
    private val callback: RTFCallback,
    private val label: RTFBuild,
    private val drawable: Drawable?
): RTFBuild {

    constructor(context: Context, callback: RTFCallback, label: RTFBuild, drawable: Int):
            this(context, callback, label, context.getDrawable(drawable))

    override fun build(tokens: List<Token>): View {
        val layout = LinearLayoutCompat(context)
        val view = label.build(tokens)
        val imageView = AppCompatImageView(context)

        imageView.setImageDrawable(drawable)

        layout.addView(view)
        layout.addView(imageView)

        return layout
    }

}