package com.yori3o.esw_fabric.common;


import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yori3o.esw_fabric.common.config.DynamicConfigHandler;
import com.yori3o.esw_fabric.common.util.LoggerUtil;


/**
 * This class adds features to biomes, just like the datapack did with Neoforge's biome_modifiers.
 */
public class BiomeModifiersCommon {


    public static final Map<TagKey<Biome>, Set<ResourceKey<PlacedFeature>>> featuresToAdd = new HashMap<>();


    private static void init() {
        registerEntry("exosphere:birch_decoration",
                List.of("exosphere:moss_ceiling", "exosphere:glow_berries", "exosphere:bamboo_vines", "exosphere:bamboo_blossom"));

        registerEntry("exosphere:cherry_decoration",
                List.of("exosphere:cherry_ceiling", "exosphere:glow_berries", "exosphere:spore_blossom", "exosphere:amethyst_cluster_hanging"));

        registerEntry("exosphere:default_decoration",
                List.of("exosphere:moss_ceiling_low", "exosphere:glow_berries", "exosphere:spore_blossom"));

        registerEntry("exosphere:dripstone_decoration",
                List.of("exosphere:dripstone_ceiling", "exosphere:roots_lichen", "minecraft:pointed_dripstone"));

        registerEntry("exosphere:dripstone_caves_decoration",
                List.of("exosphere:dripstone_ceiling", "exosphere:roots_lichen"));

        registerEntry("exosphere:ice_decoration",
                List.of("exosphere:ice_ceiling", "exosphere:snow_vines", "exosphere:blue_ice_vines", "exosphere:roots_lichen", "exosphere:glow_lichen_vines_rare"));

        registerEntry("exosphere:mushroom_decoration",
                List.of("exosphere:dark_oak_ceiling", "exosphere:glow_berries", "exosphere:mushroom_vines"));

        registerEntry("exosphere:oak_decoration",
                List.of("exosphere:oak_ceiling", "exosphere:glow_berries", "exosphere:spore_blossom"));

        registerEntry("exosphere:swamp_decoration",
                List.of("exosphere:swamp_ceiling", "exosphere:glow_berries", "exosphere:roots_lichen"));

        registerEntry("exosphere:ocean_decoration",
                List.of("exosphere:flowers/lily_flower_patch", "exosphere:river_pool", "exosphere:mud_pool", "exosphere:tuff", 
                    "exosphere:tuff_pool", "exosphere:flowers/wild_flower_patch", "exosphere:trees_branching_oak", "exosphere:common_clustered_tall_mushrooms", 
                    "exosphere:bushes/oak_bush", "exosphere:noise_patch_waterlily", "exosphere:overworld_mushrooms",
                    "exosphere:grass/tall_grass", "exosphere:dense_rooted_azalea_trees", "exosphere:rooted_towering_jungle_trees", 
                    "exosphere:rooted_branching_jungle_trees", "exosphere:bushes/rooted_jungle_bushes", "exosphere:hanging_bee_hive", 
                    "exosphere:cave_leaf_vines", "exosphere:dirt_pool_with_dripleaves",//"exosphere:lush_cave_vines",
                    "exosphere:sparse_lush_caves_vegetation", "exosphere:lush_spore_blossom", "exosphere:grass/dense_grass"
                )
            );
    }
    
	private static void registerEntry(String tagId, List<String> featureIds) {
        TagKey<Biome> tag = TagKey.create(Registries.BIOME, Identifier.parse(tagId));
        Set<ResourceKey<PlacedFeature>> features = new HashSet<>();
        for (String fid : featureIds) {
            features.add(ResourceKey.create(Registries.PLACED_FEATURE, Identifier.parse(fid)));
        }
        featuresToAdd.put(tag, features);
    }

    public static void modify() {
        init();

        for (Map.Entry<TagKey<Biome>, Set<ResourceKey<PlacedFeature>>> entry : featuresToAdd.entrySet()) {
            TagKey<Biome> biomeTag = entry.getKey();
            
            for (ResourceKey<PlacedFeature> featureKey : entry.getValue()) {
                LoggerUtil.info(featureKey.identifier().toString());
                if (DynamicConfigHandler.server().featuresBlacklist.contains(featureKey.toString()) != DynamicConfigHandler.server().whitelistMode) {
                    return;
                }

                BiomeModifications.addFeature(
                    BiomeSelectors.tag(biomeTag),
                    GenerationStep.Decoration.VEGETAL_DECORATION, 
                    featureKey
                );
            }
        }
    }
}