package at.chaotistin.chaosrealm.entities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.World;

public class StoneCrusherEntity extends CreatureEntity{
    public StoneCrusherEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BreakBlockGoal(Blocks.IRON_ORE, this, 1, 6));
        this.goalSelector.addGoal(2, new BreakBlockGoal(Blocks.STONE, this, 0.5, 6));
        this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.6d));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 2.0d, false));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0d);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6d);


    }
}
