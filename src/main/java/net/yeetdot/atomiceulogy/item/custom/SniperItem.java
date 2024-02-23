package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SniperItem extends Item {
    public SniperItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ArrowEntity arrow = new ArrowEntity(player.getEntityWorld(), player, player.getStackInHand(hand));
        arrow.setPosition(player.getEyePos());
        arrow.setVelocity(player.getRotationVec(1f).getX(), player.getRotationVec(1f).getY(), player.getRotationVec(1f).getZ(), 300, 0);
        player.getEntityWorld().spawnEntity(arrow);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
