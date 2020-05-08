package com.envidual.rtfview.common

fun <T, S> Collection<T>.prefix(selector: (T) -> S): List<T> {
    if (this.isEmpty()) return this.toList()
    val first = selector(this.first())
    return this.takeWhile { selector(it) == first }
}