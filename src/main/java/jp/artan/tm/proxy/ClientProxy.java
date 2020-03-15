package jp.artan.tm.proxy;

import jp.artan.tm.TutorialMod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        TutorialMod.logger.info("ClientProxy.preInit");
    }
}
