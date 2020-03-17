package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blockentity.WoodenBarrelBlockEntity;
import com.brand.blockus.blocks.Wood.WoodenBarrels;
import com.mojang.datafixers.types.Type;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Barrels {
	
	public static final WoodenBarrels OAK_BARREL = new WoodenBarrels("oak_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels BIRCH_BARREL = new WoodenBarrels("birch_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels JUNGLE_BARREL = new WoodenBarrels("jungle_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels ACACIA_BARREL = new WoodenBarrels("acacia_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels DARK_OAK_BARREL = new WoodenBarrels("dark_oak_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels CRIMSON_BARREL = new WoodenBarrels("crimson_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels WARPED_BARREL = new WoodenBarrels("warped_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels WHITE_OAK_BARREL = new WoodenBarrels("white_oak_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels BAMBOO_BARREL = new WoodenBarrels("bamboo_barrel", 2.0f, 3.0f);
	public static final WoodenBarrels CHARRED_BARREL = new WoodenBarrels("charred_barrel", 2.0f, 3.0f);
	
	public static final BlockEntityType<WoodenBarrelBlockEntity> WOODEN_BARREL = registerBe("wooden_barrel", BlockEntityType.Builder.create(WoodenBarrelBlockEntity::new, OAK_BARREL, BIRCH_BARREL, JUNGLE_BARREL, ACACIA_BARREL, CRIMSON_BARREL, WARPED_BARREL, DARK_OAK_BARREL, WHITE_OAK_BARREL, BAMBOO_BARREL, CHARRED_BARREL));
	
	@SuppressWarnings("rawtypes")
	private static <T extends BlockEntity> BlockEntityType<T> registerBe(String name, BlockEntityType.Builder<T> builder) {
		Type type = null;
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Blockus.MOD_ID, name), builder.build(type));
	}

}
