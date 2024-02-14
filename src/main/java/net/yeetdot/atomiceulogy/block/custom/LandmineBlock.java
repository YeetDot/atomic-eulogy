package net.yeetdot.atomiceulogy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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
        explode(world, entity, pos, 10f);
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        explode(world, entity, pos, 10f);
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            if (world.isReceivingRedstonePower(pos)) {
                explode(world,  null, pos, 100f);
                world.removeBlock(pos, false);
            }

        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            explode(world,  null, pos, 100f);
            world.removeBlock(pos, false);
        }

    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient()) {
            explode(world, player, pos, 1f);
        }

        return super.onBreak(world, pos, state, player);
    }
    private static void explode(World world, Entity entity, BlockPos pos, float power){
        world.createExplosion(entity, pos.getX(), pos.getY() + 0.5, pos.getZ(), power, World.ExplosionSourceType.BLOCK);
    }
}
