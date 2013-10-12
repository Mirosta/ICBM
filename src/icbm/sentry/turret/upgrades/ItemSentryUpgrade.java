package icbm.sentry.turret.upgrades;

import icbm.core.ICBMCore;
import icbm.core.base.ItemICBMBase;
import icbm.sentry.ITurretUpgrade;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSentryUpgrade extends ItemICBMBase implements ITurretUpgrade
{
    public enum TurretUpgradeType
    {
        RANGE("targetCard"),
        COLLECTOR("shellCollector");

        String iconName;

        private TurretUpgradeType(String name)
        {
            this.iconName = name;
        }
    }

    public static final Icon[] ICONS = new Icon[TurretUpgradeType.values().length];

    public ItemSentryUpgrade(int par1)
    {
        super(par1, "turretUpgrades");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "item." + ICBMCore.PREFIX + TurretUpgradeType.values()[itemStack.getItemDamage()].iconName;
    }

    @Override
    public Icon getIconFromDamage(int i)
    {
        return ICONS[i];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        for (int i = 0; i < TurretUpgradeType.values().length; i++)
        {
            ICONS[i] = iconRegister.registerIcon(ICBMCore.PREFIX + TurretUpgradeType.values()[i].iconName);
        }
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < TurretUpgradeType.values().length; i++)
        {
            par3List.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public TurretUpgradeType getType(ItemStack itemstack)
    {
        return TurretUpgradeType.values()[itemstack.getItemDamage()];
    }

}
