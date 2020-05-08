package com.envidual.rtfview.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import com.envidual.rtfview.callback.RTFCallback
import com.envidual.rtfview.common.toPx
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class SpaceComponent(
    private val callback: RTFCallback
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        val token = tokens.first()
        val param = callback.parameter(token)
        val space = param?.toInt()?.toPx() ?: 0

        val view =  View(callback.ctxt)
        view.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, space)
        return view
    }

}