package at.chaotistin.chaosrealm.entities;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

public class MobEntities {
    @ObjectHolder("chaosrealm:iceskeleton")
    public static EntityType<IceSkeletonEntity> ICESKELETON;

    @ObjectHolder("chaosrealm:weirdmob")
    public static EntityType<WeirdMobEntity> WEIRDMOB;
}
