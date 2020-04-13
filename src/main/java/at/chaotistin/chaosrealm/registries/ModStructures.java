package at.chaotistin.chaosrealm.registries;

import at.chaotistin.chaosrealm.Main;
import at.chaotistin.chaosrealm.world.structures.SwampHutTestStructure;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.SwampHutStructure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ModStructures {

    //public static final SwampHutStructure SWAMP_HUT = register("swamp_hut_test", new SwampHutTestStructure(NoFeatureConfig::deserialize));

    @ObjectHolder("chaosrealm:swamp_hut_test")
    public static final Structure<NoFeatureConfig> SWAMP_HUT_Test = create("swamp_hut_test", new SwampHutTestStructure(NoFeatureConfig::deserialize));



    private static @Nonnull
    <T extends Feature<?>> T create(String name, T feature) {
        feature.setRegistryName(Main.MODID, name.toLowerCase(Locale.ROOT));
        return feature;
    }

}
