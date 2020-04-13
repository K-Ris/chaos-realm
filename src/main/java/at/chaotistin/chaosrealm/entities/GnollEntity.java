package at.chaotistin.chaosrealm.entities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;
import java.util.UUID;

public class GnollEntity extends MonsterEntity {
//    private static final UUID ATTACK_SPEED_BOOST_MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
//    private static final AttributeModifier ATTACK_SPEED_BOOST_MODIFIER = (new AttributeModifier(ATTACK_SPEED_BOOST_MODIFIER_UUID, "Attacking speed boost", 0.05D, AttributeModifier.Operation.ADDITION)).setSaved(false);
//    private int angerLevel;
//    private int randomSoundDelay;
//    private UUID angerTargetUUID;

    public GnollEntity(EntityType<? extends GnollEntity> p_i50194_1_, World p_i50194_2_) {
        super(p_i50194_1_, p_i50194_2_);
    }

//    public void setRevengeTarget(@Nullable LivingEntity livingBase) {
//        super.setRevengeTarget(livingBase);
//        if (livingBase != null) {
//            this.angerTargetUUID = livingBase.getUniqueID();
//        }
//
//    }

    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.0D, false));
        //this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        //this.targetSelector.addGoal(1, new GnollEntity.HurtByAggressorGoal(this));
        //this.targetSelector.addGoal(2, new GnollEntity.TargetAggressorGoal(this));
        this.goalSelector.addGoal(0, new SwimGoal(this));
//        this.goalSelector.addGoal(1, new BreakBlockGoal(Blocks.IRON_ORE, this, 2, 3));
//        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.5d));
//        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
//        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
//        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 2.0d, false));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }


    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        //this.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(0.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.5F);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
        //this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * difficultyIn.getClampedAdditionalDifficulty());

        return spawnDataIn;
    }


//    protected boolean shouldDrown() {
//        return false;
//    }
//
//    protected void updateAITasks() {
//        IAttributeInstance iattributeinstance = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
//        LivingEntity livingentity = this.getRevengeTarget();
//        if (this.isAngry()) {
//            if (!this.isChild() && !iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER)) {
//                iattributeinstance.applyModifier(ATTACK_SPEED_BOOST_MODIFIER);
//            }
//
//            --this.angerLevel;
//            LivingEntity livingentity1 = livingentity != null ? livingentity : this.getAttackTarget();
//            if (!this.isAngry() && livingentity1 != null) {
//                if (!this.canEntityBeSeen(livingentity1)) {
//                    this.setRevengeTarget((LivingEntity)null);
//                    this.setAttackTarget((LivingEntity)null);
//                } else {
//                    this.angerLevel = this.func_223336_ef();
//                }
//            }
//        } else if (iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER)) {
//            iattributeinstance.removeModifier(ATTACK_SPEED_BOOST_MODIFIER);
//        }
//
//        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
//            this.playSound(SoundEvents.ENTITY_ZOMBIE_PIGMAN_ANGRY, this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
//        }
//
//        if (this.isAngry() && this.angerTargetUUID != null && livingentity == null) {
//            PlayerEntity playerentity = this.world.getPlayerByUuid(this.angerTargetUUID);
//            this.setRevengeTarget(playerentity);
//            this.attackingPlayer = playerentity;
//            this.recentlyHit = this.getRevengeTimer();
//        }
//
//        super.updateAITasks();
//    }
//
//    public static boolean func_223337_b(EntityType<ZombiePigmanEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason, BlockPos p_223337_3_, Random p_223337_4_) {
//        return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
//    }
//
//    public boolean isNotColliding(IWorldReader worldIn) {
//        return worldIn.checkNoEntityCollision(this) && !worldIn.containsAnyLiquid(this.getBoundingBox());
//    }
//
//    public void writeAdditional(CompoundNBT compound) {
//        super.writeAdditional(compound);
//        compound.putShort("Anger", (short)this.angerLevel);
//        if (this.angerTargetUUID != null) {
//            compound.putString("HurtBy", this.angerTargetUUID.toString());
//        } else {
//            compound.putString("HurtBy", "");
//        }
//
//    }
//
//    public void readAdditional(CompoundNBT compound) {
//        super.readAdditional(compound);
//        this.angerLevel = compound.getShort("Anger");
//        String s = compound.getString("HurtBy");
//        if (!s.isEmpty()) {
//            this.angerTargetUUID = UUID.fromString(s);
//            PlayerEntity playerentity = this.world.getPlayerByUuid(this.angerTargetUUID);
//            this.setRevengeTarget(playerentity);
//            if (playerentity != null) {
//                this.attackingPlayer = playerentity;
//                this.recentlyHit = this.getRevengeTimer();
//            }
//        }
//
//    }
//
//    public boolean attackEntityFrom(DamageSource source, float amount) {
//        if (this.isInvulnerableTo(source)) {
//            return false;
//        } else {
//            Entity entity = source.getTrueSource();
//            if (entity instanceof PlayerEntity && !((PlayerEntity)entity).isCreative() && this.canEntityBeSeen(entity)) {
//                this.becomeAngryAt(entity);
//            }
//
//            return super.attackEntityFrom(source, amount);
//        }
//    }
//
//    private boolean becomeAngryAt(Entity p_70835_1_) {
//        this.angerLevel = this.func_223336_ef();
//        this.randomSoundDelay = this.rand.nextInt(40);
//        if (p_70835_1_ instanceof LivingEntity) {
//            this.setRevengeTarget((LivingEntity)p_70835_1_);
//        }
//
//        return true;
//    }
//
//    private int func_223336_ef() {
//        return 400 + this.rand.nextInt(400);
//    }
//
//    private boolean isAngry() {
//        return this.angerLevel > 0;
//    }
//
//    protected SoundEvent getAmbientSound() {
//        return SoundEvents.ENTITY_ZOMBIE_PIGMAN_AMBIENT;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
//        return SoundEvents.ENTITY_ZOMBIE_PIGMAN_HURT;
//    }
//
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.ENTITY_ZOMBIE_PIGMAN_DEATH;
//    }
//
//    public boolean processInteract(PlayerEntity player, Hand hand) {
//        return false;
//    }
//
//    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
//        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
//    }
//
//    protected ItemStack getSkullDrop() {
//        return ItemStack.EMPTY;
//    }
//
//    public boolean isPreventingPlayerRest(PlayerEntity playerIn) {
//        return this.isAngry();
//    }
//
//    static class HurtByAggressorGoal extends HurtByTargetGoal {
//        public HurtByAggressorGoal(GnollEntity p_i45828_1_) {
//            super(p_i45828_1_);
//            this.setCallsForHelp(new Class[]{ZombieEntity.class});
//        }
//
//        protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
//            if (mobIn instanceof GnollEntity && this.goalOwner.canEntityBeSeen(targetIn) && ((GnollEntity)mobIn).becomeAngryAt(targetIn)) {
//                mobIn.setAttackTarget(targetIn);
//            }
//
//        }
//    }
//
//    static class TargetAggressorGoal extends NearestAttackableTargetGoal<PlayerEntity> {
//        public TargetAggressorGoal(GnollEntity p_i45829_1_) {
//            super(p_i45829_1_, PlayerEntity.class, true);
//        }
//
//        public boolean shouldExecute() {
//            return ((GnollEntity)this.goalOwner).isAngry() && super.shouldExecute();
//        }
//    }
}
