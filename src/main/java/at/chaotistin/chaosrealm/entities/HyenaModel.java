package at.chaotistin.chaosrealm.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.MathHelper;

public class HyenaModel <T extends HyenaEntity> extends EntityModel<T> {
    private final RendererModel head;
    private final RendererModel body;
    private final RendererModel mane;
    private final RendererModel leg1;
    private final RendererModel leg2;
    private final RendererModel leg3;
    private final RendererModel leg4;
    private final RendererModel tail;

    public HyenaModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 14.0F, -7.0F);
        head.cubeList.add(new ModelBox(head, 20, 24, -4.0F, -2.5F, -3.0F, 6, 5, 6, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 18, 13, 1.0F, -4.5F, 0.0F, 2, 3, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 0, -5.0F, -4.5F, 0.0F, 2, 3, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 23, 0, -2.5F, 0.48F, -6.0F, 3, 2, 3, 0.0F, false));

        body = new RendererModel(this);
        body.setRotationPoint(-2.0F, 14.0F, 2.0F);
        body.cubeList.add(new ModelBox(body, 0, 13, -3.0F, -2.0F, -3.0F, 4, 9, 6, 0.0F, false));

        mane = new RendererModel(this);
        mane.setRotationPoint(0.0F, 14.0F, 2.0F);
        mane.cubeList.add(new ModelBox(mane, 0, 0, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        mane.cubeList.add(new ModelBox(mane, 0, 10, 0.0F, -2.0F, 3.0F, 0, 6, 3, 0.0F, false));

        leg1 = new RendererModel(this);
        leg1.setRotationPoint(1.5F, 16.0F, 7.0F);
        leg1.cubeList.add(new ModelBox(leg1, 16, 34, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

        leg2 = new RendererModel(this);
        leg2.setRotationPoint(-1.5F, 16.0F, 7.0F);
        leg2.cubeList.add(new ModelBox(leg2, 32, 7, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

        leg3 = new RendererModel(this);
        leg3.setRotationPoint(1.5F, 16.0F, -4.0F);
        leg3.cubeList.add(new ModelBox(leg3, 8, 28, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

        leg4 = new RendererModel(this);
        leg4.setRotationPoint(-1.5F, 16.0F, -4.0F);
        leg4.cubeList.add(new ModelBox(leg4, 0, 28, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 12.0F, 8.0F);
        tail.cubeList.add(new ModelBox(tail, 24, 13, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));
    }


    public void render(T entityIn, float f, float f1, float f2, float f3, float f4, float f5) {
        head.render(f5);
        body.render(f5);
        mane.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        tail.render(f5);
    }


    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        if (entityIn.isAngry()) {
            this.tail.rotateAngleY = 0.0F;
        } else {
            this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        }

        if (entityIn.isSitting()) {
            this.mane.setRotationPoint(-1.0F, 16.0F, -3.0F);
            this.mane.rotateAngleX = 1.2566371F;
            this.mane.rotateAngleY = 0.0F;
            this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
            this.body.rotateAngleX = ((float)Math.PI / 4F);
            this.tail.setRotationPoint(-1.0F, 21.0F, 6.0F);
            this.leg2.setRotationPoint(-2.5F, 22.0F, 2.0F);
            this.leg2.rotateAngleX = ((float)Math.PI * 1.5F);
            this.leg1.setRotationPoint(0.5F, 22.0F, 2.0F);
            this.leg1.rotateAngleX = ((float)Math.PI * 1.5F);
            this.leg4.rotateAngleX = 5.811947F;
            this.leg4.setRotationPoint(-2.49F, 17.0F, -4.0F);
            this.leg3.rotateAngleX = 5.811947F;
            this.leg3.setRotationPoint(0.51F, 17.0F, -4.0F);
        } else {
            this.body.setRotationPoint(0.0F, 14.0F, 2.0F);
            this.body.rotateAngleX = ((float)Math.PI / 2F);
            this.mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.mane.rotateAngleX = this.body.rotateAngleX;
            this.tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
            this.leg2.setRotationPoint(-2.5F, 16.0F, 7.0F);
            this.leg1.setRotationPoint(0.5F, 16.0F, 7.0F);
            this.leg4.setRotationPoint(-2.5F, 16.0F, -4.0F);
            this.leg3.setRotationPoint(0.5F, 16.0F, -4.0F);
            this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        }

        this.head.rotateAngleZ = entityIn.getInterestedAngle(partialTick) + entityIn.getShakeAngle(partialTick, 0.0F);
        this.mane.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.08F);
        this.body.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.16F);
        this.tail.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.2F);
    }

    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.tail.rotateAngleX = ageInTicks;
    }
}
