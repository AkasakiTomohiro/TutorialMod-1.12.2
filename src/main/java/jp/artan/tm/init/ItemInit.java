package jp.artan.tm.init;

import jp.artan.tm.event.IItemRegisterEvent;
import jp.artan.tm.item.TutorialFood;
import jp.artan.tm.item.TutorialItem;
import jp.artan.tm.item.TutorialSeed;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<IItemRegisterEvent> ITEMS = new ArrayList<IItemRegisterEvent>();

    public static final Item TUTORIAL_ITEM = new TutorialItem("tutorial_item");

    public static final ItemFood TUTORIAL_FOOD = new TutorialFood("tutorial_food", 1, 1.0F);

    public static final ItemSeeds TUTORIAL_SEED = new TutorialSeed("tutorial_seed");
}
