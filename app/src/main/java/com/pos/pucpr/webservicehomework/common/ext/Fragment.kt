package com.pos.pucpr.webservicehomework.common.ext

import androidx.fragment.app.Fragment
import com.pos.pucpr.webservicehomework.ui.interfaces.MainProgressBarInterface

fun Fragment.showMainProgressBar() {
    if (requireActivity() is MainProgressBarInterface) {
        (requireActivity() as MainProgressBarInterface).showProgressBar()
    }
}

fun Fragment.hideMainProgressBar() {
    if (requireActivity() is MainProgressBarInterface) {
        (requireActivity() as MainProgressBarInterface).hideProgressBar()
    }
}
