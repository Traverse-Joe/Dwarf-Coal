package traverse.dwarfcoal.items;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import traverse.dwarfcoal.DwarfCoal;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Settings().group(DwarfCoal.TAB));
    }
}
