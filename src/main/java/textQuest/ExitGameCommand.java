package com.soroko.project.textQuest;

public class ExitGameCommand extends Command {


    public ExitGameCommand(String code) {
        super(code);

    }

    @Override
    public void execute(Menu menu) {
        menu.exitGame();
    }
}
