package com.envidual.rtfview.core

import android.view.View
import com.envidual.rtfview.model.Token

interface RTFBuild {

    fun build(tokens: List<Token>): View

}