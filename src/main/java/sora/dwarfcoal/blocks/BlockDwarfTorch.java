package sora.dwarfcoal.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BlockDwarfTorch extends BlockBase {
  public BlockDwarfTorch(String name) {
    super(name, Properties.from(Blocks.TORCH).lightValue(10));
  }

  private static final VoxelShape SHAPE = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D);

  public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) {
    return SHAPE;
  }

  public BlockState updatePostPlacement(BlockState blockState1, Direction direction, BlockState blockstate2, IWorld world, BlockPos pos1, BlockPos pos2) {
    return direction == Direction.DOWN && !this.isValidPosition(blockState1, world, pos1) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(blockState1, direction, blockstate2, world, pos1, pos2);
  }

  public boolean isValidPosition(BlockState state, IWorldReader reader, BlockPos pos) {
    return func_220055_a(reader, pos.down(), Direction.UP);
  }

  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
    double lvt_5_1_ = (double) pos.getX() + 0.5D;
    double lvt_7_1_ = (double) pos.getY() + 0.4D;
    double lvt_9_1_ = (double) pos.getZ() + 0.5D;
    world.addParticle(ParticleTypes.SMOKE, lvt_5_1_, lvt_7_1_, lvt_9_1_, 0.0D, 0.0D, 0.0D);
    world.addParticle(ParticleTypes.FLAME, lvt_5_1_, lvt_7_1_, lvt_9_1_, 0.0D, 0.0D, 0.0D);
  }

  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }
}

