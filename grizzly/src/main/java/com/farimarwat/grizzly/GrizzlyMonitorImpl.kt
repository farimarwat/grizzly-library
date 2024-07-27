package com.farimarwat.grizzly

import com.farimarwat.grizzly.anrmonitor.AnrMonitor
import com.farimarwat.grizzly.crashmonitor.CrashMonitor

internal class GrizzlyMonitorImpl(
    override var anrMonitor: AnrMonitor,
    override var crashMonitor: CrashMonitor
) :GrizzlyMonitor {
    override fun start() {
        crashMonitor.startMonitor()
        anrMonitor.startMonitor()
    }

    override fun stop() {
        crashMonitor.stopMonitor()
        anrMonitor.stopMonitor()
    }
}