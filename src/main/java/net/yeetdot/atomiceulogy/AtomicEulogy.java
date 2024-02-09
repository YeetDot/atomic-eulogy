package net.yeetdot.atomiceulogy;

import net.fabricmc.api.ModInitializer;

import net.yeetdot.atomiceulogy.item.ModItemGroups;
import net.yeetdot.atomiceulogy.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtomicEulogy implements ModInitializer {
	public static final String MOD_ID = "atomiceulogy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		LOGGER.info("Hello Fabric world!");
	}
}