package net.yeetdot.atomiceulogy.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.yeetdot.atomiceulogy.AtomicEulogy;

public class ModItems {
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget", new Item(new FabricItemSettings()));
    public static final Item RADIANCE_ROD = registerItem("radiance_rod", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

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
