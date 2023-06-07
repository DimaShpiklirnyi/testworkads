package com.example.adssdk.Adapter

import com.example.adssdk.Adapters.BIDNetworkAdapterProtocol

class SDKEvents : BIDNetworkAdapterProtocol {
    var inProgress:Boolean = false
    override fun initializationInProgress(): Boolean {
        return inProgress
    }

    override fun onInitializationComplete(initialized: Boolean, error: String?) {
        if (error != null)
        {
            println("Kotlin Initialization failed with error: $error")
        }
        else
        {
            println("Kotlin Initialization completed")
        }

        inProgress = false
    }


    override fun onInitializationStart() {
        inProgress = true
        println("Initialization started")
    }
}