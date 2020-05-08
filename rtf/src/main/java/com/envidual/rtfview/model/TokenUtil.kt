package com.envidual.rtfview.model

object TokenUtil {

    fun split(tokens: List<Token>, char: Char): List<List<Token>> {
        return tokens.fold(mutableListOf(emptyList<Token>())) { output, token ->
            if (token.content.isEmpty()) return output

            val parts = token.content.split(char)
            val first = parts.firstOrNull()

            if (first?.isNotEmpty() == true) output[-1] = output[-1] + Token(first, token.tags)

            output += parts.drop(1)
                .filter { it.isNotEmpty() }
                .map { listOf(Token(it, token.tags)) }

            if (parts.drop(1).lastOrNull()?.isEmpty() == true) output += emptyList<Token>()

            return output
        }
    }

}

fun <T, S> Collection<T>.prefix(selector: (T) -> S): List<T> {
    if (this.isEmpty()) return this.toList()
    val first = selector(this.first())
    return this.drop(1).takeWhile { selector(it) == first }
}