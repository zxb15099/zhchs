/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */
package ai.instance.fireTempleMemory;

import com.aionemu.gameserver.ai2.AIName;
import com.aionemu.gameserver.ai2.NpcAI2;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.services.item.ItemService;

/**
 * @author Falke_34
 */
@AIName("iris")
// 834057
public class IrisAI2 extends NpcAI2 {

	@Override
	protected void handleDialogStart(Player player) {
		getOwner().setTarget(player);
		switch (player.getRace()) {
			case ELYOS:
				getOwner().getController().useSkill(21377, 1); // Mage Transformation
				ItemService.addItem(player, 164002358, 1); // Shines' Summoning Ticket
				break;
			case ASMODIANS:
				getOwner().getController().useSkill(21380, 1); // Mage Transformation
				ItemService.addItem(player, 164002360, 1); // Shines' Summoning Ticket
				break;
			default:
				break;
		}
		getOwner().getController().delete();
	}
}
