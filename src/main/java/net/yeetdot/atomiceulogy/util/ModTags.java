package net.yeetdot.atomiceulogy.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yeetdot.atomiceulogy.AtomicEulogy;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_LEVEL_1_DETECTABLE_BLOCKS = createTag("metal_detector_level_1_detectable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(AtomicEulogy.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(AtomicEulogy.MOD_ID, name));
        }
    }

}
