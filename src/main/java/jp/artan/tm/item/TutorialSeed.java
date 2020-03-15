package jp.artan.tm.item;

import jp.artan.tm.TutorialMod;
import jp.artan.tm.event.IItemRegisterEvent;
import jp.artan.tm.init.BlockInit;
import jp.artan.tm.init.ItemInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.RegistryEvent;

public class TutorialSeed extends ItemSeeds implements IItemRegisterEvent {

    private final String name;

    public TutorialSeed(String name) {
        super(BlockInit.TUTORIAL_PLANT, Blocks.FARMLAND);
        this.name = name;
        this.setUnlocalizedName(this.name);
        this.setRegistryName(TutorialMod.MODID, this.name);
        this.setCreativeTab(TutorialMod.creativeTabs);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);

        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack)
                && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this)
                && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), BlockInit.TUTORIAL_PLANT.getDefaultState());
            if (player.capabilities.isCreativeMode || !worldIn.isRemote) {
                stack.shrink(1);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return BlockInit.TUTORIAL_PLANT.getDefaultState();
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
