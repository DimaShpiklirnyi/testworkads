package com.example.adssdk

import android.app.Activity
import android.content.Context

import com.example.adssdk.Applovin.AppLovin
import com.example.adssdk.ApplovinMax.ApplovinMax
import com.example.adssdk.Liftoff.LiftOff
import com.example.adssdk.Unity.Unity

class AdsManager(private val activity: Activity, private val adsListener: AdsListener, private
val context: Context)  {

    fun appLovin():AppLovin{
        return AppLovin(activity, adsListener)
    }
    fun appLovinMax():ApplovinMax{
        return ApplovinMax(activity, adsListener)
    }
    fun liftOff():LiftOff{
        return LiftOff(context, adsListener)
    }
    fun unity():Unity{
        return Unity(activity, adsListener)
    }

}