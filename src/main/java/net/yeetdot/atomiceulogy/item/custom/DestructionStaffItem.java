package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DestructionStaffItem extends RayTracingItem {
    public DestructionStaffItem(Settings settings) {
        super(settings);
    }



    @Override
    public void onMiss(World world, PlayerEntity player, Hand hand) {

    }

    @Override
    public void onHitBlock(World world, PlayerEntity player, Hand hand, BlockPos pos) {
        if(!world.isClient){
            world.breakBlock(pos, true);
            if(!player.getAbilities().creativeMode) player.getItemCooldownManager().set(this, 600);
            world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.PLAYERS, 5, 1);
        }
    }

    @Override
    public void onHitEntity(World world, PlayerEntity player, Hand hand, Entity entity) {
        if(!world.isClient){
            player.sendMessage(Text.literal(String.valueOf(entity.getName())));
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.kill();
                if(!player.getAbilities().creativeMode) player.getItemCooldownManager().set(this, 600);
                world.playSound(entity, entity.getBlockPos(), SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.PLAYERS, 5, 1);
            }

        }
    }
}
