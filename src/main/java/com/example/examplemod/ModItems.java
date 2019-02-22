package com.example.examplemod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid=ExampleMod.MODID)
public class ModItems {
	
	static Item saltyItem;
	
	public static void init() {
		saltyItem = new ItemSalt("salty_item");
	}

	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(saltyItem);
	}
}
