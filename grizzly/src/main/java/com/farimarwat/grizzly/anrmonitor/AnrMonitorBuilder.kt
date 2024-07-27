package com.farimarwat.grizzly.anrmonitor



internal object AnrMonitorBuilder {
    val TICKER_DEFAULT = 100L
    val THRESHOLD_DEFAULT = 4000L

    private var mThreshold: Long = THRESHOLD_DEFAULT
    private var mTicker: Long = TICKER_DEFAULT

    fun withTicker(ticker: Long): AnrMonitorBuilder {
        this.mTicker = ticker.coerceIn(1,500)
        return this
    }

    fun withThreshold(threshold: Long): AnrMonitorBuilder {
        this.mThreshold = threshold.coerceIn(1000, 4500)
        return this
    }

    fun build(): AnrMonitor = AnrMonitorImpl(mTicker, mThreshold)

}
