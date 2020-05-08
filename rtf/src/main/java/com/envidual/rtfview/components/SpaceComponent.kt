package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class SpaceComponent(
    private val context: Context,
    private val space: Int
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val view =  View(context)
        view.layoutParams = ViewGroup.LayoutParams(0, space)
        return view
    }

}