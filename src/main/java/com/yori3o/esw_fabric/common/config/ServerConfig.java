package com.yori3o.esw_fabric.common.config;


import com.yori3o.esw_fabric.impl.PlatformUtil;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;



public class ServerConfig extends JsonConfigManager<ServerConfig.Values> {

    public static class Values {
        public List<String> featuresBlacklist = new LinkedList<>();
        public boolean whitelistMode = false;
    }

    public static final Path CONFIG_PATH = PlatformUtil.getConfigDir().resolve("esw_fabric-server.json");

    public ServerConfig() {
        super(Values.class, CONFIG_PATH);
    }

    @Override
    protected Values getDefaultConfig() {
        return new Values();
    }

}
