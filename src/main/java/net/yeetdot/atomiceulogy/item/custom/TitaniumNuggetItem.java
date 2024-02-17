package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.yeetdot.atomiceulogy.damage_type.ModDamageTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.atomiceulogy.titanium_nugget.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient){
            if (user instanceof PlayerEntity player){
                if (!player.getAbilities().creativeMode){
                    player.damage(ModDamageTypes.of(world, ModDamageTypes.ATE_TITANIUM_DAMAGE_TYPE), Float.MAX_VALUE);
                }
            }
        }
        return itemStack;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(entity.getHealth() <= 30){
            entity.kill();
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
