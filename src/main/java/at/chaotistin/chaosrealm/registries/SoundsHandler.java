package at.chaotistin.chaosrealm.registries;

import at.chaotistin.chaosrealm.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundsHandler {
    public static SoundEvent ENTITY_HYENA_AMBIENT, ENTITY_HYENA_HURT, ENTITY_HYENA_GROWL,ENTITY_HYENA_DEATH;

    public static void registerSounds(){
        ENTITY_HYENA_AMBIENT = registerSound("entity.hyena.ambient");
        ENTITY_HYENA_HURT = registerSound("entity.hyena.hurt");
        ENTITY_HYENA_GROWL = registerSound("entity.hyena.growl");
        ENTITY_HYENA_DEATH = registerSound("entity.hyena.death");
    }

    private static SoundEvent registerSound(String name){
        ResourceLocation location = new ResourceLocation(Main.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
