package at.chaotistin.chaosrealm.registries;

import at.chaotistin.chaosrealm.Main;
import at.chaotistin.chaosrealm.entities.HyenaEntity;
import at.chaotistin.chaosrealm.entities.IceSkeletonEntity;
import at.chaotistin.chaosrealm.entities.IceSpiderEntity;
import at.chaotistin.chaosrealm.entities.WeirdMobEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ObjectHolder;

public class MobEntities {
    @ObjectHolder("chaosrealm:iceskeleton")
    public static EntityType<?> ICESKELETON = EntityType.Builder.create(IceSkeletonEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("iceskeleton")
            .setRegistryName(Main.MODID, "iceskeleton");

    @ObjectHolder("chaosrealm:weirdmob")
    public static EntityType<?> WEIRDMOB =EntityType.Builder.create(WeirdMobEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("weirdmob")
            .setRegistryName(Main.MODID, "weirdmob");

    @ObjectHolder("chaosrealm:icespider")
    public static EntityType<?> ICESPIDER = EntityType.Builder.create(IceSpiderEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("icespider")
            .setRegistryName(Main.MODID, "icespider");

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
