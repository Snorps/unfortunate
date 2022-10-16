package com.snorps.unfortunate.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.LootBonusEnchantment;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootBonusEnchantment.class)
public abstract class FortuneEnchantmentMixin extends Enchantment {

	protected FortuneEnchantmentMixin(Rarity rarityIn, EnchantmentCategory typeIn, EquipmentSlot[] slots) {
		super(rarityIn, typeIn, slots);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}
}