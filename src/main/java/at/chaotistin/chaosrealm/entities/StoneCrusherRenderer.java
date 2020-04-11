package at.chaotistin.chaosrealm.entities;

import at.chaotistin.chaosrealm.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class StoneCrusherRenderer extends MobRenderer<StoneCrusherEntity, StoneCrusherModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/stonecrusher.png");

    public StoneCrusherRenderer(EntityRendererManager manager) {
        super(manager, new StoneCrusherModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(StoneCrusherEntity entity) {
        return TEXTURE;
    }
}
