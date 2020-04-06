package at.chaotistin.chaosrealm.items;

import at.chaotistin.chaosrealm.setup.ModSetup;
import net.minecraft.item.SwordItem;

public class
GlassSword extends SwordItem {
    public GlassSword() {
        super(ToolMaterialList.GLASS, 3, -2.4f, (new Properties().group(ModSetup.itemGroup)));
        setRegistryName("glasssword");
    }
}
