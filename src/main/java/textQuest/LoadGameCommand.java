package com.soroko.project.textQuest;

public class LoadGameCommand extends Command {
    QuestStateMachine questStateMachine;
    public LoadGameCommand(String code) {
        super(code);

    }

    @Override
    public void execute(Menu menu) {
        menu.loadGame();
    }
}
