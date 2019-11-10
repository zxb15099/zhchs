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
package quest.ishalgen;

import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;
import com.aionemu.gameserver.services.QuestService;

/**
 * @author QuestGenerator by Mariella
 */
public class _70007OdellaTrack1 extends QuestHandler {

    private final static int questId = 70007;

    public _70007OdellaTrack1() {
        super(questId);
    }

    @Override
    public void register() {
        qe.registerOnLevelUp(questId);
        qe.registerQuestNpc(203553).addOnTalkEvent(questId);  // Rae
        qe.registerQuestNpc(806811).addOnTalkEvent(questId);  // Investigating Cheska
        qe.registerQuestNpc(806812).addOnTalkEvent(questId);  // Implementer Cheska
        qe.registerQuestNpc(703485).addOnTalkEvent(questId);  // Dundun Cauldron
    }

    @Override
    public boolean onLvlUpEvent(QuestEnv env) {
        return defaultOnLvlUpEvent(env, 70000, false);
    }

    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        DialogAction dialog = env.getDialog();
        int targetId = env.getTargetId();

        if (qs == null) {
            return false;
        }

        if (qs.getStatus() == QuestStatus.START) {
            switch (targetId) {
                case 203553: {
                    switch (dialog) {
                        case QUEST_SELECT: {
                            return sendQuestDialog(env, 1011);
                        }
                        case SETPRO1: {
                            qs.setQuestVar(1);
                            updateQuestStatus(env);
                            return closeDialogWindow(env);
                        }
                        default: 
                            break;
                    }
                    break;
                }
                case 806811: {
                    switch (dialog) {
                        case QUEST_SELECT: {
                            return sendQuestDialog(env, 1352);
                        }
                        case SETPRO2: {
                            qs.setQuestVar(2);
                            updateQuestStatus(env);
                            return closeDialogWindow(env);
                        }
                        default: 
                            break;
                    }
                    break;
                }
                case 806812: {
                    switch (dialog) {
                        case CHECK_USER_HAS_QUEST_ITEM: {
                            if (QuestService.collectItemCheck(env,true)) {
                                qs.setQuestVar(3);
                                updateQuestStatus(env);
                                return sendQuestDialog(env, 10000);
                            } else {
                                return sendQuestDialog(env, 10001);
                            }
                        }
                        default: 
                            break;
                    }
                    break;
                }
                case 703485: {
                    switch (dialog) {
                        // ToDo: check correct action for this npc
                        case USE_OBJECT: {
                            qs.setQuestVar(4);
                            qs.setStatus(QuestStatus.REWARD);
                            updateQuestStatus(env);
                            return false;
                        }
                        default: 
                            break;
                    }
                    break;
                }
                default:
                    break;
            }
        } else if (qs.getStatus() == QuestStatus.REWARD) {
            if (targetId == 806812) {
                if (dialog == DialogAction.USE_OBJECT) {
                    return sendQuestDialog(env, 10002);
                }
                return sendQuestEndDialog(env);
            }
        }

        return false;
    }
}
