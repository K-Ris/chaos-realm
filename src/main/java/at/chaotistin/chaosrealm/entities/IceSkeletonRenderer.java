package at.chaotistin.chaosrealm.entities;


import at.chaotistin.chaosrealm.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class IceSkeletonRenderer extends MobRenderer<IceSkeletonEntity, IceSkeletonModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/iceskeleton.png");

    public IceSkeletonRenderer(EntityRendererManager manager) {
        super(manager, new IceSkeletonModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(IceSkeletonEntity entity) {
        return TEXTURE;
    }
}
