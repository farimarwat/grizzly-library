package com.farimarwat.grizzly

import com.farimarwat.grizzly.anrmonitor.AnrMonitor
import com.farimarwat.grizzly.crashmonitor.CrashMonitor

interface GrizzlyMonitor{
    var anrMonitor:AnrMonitor
    var crashMonitor:CrashMonitor
    fun start()
    fun stop()
}