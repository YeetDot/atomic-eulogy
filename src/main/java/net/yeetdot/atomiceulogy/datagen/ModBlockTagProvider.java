package net.yeetdot.atomiceulogy.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.yeetdot.atomiceulogy.block.ModBlocks;
import net.yeetdot.atomiceulogy.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_LEVEL_1_DETECTABLE_BLOCKS)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.TITANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(ModBlocks.RAW_TITANIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.TITANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(ModBlocks.RAW_TITANIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.POISONOUS_BLOCK);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.TITANIUM_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.TITANIUM_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.TITANIUM_BUTTON);

    }
}
