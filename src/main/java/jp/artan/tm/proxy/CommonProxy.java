package jp.artan.tm.proxy;

import jp.artan.tm.TutorialMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
}
