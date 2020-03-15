package jp.artan.tm.tab;

import jp.artan.tm.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TutorialTab extends CreativeTabs {

    public TutorialTab() {
        super("tutorial_tab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.TUTORIAL_ITEM);
    }

}
