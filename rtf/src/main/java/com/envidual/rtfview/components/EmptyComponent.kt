package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class EmptyComponent(private val context: Context): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return View(context)
    }

}