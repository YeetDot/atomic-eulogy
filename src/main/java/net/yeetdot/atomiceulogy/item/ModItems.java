package net.yeetdot.atomiceulogy.item;

import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.yeetdot.atomiceulogy.AtomicEulogy;
import net.yeetdot.atomiceulogy.item.custom.MetalDetectorItemLevel1;
import net.yeetdot.atomiceulogy.item.custom.TitaniumNuggetItem;

public class ModItems {
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget", new TitaniumNuggetItem(new FabricItemSettings().food(ModFoodComponents.TITANIUM_NUGGET)));
    public static final Item RADIANCE_ROD = registerItem("radiance_rod", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item METAL_DETECTOR_LEVEL_1 = registerItem("metal_detector_level_1", new MetalDetectorItemLevel1(new FabricItemSettings().maxDamage(16384)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(TITANIUM_INGOT);
        entries.add(RAW_TITANIUM);
        entries.add(TITANIUM_NUGGET);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AtomicEulogy.MOD_ID, name), item);
    }
    public static void registerModItems() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        AtomicEulogy.LOGGER.info("Registering Mod Items for " + AtomicEulogy.MOD_ID);
    }
}
