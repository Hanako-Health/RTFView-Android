package com.envidual.rtfview.model

fun Token.contains(tag: String): Boolean {
    return tags.map { it.type }.contains(tag)
}

fun Token.containsAny(tags: List<String>): Boolean {
    return this.tags.firstOrNull { tags.contains(it.type) } != null
}

fun Token.containsAll(tags: List<String>): Boolean {
    return this.tags.map { it.type }.containsAll(tags)
}

fun Token.containsAny(vararg tags: String) = containsAny(tags.toList())

fun Token.containsAll(vararg tags: String) = containsAll(tags.toList())