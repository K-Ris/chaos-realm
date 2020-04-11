package at.chaotistin.chaosrealm.entities;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class StoneCrusherModel extends QuadrupedModel<StoneCrusherEntity> {
    private final RendererModel body;
    private final RendererModel head;
    private final RendererModel jaw;
    private final RendererModel tail;
    private final RendererModel leg_front_left;
    private final RendererModel leg_front_right;
    private final RendererModel leg_back_left;
    private final RendererModel leg_back_right;

    public StoneCrusherModel() {
        super(6, 0.0F);
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 22.0F, -4.0F);
        body.cubeList.add(new ModelBox(body, 28, 28, -4.0F, -8.0F, 5.0F, 8, 8, 8, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 17, -5.0F, -8.0F, -3.0F, 10, 8, 8, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 44, 44, 2.0F, -9.0F, 1.0F, 3, 1, 3, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 36, 22, -5.0F, -9.0F, 1.0F, 3, 1, 3, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 3, -4.0F, -9.0F, 7.0F, 2, 1, 2, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 0, 2.0F, -9.0F, 7.0F, 2, 1, 2, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 14.0F, -5.5F);
        head.cubeList.add(new ModelBox(head, 35, 10, -4.0F, -5.0F, -5.5F, 8, 5, 7, 0.0F, false));

        jaw = new RendererModel(this);
        jaw.setRotationPoint(0.0F, -0.3333F, 1.3333F);
        head.addChild(jaw);
        jaw.cubeList.add(new ModelBox(jaw, 0, 0, -6.0F, -0.6667F, -10.8333F, 12, 8, 9, 0.0F, false));
        jaw.cubeList.add(new ModelBox(jaw, 0, 54, -6.0F, -5.6667F, -10.8333F, 2, 5, 3, 0.0F, false));
        jaw.cubeList.add(new ModelBox(jaw, 13, 53, 4.0F, -5.6667F, -10.8333F, 2, 5, 3, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 19.0F, 9.0F);
        tail.cubeList.add(new ModelBox(tail, 0, 33, -3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F, false));
        tail.cubeList.add(new ModelBox(tail, 33, 0, -2.0F, -1.0F, 6.0F, 4, 4, 5, 0.0F, false));
        tail.cubeList.add(new ModelBox(tail, 23, 56, -1.0F, 1.0F, 11.0F, 2, 2, 3, 0.0F, false));

        leg_front_left = new RendererModel(this);
        leg_front_left.setRotationPoint(6.6667F, 17.8333F, -1.1667F);
        leg_front_left.cubeList.add(new ModelBox(leg_front_left, 34, 44, -1.6667F, -1.8333F, -2.8333F, 3, 8, 4, 0.0F, false));
        leg_front_left.cubeList.add(new ModelBox(leg_front_left, 0, 21, 0.3333F, 4.1667F, -4.8333F, 1, 2, 2, 0.0F, false));
        leg_front_left.cubeList.add(new ModelBox(leg_front_left, 18, 33, -1.6667F, 3.1667F, -5.8333F, 2, 3, 3, 0.0F, false));

        leg_front_right = new RendererModel(this);
        leg_front_right.setRotationPoint(-6.6667F, 17.8333F, -2.1667F);
        leg_front_right.cubeList.add(new ModelBox(leg_front_right, 20, 44, -1.3333F, -1.8333F, -1.8333F, 3, 8, 4, 0.0F, false));
        leg_front_right.cubeList.add(new ModelBox(leg_front_right, 0, 17, -1.3333F, 4.1667F, -3.8333F, 1, 2, 2, 0.0F, false));
        leg_front_right.cubeList.add(new ModelBox(leg_front_right, 28, 19, -0.3333F, 3.1667F, -4.8333F, 2, 3, 3, 0.0F, false));

        leg_back_left = new RendererModel(this);
        leg_back_left.setRotationPoint(5.5F, 17.8333F, 5.3333F);
        leg_back_left.cubeList.add(new ModelBox(leg_back_left, 52, 22, -1.5F, 2.1667F, -0.3333F, 3, 4, 3, 0.0F, false));
        leg_back_left.cubeList.add(new ModelBox(leg_back_left, 48, 48, -1.5F, -1.8333F, -2.3333F, 3, 4, 5, 0.0F, false));
        leg_back_left.cubeList.add(new ModelBox(leg_back_left, 33, 56, -1.5F, 3.1667F, -2.3333F, 3, 3, 2, 0.0F, false));

        leg_back_right = new RendererModel(this);
        leg_back_right.setRotationPoint(-5.5F, 17.8333F, 5.3333F);
        leg_back_right.cubeList.add(new ModelBox(leg_back_right, 51, 0, -1.5F, 2.1667F, -0.3333F, 3, 4, 3, 0.0F, false));
        leg_back_right.cubeList.add(new ModelBox(leg_back_right, 0, 45, -1.5F, -1.8333F, -2.3333F, 3, 4, 5, 0.0F, false));
        leg_back_right.cubeList.add(new ModelBox(leg_back_right, 52, 29, -1.5F, 3.1667F, -2.3333F, 3, 3, 2, 0.0F, false));
    }

    @Override
    public void render(StoneCrusherEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        body.render(scale);
        head.render(scale);
        tail.render(scale);
        leg_front_left.render(scale);
        leg_front_right.render(scale);
        leg_back_left.render(scale);
        leg_back_right.render(scale);
    }


    @Override
    public void setRotationAngles(StoneCrusherEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.headModel.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.headModel.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.leg_front_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg_front_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_back_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_back_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    public RendererModel getHead() {
        return this.head;
    }
}
