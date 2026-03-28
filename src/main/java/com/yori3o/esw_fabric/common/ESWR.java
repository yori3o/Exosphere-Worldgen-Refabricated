package com.yori3o.esw_fabric.common;



public class ESWR {


	public static final String MOD_ID = "esw_fabric";
    

	public void init() {

        BiomeModifiersBase.modify();
        BiomeModifiersCommon.modify();
            
	}
 
}