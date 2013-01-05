package com.github.JamesNorris.Enumerated;

import java.util.Map;

import org.bukkit.enchantments.Enchantment;

import com.github.JamesNorris.Util.MiscUtil;
import com.google.common.collect.Maps;

public enum ZAEnchantment {
	/**@formatter:off**/
	DAMAGE(1, Local.ENCHANTMENTDAMAGESTRING.getSetting(), Enchantment.DAMAGE_ALL, (Integer) Setting.ENCHDAMAGECOST.getSetting()), 
	RANDOM(2, Local.ENCHANTMENTRANDOMSTRING.getSetting(), null, (Integer) Setting.ENCHRANDOMCOST.getSetting());
	/**@formatter:on**/
	private int id, cost;
	private Enchantment ench;
	private String label;
	private final static Map<Integer, ZAEnchantment> BY_ID = Maps.newHashMap();

	ZAEnchantment(int id, String label, Enchantment ench, int cost) {
		this.id = id;
		this.label = label;
		this.cost = cost;
		this.ench = ench;
	}

	public Enchantment getEnchantment() {
		if (this == ZAEnchantment.RANDOM)
			return MiscUtil.randomEnchant();
		return ench;
	}

	public int getCost() {
		return cost;
	}

	public String getLabel() {
		return label;
	}

	public int getId() {
		return id;
	}

	public static ZAEnchantment getById(final int id) {
		return BY_ID.get(id);
	}

	static {
		for (ZAEnchantment setting : values())
			BY_ID.put(setting.id, setting);
	}
}
