package com.cyrillrx.logger.extension;

import com.cyrillrx.logger.LogChild;
import com.cyrillrx.logger.LogHelper;
import com.cyrillrx.logger.SeverityLogChild;

/**
 * A ready-to-use severity-aware {@link LogChild} wrapping <code>System.out#println(String)</code> class.
 *
 * @author Cyril Leroux
 *         Created on 18/10/2015.
 */
public class SystemOutLog extends SeverityLogChild {

    private final boolean detailedLogs;

    public SystemOutLog(int severity, boolean detailedLogs) {
        super(severity);
        this.detailedLogs = detailedLogs;
    }

    public SystemOutLog(int severity) { this(severity, false); }

    @Override
    protected void doLog(int severity, String tag, String rawMessage, Throwable throwable) {

        final String message = detailedLogs ? LogHelper.getDetailedLog(rawMessage) : rawMessage;

        if (throwable == null) {
            simpleLog(severity, tag, message);
            return;
        }

        final String stackTrace = LogHelper.getStackTrace(throwable);
        if (stackTrace == null) {
            simpleLog(severity, tag, message);
            return;
        }

        logWithStackTrace(severity, tag, message, stackTrace);
    }

    private static void simpleLog(int severity, String tag, String message) {
        println(LogHelper.simpleLog(severity, tag, message));
    }

    private static void logWithStackTrace(int severity, String tag, String message, String stackTrace) {
        println(LogHelper.logWithStackTrace(severity, tag, message, stackTrace));
    }

    /**
     * Prints a String into the "standard" output stream and then terminate the line.
     *
     * @param x The <code>String</code> to be printed.
     */
    private static void println(String x) { System.out.println(x); }

}
