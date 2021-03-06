package at.chaotistin.chaosrealm.entities;

import at.chaotistin.chaosrealm.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class PlatypunkRenderer extends MobRenderer<PlatypunkEntity, PlatypunkModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/platypunk.png");

    public PlatypunkRenderer(EntityRendererManager manager) {
        super(manager, new PlatypunkModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(PlatypunkEntity entity) {
        return TEXTURE;
    }
}
