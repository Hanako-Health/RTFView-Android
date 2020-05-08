package com.envidual.rtfview.core

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.envidual.rtfview.R
import com.envidual.rtfview.components.EmptyComponent
import com.envidual.rtfview.parser.FlatParser

open class RTFView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    open val root: RTFBuild = EmptyComponent(context)
    open val parser: RTFParser = FlatParser()

    var text: String = ""
        set(value) {
            field = value
            rebuild()
            invalidate()
            requestLayout()
        }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RTFView,
            0,
            0
        ).apply {
            try {
                //text = getString(R.styleable.RTFView_text) ?: ""
            } finally {
                recycle()
            }
        }
    }

    private fun rebuild() {
        removeAllViews()
        build()
    }

    private fun build() {
        val parsed = parser.parse(text)
        val view = root.build(parsed)
        addView(view)
    }

}