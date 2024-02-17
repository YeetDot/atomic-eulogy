package net.yeetdot.atomiceulogy.item.custom;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.yeetdot.atomiceulogy.item.ModItems;

public class EthereumSwordItem extends SwordItem {
    public EthereumSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity){
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 5, true, false, false));
        } else {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 255, true, false, false));
        }

        target.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.TITANIUM_NUGGET, 1));

        return super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        entity.dropStack(entity.getMainHandStack());
        entity.dropStack(entity.getOffHandStack());
        entity.dropStack(entity.getEquippedStack(EquipmentSlot.HEAD));
        entity.dropStack(entity.getEquippedStack(EquipmentSlot.CHEST));
        entity.dropStack(entity.getEquippedStack(EquipmentSlot.LEGS));
        entity.dropStack(entity.getEquippedStack(EquipmentSlot.FEET));
        entity.kill();
        
        player.getInventory().clear();
        for (int i = 0; i <= 35; i++){
            player.dropStack(new ItemStack(Items.BOWL, 64));
        }
        player.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOWL, 127));
        player.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.BOWL, 127));
        player.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.BOWL, 127));
        player.getEquippedStack(EquipmentSlot.HEAD).addEnchantment(Enchantments.BINDING_CURSE, 1);
        player.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.BOWL, 127));
        player.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(Enchantments.BINDING_CURSE, 1);
        player.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.BOWL, 127));
        player.getEquippedStack(EquipmentSlot.LEGS).addEnchantment(Enchantments.BINDING_CURSE, 1);
        player.equipStack(EquipmentSlot.FEET, new ItemStack(Items.BOWL, 127));
        player.getEquippedStack(EquipmentSlot.FEET).addEnchantment(Enchantments.BINDING_CURSE, 1);
        
        return ActionResult.SUCCESS;
    }
}