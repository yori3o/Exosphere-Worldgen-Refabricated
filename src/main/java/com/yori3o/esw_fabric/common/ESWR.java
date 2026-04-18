package com.yori3o.esw_fabric.common;


// esw = ExoSphere Worldgen, r = Refabricated 
public class ESWR {


	public static final String MOD_ID = "esw_fabric";
    

	public void init() {

        BiomeModifiersBase.modify();
        BiomeModifiersCommon.modify();
            
	}
 
}