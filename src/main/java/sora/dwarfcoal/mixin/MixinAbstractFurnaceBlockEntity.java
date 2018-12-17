package sora.dwarfcoal.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sora.dwarfcoal.init.ModBlocks;
import sora.dwarfcoal.init.ModItems;

@Mixin(AbstractFurnaceBlockEntity.class)
public class MixinAbstractFurnaceBlockEntity {

    @Inject(method = "getItemBurnTime", at = @At("HEAD"), cancellable = true)
    private void onGetItemBurnTime(ItemStack var1, CallbackInfoReturnable<Integer> cir) {
        if (!var1.isEmpty()) {
            Item item = var1.getItem();
            if(item == ModItems.DWARF_COAL){
                cir.setReturnValue(200);
                cir.cancel();
            }else if(item == ModItems.DWARF_CHARCOAL){
                cir.setReturnValue(200);
                cir.cancel();
            }else if(item == Item.getItemFromBlock(ModBlocks.CHARCOAL_BLOCK)){
                cir.setReturnValue(14400);
                cir.cancel();

            }
        }

    }
    @Inject(method = "canUseAsFuel", at = @At("HEAD"), cancellable = true)
    private static void onCanUseFuel(ItemStack var0, CallbackInfoReturnable<Boolean> cir){
        if(!var0.isEmpty() && (var0.getItem() == ModItems.DWARF_COAL || var0.getItem() == ModItems.DWARF_CHARCOAL || (var0.getItem() == Item.getItemFromBlock(ModBlocks.CHARCOAL_BLOCK)))){
            cir.setReturnValue(true);
            cir.cancel();

        }

    }
}
