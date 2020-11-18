package com.leitedesnatado.examplemod.objects.blocks;

import com.leitedesnatado.examplemod.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class ruby_ore extends OreBlock {

	public ruby_ore() {
		super((
				Block.Properties.create(Material.ROCK)
				.hardnessAndResistance(5.0f, 6.0f)
				.sound(SoundType.STONE)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)));										
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		return 1;
	}
	

}
