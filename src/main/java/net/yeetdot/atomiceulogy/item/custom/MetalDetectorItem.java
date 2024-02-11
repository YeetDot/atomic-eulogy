package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.yeetdot.atomiceulogy.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector.tooltip_line_1"));
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector.tooltip_line_2"));
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector.tooltip_line_3"));
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector.tooltip_line_4"));
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector.tooltip_line_5"));

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                    context.getStack().damage(positionClicked.getY() - positionClicked.down(i).getY(), context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                    break;
                }
            }

            if (!foundBlock) {
                context.getStack().damage(128, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                player.sendMessage(Text.literal("No Valuables Found"), true);
            }
        }


        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), true);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE) || state.isOf(ModBlocks.TITANIUM_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(ModBlocks.DEEPSLATE_TITANIUM_ORE);

    }
}
