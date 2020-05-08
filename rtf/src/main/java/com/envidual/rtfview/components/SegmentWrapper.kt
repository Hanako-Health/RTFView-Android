package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token
import com.envidual.rtfview.model.prefix

class SegmentWrapper(
    private val callback: RTFCallback,
    private val selector: RTFBuild,
    private val context: Context
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val output = LinearLayout(context)
        output.orientation = LinearLayout.VERTICAL

        var result = tokens.toMutableList()

        do {
            val prefix = result.prefix { callback.type(it) }
            result = result.slice(prefix.size until result.size).toMutableList()
            output.addView(selector.build(prefix))
        } while (result.isNotEmpty())

        return output
    }

}