package com.envidual.rtfview.util

import com.envidual.rtfview.model.Token

object TokenUtil {

    fun split(tokens: List<Token>, char: Char): List<List<Token>> {
        val remaining = tokens.toMutableList()
        val output = mutableListOf(emptyList<Token>())

        do {
            val current = remaining.removeAt(0)

            if (current.content.isEmpty()) continue

            val parts = current.content.split(char)
            val first = parts.firstOrNull()

            if (first?.isNotEmpty() == true)
                output[output.lastIndex] = output[output.lastIndex] + Token(
                    first,
                    current.tags
                )


            output += parts.drop(1)
                .filter { it.isNotEmpty() }
                .map { listOf(Token(it, current.tags)) }

            if (parts.drop(1).lastOrNull()?.isEmpty() == true)
                output += emptyList<Token>()

        } while (remaining.isNotEmpty())

        return if (output.last().isEmpty()) output.dropLast(1) else output
    }

}

