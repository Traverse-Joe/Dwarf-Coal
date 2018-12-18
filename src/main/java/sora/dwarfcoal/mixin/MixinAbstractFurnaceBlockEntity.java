package sora.dwarfcoal.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sora.dwarfcoal.init.ModBlocks;
import sora.dwarfcoal.init.ModItems;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public class MixinAbstractFurnaceBlockEntity {

    @Inject(method = "getBurnTimeMap", at = @At("RETURN"), cancellable = true)
    private static void getBurnTimeMap(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        addMapping(cir.getReturnValue(), ModItems.DWARF_COAL, 200);
        addMapping(cir.getReturnValue(), ModItems.DWARF_CHARCOAL, 200);
        addMapping(cir.getReturnValue(), ModBlocks.CHARCOAL_BLOCK, 14400);

    }

    private static void addMapping(Map<Item, Integer> var0, ItemProvider var1, int var2) {
        var0.put(var1.getItem(), var2);
    }

}
