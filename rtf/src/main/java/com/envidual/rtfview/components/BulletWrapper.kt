package com.envidual.rtfview.components

import android.view.View
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token
import com.envidual.rtfview.model.TokenUtil

class BulletWrapper(
    private val label: RTFBuild
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return TokenUtil.split(tokens, '\n').flatMap { l ->
            val bullet = Token("\u2022\t", emptyList())
            val line = Token("\n\n", emptyList())
            listOf(bullet) + l + line
        }.dropLast(1).let {
            label.build(it)
        }
    }

}