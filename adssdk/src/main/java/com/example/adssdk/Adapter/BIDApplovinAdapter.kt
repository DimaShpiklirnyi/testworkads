package com.example.adssdk.Adapter

import android.content.Context
import com.applovin.sdk.AppLovinSdk
import com.example.adssdk.Adapters.BIDNetworkAdapterProtocol

class BIDApplovinAdapter(
    val context: Context,
    val bidNetworkAdapterProtocol: BIDNetworkAdapterProtocol,
    key: String
) {
    init {
            bidNetworkAdapterProtocol.onInitializationStart()
            AppLovinSdk.getInstance(key, null, context).mediationProvider = "max"
            AppLovinSdk.getInstance(key, null, context).initializeSdk {
                AppLovinSdk.SdkInitializationListener { sdkConfiguration ->
                    if (sdkConfiguration != null) {
                        bidNetworkAdapterProtocol.onInitializationComplete(true, null)
                    } else {
                        bidNetworkAdapterProtocol.onInitializationComplete(
                            false,
                            "AppLovin Initialization failed"
                        )
                    }
                }
            }




    }
}

