package com.brand.blockus.datagen.providers;

import com.brand.blockus.registry.content.BlockusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;


public class VanillaRecipeOverride extends FabricRecipeProvider {
    public VanillaRecipeOverride(FabricPackOutput result, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(result, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registriesFuture, RecipeOutput output) {
        return new RecipeProvider(registriesFuture, output) {
            @Override
            public void buildRecipes() {
                shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO_PLANKS, 2).requires(Blocks.STRIPPED_BAMBOO_BLOCK).group("planks").unlockedBy(getHasName(Blocks.STRIPPED_BAMBOO_BLOCK), has(Blocks.STRIPPED_BAMBOO_BLOCK)).save(output);
                polished(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICKS, BlockusBlocks.POLISHED_END_STONE.block());
                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_PILLAR).define('#', Blocks.PURPUR_BLOCK).pattern("#").pattern("#").unlockedBy(getHasName(Blocks.PURPUR_BLOCK), has(Blocks.PURPUR_BLOCK)).save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Vanilla Recipes Override";
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.withDefaultNamespace(identifier.getPath());
    }
}
