package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DestructionStaffItem extends AbstractRayTracingItem{
    public DestructionStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onMiss(World world, PlayerEntity player, Hand hand) {

        super.onMiss(world, player, hand);
    }

    @Override
    public void onHitBlock(World world, PlayerEntity player, Hand hand, BlockPos pos) {
        if(!world.isClient){
            world.breakBlock(pos, true);
            if(!player.getAbilities().creativeMode) player.getItemCooldownManager().set(this, 600);
            player.playSound(SoundEvents.ENTITY_ENDER_DRAGON_DEATH, 5, 1);
        }
    }

    @Override
    public void onHitEntity(World world, PlayerEntity player, Hand hand, Entity entity) {
        if(!world.isClient){
            entity.kill();
            if(!player.getAbilities().creativeMode) player.getItemCooldownManager().set(this, 600);
            player.playSound(SoundEvents.ENTITY_ENDER_DRAGON_DEATH, 5, 1);
        }
    }
}
