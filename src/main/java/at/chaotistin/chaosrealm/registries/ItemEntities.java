package at.chaotistin.chaosrealm.registries;

import at.chaotistin.chaosrealm.entities.FireballSpellEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ObjectHolder;

public class ItemEntities {

    @ObjectHolder("chaosrealm:fireballspellentity")
    //public static final EntityType<?> FIREBALLSPELL_ENTITY = EntityType.Builder.<FireballSpellEntity>create(FireballSpellEntity::new, EntityClassification.MISC).size(0.25F, 0.25F);
    public static final EntityType<FireballSpellEntity> FIREBALLSPELL_ENTITY = register("snowball", EntityType.Builder.<FireballSpellEntity>create(FireballSpellEntity::new, EntityClassification.MISC).size(0.25F, 0.25F));

    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
}
