package com.example.testwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get
import com.applovin.mediation.ads.MaxAdView
import com.example.adssdk.AdsListener
import com.example.adssdk.AdsManager
import com.example.adssdk.Applovin.AppLovin
import com.example.adssdk.ApplovinMax.ApplovinMax
import com.example.adssdk.Liftoff.LiftOff
import com.example.adssdk.Unity.Unity

class MainActivity : AppCompatActivity(), AdsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adsServer = 0
        val radioGroup = findViewById<RadioGroup>(R.id.radioAds)
        val radioAppLovin = findViewById<RadioButton>(R.id.applovinBut)
        val radioAppLovinMax = findViewById<RadioButton>(R.id.applovinMaxBut)
        val radioLiftOff = findViewById<RadioButton>(R.id.liftoffBut)
        val radioUnity = findViewById<RadioButton>(R.id.unityBut)
        val buttonInter = findViewById<Button>(R.id.buttonInter)
        val buttonBanner = findViewById<Button>(R.id.buttonBanner)
        val bannerContainer = findViewById<LinearLayout>(R.id.bannerContainer)
        val bannerApplovinMax = findViewById<MaxAdView>(R.id.adView)
        val adsManager = AdsManager(this, this, applicationContext)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (i == radioAppLovin.id) {
                adsManager.appLovin().init(this)
                adsServer = 1
            }
            if (i == radioAppLovinMax.id) {
                adsServer = 2
                adsManager.appLovinMax().init()
            }
            if (i == radioLiftOff.id) {
                adsServer = 3
                adsManager.liftOff().init("647e1806e9bdb0a36fb6c0c5")
            }
            if (i == radioUnity.id) {
                adsManager.unity().init("5303154", true)
                adsServer = 4
            }
        }

        buttonInter.setOnClickListener {
            when(adsServer){
                1 -> {
                    adsManager.appLovin().showInterstitial(this)
                }
                2 -> {
                    adsManager.appLovinMax().showInterstitial("8143d0bb0419d923",this)
                }
                3 -> {
                    adsManager.liftOff().showInterstitial("INTER-8139840")
                }
                4 -> {
                    adsManager.unity().showInterstitial(this, "Interstitial_Android")
                }
            }
        }

        buttonBanner.setOnClickListener {
            when(adsServer){
                1 -> {
                    adsManager.appLovin().showBanner(bannerContainer)
                }
                2 -> {
                    bannerApplovinMax.visibility = View.VISIBLE
                    adsManager.appLovinMax().showBanner(bannerApplovinMax)
                }
                3 -> {
                    adsManager.liftOff().showBanner("DEFAULT-2528975", bannerContainer)
                }
                4 -> {
                    adsManager.unity().showBanner(this, bannerContainer, "Banner_Android")
                }
            }
        }


    }

    override fun success(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    override fun error(err: String) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show()
    }

    override fun bannerError(err: String) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show()
    }

    override fun interstitialError(err: String) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show()
    }

    override fun bannerClick() {
        Toast.makeText(this, "banner click", Toast.LENGTH_LONG).show()
    }

    override fun interstitialClick() {
        Toast.makeText(this, "intestitial click", Toast.LENGTH_LONG).show()
    }
}