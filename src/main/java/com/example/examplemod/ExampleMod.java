package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.Logger;


@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
	public static final String MODID = "examplemod";
	public static final String NAME = "Example Mod";
	public static final String VERSION = "1.0";

	private static Logger logger;
	

	public static Item salt;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		ModItems.init();
		ModBlocks.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//event.getWorld().setSeaLevel(event.getWorld().getSeaLevel()+1);
		
		// some example code
		logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());

		MinecraftForge.EVENT_BUS.register(new BlockPlaceMessage());
		logger.info("maybe just registered event handler?");
		
		

		// Let's make some salt
		salt = new SaltyItem("salty_item");
		IForgeRegistry<Item> itemRegistry = GameRegistry.findRegistry(Item.class);
		if (itemRegistry == null) {
            System.out.println("itemRegistry is null");
        } else { 
            System.out.println("itemRegistry is not null");
        }
		
		itemRegistry.register(salt);
		System.out.println("we *think* we just registered salt");
	}

}
