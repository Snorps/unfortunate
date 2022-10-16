package com.snorps.unfortunate.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Map;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {

    @ModifyVariable(method = "getDrops", at = @At("HEAD"), ordinal = 0, require = 1)
    public LootContext.Builder applyFortune(LootContext.Builder lootContextBuilder) {
        ItemStack tool = lootContextBuilder.getParameter(LootContextParams.TOOL);
        Map<Enchantment, Integer> enchantmentMap = EnchantmentHelper.getEnchantments(tool);

        Enchantment fortuneEnchantment = Enchantments.BLOCK_FORTUNE;
        enchantmentMap.put(fortuneEnchantment, fortuneEnchantment.getMaxLevel());

        EnchantmentHelper.setEnchantments(enchantmentMap, tool);
        return lootContextBuilder.withParameter(LootContextParams.TOOL, tool);
    }
}