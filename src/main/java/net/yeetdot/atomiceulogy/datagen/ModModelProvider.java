package net.yeetdot.atomiceulogy.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.yeetdot.atomiceulogy.block.ModBlocks;
import net.yeetdot.atomiceulogy.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }



    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool titaniumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POISONOUS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TITANIUM_ORE);

        titaniumPool.button(ModBlocks.TITANIUM_BUTTON);

        blockStateModelGenerator.registerDoor(ModBlocks.TITANIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TITANIUM_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TITANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TITANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ETHEREUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RADIANCE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TELEPORT_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESTRUCTION_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR_LEVEL_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREUM_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEUTRONIUM_SWORD, Models.GENERATED);
    }
}
