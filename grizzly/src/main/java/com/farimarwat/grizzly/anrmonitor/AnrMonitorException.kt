package com.farimarwat.grizzly.anrmonitor

internal class AnrMonitorException(title:String, stacktrace:Array<StackTraceElement>):Throwable(title) {
    init {
        stackTrace = stacktrace
    }
}