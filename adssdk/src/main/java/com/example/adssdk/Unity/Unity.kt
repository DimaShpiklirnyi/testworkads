package com.example.adssdk.Unity

import android.app.Activity
import android.content.Context
import android.widget.LinearLayout
import com.example.adssdk.Adapters.UnityBanner
import com.example.adssdk.Adapters.UnityInterstitial
import com.example.adssdk.AdsListener
import com.unity3d.ads.*
import com.unity3d.services.banners.BannerErrorInfo
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize

class Unity(private val context: Context, private val adsListener: AdsListener) : UnityInitialization, UnityInterstitial, UnityBanner {

    override fun init(unityGameID: String, testMode: Boolean) {
        val iUnityAdsInitializationListener = object : IUnityAdsInitializationListener{
            override fun onInitializationComplete() {
                adsListener.success("Unity - Init Success")
            }

            override fun onInitializationFailed(
                error: UnityAds.UnityAdsInitializationError?,
                message: String?
            ) {
                adsListener.error("Unity - $error")
            }

        }
        UnityAds.initialize(context, unityGameID, testMode, iUnityAdsInitializationListener)
    }

    override fun showInterstitial(activity: Activity ,adUnitId: String) {
        val showListener: IUnityAdsShowListener = object : IUnityAdsShowListener {
            override fun onUnityAdsShowFailure(
                placementId: String,
                error: UnityAds.UnityAdsShowError,
                message: String
            ) {
                adsListener.interstitialError("Unity - $error")
            }

            override fun onUnityAdsShowStart(placementId: String) {

            }

            override fun onUnityAdsShowClick(placementId: String) {
              adsListener.interstitialClick()
            }

            override fun onUnityAdsShowComplete(
                placementId: String,
                state: UnityAds.UnityAdsShowCompletionState
            ) {

            }
        }
        val loadListener: IUnityAdsLoadListener = object : IUnityAdsLoadListener {
            override fun onUnityAdsAdLoaded(placementId: String) {
                UnityAds.show(
                    activity,
                    adUnitId,
                    UnityAdsShowOptions(),
                    showListener
                )
            }

            override fun onUnityAdsFailedToLoad(
                placementId: String,
                error: UnityAds.UnityAdsLoadError,
                message: String
            ) {
               adsListener.interstitialError("Unity - $error")
            }
        }
        UnityAds.load(adUnitId, loadListener)
    }

    override fun showBanner(activity: Activity, linearLayout: LinearLayout, adUnitId: String) {
        val banner = BannerView(activity, adUnitId, UnityBannerSize(320, 50))
        val bannerListener = object : BannerView.IListener{
            override fun onBannerLoaded(bannerAdView: BannerView?) {
                linearLayout.addView(banner)
            }

            override fun onBannerClick(bannerAdView: BannerView?) {
                adsListener.bannerClick()
            }

            override fun onBannerFailedToLoad(
                bannerAdView: BannerView?,
                errorInfo: BannerErrorInfo?
            ) {
                adsListener.bannerError("Unity - $errorInfo")
            }

            override fun onBannerLeftApplication(bannerView: BannerView?) {
            }

        }
        banner.listener = bannerListener
        banner.load()

    }


}