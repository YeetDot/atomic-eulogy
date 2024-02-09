package net.yeetdot.atomiceulogy.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yeetdot.atomiceulogy.AtomicEulogy;

public class ModItemGroups {
    public static final ItemGroup ATOMIC_EULOGY_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(AtomicEulogy.MOD_ID, "moditems"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.moditems"))
            .icon(() -> new ItemStack(ModItems.TITANIUM_INGOT)).entries((displayContext, entries) -> {
                entries.add(ModItems.TITANIUM_INGOT);
                entries.add(ModItems.RAW_TITANIUM);
            }).build());

    public static void registerItemGroups() {


        AtomicEulogy.LOGGER.info("Registering Mod Item Groups for " + AtomicEulogy.MOD_ID);
    }
}
