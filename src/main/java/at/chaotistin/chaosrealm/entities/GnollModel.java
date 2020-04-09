package at.chaotistin.chaosrealm.entities;

import net.minecraft.client.renderer.entity.model.AbstractZombieModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;

public class GnollModel <T extends MonsterEntity> extends BipedModel<T>
{
    private final RendererModel head;
    private final RendererModel right_ear;
    private final RendererModel left_ear;
    private final RendererModel snout;
    private final RendererModel headwear;
    private final RendererModel body;
    private final RendererModel left_arm;
    private final RendererModel right_arm;
    private final RendererModel left_leg;
    private final RendererModel right_leg;

    public GnollModel()
    {
        textureWidth = 64;
        textureHeight = 64;

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.cubeList.add(new ModelBox(head, 0, 13, -4.0F, -6.0F, -6.0F, 8, 6, 7, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 10, 0.0F, -6.0F, 1.0F, 0, 6, 3, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 20, 22, 0.0F, -9.0F, -3.0F, 0, 3, 4, 0.0F, false));

        right_ear = new RendererModel(this);
        right_ear.setRotationPoint(-1.0F, -6.0F, -2.0F);
        setRotationAngle(right_ear, 0.0F, -0.0873F, 0.0F);
        head.addChild(right_ear);
        right_ear.cubeList.add(new ModelBox(right_ear, 30, 19, -3.0F, -4.0F, 0.0F, 3, 4, 1, 0.0F, false));

        left_ear = new RendererModel(this);
        left_ear.setRotationPoint(1.0F, -6.0F, -2.0F);
        head.addChild(left_ear);
        left_ear.cubeList.add(new ModelBox(left_ear, 23, 15, 0.0F, -4.0F, 0.0F, 3, 4, 1, 0.0F, false));

        snout = new RendererModel(this);
        snout.setRotationPoint(0.0F, 0.0F, -3.0F);
        head.addChild(snout);
        snout.cubeList.add(new ModelBox(snout, 0, 42, -2.0F, -4.0F, -7.0F, 4, 4, 4, 0.0F, false));

        headwear = new RendererModel(this);
        headwear.setRotationPoint(0.0F, 0.0F, -3.0F);
        headwear.cubeList.add(new ModelBox(headwear, 0, 0, -4.0F, -6.0F, -3.0F, 8, 6, 7, 0.25F, false));

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 26, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));

        left_arm = new RendererModel(this);
        left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        left_arm.cubeList.add(new ModelBox(left_arm, 40, 16, 9.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

        right_arm = new RendererModel(this);
        right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
        right_arm.cubeList.add(new ModelBox(right_arm, 36, 38, -13.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

        left_leg = new RendererModel(this);
        left_leg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        left_leg.cubeList.add(new ModelBox(left_leg, 30, 0, 1.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

        right_leg = new RendererModel(this);
        right_leg.setRotationPoint(1.9F, 12.0F, 0.0F);
        right_leg.cubeList.add(new ModelBox(right_leg, 24, 26, -5.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
    }

    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        head.render(scale);
        headwear.render(scale);
        body.render(scale);
        left_arm.render(scale);
        right_arm.render(scale);
        left_leg.render(scale);
        right_leg.render(scale);
    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
