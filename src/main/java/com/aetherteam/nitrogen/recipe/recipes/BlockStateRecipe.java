package com.aetherteam.nitrogen.recipe.recipes;

import com.aetherteam.nitrogen.recipe.BlockPropertyPair;
import com.aetherteam.nitrogen.recipe.BlockStateIngredient;
import net.minecraft.commands.CacheableFunction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

/**
 * Overrides anything container-related or item-related because these in-world recipes have no container and are {@link BlockState}-based. Instead, custom behavior is implemented by recipes that extend this.
 */
public interface BlockStateRecipe extends Recipe<Container> {
    BlockStateIngredient getIngredient();

    BlockPropertyPair getResult();

    BlockState getResultState(BlockState originalState);

    Optional<CacheableFunction> getFunction();

    Optional<ResourceLocation> getFunctionId();

    @Override
    default boolean matches(Container container, Level level) {
        return false;
    }

    @Override
    default ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    default boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    default ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    default NonNullList<ItemStack> getRemainingItems(Container container) {
        return NonNullList.create();
    }

    @Override
    default boolean isSpecial() {
        return true;
    }
}
