package jp.artan.tm.init;

import jp.artan.tm.block.TutorialPlant;
import jp.artan.tm.event.IBlockRegisterEvent;
import net.minecraft.block.BlockCrops;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();

    public static final BlockCrops TUTORIAL_PLANT = new TutorialPlant("tutorial_plant");
}
