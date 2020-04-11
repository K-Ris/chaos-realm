package at.chaotistin.chaosrealm.registries;

import at.chaotistin.chaosrealm.items.FireballSpellItem;
import at.chaotistin.chaosrealm.items.GlassSwordItem;
import at.chaotistin.chaosrealm.setup.ModSetup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SnowballItem;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {

    @ObjectHolder("chaosrealm:glasssword")
    public static GlassSwordItem GLASSSWORD;

    @ObjectHolder("chaosrealm:fireballspell")
    public static final Item FIREBALLSPELL = new FireballSpellItem((new Item.Properties()).maxStackSize(16).group(ModSetup.itemGroup));
}
