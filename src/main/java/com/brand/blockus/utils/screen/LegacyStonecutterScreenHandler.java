package com.brand.blockus.utils.screen;

import com.brand.blockus.registry.content.BlockusBlocks;
import com.google.common.collect.Lists;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.Level;

import java.util.List;

public class LegacyStonecutterScreenHandler extends AbstractContainerMenu {
    public static final int INPUT_ID = 0;
    public static final int OUTPUT_ID = 1;
    private static final int INVENTORY_START = 2;
    private static final int INVENTORY_END = 29;
    private static final int OUTPUT_START = 29;
    private static final int OUTPUT_END = 38;
    private final ContainerLevelAccess context;
    private final DataSlot selectedRecipe;
    private final Level world;
    private List<RecipeHolder<StonecutterRecipe>> availableRecipes;
    private ItemStack inputStack;
    long lastTakeTime;
    final Slot inputSlot;
    final Slot outputSlot;
    Runnable contentsChangedListener;
    public final Container input;
    final ResultContainer output;

    public LegacyStonecutterScreenHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, ContainerLevelAccess.NULL);
    }

    public LegacyStonecutterScreenHandler(int syncId, Inventory playerInventory, final ContainerLevelAccess context) {
        super(MenuType.STONECUTTER, syncId);
        this.selectedRecipe = DataSlot.standalone();
        this.availableRecipes = Lists.newArrayList();
        this.inputStack = ItemStack.EMPTY;
        this.contentsChangedListener = () -> {
        };
        this.input = new SimpleContainer(1) {
            public void setChanged() {
                super.setChanged();
                LegacyStonecutterScreenHandler.this.slotsChanged(this);
                LegacyStonecutterScreenHandler.this.contentsChangedListener.run();
            }
        };
        this.output = new ResultContainer();
        this.context = context;
        this.world = playerInventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                LegacyStonecutterScreenHandler.this.output.awardUsedRecipes(player, this.getInputStacks());
                ItemStack itemStack = LegacyStonecutterScreenHandler.this.inputSlot.remove(1);
                if (!itemStack.isEmpty()) {
                    LegacyStonecutterScreenHandler.this.populateResult();
                }

                context.execute((world, pos) -> {
                    long l = world.getGameTime();
                    if (LegacyStonecutterScreenHandler.this.lastTakeTime != l) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        LegacyStonecutterScreenHandler.this.lastTakeTime = l;
                    }

                });
                super.onTake(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(LegacyStonecutterScreenHandler.this.inputSlot.getItem());
            }
        });

        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addDataSlot(this.selectedRecipe);
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public List<RecipeHolder<StonecutterRecipe>> getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && !this.availableRecipes.isEmpty();
    }

    public boolean stillValid(Player player) {
        return stillValid(this.context, player, BlockusBlocks.LEGACY_STONECUTTER);
    }

    public boolean clickMenuButton(Player player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }

        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    public void slotsChanged(Container inventory) {
        ItemStack itemStack = this.inputSlot.getItem();
        if (!itemStack.is(this.inputStack.getItem())) {
            this.inputStack = itemStack.copy();
            this.updateInput(inventory, itemStack);
        }

    }

    private static SingleRecipeInput createRecipeInput(Container inventory) {
        return new SingleRecipeInput(inventory.getItem(0));
    }

    private void updateInput(Container input, ItemStack stack) {
        this.availableRecipes.clear();
        this.selectedRecipe.set(-1);
        this.outputSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.availableRecipes = this.world.getRecipeManager().getRecipesFor(RecipeType.STONECUTTING, createRecipeInput(input), this.world);
        }

    }

    void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RecipeHolder<StonecutterRecipe> recipeEntry = this.availableRecipes.get(this.selectedRecipe.get());
            ItemStack itemStack = recipeEntry.value().assemble(createRecipeInput(this.input), this.world.registryAccess());
            if (itemStack.isItemEnabled(this.world.enabledFeatures())) {
                this.output.setRecipeUsed(recipeEntry);
                this.outputSlot.set(itemStack);
            } else {
                this.outputSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return MenuType.STONECUTTER;
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.output && super.canTakeItemForPickAll(stack, slot);
    }

    public ItemStack quickMoveStack(Player player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasItem()) {
            ItemStack itemStack2 = slot2.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (slot == 1) {
                item.onCraftedBy(itemStack2, player.level(), player);
                if (!this.moveItemStackTo(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickCraft(itemStack2, itemStack);
            } else if (slot == 0) {
                if (!this.moveItemStackTo(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.world.getRecipeManager().getRecipeFor(RecipeType.STONECUTTING, new SingleRecipeInput(itemStack2), this.world).isPresent()) {
                if (!this.moveItemStackTo(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 2 && slot < 29) {
                if (!this.moveItemStackTo(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 29 && slot < 38 && !this.moveItemStackTo(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setByPlayer(ItemStack.EMPTY);
            }

            slot2.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTake(player, itemStack2);
            this.broadcastChanges();
        }

        return itemStack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.output.removeItemNoUpdate(1);
        this.context.execute((world, pos) -> {
            this.clearContainer(player, this.input);
        });
    }
}
