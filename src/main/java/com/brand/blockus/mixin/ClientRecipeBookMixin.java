package com.brand.blockus.mixin;

import com.brand.blockus.BlockusClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;

@Environment(EnvType.CLIENT)
@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {
    @Inject(method = "getGroupForRecipe", at = @At("HEAD"), cancellable = true)
    private static void getGroupForBlockusRecipe(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookGroup> ci) {
        RecipeType<?> type = recipe.getType();
        if (type == RecipeType.CRAFTING) {
            ItemStack output = recipe.getOutput();
            ItemGroup itemGroup = output.getItem().getGroup();

            RecipeBookGroup group = BlockusClient.getRecipeBookGroup(itemGroup);
            if (group != null) {
                ci.setReturnValue(group);
            }
        }
    }
}
