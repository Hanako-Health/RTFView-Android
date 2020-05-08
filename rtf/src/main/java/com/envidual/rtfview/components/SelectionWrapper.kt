package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class SelectionWrapper(
    private val callback: RTFCallback,
    private val mapping: Map<String?, RTFBuild>
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return tokens.firstOrNull()
            ?.let { callback.type(it) }
            .let { mapping[it] }
            ?.build(tokens)
            ?: View(callback.ctxt)
    }

}