package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class TestComponent constructor(
    private val context: Context
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return View(context)
    }

}