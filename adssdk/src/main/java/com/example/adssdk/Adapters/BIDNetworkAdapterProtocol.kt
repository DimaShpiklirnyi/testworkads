package com.example.adssdk.Adapters

interface BIDNetworkAdapterProtocol {
    fun initializationInProgress():Boolean
    fun onInitializationComplete(initialized: Boolean, error: String?)
    fun onInitializationStart()
}