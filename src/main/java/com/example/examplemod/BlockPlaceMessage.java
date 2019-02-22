package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

public class BlockPlaceMessage {
	@SubscribeEvent
	public void sendMessage(PlaceEvent event) 
	{
//		event.getState().getBlock();
//		if(event.getState().getBlock() != Blocks.DIRT){
//			event
//			.getPlayer()
//			.sendMessage(new TextComponentString("Your block was not dirt. No explosion for you."));
//            return;
//        }
//        event.getWorld().createExplosion(null,event.getPos().getX(),event.getPos().getY(),event.getPos().getZ(),100,true);
//		
		event
		.getPlayer()
		.sendMessage(new TextComponentString("You added a block! SEA LEVEL IS " + event.getWorld().getSeaLevel() ));
		
		event.getWorld().setSeaLevel(event.getWorld().getSeaLevel()+1);
	}
}
