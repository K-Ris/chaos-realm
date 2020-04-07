package at.chaotistin.chaosrealm.entities;

import at.chaotistin.chaosrealm.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.ResourceLocation;

public class IceSpiderRenderer <T extends IceSpiderEntity> extends MobRenderer<T, IceSpiderModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/icespider.png");

    public IceSpiderRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new IceSpiderModel<>(), 0.8F);
        //this.addLayer(new SpiderEyesLayer<>(this));
    }

    protected float getDeathMaxRotation(T entityLivingBaseIn) {
        return 180.0F;
    }

    protected ResourceLocation getEntityTexture(T entity) {
        return TEXTURE;
    }
}
