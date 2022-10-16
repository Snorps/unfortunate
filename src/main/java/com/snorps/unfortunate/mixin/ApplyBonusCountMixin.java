package com.snorps.unfortunate.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ApplyBonusCount.class)
public class ApplyBonusCountMixin {
    @Redirect(method = "run", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getItemEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/item/ItemStack;)I"))
    private int setLevel(Enchantment ench, ItemStack itemstack) {
        if (ench == Enchantments.BLOCK_FORTUNE) {
            return 3;
        }
        return EnchantmentHelper.getItemEnchantmentLevel(ench, itemstack);
    }
}