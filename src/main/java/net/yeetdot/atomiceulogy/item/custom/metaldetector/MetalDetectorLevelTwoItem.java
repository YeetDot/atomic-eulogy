package net.yeetdot.atomiceulogy.item.custom.metaldetector;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.yeetdot.atomiceulogy.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorLevelTwoItem extends MetalDetectorItem{
    public MetalDetectorLevelTwoItem(Settings settings) {super(settings);}

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector_level_2.tooltip"));
    }

    @Override
    public boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_LEVEL_2_DETECTABLE_BLOCKS);
    }
}
