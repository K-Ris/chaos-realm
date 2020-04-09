package at.chaotistin.chaosrealm.entities;

import at.chaotistin.chaosrealm.Main;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ObjectHolder;

public class MobEntities {
    @ObjectHolder("chaosrealm:iceskeleton")
    public static EntityType<IceSkeletonEntity> ICESKELETON;

    @ObjectHolder("chaosrealm:weirdmob")
    public static EntityType<WeirdMobEntity> WEIRDMOB;

    @ObjectHolder("chaosrealm:icespider")
    public static EntityType<WeirdMobEntity> ICESPIDER;

    @ObjectHolder("chaosrealm:hyena")
    public static EntityType<?> HYENA = EntityType.Builder.create(HyenaEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("hyena")
            .setRegistryName(Main.MODID, "hyena");

    public static void registerEntityWorldSpawns(){
        registerEntityWorldSpawn(HYENA, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU);
    }

    private static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes){
        for(Biome biome : biomes){
            if(biome != null){
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 10, 1,10));
            }
        }
    }
}
