package com.github.JamesNorris.Interface;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.github.JamesNorris.Util.MiscUtil.PlayerStatus;
import com.github.JamesNorris.Util.MiscUtil.PowerupType;

public interface ZAPlayer {
	/**
	 * Gives points to the player.
	 * 
	 * @param i The amount of points to give the player
	 */
	public void addPoints(int i);

	/**
	 * Gets the game the player is currently in
	 * 
	 * @return The game the player is in
	 */
	public ZAGame getGame();

	/**
	 * Returns the players' name.
	 * 
	 * @return The name of the player
	 */
	public String getName();

	/**
	 * Gets the Player instance of this ZAPlayer.
	 * 
	 * @return The player instance involved with this instance
	 */
	public Player getPlayer();

	/**
	 * Gets the points the player currently has.
	 * 
	 * @return The amount of points the player has
	 */
	public int getPoints();

	/**
	 * Gives the player the specified powerup.
	 * 
	 * @param type The type of powerup to give the player
	 */
	public void givePowerup(PowerupType type);

	/**
	 * Returns true if the player is in last stand
	 * 
	 * @return Whether or not the player is in last stand
	 */
	public boolean isInLastStand();

	/**
	 * Gets whether or not the player is in limbo.
	 * 
	 * @return Whether or not the player is in limbo
	 */
	public boolean isInLimbo();

	/**
	 * Checks if the name given is the name of a game. If not, creates a new game.
	 * Then, adds the player to that game with all settings completed.
	 * 
	 * @param name The name of the player to be loaded into the game
	 */
	public void loadPlayerToGame(String name);

	/**
	 * Removes the player from the game, and removes all data from the player.
	 */
	public void removeFromGame();

	/**
	 * Teleports the player to the mainframe of the game.
	 * 
	 * @param reason The reason for teleportation for the debug mode
	 */
	public void sendToMainframe(String reason);

	/**
	 * Removes points from the player.
	 * 
	 * @param i The amount of points to remove from the player
	 */
	public void subtractPoints(int i);

	/**
	 * Teleport the player to the specified location, with the specified reason for the debug mode.
	 * 
	 * @param location The location to teleport to
	 * @param reason The reason for teleportation
	 */
	public void teleport(Location location, String reason);

	/**
	 * Teleports the player to the specified location,
	 * with the specified arguments, and the specified reason for the debug mode.
	 * 
	 * @param world The world to teleport in
	 * @param x The x coord to teleport to
	 * @param y The y coord to teleport to
	 * @param z The z coord to teleport to
	 * @param reason The reason for teleportation
	 */
	public void teleport(World world, int x, int y, int z, String reason);

	/**
	 * Toggles sitting for the player.
	 */
	public void toggleLastStand();

	/**
	 * Changes the player limbo status.
	 */
	public void setLimbo(boolean tf);

	/**
	 * Changes the teleportation status of the player.
	 * 
	 * @param tf What to change the status to
	 */
	public void setTeleporting(boolean tf);

	/**
	 * Checks if the player is teleporting or not.
	 * 
	 * @return Whether or not the player is teleporting
	 */
	public boolean isTeleporting();

	/**
	 * Gets the status of the player.
	 * 
	 * @return The current status of the player
	 */
	public PlayerStatus getStatus();
}
