package sora.dwarfcoal.blocks;

import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import net.minecraft.world.loot.context.LootContext;

import java.util.List;
import java.util.Random;

public class BlockDwarfTorch extends Block {
    public BlockDwarfTorch() {
        super(FabricBlockSettings.copy(Blocks.TORCH).lightLevel(10).build());
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState blockState, LootContext.Builder builder) {
        return Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this)));
    }

    public static final VoxelShape BOUNDING_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D);

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
        return BOUNDING_SHAPE;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState var1, Direction var2, BlockState var3, IWorld var4, BlockPos var5, BlockPos var6) {
        return var2 == Direction.DOWN && !this.canPlaceAt(var1, var4, var5) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(var1, var2, var3, var4, var5, var6);
    }

    @Override
    public boolean canPlaceAt(BlockState var1, ViewableWorld var2, BlockPos var3) {
        BlockPos var4 = var3.down();
        BlockState var5 = var2.getBlockState(var4);
        Block var6 = var5.getBlock();
        boolean var7 = var6.matches(BlockTags.FENCES) || var6 instanceof StainedGlassBlock || var6 == Blocks.GLASS || var6.matches(BlockTags.WALLS) || var5.hasSolidTopSurface(var2, var4);
        return var7 && var6 != Blocks.END_GATEWAY;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState var1, World var2, BlockPos var3, Random var4) {
        double var5 = (double)var3.getX() + 0.5D;
        double var7 = (double)var3.getY() + 0.4D;
        double var9 = (double)var3.getZ() + 0.5D;
        var2.addParticle(ParticleTypes.SMOKE, var5, var7, var9, 0.0D, 0.0D, 0.0D);
        var2.addParticle(ParticleTypes.FLAME, var5, var7, var9, 0.0D, 0.0D, 0.0D);
    }
@Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
