package com.envidual.rtfview.components

import android.view.View
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token
import com.envidual.rtfview.model.TokenUtil

class EnumerationWrapper(
    private val label: RTFBuild
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return TokenUtil.split(tokens, '\n').withIndex().flatMap { l ->
            val number = Token("${l.index + 1}\t", emptyList())
            val line = Token("\n\n", emptyList())
            listOf(number) + l.value + line
        }.dropLast(1).let {
            label.build(it)
        }
    }

}