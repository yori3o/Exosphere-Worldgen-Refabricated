package com.yori3o.esw_fabric.common;


import com.yori3o.esw_fabric.common.config.DynamicConfigHandler;

// esw = ExoSphere Worldgen, r = Refabricated 
public class ESWR {


	public static final String MOD_ID = "esw_fabric";
    

	public void init() {

        DynamicConfigHandler.loadServer();

        BiomeModifiersBase.modify();
        BiomeModifiersCommon.modify();
            
	}
 
}