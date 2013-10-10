package icbm.explosion.zhapin.daodan;

import icbm.core.ICBMCore;
import icbm.explosion.zhapin.Explosive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class DaoDan extends Explosive
{
	@SideOnly(Side.CLIENT)
	private ResourceLocation resourceLocation;

	public DaoDan(String mingZi, int tier)
	{
		super(mingZi, tier);
	}

	/**
	 * Called when launched.
	 */
	public void launch(EDaoDan missileObj)
	{
	}

	/**
	 * Called every tick while flying.
	 */
	public void update(EDaoDan missileObj)
	{
	}

	public boolean onInteract(EDaoDan missileObj, EntityPlayer entityPlayer)
	{
		return false;
	}

	/**
	 * Is this missile compatible with the cruise launcher?
	 * 
	 * @return
	 */
	public boolean isCruise()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public ResourceLocation getMissileResource()
	{
		if (this.resourceLocation == null)
		{
			this.resourceLocation = new ResourceLocation(ICBMCore.DOMAIN, ICBMCore.MODEL_PATH + "missile_" + this.getUnlocalizedName() + ".png");
		}

		return this.resourceLocation;
	}
}
