package net.yeetdot.atomiceulogy.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.yeetdot.atomiceulogy.block.ModBlocks;
import net.yeetdot.atomiceulogy.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TITANIUM_BLOCK);
        addDrop(ModBlocks.RAW_TITANIUM_BLOCK);
        addDrop(ModBlocks.POISONOUS_BLOCK);
        addDrop(ModBlocks.TITANIUM_TRAPDOOR);
        addDrop(ModBlocks.TITANIUM_BUTTON);

        addDrop(ModBlocks.TITANIUM_DOOR, doorDrops(ModBlocks.TITANIUM_DOOR));

        addDrop(ModBlocks.TITANIUM_ORE, oreDrops(ModBlocks.TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.DEEPSLATE_TITANIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_TITANIUM_ORE, ModItems.RAW_TITANIUM));
    }
}
