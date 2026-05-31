package com.yori3o.esw_fabric.fabric;


import com.yori3o.esw_fabric.common.ESWR;

import net.fabricmc.api.ModInitializer;



public class ESWRFabric implements ModInitializer {


	@Override
	public void onInitialize() {

        (new ESWR()).init();
            
	}

}