package net.yeetdot.atomiceulogy.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.yeetdot.atomiceulogy.block.ModBlocks;
import net.yeetdot.atomiceulogy.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> TITANIUM_SMELTABLES = List.of(ModItems.RAW_TITANIUM, ModBlocks.TITANIUM_ORE, ModBlocks.DEEPSLATE_TITANIUM_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT, 0.7f, 200, "titanium");
        offerBlasting(exporter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT, 0.7f, 100, "titanium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TITANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TITANIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_TITANIUM_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POISONOUS_BLOCK, 1)
                .pattern(" E ")
                .pattern("ESE")
                .pattern(" E ")
                .input('E', Items.SPIDER_EYE)
                .input('S', Items.SLIME_BALL)
                .criterion(hasItem(Items.SPIDER_EYE), conditionsFromItem(Items.SPIDER_EYE))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POISONOUS_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TITANIUM_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.TITANIUM_NUGGET)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier("titanium_ingot_from_titanium_nugget"));

        offerShapelessRecipe(exporter, ModItems.TITANIUM_NUGGET, ModItems.TITANIUM_INGOT, "titanium_ingot", 9);



        createDoorRecipe(ModBlocks.TITANIUM_DOOR, Ingredient.ofItems(ModItems.TITANIUM_INGOT))
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TITANIUM_DOOR)));

        createTrapdoorRecipe(ModBlocks.TITANIUM_TRAPDOOR, Ingredient.ofItems(ModItems.TITANIUM_INGOT))
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TITANIUM_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_PICKAXE, 1)
                .pattern("TTT")
                .pattern(" / ")
                .pattern(" / ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TITANIUM_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_SHOVEL, 1)
                .pattern("T")
                .pattern("/")
                .pattern("/")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TITANIUM_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_HOE, 1)
                .pattern("TT")
                .pattern(" /")
                .pattern(" /")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier("titanium_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_HOE, 1)
                .pattern("TT")
                .pattern("/ ")
                .pattern("/ ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier("titanium_hoe_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_AXE, 1)
                .pattern("TT")
                .pattern("T/")
                .pattern(" /")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier("titanium_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_AXE, 1)
                .pattern("TT")
                .pattern("/T")
                .pattern("/ ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier("titanium_axe_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TITANIUM_SWORD, 1)
                .pattern("T")
                .pattern("T")
                .pattern("/")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TITANIUM_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETHEREUM_PICKAXE, 1)
                .pattern("TTT")
                .pattern(" / ")
                .pattern(" / ")
                .input('T', ModItems.ETHEREUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETHEREUM_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETHEREUM_SHOVEL, 1)
                .pattern("T")
                .pattern("/")
                .pattern("/")
                .input('T', ModItems.ETHEREUM_SHOVEL)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETHEREUM_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETHEREUM_HOE, 1)
                .pattern("TT")
                .pattern(" /")
                .pattern(" /")
                .input('T', ModItems.ETHEREUM_HOE)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier("ethereum_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETHEREUM_HOE, 1)
                .pattern("TT")
                .pattern("/ ")
                .pattern("/ ")
                .input('T', ModItems.ETHEREUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier("ethereum_hoe_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETHEREUM_AXE, 1)
                .pattern("TT")
                .pattern("T/")
                .pattern(" /")
                .input('T', ModItems.ETHEREUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier("ethereum_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETHEREUM_AXE, 1)
                .pattern("TT")
                .pattern("/T")
                .pattern("/ ")
                .input('T', ModItems.ETHEREUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier("ethereum_axe_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ETHEREUM_SWORD, 1)
                .pattern("T")
                .pattern("T")
                .pattern("/")
                .input('T', ModItems.ETHEREUM_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.ETHEREUM_INGOT), conditionsFromItem(ModItems.ETHEREUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETHEREUM_SWORD)));

    }

}
