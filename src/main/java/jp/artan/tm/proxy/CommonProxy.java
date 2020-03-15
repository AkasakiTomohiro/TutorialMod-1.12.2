package jp.artan.tm.proxy;

import jp.artan.tm.TutorialMod;
import jp.artan.tm.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID)
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        TutorialMod.logger.info("CommonProxy.preInit");
    }

    public void init(FMLInitializationEvent event) {
        TutorialMod.logger.info("CommonProxy.init");
    }

    public void postInit(FMLPostInitializationEvent event) {
        TutorialMod.logger.info("CommonProxy.postInit");
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        TutorialMod.logger.info("CommonProxy.registerItems");
        ItemInit.ITEMS.forEach(f -> f.registerItem(event));
    }
}
