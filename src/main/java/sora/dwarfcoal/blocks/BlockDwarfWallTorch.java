package sora.dwarfcoal.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Random;

public class BlockDwarfWallTorch extends BlockDwarfTorch {
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> BOUNDING_SHAPES;


    public  BlockDwarfWallTorch(){
        super();
        this.setDefaultState((BlockState)((BlockState)this.stateFactory.getDefaultState()).with(FACING, Direction.NORTH));
    }

    public String getTranslationKey() {
        return this.getItem().getTranslationKey();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
        return
                getBoundingShape(blockState_1,blockView_1,blockPos_1);
    }

    public VoxelShape getBoundingShape(BlockState var1, BlockView var2, BlockPos var3) {
        return (VoxelShape)BOUNDING_SHAPES.get(var1.get(FACING));
    }

    public boolean canPlaceAt(BlockState var1, ViewableWorld var2, BlockPos var3) {
        Direction var4 = (Direction)var1.get(FACING);
        BlockPos var5 = var3.offset(var4.getOpposite());
        BlockState var6 = var2.getBlockState(var5);
        return Block.isFaceFullSquare(var6.getCollisionShape(var2, var5), var4) && !method_9581(var6.getBlock());
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        BlockState blockState_1 = this.getDefaultState();
        ViewableWorld viewableWorld_1 = itemPlacementContext_1.getWorld();
        BlockPos blockPos_1 = itemPlacementContext_1.getBlockPos();
        Direction[] directions_1 = itemPlacementContext_1.getPlacementFacings();
        Direction[] var6 = directions_1;
        int var7 = directions_1.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction direction_1 = var6[var8];
            if (direction_1.getAxis().isHorizontal()) {
                Direction direction_2 = direction_1.getOpposite();
                blockState_1 = (BlockState)blockState_1.with(FACING, direction_2);
                if (blockState_1.canPlaceAt(viewableWorld_1, blockPos_1)) {
                    return blockState_1;
                }
            }
        }

        return null;
    }

    public BlockState getStateForNeighborUpdate(BlockState var1, Direction var2, BlockState var3, IWorld var4, BlockPos var5, BlockPos var6) {
        return var2.getOpposite() == var1.get(FACING) && !var1.canPlaceAt(var4, var5) ? Blocks.AIR.getDefaultState() : var1;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState var1, World var2, BlockPos var3, Random var4) {
        Direction var5 = (Direction)var1.get(FACING);
        double var6 = (double)var3.getX() + 0.5D;
        double var8 = (double)var3.getY() + 0.4D;
        double var10 = (double)var3.getZ() + 0.5D;
        double var12 = 0.22D;
        double var14 = 0.27D;
        Direction var16 = var5.getOpposite();
        var2.addParticle(ParticleTypes.SMOKE, var6 + 0.36D * (double)var16.getOffsetX(), var8 + 0.22D, var10 + 0.36D * (double)var16.getOffsetZ(), 0.0D, 0.0D, 0.0D);
        var2.addParticle(ParticleTypes.FLAME, var6 + 0.36D * (double)var16.getOffsetX(), var8 + 0.22D, var10 + 0.36D * (double)var16.getOffsetZ(), 0.0D, 0.0D, 0.0D);
    }

    public BlockState applyRotation(BlockState var1, Rotation var2) {
        return (BlockState)var1.with(FACING, var2.rotate(var1.get(FACING)));
    }

    public BlockState applyMirror(BlockState var1, Mirror var2) {
        return var1.rotate(var2.getRotation((Direction)var1.get(FACING)));
    }

    protected void appendProperties(StateFactory.Builder<Block, BlockState> var1) {
        var1.with(new Property[]{FACING});
    }

    static {
        FACING = HorizontalFacingBlock.field_11177;
        BOUNDING_SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, Block.createCuboidShape(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, Block.createCuboidShape(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, Block.createCuboidShape(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));
    }
}
