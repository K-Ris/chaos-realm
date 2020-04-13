package at.chaotistin.chaosrealm.world.structures;

import at.chaotistin.chaosrealm.Main;
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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("chaosrealm")
public class ModStructures {

    //public static final SwampHutStructure SWAMP_HUT = register("swamp_hut_test", new SwampHutTestStructure(NoFeatureConfig::deserialize));

    public static final Structure<NoFeatureConfig> SWAMP_HUT_Test = create("swamp_hut_test", new SwampHutTestStructure(NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void registerStructures(RegistryEvent.Register<Feature<?>> event) {
        // Register Pieces
        //ModStructurePieces.registerPieces();

        // Register Structures
        IForgeRegistry<Feature<?>> registry = event.getRegistry();

        registry.register(SWAMP_HUT_Test);
    }

    private static @Nonnull
    <T extends Feature<?>> T create(String name, T feature) {
        feature.setRegistryName(Main.MODID, name.toLowerCase(Locale.ROOT));
        return feature;
    }

}
