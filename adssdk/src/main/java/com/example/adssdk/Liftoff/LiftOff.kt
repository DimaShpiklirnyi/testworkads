package com.example.adssdk.Liftoff

import android.content.Context
import android.widget.LinearLayout
import com.example.adssdk.Adapters.LiftOffBanner
import com.example.adssdk.Adapters.LiftOffInterstitial
import com.example.adssdk.AdsListener
import com.vungle.warren.*
import com.vungle.warren.error.VungleException

class LiftOff(private val context: Context, private val adsListener: AdsListener) : LiftOffInitialization, LiftOffBanner, LiftOffInterstitial {

    override fun init(appId:String) {
        Vungle.init(appId, context, object : InitCallback {
            override fun onSuccess() {
                adsListener.success("LiftOff - Init Success")
            }
            override fun onError(exception: VungleException?) {
                adsListener.error("LiftOff - $exception")
            }
            override fun onAutoCacheAdAvailable(placementId: String?) {}
        })
    }

    override fun showBanner(placementId: String, linearLayout: LinearLayout) {
        val vungleLoadAdCallback: LoadAdCallback = object : LoadAdCallback {
            override fun onAdLoad(id: String) {

            }

            override fun onError(id: String, exception: VungleException) {
                adsListener.bannerError("LiftOff - $exception")
            }
        }
        val vunglePlayAdCallback: PlayAdCallback = object : PlayAdCallback {
            override fun onAdStart(id: String) {

            }

            @Deprecated(
                "Deprecated in Java",
                ReplaceWith("Log.d(\"mylog\", \"onAdEnd\")", "android.util.Log")
            )
            override fun onAdEnd(placementId: String?, completed: Boolean, isCTAClicked: Boolean) {

            }

            override fun onAdViewed(id: String) {

            }

            override fun onAdEnd(id: String) {

            }

            override fun onAdClick(id: String) {
                adsListener.bannerClick()
            }

            override fun onAdRewarded(id: String) {

            }

            override fun onAdLeftApplication(id: String) {

            }

            override fun creativeId(creativeId: String) {

            }

            override fun onError(id: String, exception: VungleException) {

            }
        }
        val bannerAdConfig = BannerAdConfig()
        bannerAdConfig.adSize = AdConfig.AdSize.BANNER
        Banners.loadBanner(placementId, bannerAdConfig, vungleLoadAdCallback)
        if (Banners.canPlayAd(placementId, bannerAdConfig.adSize)) {
            val vungleBanner =
                Banners.getBanner(placementId, bannerAdConfig, vunglePlayAdCallback)
            linearLayout.addView(vungleBanner)
        }
    }

    override fun showInterstitial(placementId: String) {
        val vungleLoadAdCallback: LoadAdCallback = object : LoadAdCallback {
            override fun onAdLoad(id: String) {


            }

            override fun onError(id: String, exception: VungleException) {

            }
        }
        val vunglePlayAdCallback: PlayAdCallback = object : PlayAdCallback {
            override fun onAdStart(id: String) {

            }

            @Deprecated(
                "Deprecated in Java",
                ReplaceWith("Log.d(\"mylog\", \"onAdEnd\")", "android.util.Log")
            )
            override fun onAdEnd(placementId: String?, completed: Boolean, isCTAClicked: Boolean) {

            }

            override fun onAdViewed(id: String) {

            }

            override fun onAdEnd(id: String) {

            }

            override fun onAdClick(id: String) {
                adsListener.interstitialClick()
            }

            override fun onAdRewarded(id: String) {

            }

            override fun onAdLeftApplication(id: String) {

            }

            override fun creativeId(creativeId: String) {

            }

            override fun onError(id: String, exception: VungleException) {
                adsListener.interstitialError("LiftOff - $exception")
            }
        }
        Vungle.loadAd(placementId, vungleLoadAdCallback)
        if (Vungle.canPlayAd(placementId)) {
            Vungle.playAd(placementId, null, vunglePlayAdCallback)
        }
    }
}