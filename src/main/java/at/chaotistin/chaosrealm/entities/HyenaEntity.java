package at.chaotistin.chaosrealm.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public class HyenaEntity extends WolfEntity {
    public HyenaEntity(EntityType<? extends WolfEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
