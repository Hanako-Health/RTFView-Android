package com.envidual.rtfview.callback

import android.content.Context
import android.view.View
import androidx.core.view.ViewCompat
import com.envidual.rtfview.model.Token

interface RTFCallback {

    var context: Context

    fun type(token: Token): String?

    fun parameter(token: Token): String?

    fun event(token: Token, view: View)

}