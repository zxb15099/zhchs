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
package ai.instance.jormungandMarchingRoute;

import com.aionemu.gameserver.ai2.AIName;
import com.aionemu.gameserver.ai2.NpcAI2;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_DIALOG_WINDOW;
import com.aionemu.gameserver.services.teleport.TeleportService2;
import com.aionemu.gameserver.utils.PacketSendUtility;

@AIName("delegate_officer_of_the_zephyr_daevas") // 701984, 701986
public class Delegate_Officer_Of_The_Zephyr_DaevasAI2 extends NpcAI2 {

	@Override
	protected void handleDialogStart(Player player) {
		if (player.getInventory().getFirstItemByItemId(164000279) != null) { // Advance Route Teleport Scroll.
			PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getObjectId(), 1011));
		}
		else {
			PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getObjectId(), 27));
		}
	}

	@Override
	public boolean onDialogSelect(Player player, int dialogId, int questId, int extendedRewardIndex) {
		int instanceId = getPosition().getInstanceId();
		if (dialogId == 10000 && player.getInventory().decreaseByItemId(164000279, 1)) { // Advance Route Teleport Scroll.
			TeleportService2.teleportTo(player, 301210000, instanceId, 692.0453f, 485.75558f, 599.91113f, (byte) 71);
		}
		if (dialogId == 10001 && player.getInventory().decreaseByItemId(164000279, 1)) { // Advance Route Teleport Scroll.
			TeleportService2.teleportTo(player, 301210000, instanceId, 535.967f, 458.2419f, 619.88727f, (byte) 85);
		}
		if (dialogId == 10002 && player.getInventory().decreaseByItemId(164000279, 1)) { // Advance Route Teleport Scroll.
			TeleportService2.teleportTo(player, 301210000, instanceId, 597.6529f, 571.45654f, 590.91034f, (byte) 100);
		}
		if (dialogId == 10003 && player.getInventory().decreaseByItemId(164000279, 1)) { // Advance Route Teleport Scroll.
			TeleportService2.teleportTo(player, 301210000, instanceId, 475.34265f, 522.1061f, 597.375f, (byte) 15);
		}
		else if (dialogId == 1352) {
			PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getObjectId(), 1352));
		}
		return true;
	}
}
