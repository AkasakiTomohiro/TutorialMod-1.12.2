package jp.artan.tm.block;

import jp.artan.tm.TutorialMod;
import jp.artan.tm.event.IBlockRegisterEvent;
import jp.artan.tm.init.BlockInit;
import jp.artan.tm.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class TutorialPlant extends BlockCrops implements IBlockRegisterEvent {
    protected final String Name;

    public TutorialPlant(String name) {
        super();
        this.Name = name;
        this.setUnlocalizedName(this.Name);
        this.setRegistryName(TutorialMod.MODID, this.Name);

        BlockInit.BLOCKS.add(this);
    }

    @Override
    public Item getSeed() {
        return ItemInit.TUTORIAL_SEED;
    }

    @Override
    public Item getCrop() {
        return ItemInit.TUTORIAL_FOOD;
    }

    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(new ResourceLocation(TutorialMod.MODID, this.Name), "inventory"));
    }
}
