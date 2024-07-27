package com.farimarwat.grizzly.anrmonitor

import kotlin.time.Duration

 interface AnrMonitor {
    var mDuration:Long
    var mTicker:Long
    var mTester:Int
    var mThreshold:Long
    fun handleAnr(stack:Array<StackTraceElement>,duration: Long)
    fun startMonitor()
    fun stopMonitor()
}