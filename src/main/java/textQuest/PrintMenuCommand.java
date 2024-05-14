package com.soroko.project.textQuest;

public class PrintMenuCommand extends Command {
    public PrintMenuCommand(String code) {
        super(code);

    }

    @Override
    public void execute(Menu menu) {
        menu.printMenu();
    }
}
