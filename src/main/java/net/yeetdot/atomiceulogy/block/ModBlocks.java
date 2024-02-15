package net.yeetdot.atomiceulogy.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.yeetdot.atomiceulogy.AtomicEulogy;
import net.yeetdot.atomiceulogy.block.custom.LandmineBlock;
import net.yeetdot.atomiceulogy.block.custom.PoisonousBlock;

public class ModBlocks {
    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(7.0F,6.0F).mapColor(MapColor.GRAY)));
    public static final Block RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(7.0F,6.0F).mapColor(MapColor.DEEPSLATE_GRAY)));

    public static final Block POISONOUS_BLOCK = registerBlock("poisonous_block",
            new PoisonousBlock(FabricBlockSettings.create().mapColor(MapColor.LICHEN_GREEN).strength(0.5f)));
    public static final Block LANDMINE = registerBlock("landmine",
            new LandmineBlock(FabricBlockSettings.create().mapColor(MapColor.LICHEN_GREEN).solid().noCollision().dropsNothing()));

    public static final Block TITANIUM_ORE = registerBlock("titanium_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0), FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));

    public static final Block TITANIUM_BUTTON = registerBlock("titanium_button",
            new ButtonBlock(BlockSetType.IRON, 1, FabricBlockSettings.copyOf(Blocks.STONE_BUTTON)));


    public static final Block TITANIUM_DOOR = registerBlock("titanium_door",
            new DoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_DOOR).nonOpaque()));

    public static final Block TITANIUM_TRAPDOOR = registerBlock("titanium_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).nonOpaque()));


    private static void addItemsToBuildingBlockGroup(FabricItemGroupEntries entries) {
        entries.add(TITANIUM_BLOCK);
    }

    private static void addItemsToNaturalBlockGroup(FabricItemGroupEntries entries) {
        entries.add(RAW_TITANIUM_BLOCK);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AtomicEulogy.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AtomicEulogy.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlockGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemsToNaturalBlockGroup);
        AtomicEulogy.LOGGER.info("Registering Mod Blocks for " + AtomicEulogy.MOD_ID);
    }
}
