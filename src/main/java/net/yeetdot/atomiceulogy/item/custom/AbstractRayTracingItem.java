package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AbstractRayTracingItem extends Item {
    public AbstractRayTracingItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        MinecraftClient client = MinecraftClient.getInstance();
        double maxReach = 1000;
        float tickDelta = 1.0F;
        boolean includeFluids = true;

        assert client.cameraEntity != null;
        HitResult hit = client.cameraEntity.raycast(maxReach, tickDelta, includeFluids);

        switch (hit.getType()){
            case MISS:
                onMiss(world, player, hand);
            case BLOCK:
                BlockHitResult blockHitResult = (BlockHitResult) hit;
                BlockPos pos = blockHitResult.getBlockPos();
                onHitBlock(world, player, hand, pos);

            case ENTITY:
                assert hit instanceof EntityHitResult;
                EntityHitResult entityHitResult = (EntityHitResult) hit;
                Entity entity = entityHitResult.getEntity();
                onHitEntity(world, player, hand, entity);
        }

        return super.use(world, player, hand);
    }

    public void onHitEntity(World world, PlayerEntity player, Hand hand, Entity entity) {
    }

    public void onHitBlock(World world, PlayerEntity player, Hand hand, BlockPos pos) {
    }

    public void onMiss(World world, PlayerEntity player, Hand hand) {
    }
}
