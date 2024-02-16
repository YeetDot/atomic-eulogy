package net.yeetdot.atomiceulogy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class LandmineBlock extends Block {
    public LandmineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 1, 15, 1, 15), Block.createCuboidShape(7, 0.2, 7, 9, 1.2, 9), BooleanBiFunction.OR);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        world.removeBlock(pos, false);
        explode(world, entity, pos, 50);
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        world.removeBlock(pos, false);
        explode(world, entity, pos, 50);
        world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 100, World.ExplosionSourceType.BLOCK);
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            if (world.isReceivingRedstonePower(pos)) {
                world.removeBlock(pos, false);
                explode(world, null, pos, 10);
            }

        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            world.removeBlock(pos, false);
            explode(world,  null, pos, 10);
        }

    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        explode(world, player, pos, 1);
        return super.onBreak(world, pos, state, player);
    }

    private static void explode(World world, Entity entity, BlockPos pos, int amount){
        explode(world, entity, pos, amount, 0);
    }

    private static void explode(World world, Entity entity, BlockPos pos, int amount, int fuse){
        if(!world.isClient) {
            if (entity instanceof LivingEntity) {
                for (int i = 0; i <= amount; i++) {
                    primeTnt(world, pos, (LivingEntity) entity, fuse);
                }
            } else {
                for (int i = 0; i <= amount; i++) {
                    primeTnt(world, pos, null, fuse);
                }
            }
        }
    }

    private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter){
        primeTnt(world, pos, igniter, 0);
    }

    private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter, int fuse) {
        if (!world.isClient) {
            TntEntity tntEntity = new TntEntity(world, (double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, igniter);
            tntEntity.setFuse(fuse);
            world.spawnEntity(tntEntity);
            world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }
}
