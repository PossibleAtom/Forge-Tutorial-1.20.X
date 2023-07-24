package net.kegs.tutorialmod.datagen;

import net.kegs.tutorialmod.block.ModBlocks;
import net.kegs.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModItems.RAW_SAPPHIRE.get()), RecipeCategory.MISC,
                ModItems.SAPPHIRE.get(), 0.7f, 200, "sapphire");

        oreBlasting(consumer, List.of(ModItems.RAW_SAPPHIRE.get()), RecipeCategory.MISC,
                ModItems.SAPPHIRE.get(), 0.7f, 200, "sapphire");

        /*
         2 Other ways of doing the nineBlockStorageRecipes below without the helper
         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
                 .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                 .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
                 .save(consumer);

         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                 .define('B', ModItems.BLACK_OPAL.get())
                 .pattern("BBB")
                 .pattern("BBB")
                 .pattern("BBB")
                 .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(ModItems.BLACK_OPAL.get()).build()))
                 .save(consumer);

        However, when using vanilla-like recipes you can (and should) always use the helper methods,
        if not try to define your own!
        */
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE.get(), RecipeCategory.MISC,
                ModBlocks.SAPPHIRE_BLOCK.get());

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE.get(), RecipeCategory.MISC,
                ModBlocks.RAW_SAPPHIRE_BLOCK.get());
    }
}
