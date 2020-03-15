package jp.artan.tm.proxy;

import jp.artan.tm.TutorialMod;
import jp.artan.tm.init.BlockInit;
import jp.artan.tm.init.ItemInit;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        TutorialMod.logger.info("ClientProxy.preInit");
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        TutorialMod.logger.info("ClientProxy.registerModels");

        ItemInit.ITEMS.forEach(f -> f.registerModel(event));
        BlockInit.BLOCKS.forEach(f -> f.registerModel(event));
    }
}
