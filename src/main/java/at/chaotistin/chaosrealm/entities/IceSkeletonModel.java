package at.chaotistin.chaosrealm.entities;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceSkeletonModel extends BipedModel<IceSkeletonEntity> {
    private final RendererModel head;
    private final RendererModel headwear;
    private final RendererModel body;
    private final RendererModel left_arm;
    private final RendererModel right_arm;
    private final RendererModel left_leg;
    private final RendererModel right_leg;


    public IceSkeletonModel() {
        super(2.0f);
        textureWidth = 64;
        textureHeight = 64;

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.cubeList.add(new ModelBox(head, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));

        headwear = new RendererModel(this);
        headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        headwear.cubeList.add(new ModelBox(headwear, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.25F, false));

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 28, 28, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));

        left_arm = new RendererModel(this);
        left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        left_arm.cubeList.add(new ModelBox(left_arm, 32, 0, -1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F, false));

        right_arm = new RendererModel(this);
        right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
        right_arm.cubeList.add(new ModelBox(right_arm, 16, 32, -1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F, false));

        left_leg = new RendererModel(this);
        left_leg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        left_leg.cubeList.add(new ModelBox(left_leg, 8, 32, 2.9F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));

        right_leg = new RendererModel(this);
        right_leg.setRotationPoint(1.9F, 12.0F, 0.0F);
        right_leg.cubeList.add(new ModelBox(right_leg, 0, 32, -4.9F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));

        super.bipedHead = head;
        super.bipedBody = body;
        super.bipedLeftArm = left_arm;
        super.bipedRightArm = right_arm;
        super.bipedLeftLeg = left_leg;
        super.bipedRightLeg = right_leg;
        super.bipedHeadwear = headwear;
    }

    public void render(IceSkeletonModel entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        head.render(scale);
        //headwear.render(scale);
        body.render(scale);
        left_arm.render(scale);
        right_arm.render(scale);
        left_leg.render(scale);
        right_leg.render(scale);
    }

    private void setRotationAngles(IceSkeletonModel entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    }

}
