package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

@Mod.EventBusSubscriber(modid=ExampleMod.MODID)
public class ModBlocks {

	static Block saltyBlock;
	static Block tutorialBlock;
	public static Block tutorialOre;
	static Block tuturialOreMultiple;
	public static void init() {
		tutorialBlock = new BlockBasic("tutorialBlock", Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(1.0f);
		tutorialBlock.setHarvestLevel("pickaxe", 2);
		tutorialOre = new BlockOre("tutorialOre", Material.ROCK, ModItems.tutorialDust, 1, 5).setHardness(3f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		tutorialOre.setHarvestLevel("pickaxe", 2);
		tuturialOreMultiple = new BlockOreMultiple("tutorialOreMultiple", Material.ROCK).setHardness(3f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		tuturialOreMultiple.setHarvestLevel("pickaxe", 2);
		saltyBlock = new SaltyBlock("salty_block", Material.SAND);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		  event.getRegistry().registerAll(saltyBlock);
		  event.getRegistry().registerAll(tutorialBlock, tutorialOre, tuturialOreMultiple);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(saltyBlock).setRegistryName(saltyBlock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tutorialBlock).setRegistryName(tutorialBlock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tutorialOre).setRegistryName(tutorialOre.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tuturialOreMultiple).setRegistryName(tuturialOreMultiple.getRegistryName()));

	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(saltyBlock));
		registerRender(Item.getItemFromBlock(tutorialBlock));
		registerRender(Item.getItemFromBlock(tutorialOre));
		registerRender(Item.getItemFromBlock(tuturialOreMultiple));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}

}