package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.yeetdot.atomiceulogy.damage_type.ModDamageTypes;

public class TitaniumNuggetItem extends Item {
    public TitaniumNuggetItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.sendMessage(Text.literal("Don't eat it or else..."), true);

        return super.use(world, player, hand);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient){
            if (user instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) user;
                if (!player.getAbilities().creativeMode){
                    player.damage(ModDamageTypes.of(world, ModDamageTypes.ATE_TITANIUM_DAMAGE_TYPE), Float.MAX_VALUE);
                }
            }
        }

        return itemStack;
    }
}
