package at.chaotistin.chaosrealm.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PlatypunkEntity extends TameableEntity {

    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(PlatypunkEntity.class, DataSerializers.FLOAT);

    public PlatypunkEntity(EntityType<? extends PlatypunkEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
    }

    @Override
    protected void registerGoals(){
        this.sitGoal = new SitGoal(this);
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, this.sitGoal);
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 2.0d, false));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.6d));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
        if (this.isTamed()) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (item.isFood()) {
                    if (item.getFood().isMeat() && this.dataManager.get(DATA_HEALTH_ID) < 20.0F) {
                        if (!player.abilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }

                        this.heal((float)item.getFood().getHealing());
                        return true;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
                this.sitGoal.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((LivingEntity)null);
            }
        } else if (item == Items.BONE) {
            if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity)null);
                    this.sitGoal.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }
}
