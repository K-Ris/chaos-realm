package at.chaotistin.chaosrealm.setup;

import at.chaotistin.chaosrealm.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public static ItemGroup itemGroup = new ItemGroup("chaosrealm"){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModItems.GLASSSWORD);
        }
    };

    public void init(){
    }
}
