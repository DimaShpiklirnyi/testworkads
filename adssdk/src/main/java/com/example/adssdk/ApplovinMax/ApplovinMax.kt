package com.example.adssdk.ApplovinMax

import android.app.Activity
import android.content.Context
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxAdView
import com.applovin.mediation.ads.MaxInterstitialAd
import com.applovin.sdk.AppLovinSdk
import com.example.adssdk.Adapters.ApplovinMaxBanner
import com.example.adssdk.Adapters.ApplovinMaxInterstitial
import com.example.adssdk.AdsListener

class ApplovinMax(private val context: Context, private val adsListener: AdsListener) : AppLovinMaxInitialization, ApplovinMaxBanner, ApplovinMaxInterstitial {
    override fun init() {
        AppLovinSdk.getInstance(context).mediationProvider = "max"
        AppLovinSdk.getInstance(context).initializeSdk {
            adsListener.success("AplovinMax -- Init Success")
        }
    }

    override fun showBanner(view: MaxAdView) {
        view.loadAd()
    }

    override fun showInterstitial(id: String, activity: Activity) {
        val interstitialAd = MaxInterstitialAd(id, activity)
        val maxAdListener = object : MaxAdListener{
            override fun onAdLoaded(p0: MaxAd?) {
                if ( interstitialAd.isReady)
                {
                    interstitialAd.showAd()
                }
            }

            override fun onAdDisplayed(p0: MaxAd?) {}

            override fun onAdHidden(p0: MaxAd?) {}

            override fun onAdClicked(p0: MaxAd?) {}

            override fun onAdLoadFailed(p0: String?, p1: MaxError?) {
                adsListener.interstitialError("AppLovin -- $p1")
            }

            override fun onAdDisplayFailed(p0: MaxAd?, p1: MaxError?) { }

        }
        interstitialAd.setListener(maxAdListener)
        interstitialAd.loadAd()
    }
}