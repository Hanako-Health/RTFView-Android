package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.common.prefix
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class SegmentWrapper(
    private val callback: RTFCallback,
    private val selector: RTFBuild
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val output = LinearLayout(callback.ctxt)
        output.orientation = LinearLayout.VERTICAL

        var result = tokens

        do {
            val prefix = result.prefix { callback.type(it) }
            result = result.slice(prefix.size until result.size).toMutableList()
            output.addView(selector.build(prefix))
        } while (result.isNotEmpty())

        return output
    }

}