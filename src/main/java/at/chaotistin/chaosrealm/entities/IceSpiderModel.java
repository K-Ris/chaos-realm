package at.chaotistin.chaosrealm.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class IceSpiderModel<T extends Entity> extends EntityModel<T> {
    private final RendererModel head;
    private final RendererModel neck;
    private final RendererModel neck2;
    private final RendererModel body;
    private final RendererModel body2;
    private final RendererModel body3;
    private final RendererModel body4;
    private final RendererModel leg3;
    private final RendererModel leg4;
    private final RendererModel leg5;
    private final RendererModel leg6;
    private final RendererModel leg7;
    private final RendererModel leg8;

    public IceSpiderModel() {
        textureWidth = 128;
        textureHeight = 128;

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 15.0F, -3.0F);
        head.cubeList.add(new ModelBox(head, 0, 44, -4.0F, -2.0F, -7.0F, 8, 6, 1, 0.0F, false));

        neck = new RendererModel(this);
        neck.setRotationPoint(0.0F, 0.0F, 3.0F);
        head.addChild(neck);
        neck.cubeList.add(new ModelBox(neck, 32, 36, -5.0F, -4.0F, -9.0F, 10, 8, 4, 0.0F, false));

        neck2 = new RendererModel(this);
        neck2.setRotationPoint(0.0F, 15.0F, 5.0F);
        neck2.cubeList.add(new ModelBox(neck2, 0, 0, -6.0F, -5.0F, -10.0F, 12, 9, 11, 0.0F, false));

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 15.0F, 9.0F);
        body.cubeList.add(new ModelBox(body, 0, 20, -4.0F, -4.0F, -3.0F, 8, 8, 7, 0.0F, false));

        body2 = new RendererModel(this);
        body2.setRotationPoint(0.0F, 15.0F, 9.0F);
        body2.cubeList.add(new ModelBox(body2, 0, 40, -6.0F, -5.0F, -3.0F, 12, 0, 4, 0.0F, false));

        body3 = new RendererModel(this);
        body3.setRotationPoint(6.0F, 24.0F, 5.0F);
        body3.cubeList.add(new ModelBox(body3, 26, 44, 0.0F, -14.0F, 1.0F, 0, 9, 4, 0.0F, false));

        body4 = new RendererModel(this);
        body4.setRotationPoint(6.0F, 24.0F, 5.0F);
        body4.cubeList.add(new ModelBox(body4, 18, 40, -12.0F, -14.0F, 1.0F, 0, 9, 4, 0.0F, false));

        leg3 = new RendererModel(this);
        leg3.setRotationPoint(4.0F, 15.0F, 4.0F);
        leg3.cubeList.add(new ModelBox(leg3, 0, 36, -25.0F, -5.0F, -1.0F, 16, 2, 2, 0.0F, false));

        leg4 = new RendererModel(this);
        leg4.setRotationPoint(-4.0F, 15.0F, 4.0F);
        leg4.cubeList.add(new ModelBox(leg4, 35, 4, 9.0F, -5.0F, -1.0F, 16, 2, 2, 0.0F, false));

        leg5 = new RendererModel(this);
        leg5.setRotationPoint(4.0F, 15.0F, 0.0F);
        leg5.cubeList.add(new ModelBox(leg5, 35, 0, -25.0F, -5.0F, -1.0F, 16, 2, 2, 0.0F, false));

        leg6 = new RendererModel(this);
        leg6.setRotationPoint(-4.0F, 15.0F, 0.0F);
        leg6.cubeList.add(new ModelBox(leg6, 30, 26, 9.0F, -5.0F, -1.0F, 16, 2, 2, 0.0F, false));

        leg7 = new RendererModel(this);
        leg7.setRotationPoint(4.0F, 15.0F, -5.0F);
        leg7.cubeList.add(new ModelBox(leg7, 30, 30, -25.0F, -5.0F, 5.0F, 16, 3, 3, 0.0F, false));

        leg8 = new RendererModel(this);
        leg8.setRotationPoint(-4.0F, 15.0F, -5.0F);
        leg8.cubeList.add(new ModelBox(leg8, 23, 20, 9.0F, -5.0F, 5.0F, 16, 3, 3, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        //this.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        head.render(f5);
        //neck.render(f5);
        neck2.render(f5);
        body.render(f5);
        body2.render(f5);
        body3.render(f5);
        body4.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        leg5.render(f5);
        leg6.render(f5);
        leg7.render(f5);
        leg8.render(f5);
    }
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 90F);
        float f = ((float)Math.PI / 4F);
        this.leg3.rotateAngleZ = (-(float)Math.PI / 4F);
        this.leg4.rotateAngleZ = ((float)Math.PI / 4F);
        this.leg5.rotateAngleZ = -0.58119464F;
        this.leg6.rotateAngleZ = 0.58119464F;
        this.leg7.rotateAngleZ = -0.58119464F;
        this.leg8.rotateAngleZ = 0.58119464F;
        float f1 = -0.0F;
        float f2 = ((float)Math.PI / 8F);
        this.leg3.rotateAngleY = ((float)Math.PI / 4F);
        this.leg4.rotateAngleY = (-(float)Math.PI / 4F);
        this.leg5.rotateAngleY = ((float)Math.PI / 8F);
        this.leg6.rotateAngleY = (-(float)Math.PI / 8F);
        this.leg7.rotateAngleY = (-(float)Math.PI / 8F);
        this.leg8.rotateAngleY = ((float)Math.PI / 8F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.leg3.rotateAngleY += f3;
        this.leg4.rotateAngleY += -f3;
        this.leg5.rotateAngleY += f4;
        this.leg6.rotateAngleY += -f4;
        this.leg7.rotateAngleY += f5;
        this.leg8.rotateAngleY += -f5;
        //this.field_78210_j.rotateAngleY += f6;
        //this.field_78211_k.rotateAngleY += -f6;
        //this.leg3.rotateAngleZ += f7;
        //this.leg4.rotateAngleZ += -f7;
        //this.leg5.rotateAngleZ += f8;
        //this.leg6.rotateAngleZ += -f8;
        //this.leg7.rotateAngleZ += f9;
        //this.leg8.rotateAngleZ += -f9;
        //this.field_78210_j.rotateAngleZ += f10;
        //this.field_78211_k.rotateAngleZ += -f10;
    }
}
