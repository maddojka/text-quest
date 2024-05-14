package com.soroko.project.textQuest;

public class StartGameCommand extends Command {

    public StartGameCommand(String code) {
        super(code);

    }

    @Override
    public void execute(Menu menu) {
        menu.startGame();
    }
}
