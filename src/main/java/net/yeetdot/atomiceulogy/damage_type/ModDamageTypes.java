package net.yeetdot.atomiceulogy.damage_type;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.yeetdot.atomiceulogy.AtomicEulogy;

public class ModDamageTypes {

    public static final RegistryKey<DamageType> POISONOUS_BLOCK_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(AtomicEulogy.MOD_ID, "poisonous_block_damage_type"));
    public static final RegistryKey<DamageType> ATE_TITANIUM_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(AtomicEulogy.MOD_ID, "ate_titanium_damage_type"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
