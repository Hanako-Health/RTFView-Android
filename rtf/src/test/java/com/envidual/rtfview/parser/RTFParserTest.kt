package com.envidual.rtfview.parser

import com.envidual.rtfview.core.RTFParser
import org.junit.Test
import java.lang.Exception

abstract class RTFParserTest(
    val parser: RTFParser
) {

    @Test
    fun testEmptyInput() {
        // Arrange
        val input = ""

        // Act
        val result = parser.parse(input)

        // Assert
        assert(result.isEmpty())
    }

    @Test
    fun testAutoClosingTags() {
        val tag = "IMG"
        val parameter = "Bundle"
        val string = "[$tag=$parameter /]"
        val tokens = parser.parse(string)

        assert(tokens.size == 1)
        assert(tokens.first().tags.size == 1)
        assert(tokens.first().tags.first().type == tag)
        assert(tokens.first().tags.first().parameter == parameter)
    }

    @Test
    fun testAllMissingBracketCombinations() {
        val v = listOf(true, false)
        for (v0 in v) for (v1 in v) for (v2 in v) for (v3 in v)
            testFormattingError(
                "Start"
                        + (if(v0) "[" else "")
                        + "B"
                        + (if(v1) "]" else "")
                        + "Middle"
                        + (if(v2) "[" else "")
                        + "/B"
                        + (if(v3) "]" else "")
                        + "End"
            )
    }

    private fun testFormattingError(input: String) {
        try {
            parser.parse(input)
            assert(true)
        } catch (e: Exception) {
            println("Exception on input: $input")
            assert(false) {
                println(e)
            }
        }

    }



}