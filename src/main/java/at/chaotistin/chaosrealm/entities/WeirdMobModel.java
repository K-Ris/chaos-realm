package at.chaotistin.chaosrealm.entities;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class WeirdMobModel extends QuadrupedModel<WeirdMobEntity> {

    private final RendererModel main;
    private final RendererModel head;
    private final RendererModel antena;
    private final RendererModel snout;
    private final RendererModel leg_front_left;
    private final RendererModel leg_front_right;
    private final RendererModel leg_back_left;
    private final RendererModel leg_back_right;

    public WeirdMobModel() {
        super(6, 0.0F);
        textureWidth = 64;
        textureHeight = 64;

        main = new RendererModel(this);
        main.setRotationPoint(0.0F, 21.0F, 0.0F);
        main.cubeList.add(new ModelBox(main, 0, 12, -3.0F, -4.0F, -3.0F, 6, 4, 7, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, -4.0F, -2.0F);
        main.addChild(head);
        head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -5.0F, 8, 6, 6, 0.0F, false));

        antena = new RendererModel(this);
        antena.setRotationPoint(0.0F, -4.0F, -1.0F);
        head.addChild(antena);
        antena.cubeList.add(new ModelBox(antena, 22, 0, -2.0F, -1.0F, -2.0F, 4, 1, 3, 0.0F, false));

        snout = new RendererModel(this);
        snout.setRotationPoint(0.0F, 4.0F, 2.0F);
        head.addChild(snout);
        snout.cubeList.add(new ModelBox(snout, 19, 12, -2.0F, -6.0F, -10.0F, 4, 3, 3, 0.0F, false));

        leg_front_left = new RendererModel(this);
        leg_front_left.setRotationPoint(3.0F, -1.0F, -1.0F);
        main.addChild(leg_front_left);
        leg_front_left.cubeList.add(new ModelBox(leg_front_left, 24, 24, -1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));

        leg_front_right = new RendererModel(this);
        leg_front_right.setRotationPoint(-3.0F, -1.0F, -1.0F);
        main.addChild(leg_front_right);
        leg_front_right.cubeList.add(new ModelBox(leg_front_right, 16, 23, -1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));

        leg_back_left = new RendererModel(this);
        leg_back_left.setRotationPoint(3.0F, -1.0F, 4.0F);
        main.addChild(leg_back_left);
        leg_back_left.cubeList.add(new ModelBox(leg_back_left, 8, 23, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, false));

        leg_back_right = new RendererModel(this);
        leg_back_right.setRotationPoint(-3.0F, -1.0F, 4.0F);
        main.addChild(leg_back_right);
        leg_back_right.cubeList.add(new ModelBox(leg_back_right, 0, 23, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, false));
    }

    @Override
    public void render(WeirdMobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        main.render(scale);
    }


    @Override
    public void setRotationAngles(WeirdMobEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
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
