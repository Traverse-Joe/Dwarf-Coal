package sora.dwarfcoal.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

public class BlockWallTorchBase extends BlockTorchBase {

  public static final DirectionProperty HORIZONTAL_FACING;
  private static final Map<Direction, VoxelShape> SHAPES;


  public BlockWallTorchBase(String name) {
    super(name);

  }

  public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
    return func_220289_j(state);
  }

  public static VoxelShape func_220289_j(BlockState state) {
    return (VoxelShape) SHAPES.get(state.get(HORIZONTAL_FACING));
  }

  public boolean isValidPosition(BlockState state, IWorldReader reader, BlockPos blockPos) {
    Direction lvt_4_1_ = (Direction) state.get(HORIZONTAL_FACING);
    BlockPos lvt_5_1_ = blockPos.offset(lvt_4_1_.getOpposite());
    BlockState lvt_6_1_ = reader.getBlockState(lvt_5_1_);
    return Block.hasSolidSide(lvt_6_1_, reader, lvt_5_1_, lvt_4_1_);
  }

  @Nullable
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    BlockState lvt_2_1_ = this.getDefaultState();
    IWorldReader lvt_3_1_ = context.getWorld();
    BlockPos lvt_4_1_ = context.getPos();
    Direction[] lvt_5_1_ = context.getNearestLookingDirections();
    Direction[] var6 = lvt_5_1_;
    int var7 = lvt_5_1_.length;

    for (int var8 = 0; var8 < var7; ++var8) {
      Direction lvt_9_1_ = var6[var8];
      if (lvt_9_1_.getAxis().isHorizontal()) {
        Direction lvt_10_1_ = lvt_9_1_.getOpposite();
        lvt_2_1_ = (BlockState) lvt_2_1_.with(HORIZONTAL_FACING, lvt_10_1_);
        if (lvt_2_1_.isValidPosition(lvt_3_1_, lvt_4_1_)) {
          return lvt_2_1_;
        }
      }
    }

    return null;
  }

  public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState state1, IWorld world, BlockPos pos1, BlockPos pos2) {
    return direction.getOpposite() == state.get(HORIZONTAL_FACING) && !state.isValidPosition(world, pos1) ? Blocks.AIR.getDefaultState() : state;
  }

  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
    Direction lvt_5_1_ = (Direction) state.get(HORIZONTAL_FACING);
    double lvt_6_1_ = (double) pos.getX() + 0.5D;
    double lvt_8_1_ = (double) pos.getY() + 0.7D;
    double lvt_10_1_ = (double) pos.getZ() + 0.5D;
    double lvt_12_1_ = 0.22D;
    double lvt_14_1_ = 0.27D;
    Direction lvt_16_1_ = lvt_5_1_.getOpposite();
    world.addParticle(ParticleTypes.SMOKE, lvt_6_1_ + 0.27D * (double) lvt_16_1_.getXOffset(), lvt_8_1_ + 0.22D, lvt_10_1_ + 0.27D * (double) lvt_16_1_.getZOffset(), 0.0D, 0.0D, 0.0D);
    world.addParticle(ParticleTypes.FLAME, lvt_6_1_ + 0.27D * (double) lvt_16_1_.getXOffset(), lvt_8_1_ + 0.22D, lvt_10_1_ + 0.27D * (double) lvt_16_1_.getZOffset(), 0.0D, 0.0D, 0.0D);
  }

  public BlockState rotate(BlockState state, Rotation rotation) {
    return (BlockState) state.with(HORIZONTAL_FACING, rotation.rotate((Direction) state.get(HORIZONTAL_FACING)));
  }

  public BlockState mirror(BlockState state, Mirror mirror ) {
    return state.rotate(mirror.toRotation((Direction) state.get(HORIZONTAL_FACING)));
  }

  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
    p_206840_1_.add(new Property[]{HORIZONTAL_FACING});
  }

  static {
    HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
    SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.makeCuboidShape(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, Block.makeCuboidShape(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, Block.makeCuboidShape(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, Block.makeCuboidShape(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));
  }
}
