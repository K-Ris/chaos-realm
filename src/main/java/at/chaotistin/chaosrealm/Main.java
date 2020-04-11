package at.chaotistin.chaosrealm;

import at.chaotistin.chaosrealm.items.*;
import at.chaotistin.chaosrealm.proxy.ClientProxy;
import at.chaotistin.chaosrealm.proxy.IProxy;
import at.chaotistin.chaosrealm.proxy.ServerProxy;
import at.chaotistin.chaosrealm.registries.MobEntities;
import at.chaotistin.chaosrealm.registries.ModItems;
import at.chaotistin.chaosrealm.registries.SoundsHandler;
import at.chaotistin.chaosrealm.setup.ModSetup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("chaosrealm")
public class Main
{
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static final String MODID = "chaosrealm";

    public static ModSetup setup = new ModSetup();
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        setup.init();
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onSoundsRegistry(final RegistryEvent.Register<SoundEvent> event){
            SoundsHandler.registerSounds();
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new GlassSwordItem());
            event.getRegistry().register(new IceSkeletonEggItem());
            event.getRegistry().register(new WeirdMobEggItem());
            event.getRegistry().register(new IceSpiderEggItem());
            event.getRegistry().register(new PlatypunkEggItem());
            event.getRegistry().register(new HyenaEggItem());
            event.getRegistry().register(new GnollEggItem());
            event.getRegistry().register(new StoneCrusherEggItem());

            event.getRegistry().register(ModItems.FIREBALLSPELL);
        }
        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(MobEntities.ICESKELETON);
            event.getRegistry().register(MobEntities.WEIRDMOB);
            event.getRegistry().register(MobEntities.ICESPIDER);
            event.getRegistry().register(MobEntities.HYENA);
            event.getRegistry().register(MobEntities.GNOLL);
            event.getRegistry().register(MobEntities.PLATYPUNK);
            event.getRegistry().register(MobEntities.STONECRUSHER);

            MobEntities.registerEntityWorldSpawns();

        }

    }
}
