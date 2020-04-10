package at.chaotistin.chaosrealm.entities;

import at.chaotistin.chaosrealm.Main;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.util.ResourceLocation;

public class GnollRenderer extends BipedRenderer<GnollEntity, GnollModel<GnollEntity>> {
    private static final ResourceLocation ZOMBIE_PIGMAN_TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/gnoll.png");

    public GnollRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GnollModel<>(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new GnollModel(), new GnollModel()));
    }

    protected ResourceLocation getEntityTexture(GnollEntity entity) {
        return ZOMBIE_PIGMAN_TEXTURE;
    }
}
