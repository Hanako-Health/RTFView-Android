package com.envidual.rtfview.core

import com.envidual.rtfview.model.Token

interface RTFParser {

    fun parse(input: String): List<Token>

}