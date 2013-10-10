package icbm.explosion.zhapin.ex;

import icbm.core.ICBMConfiguration;
import icbm.core.base.ModelICBM;
import icbm.explosion.explosive.explosion.BzDiLei;
import icbm.explosion.model.tiles.MDiLei;
import icbm.explosion.zhapin.Explosive;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.RecipeHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExDiLei extends Explosive
{
	public ExDiLei(String mingZi, int tier)
	{
		super(mingZi, tier);
		this.setYinXin(20);
		this.hasGrenade = false;
		this.hasMinecart = false;
		this.hasMissile = false;
	}

	@Override
	public void onYinZha(World worldObj, Vector3 position, int fuseTicks)
	{

	}

	@Override
	public void init()
	{
		RecipeHelper.addRecipe(new ShapedOreRecipe(this.getItemStack(), new Object[] { "S", "L", "R", 'S', Explosive.qunDan.getItemStack(), 'L', Explosive.la.getItemStack(), 'R', Explosive.tui.getItemStack() }), this.getUnlocalizedName(), ICBMConfiguration.CONFIGURATION, true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelICBM getBlockModel()
	{
		return MDiLei.INSTANCE;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ResourceLocation getBlockResource()
	{
		return MDiLei.TEXTURE;
	}

	@Override
	public void doCreateExplosion(World world, double x, double y, double z, Entity entity)
	{
		new BzDiLei(world, entity, x, y, z, 5).explode();
	}

}
