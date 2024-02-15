package net.yeetdot.atomiceulogy.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yeetdot.atomiceulogy.AtomicEulogy;
import net.yeetdot.atomiceulogy.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ATOMIC_EULOGY_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(AtomicEulogy.MOD_ID, "moditems"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.moditems"))
            .icon(() -> new ItemStack(ModItems.TITANIUM_INGOT)).entries((displayContext, entries) -> {
                //Item Items
                entries.add(ModItems.TITANIUM_INGOT);
                entries.add(ModItems.RAW_TITANIUM);
                entries.add(ModItems.TITANIUM_NUGGET);
                entries.add(ModItems.RADIANCE_ROD);
                entries.add(ModItems.METAL_DETECTOR_LEVEL_1);
                entries.add(ModItems.TITANIUM_PICKAXE);
                entries.add(ModItems.TITANIUM_AXE);
                entries.add(ModItems.TITANIUM_SHOVEL);
                entries.add(ModItems.TITANIUM_HOE);
                entries.add(ModItems.TITANIUM_SWORD);
                //Block Items
                entries.add(ModBlocks.TITANIUM_BLOCK);
                entries.add(ModBlocks.RAW_TITANIUM_BLOCK);
                entries.add(ModBlocks.TITANIUM_ORE);
                entries.add(ModBlocks.DEEPSLATE_TITANIUM_ORE);
                entries.add(ModBlocks.POISONOUS_BLOCK);
                entries.add(ModBlocks.TITANIUM_BUTTON);
                entries.add(ModBlocks.TITANIUM_DOOR);
                entries.add(ModBlocks.TITANIUM_TRAPDOOR);
                entries.add(ModBlocks.LANDMINE);

            }).build());

    public static void registerItemGroups() {


        AtomicEulogy.LOGGER.info("Registering Mod Item Groups for " + AtomicEulogy.MOD_ID);
    }
}
