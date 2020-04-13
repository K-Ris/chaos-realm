package at.chaotistin.chaosrealm.world.structures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.DungeonRoomConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGen {
    /**
     * Setup World Generation
     */
    public static void setupWorldGen() {
        // Add Structures to World Generation
        for (Biome biome : ForgeRegistries.BIOMES) {

            // Globally Blacklisted biomes.
            if (biome == Biomes.RIVER) {
                continue;
            }

            // Surface Structures
            if (biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.FOREST) {
                if (biome.getTempCategory() == Biome.TempCategory.MEDIUM && biome.getPrecipitation() == Biome.RainType.RAIN) {
                    addSurfaceStructure(biome, ModStructures.SWAMP_HUT_Test);
                }
            }

            // Underground Structures
//            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
//                addUndergroundStructure(biome, ModStructures.SMALL_DUNGEON);
//            }
        }
    }

    /**
     * Add a structure to the given biome.
     * @param biome The biome to add a structure to.
     * @param structure The structure to add.
     */
    private static void addSurfaceStructure(Biome biome, Structure<NoFeatureConfig> structure) {
        biome.addStructure(structure, IFeatureConfig.NO_FEATURE_CONFIG);
        biome.addFeature(
                GenerationStage.Decoration.SURFACE_STRUCTURES,
                Biome.createDecoratedFeature(structure,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.NOPE,
                        IPlacementConfig.NO_PLACEMENT_CONFIG));
    }

    @SuppressWarnings("SameParameterValue")
    private static void addUndergroundStructure(Biome biome, Structure<NoFeatureConfig> structure) {
        biome.addStructure(structure, IFeatureConfig.NO_FEATURE_CONFIG);
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
                Biome.createDecoratedFeature(structure,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.DUNGEONS,
                        new DungeonRoomConfig(8)));
    }
}
