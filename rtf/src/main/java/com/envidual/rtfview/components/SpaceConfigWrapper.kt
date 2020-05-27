package com.envidual.rtfview.components

import android.view.View
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Tag
import com.envidual.rtfview.model.Token

class SpaceConfigWrapper(
    private val wrapped: RTFBuild,
    private val callback: Callback
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return tokens.windowed(2) {
            callback.space(it.first(), it.last())?.let { s ->
                return@windowed listOf(
                    it.first(),
                    Token("", listOf(Tag("SP", s.toString())))
                )
            }
            listOf(it.first())
        }.flatten().let { wrapped.build(it + tokens.last()) }
    }

    interface Callback {

        fun space(first: Token, second: Token): Int?

    }

}