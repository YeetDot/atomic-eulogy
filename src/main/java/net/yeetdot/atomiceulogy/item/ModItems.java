package net.yeetdot.atomiceulogy.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.yeetdot.atomiceulogy.AtomicEulogy;
import net.yeetdot.atomiceulogy.item.custom.*;
import net.yeetdot.atomiceulogy.item.custom.metaldetector.*;

public class ModItems {
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget", new TitaniumNuggetItem(new FabricItemSettings().food(ModFoodComponents.TITANIUM_NUGGET)));
    public static final Item RADIANCE_ROD = registerItem("radiance_rod", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item METAL_DETECTOR_LEVEL_1 = registerItem("metal_detector_level_1", new MetalDetectorLevelOneItem(new FabricItemSettings().maxDamage(16384)));
    public static final Item METAL_DETECTOR_LEVEL_2 = registerItem("metal_detector_level_2", new MetalDetectorLevelTwoItem(new FabricItemSettings().maxDamage(16384)));
    public static final Item METAL_DETECTOR_LEVEL_3 = registerItem("metal_detector_level_3", new MetalDetectorLevelThreeItem(new FabricItemSettings().maxDamage(16384)));
    public static final Item TELEPORT_STAFF = registerItem("teleport_staff", new TeleportStaffItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item DESTRUCTION_STAFF = registerItem("destruction_staff", new DestructionStaffItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item SNIPER = registerItem("sniper", new SniperItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item ETHEREUM_INGOT = registerItem("ethereum_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_ETHEREUM = registerItem("raw_ethereum", new Item(new FabricItemSettings()));
    public static final Item ETHEREUM_NUGGET = registerItem("ethereum_nugget", new Item(new FabricItemSettings()));

    public static final Item NEUTRONIUM_INGOT = registerItem("neutronium_ingot", new Item(new FabricItemSettings()));
    public static final Item NEUTRONIUM_NUGGET = registerItem("neutronium_nugget", new Item(new FabricItemSettings()));

    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe", new PickaxeItem(ModToolMaterial.TITANIUM, 1, -2.8f, new Item.Settings()));
    public static final Item TITANIUM_SHOVEL = registerItem("titanium_shovel", new ShovelItem(ModToolMaterial.TITANIUM, 1.5f, -3, new Item.Settings()));
    public static final Item TITANIUM_AXE = registerItem("titanium_axe", new AxeItem(ModToolMaterial.TITANIUM, 6, -3.1f, new Item.Settings()));
    public static final Item TITANIUM_HOE = registerItem("titanium_hoe", new HoeItem(ModToolMaterial.TITANIUM, 0, -1, new Item.Settings()));
    public static final Item TITANIUM_SWORD = registerItem("titanium_sword", new SwordItem(ModToolMaterial.TITANIUM, 3, -2.4f, new Item.Settings()));

    public static final Item ETHEREUM_PICKAXE = registerItem("ethereum_pickaxe", new PickaxeItem(ModToolMaterial.ETHEREUM, 1, -2.8f, new Item.Settings()));
    public static final Item ETHEREUM_SHOVEL = registerItem("ethereum_shovel", new ShovelItem(ModToolMaterial.ETHEREUM, 1.5f, -3, new Item.Settings()));
    public static final Item ETHEREUM_AXE = registerItem("ethereum_axe", new AxeItem(ModToolMaterial.ETHEREUM, 6, -2.8f, new Item.Settings()));
    public static final Item ETHEREUM_HOE = registerItem("ethereum_hoe", new HoeItem(ModToolMaterial.ETHEREUM, 0, -1, new Item.Settings()));
    public static final Item ETHEREUM_SWORD = registerItem("ethereum_sword", new EthereumSwordItem(ModToolMaterial.ETHEREUM, 3, -2.4f, new Item.Settings()));

    public static final Item NEUTRONIUM_PICKAXE = registerItem("neutronium_pickaxe", new PickaxeItem(ModToolMaterial.NEUTRONIUM, 1, -2.8f, new Item.Settings()));
    public static final Item NEUTRONIUM_SHOVEL = registerItem("neutronium_shovel", new ShovelItem(ModToolMaterial.NEUTRONIUM, 1.5f, -3, new Item.Settings()));
    public static final Item NEUTRONIUM_AXE = registerItem("neutronium_axe", new AxeItem(ModToolMaterial.NEUTRONIUM, 6, -2.8f, new Item.Settings()));
    public static final Item NEUTRONIUM_HOE = registerItem("neutronium_hoe", new HoeItem(ModToolMaterial.NEUTRONIUM, 0, -1, new Item.Settings()));
    public static final Item NEUTRONIUM_SWORD = registerItem("neutronium_sword", new SwordItem(ModToolMaterial.NEUTRONIUM, 3, -2.4f, new Item.Settings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.IRON_INGOT, TITANIUM_INGOT);
        entries.addAfter(Items.RAW_IRON, RAW_TITANIUM);
        entries.addAfter(Items.IRON_NUGGET, TITANIUM_NUGGET);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AtomicEulogy.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        AtomicEulogy.LOGGER.info("Registering Mod Items for " + AtomicEulogy.MOD_ID);
    }
}