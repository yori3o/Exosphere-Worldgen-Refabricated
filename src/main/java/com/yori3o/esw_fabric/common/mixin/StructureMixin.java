package com.yori3o.esw_fabric.common.mixin;


import net.minecraft.world.level.levelgen.structure.Structure;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(Structure.class)
public class StructureMixin {


    @Inject(method = "isValidBiome", at = @At("RETURN"), cancellable = true)
    private static void preventVoidGeneration(Structure.GenerationStub stub, Structure.GenerationContext context, CallbackInfoReturnable<Boolean> cir) {
        if (stub.position().getY() <= context.chunkGenerator().getMinY() + 5) {
            cir.setReturnValue(false);
        }
        cir.setReturnValue(cir.getReturnValue());
    }

}
