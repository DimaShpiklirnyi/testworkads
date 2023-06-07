package com.example.adssdk.Adapters

import android.app.Activity
import android.widget.LinearLayout

interface UnityBanner {
    fun showBanner(activity: Activity, linearLayout: LinearLayout, adUnitId : String)
}