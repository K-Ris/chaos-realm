package at.chaotistin.chaosrealm.entities;


import at.chaotistin.chaosrealm.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class WeirdMobRenderer extends MobRenderer<WeirdMobEntity, WeirdMobModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/weirdmob.png");

    public WeirdMobRenderer(EntityRendererManager manager) {
        super(manager, new WeirdMobModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(WeirdMobEntity entity) {
        return TEXTURE;
    }
}
