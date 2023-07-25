package net.kegs.tutorialmod.datagen;

import net.kegs.tutorialmod.TutorialMod;
import net.kegs.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.EBONY_PLANKS);
        logBlockWithItem(ModBlocks.EBONY_LOG, "_top");
        woodBlockWithItem(ModBlocks.EBONY_WOOD, ModBlocks.EBONY_LOG);
        logBlockWithItem(ModBlocks.STRIPPED_EBONY_LOG, "_top");
        woodBlockWithItem(ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG);
        slabBlockWithItem(ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PLANKS);
        stairBlockWithItem(ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_PLANKS);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void logBlockWithItem(RegistryObject<RotatedPillarBlock> blockRegistryObject, String topTextureSuffix) {
        RotatedPillarBlock logBlockInfo = blockRegistryObject.get();
        logBlock(logBlockInfo);
        itemModels().cubeColumn(name(logBlockInfo), blockTexture(logBlockInfo), extend(blockTexture(logBlockInfo), topTextureSuffix));
    }

    private void woodBlockWithItem(
            RegistryObject<RotatedPillarBlock> woodBlockRegistryObject,
            RegistryObject<RotatedPillarBlock> textureOverrideBlockRegistryObject) {
        ResourceLocation textureOverride = blockTexture(textureOverrideBlockRegistryObject.get());
        RotatedPillarBlock woodBlockInfo = woodBlockRegistryObject.get();
        axisBlock(woodBlockInfo, textureOverride, textureOverride);
        itemModels().cubeColumn(name(woodBlockInfo), textureOverride, textureOverride);
    }

    private void slabBlockWithItem(
            RegistryObject<SlabBlock> slabBlockRegistryObject,
            RegistryObject<Block> textureRegistryObject
    ) {
        ResourceLocation textureLocation = blockTexture(textureRegistryObject.get());
        slabBlock(slabBlockRegistryObject.get(), textureLocation, textureLocation);
        itemModels().slab(name(slabBlockRegistryObject.get()), textureLocation, textureLocation, textureLocation);
    }

    private void stairBlockWithItem(
            RegistryObject<StairBlock> stairBlockRegistryObject,
            RegistryObject<Block> textureRegistryObject
    ) {
        ResourceLocation textureLocation = blockTexture(textureRegistryObject.get());
        stairsBlock(stairBlockRegistryObject.get(), textureLocation);
        itemModels().stairs(name(stairBlockRegistryObject.get()), textureLocation, textureLocation, textureLocation);
    }
}
