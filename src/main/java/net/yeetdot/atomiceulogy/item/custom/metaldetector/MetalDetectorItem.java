package net.yeetdot.atomiceulogy.item.custom.metaldetector;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.atomiceulogy.metal_detector_level_1.tooltip_line_1"));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            foundBlock = search(context, positionClicked, player, foundBlock);


            if (!foundBlock) {
                foundBlock = search(context, new BlockPos(positionClicked.getX()+1, positionClicked.getY(), positionClicked.getZ()), player, foundBlock);
                if (!foundBlock) {
                    foundBlock = search(context, new BlockPos(positionClicked.getX()+1, positionClicked.getY(), positionClicked.getZ()+1), player, foundBlock);
                    if (!foundBlock) {
                        foundBlock = search(context, new BlockPos(positionClicked.getX(), positionClicked.getY(), positionClicked.getZ()+1), player, foundBlock);
                        if (!foundBlock) {
                            foundBlock = search(context, new BlockPos(positionClicked.getX()-1, positionClicked.getY(), positionClicked.getZ()+1), player, foundBlock);
                            if (!foundBlock) {
                                foundBlock = search(context, new BlockPos(positionClicked.getX()-1, positionClicked.getY(), positionClicked.getZ()), player, foundBlock);
                                if (!foundBlock) {
                                    foundBlock = search(context, new BlockPos(positionClicked.getX()-1, positionClicked.getY(), positionClicked.getZ()-1), player, foundBlock);
                                    if (!foundBlock) {
                                        foundBlock = search(context, new BlockPos(positionClicked.getX(), positionClicked.getY(), positionClicked.getZ()-1), player, foundBlock);
                                        if (!foundBlock) {
                                            foundBlock = search(context, new BlockPos(positionClicked.getX()+1, positionClicked.getY(), positionClicked.getZ()-1), player, foundBlock);
                                            if (!foundBlock){
                                                context.getStack().damage(128, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                                                player.sendMessage(Text.literal("No Valuables Detected"), true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(!player.getAbilities().creativeMode){
                player.getItemCooldownManager().set(this, 20);
            }
        }


        return ActionResult.SUCCESS;
    }

    private boolean search(ItemUsageContext context, BlockPos positionClicked, PlayerEntity player, boolean foundBlock) {

        for (int i = 0; i <= positionClicked.getY() + 64; i++){
            BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

            if(isValuableBlock(state)) {
                outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                foundBlock = true;
                context.getStack().damage(positionClicked.getY() - positionClicked.down(i).getY(), context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                break;
            }
        }

        return foundBlock;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), true);
    }

    public abstract boolean isValuableBlock(BlockState state);
}
