package net.yeetdot.atomiceulogy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class LandmineBlock extends Block {
    public LandmineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity){
            primeTnt(world, pos, (LivingEntity) entity);
            primeTnt(world, pos, (LivingEntity) entity);
            primeTnt(world, pos, (LivingEntity) entity);
            primeTnt(world, pos, (LivingEntity) entity);
            primeTnt(world, pos, (LivingEntity) entity);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            if (world.isReceivingRedstonePower(pos)) {
                primeTnt(world, pos);
                world.removeBlock(pos, false);
            }

        }
    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient()) {
            primeTnt(world, pos, player);
            primeTnt(world, pos, player);
            primeTnt(world, pos, player);
        }

        return super.onBreak(world, pos, state, player);
    }

    public static void primeTnt(World world, BlockPos pos) {
        primeTnt(world, pos, (LivingEntity)null);
    }

    private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (!world.isClient) {
            TntEntity tntEntity = new TntEntity(world, (double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5, igniter);
            tntEntity.setFuse(0);
            world.spawnEntity(tntEntity);
            world.playSound((PlayerEntity)null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }
}
