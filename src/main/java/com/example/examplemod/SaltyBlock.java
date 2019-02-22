package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SaltyBlock extends Block {

	public SaltyBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}