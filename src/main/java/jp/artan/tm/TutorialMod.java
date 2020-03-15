package jp.artan.tm;

import jp.artan.tm.proxy.CommonProxy;
import jp.artan.tm.tab.TutorialTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TutorialMod.MODID, name = TutorialMod.NAME, version = TutorialMod.VERSION)
public class TutorialMod
{
    public static final String MODID = "tm";
    public static final String NAME = "Tutorial Mod";
    public static final String VERSION = "1.0";

    public static Logger logger;

    public static final String CLIENT_PROXY = "jp.artan." + MODID + ".proxy.ClientProxy";
    public static final String SERVER_PROXY = "jp.artan." + MODID + ".proxy.ServerProxy";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;

    public static CreativeTabs creativeTabs = new TutorialTab();

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(proxy);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("TutorialMod.preInit");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("TutorialMod.init");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("TutorialMod.postInit");
        proxy.postInit(event);
    }
}
