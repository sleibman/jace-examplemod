package com.example.examplemod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid=ExampleMod.MODID)
public class ModItems {
	
	static Item saltyItem;
	static Item tutorialItem;
	static Item tutorialDust;
	public static void init() {
		saltyItem = new ItemSalt("saltyItem");
		tutorialItem = new ItemBasic("tutorialItem").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(32);
		tutorialDust = new ItemBasic("tutorialDust").setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(saltyItem);
		event.getRegistry().registerAll(tutorialItem, tutorialDust);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(saltyItem);
		registerRender(tutorialItem);
		registerRender(tutorialDust);

	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
