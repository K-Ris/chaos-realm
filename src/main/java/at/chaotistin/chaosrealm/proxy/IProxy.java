package at.chaotistin.chaosrealm.proxy;

import net.minecraft.world.World;

public interface IProxy {
    void init();

    World getClientWorld();
}
