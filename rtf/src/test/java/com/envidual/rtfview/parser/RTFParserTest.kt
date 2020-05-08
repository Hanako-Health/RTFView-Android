package com.envidual.rtfview.parser

import com.envidual.rtfview.core.RTFParser
import org.junit.Test

abstract class RTFParserTest(
    val parser: RTFParser
) {

    @Test
    fun testEmptyTags() {
        val tag = "IMG"
        val parameter = "Bundle"
        val string = "[$tag=$parameter /]"
        val tokens = parser.parse(string)

        assert(tokens.size == 1)
        assert(tokens.first().tags.size == 1)
        assert(tokens.first().tags.first().type == tag)
        assert(tokens.first().tags.first().parameter == parameter)
    }



}