package jp.artan.tm.item;

import jp.artan.tm.TutorialMod;
import jp.artan.tm.event.IItemRegisterEvent;
import jp.artan.tm.init.ItemInit;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class TutorialFood extends ItemFood implements IItemRegisterEvent {

    private final String name;

    public TutorialFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        this.name = name;
        this.setUnlocalizedName(this.name);
        this.setRegistryName(TutorialMod.MODID, this.name);
        this.setCreativeTab(TutorialMod.creativeTabs);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(new ResourceLocation(TutorialMod.MODID, this.name), "inventory"));
    }
}
