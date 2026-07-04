package com.yori3o.esw_fabric.common.util;


import com.yori3o.esw_fabric.impl.PlatformUtil;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class LoggerUtil {

    
    private static final Logger LOGGER = LogManager.getLogger("esw_fabric");


    // ==================
    // These methods are needed to add [esw_fabric] to logs.
    // ==================

    public static final void info(String message) {
        if (PlatformUtil.isFabric()) {
            LOGGER.info("[esw_fabric]: " + message);
        } else {
            LOGGER.info(message);
        }
    }

    public static final void warn(String message) {
        if (PlatformUtil.isFabric()) {
            LOGGER.warn("[esw_fabric]: " + message);
        } else {
            LOGGER.warn(message);
        }
    }

    public static final void error(String message) {
        if (PlatformUtil.isFabric()) {
            LOGGER.error("[esw_fabric]: " + message);
        } else {
            LOGGER.error(message);
        }
    }

    public static final void errorWithException(String message, Exception e) {
        if (PlatformUtil.isFabric()) {
            LOGGER.error("[esw_fabric]: " + message, e);
        } else {
            LOGGER.error(message, e);
        }
    }

}