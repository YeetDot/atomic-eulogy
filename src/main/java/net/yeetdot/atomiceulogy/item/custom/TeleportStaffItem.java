package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeleportStaffItem extends RayTracingItem {
    public TeleportStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onMiss(World world, PlayerEntity player, Hand hand) {
    }

    @Override
    public void onHitBlock(World world, PlayerEntity player, Hand hand, BlockPos pos) {
        if(!world.isClient) {
            player.teleport(pos.getX(), pos.getY() + 1, pos.getZ());
            player.getItemCooldownManager().set(this, 20);
            world.playSound(player, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1, 1);
        }
    }

    @Override
    public void onHitEntity(World world, PlayerEntity player, Hand hand, Entity entity) {
        if(!world.isClient) {
            entity.teleport(player.getX(), player.getY(), player.getZ());
            player.getItemCooldownManager().set(this, 20);
            world.playSound(player, entity.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1, 1);
        }
    }
}