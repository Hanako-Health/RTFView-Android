package com.envidual.rtfview.parser

import com.envidual.rtfview.core.RTFParser
import com.envidual.rtfview.model.Tag
import com.envidual.rtfview.model.Token

class FlatParser: RTFParser {

    var tagStart = '['
    var tagEnd = ']'
    var tagParameter = '='
    var tagClose = '/'

    override fun parse(input: String): List<Token> {
        val output = mutableListOf<Token>()
        val activeTags = mutableListOf<Tag>()
        var content = ""

        var tag = ""
        var param: String? = null
        var inside = false
        var close = false
        var index = 0

        loop@ while (index < input.length) {
            when(val c = input[index]) {
                tagStart -> {
                    if (content.isNotEmpty()) {
                        output += Token(content, activeTags.toList())
                        content = ""
                    }
                    inside = true
                }
                tagEnd -> {
                    if (inside) {
                        if (close) {
                            activeTags.withIndex()
                                .lastOrNull { it.value.type == tag }
                                ?.also { activeTags.removeAt(it.index) }
                        } else {
                            activeTags += Tag(tag, param)
                        }
                    }

                    tag = ""
                    param = null
                    inside = false
                    close = false
                }
                tagClose -> {
                    if (tag.isNotEmpty()) {
                        activeTags += Tag(tag, param)
                        output += Token("", activeTags.toList())
                    }

                    close = true
                }
                tagParameter -> {
                    param = input.drop(++index)
                        .takeWhile { !(it.isWhitespace() || it == tagEnd) }
                    index += param.length
                    continue@loop
                }
                else -> {
                    if (inside) {
                        if (!c.isWhitespace()) {
                            tag += c
                        }
                    } else {
                        content += c
                    }
                }
            }
            index++
        }

        if (content.isNotEmpty()) {
            output += Token(content, emptyList())
        }

        return output
    }

}