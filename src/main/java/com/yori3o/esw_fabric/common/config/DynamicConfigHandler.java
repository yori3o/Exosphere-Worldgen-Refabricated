package com.yori3o.esw_fabric.common.config;



/**
 * This class stores instances of configs that are used everywhere.
 */
public class DynamicConfigHandler {


    public static ServerConfig sc = new ServerConfig();


    public static ServerConfig.Values server() {
        return sc.get();
    }

    public static void loadServer() {
        sc.load();
    }

}
