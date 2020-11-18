package com.leitedesnatado.examplemod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RubyBlock extends Block
{

	public RubyBlock() {
		super(Block.Properties.create(Material.IRON)
				.hardnessAndResistance(5.0f, 6.0f)
				.slipperiness(0.3f)
				.sound(SoundType.METAL)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				
				
				);
		
	}

}
