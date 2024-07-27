package com.farimarwat.grizzly

import android.content.Context
import com.farimarwat.grizzly.anrmonitor.AnrMonitorBuilder
import com.farimarwat.grizzly.anrmonitor.AnrMonitorBuilder.THRESHOLD_DEFAULT
import com.farimarwat.grizzly.anrmonitor.AnrMonitorBuilder.TICKER_DEFAULT
import com.farimarwat.grizzly.crashmonitor.CrashMonitor
import com.farimarwat.grizzly.crashmonitor.CrashMonitorBuilder
import com.google.firebase.crashlytics.FirebaseCrashlytics


class GrizzlyMonitorBuilder(private val context: Context) {

    //AnrMonitor Params
    private var mTicker:Long = TICKER_DEFAULT
    private var mThreshold:Long = THRESHOLD_DEFAULT

    //CrashMonitor Params
    private var mTitle: String = "Application Error"
    private var mMessage: String = "An unexpected error occurred. Please restart the app."
    private var mFirebaseCrashlytics: FirebaseCrashlytics? = null


    fun withTicker(ticker:Long):GrizzlyMonitorBuilder{
        this.mTicker = ticker
        return this
    }
    fun withThreshold(threshold:Long):GrizzlyMonitorBuilder{
        this.mThreshold = threshold
        return this
    }

    fun withTitle(title:String):GrizzlyMonitorBuilder{
        this.mTitle = title
        return this
    }
    fun withMessage(message:String):GrizzlyMonitorBuilder{
        this.mMessage = message
        return this
    }
    fun withFirebaseCrashLytics(firebaseCrashlytics: FirebaseCrashlytics):GrizzlyMonitorBuilder{
        this.mFirebaseCrashlytics = firebaseCrashlytics
        return this
    }

    fun build():GrizzlyMonitor{
        return GrizzlyMonitorImpl(
            AnrMonitorBuilder
                .withTicker(mTicker)
                .withThreshold(mThreshold)
                .build(),
            CrashMonitorBuilder(context)
                .withTitle(mTitle)
                .withMessage(mMessage)
                .withFirebaseCrashlytics(mFirebaseCrashlytics)
                .build()
        )
    }
}