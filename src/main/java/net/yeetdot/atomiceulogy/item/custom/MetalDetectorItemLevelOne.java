package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.block.BlockState;
import net.yeetdot.atomiceulogy.util.ModTags;

public class MetalDetectorItemLevelOne extends AbstractMetalDetectorItem {
    public MetalDetectorItemLevelOne(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_LEVEL_1_DETECTABLE_BLOCKS);
    }
}
