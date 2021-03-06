package at.chaotistin.chaosrealm.proxy;

import at.chaotistin.chaosrealm.entities.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy{
    @Override
    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(IceSkeletonEntity.class, IceSkeletonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WeirdMobEntity.class, WeirdMobRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(IceSpiderEntity.class, IceSpiderRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(HyenaEntity.class, HyenaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(GnollEntity.class, GnollRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PlatypunkEntity.class, PlatypunkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(StoneCrusherEntity.class, StoneCrusherRenderer::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
