package com.github.JamesNorris.Util;

/* Breakable Packages */
import net.minecraft.server.v1_4_6.*;
import org.bukkit.craftbukkit.v1_4_6.*;
import org.bukkit.craftbukkit.v1_4_6.inventory.*;
import org.bukkit.craftbukkit.v1_4_6.entity.*;
/* End Breakable Packages */

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;

import com.github.JamesNorris.Data.ByteData;

/**
 * The class for all breakable methods and code.
 */
public class Breakable {
	public class ItemNameManager {// TODO annotations, TEST
		private final ItemStack itemStack;

		public ItemNameManager(ItemStack itemStack) {
			this.itemStack = itemStack;
			CraftItemStack is = ((CraftItemStack) this.itemStack);
			NBTTagCompound tag = CraftItemStack.asNMSCopy(is).getTag();
			if (tag == null)
				CraftItemStack.asNMSCopy(is).setTag(new NBTTagCompound());
		}

		private void addDisplay() {
			CraftItemStack.asNMSCopy((CraftItemStack) itemStack).getTag().setCompound("display", new NBTTagCompound());
		}

		private NBTTagCompound getDisplay() {
			return CraftItemStack.asNMSCopy((CraftItemStack) itemStack).getTag().getCompound("display");
		}

		public String getName() {
			if (hasDisplay() == false)
				return null;
			String name = getDisplay().getString("name");
			if (name.equals(""))
				return null;
			return name;
		}

		private boolean hasDisplay() {
			return CraftItemStack.asNMSCopy((CraftItemStack) itemStack).getTag().hasKey("display");
		}

		public void setName(String name) {
			if (hasDisplay() == false)
				this.addDisplay();
			NBTTagCompound display = this.getDisplay();
			// if (name == null)
			// display.remove("name");
			display.setString("name", name);
		}
	}

	/**
	 * Gets the Entity from the NMS code for the specified entity.
	 * 
	 * @param entity The entity to get
	 * @return The NMS entity
	 */
	public static net.minecraft.server.v1_4_6.Entity getNMSEntity(Entity entity) {
		return ((CraftEntity) entity).getHandle();
	}

	/**
	 * Gets the EntityPlayer from the NMS code for the specified player.
	 * 
	 * @param player The Player to get
	 * @return The NMS EntityPlayer
	 */
	public static EntityPlayer getNMSPlayer(Player player) {
		return ((CraftPlayer) player).getHandle();
	}

	/**
	 * Gets the EntityWolf from the NMS code for the specified wolf.
	 * 
	 * @param wolf The wolf to get
	 * @return The NMS EntityWolf
	 */
	public static EntityWolf getNMSWolf(Wolf wolf) {
		return ((CraftWolf) wolf).getHandle();
	}

	/**
	 * Gets the WorldServer from the NMS code for the specified world.
	 * 
	 * @param wolf The world to get
	 * @return The NMS WorldServer
	 */
	public static WorldServer getNMSWorld(World world) {
		return ((CraftWorld) world).getHandle();
	}

	/**
	 * Makes the player appear to be sitting down/standing up.
	 * 
	 * @param player The player to change
	 * @param tf Whether or not to make the player stand up or sit down
	 */
	public static void setSitting(Player player, boolean tf) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			EntityPlayer ep = Breakable.getNMSPlayer(p);
			if (tf)
				ep.playerConnection.sendPacket(new Packet40EntityMetadata(player.getEntityId(), new ByteData((byte) 0x04), true));// TODO test
			else
				ep.playerConnection.sendPacket(new Packet40EntityMetadata(player.getEntityId(), new ByteData((byte) 0x00), true));
		}
		if (tf)
			player.teleport(player.getLocation().subtract(0, .5, 0));
	}
}
