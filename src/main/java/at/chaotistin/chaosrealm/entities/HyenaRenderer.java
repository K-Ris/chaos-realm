package at.chaotistin.chaosrealm.entities;

import at.chaotistin.chaosrealm.Main;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;

public class HyenaRenderer extends MobRenderer<HyenaEntity, HyenaModel<HyenaEntity>> {
    private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/hyena.png");
    private static final ResourceLocation TAMED_WOLF_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/hyena.png");
    private static final ResourceLocation ANGRY_WOLF_TEXTURES = new ResourceLocation(Main.MODID,"textures/entity/hyena.png");

    public HyenaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HyenaModel<>(), 0.5F);
        //this.addLayer(new WolfCollarLayer(this));
    }

    protected float handleRotationFloat(HyenaEntity livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    public void doRender(HyenaEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isWolfWet()) {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color3f(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(HyenaEntity entity) {
        if (entity.isTamed()) {
            return TAMED_WOLF_TEXTURES;
        } else {
            return entity.isAngry() ? ANGRY_WOLF_TEXTURES : WOLF_TEXTURES;
        }
    }
}
