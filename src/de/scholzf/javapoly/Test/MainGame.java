
package de.scholzf.javapoly.Test;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Manager.CommunityCardManager;
import de.scholzf.javapoly.Manager.ConsoleManager;
import de.scholzf.javapoly.Manager.GameManager;
import de.scholzf.javapoly.Manager.HouseManager;

import java.awt.event.KeyEvent;

public class MainGame {

	private static CommunityCardManager communityCardManager;
	private static GameManager gameManager;
	private static HouseManager houseManager;
	private static ConsoleManager consoleManager;

	public static CommunityCardManager getCommunityCardManager() {
		return communityCardManager;
	}

	public static GameManager getGameManager() { return gameManager; }

	public static HouseManager getHouseManager() { return houseManager; }

	public static ConsoleManager getConsoleManager() { return consoleManager; }

	void onEnable() {
		gameManager = new GameManager();
		houseManager = new HouseManager();
		consoleManager = new ConsoleManager();
		communityCardManager = new CommunityCardManager(gameManager.getPlayers());

		gameManager.create();
		communityCardManager.create();
		houseManager.create();

		Player player = gameManager.getLocalPlayer();

		while(true) {
			int key = gameManager.getKey();

			if(key == KeyEvent.VK_S) {
				//Show player stats
				consoleManager.stats(player);
			} else if(key == KeyEvent.VK_D) {
				//Roll next die
				gameManager.next();
				//Starts the game
			} else if(key == KeyEvent.VK_P) {
				//Purchase
				player.purchaseItem(houseManager.getPurchaseable(player.getFieldId()));
			} else if(key == KeyEvent.VK_T) {
				//Show stats of card you are currently on
				consoleManager.showTileStats(player);
			}
		}
	}

	public static void main(String[] args) {
		new MainGame().onEnable();
	}

}