package com.envidual.rtfview.components

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.LinearLayoutCompat.HORIZONTAL
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.common.toPx
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class ButtonWrapper(
    private val callback: RTFCallback,
    private val label: RTFBuild,
    private val drawable: Int
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val view = label.build(tokens)
        val layout = LinearLayoutCompat(view.context)
        val imageView = AppCompatImageView(view.context)

        view.layoutParams = if (view.layoutParams == null) {
            LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        } else {
            LinearLayoutCompat.LayoutParams(view.layoutParams)
        }.apply {
            weight = 1f
        }
        imageView.setImageResource(drawable)
        imageView.layoutParams = LinearLayoutCompat.LayoutParams(24.toPx(), 24.toPx())

        layout.gravity = Gravity.CENTER
        layout.orientation = HORIZONTAL
        layout.addView(view)
        layout.addView(imageView)
        layout.setOnClickListener { callback.event(tokens.first(), view) }

        return layout
    }

}