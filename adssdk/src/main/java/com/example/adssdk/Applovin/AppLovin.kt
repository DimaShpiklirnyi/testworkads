package com.example.adssdk.Applovin

import android.app.Activity
import android.content.Context
import android.widget.LinearLayout
import com.applovin.adview.AppLovinAdView
import com.applovin.adview.AppLovinInterstitialAd
import com.applovin.sdk.AppLovinAd
import com.applovin.sdk.AppLovinAdLoadListener
import com.applovin.sdk.AppLovinAdSize
import com.applovin.sdk.AppLovinSdk
import com.example.adssdk.Adapters.AppLovinBanner
import com.example.adssdk.Adapters.AppLovinInterstitial
import com.example.adssdk.AdsListener

class AppLovin(private val context: Context,private val adsListener: AdsListener) : AppLovinInitialization, AppLovinBanner, AppLovinInterstitial {

    override fun init(activity: Activity) {
        AppLovinSdk.initializeSdk(activity){
            adsListener.success("Applovin -- Init Success")
        }
    }

    override fun showBanner(linearLayout: LinearLayout) {
        val bannerAd = AppLovinAdView(AppLovinAdSize.BANNER, context)
        linearLayout.addView(bannerAd)
        bannerAd.loadNextAd()
    }

    override fun showInterstitial(activity: Activity) {
        val interstitialAd = AppLovinInterstitialAd.create(AppLovinSdk.getInstance(activity), activity)
        AppLovinSdk.getInstance(activity).adService.loadNextAd(
            AppLovinAdSize.INTERSTITIAL,
            object : AppLovinAdLoadListener {
                override fun adReceived(ad: AppLovinAd) {
                    interstitialAd.showAndRender(ad)
                }
                override fun failedToReceiveAd(errorCode: Int) {
                    adsListener.interstitialError("Applovin - $errorCode")
                }
            })
    }




}