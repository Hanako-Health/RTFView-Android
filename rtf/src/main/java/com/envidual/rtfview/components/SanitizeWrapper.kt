package com.envidual.rtfview.components

import android.view.View
import com.envidual.rtfview.core.RTFBuild
import com.envidual.rtfview.model.Token

class SanitizeWrapper(
    private val wrapped: RTFBuild
): RTFBuild {

    override fun build(tokens: List<Token>): View {
        return tokens.map {
            val text = it.content.replace(Regex.fromLiteral("\n\r|\r\n"), "\n")
            it.copy(content = text)
        }.let { wrapped.build(it) }
    }

}