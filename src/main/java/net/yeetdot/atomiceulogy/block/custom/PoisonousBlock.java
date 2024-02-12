package net.yeetdot.atomiceulogy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.yeetdot.atomiceulogy.damage_type.ModDamageTypes;

public class PoisonousBlock extends Block {
    public PoisonousBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                if (!livingEntity.isInvulnerableTo(world.getDamageSources().wither())) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60));
                }
                livingEntity.damage(ModDamageTypes.of(world, ModDamageTypes.POISONOUS_BLOCK_DAMAGE_TYPE), 1.0f);
            }

        }
    }



}
