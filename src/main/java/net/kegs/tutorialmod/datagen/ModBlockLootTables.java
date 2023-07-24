package net.kegs.tutorialmod.datagen;

import net.kegs.tutorialmod.block.ModBlocks;
import net.kegs.tutorialmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

        add(ModBlocks.SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        add(ModBlocks.END_SAPPHIRE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.END_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
