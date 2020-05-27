package com.envidual.rtfview.components

import android.view.View
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Tag
import com.envidual.rtfview.model.Token
import com.envidual.rtfview.util.TokenUtil

class BulletWrapper(
    private val label: RTFBuild
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return TokenUtil.split(tokens, '\n').flatMap { l ->
            val bullet = Token("\u25CF\t", emptyList()) // 25CF 2022 2219 26AB 2B24
            val line = Token("", listOf(Tag("SP", null)))
            listOf(bullet) + l + line
        }.dropLast(1).let {
            label.build(it)
        }
    }

}