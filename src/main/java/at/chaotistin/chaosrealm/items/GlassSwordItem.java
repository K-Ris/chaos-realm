package at.chaotistin.chaosrealm.items;

import at.chaotistin.chaosrealm.setup.ModSetup;
import net.minecraft.item.SwordItem;

public class
GlassSwordItem extends SwordItem {
    public GlassSwordItem() {
        super(ToolMaterialList.GLASS, 3, -2.4f, (new Properties().group(ModSetup.itemGroup)));
        setRegistryName("glasssword");
    }
}
