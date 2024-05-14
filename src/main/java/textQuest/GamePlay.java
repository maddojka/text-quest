package textQuest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static textQuest.Constants.*;

public class GamePlay {
    private Map<String, Command> menuCommands = new HashMap<>();
    private Menu menu;
    private Scanner scanner;

    public GamePlay(Menu menu) {
        if (menu == null)
            throw new IllegalArgumentException();
        this.menu = menu;
        scanner = new Scanner(System.in);
    }

    public void setCommand(Command command) {
        menuCommands.put(command.getCode(), command);
    }

    public void menuItemSelected(String code) {
        menuCommands.get(code).execute(menu);
    }

    public void startGameLoop() {
        System.out.println("Введите свое имя на латинице:");
        menu.setUsername(scanner.next());
        // quest logic
        while (true) { // menu loop
            menuItemSelected(PRINT_MENU); // printing menu
            switch (scanner.nextInt()) { // menu selection
                case 1 -> menuItemSelected(START_GAME); // start game command
                case 2 -> menuItemSelected(RETURN_GAME); // return game command
                case 3 -> menuItemSelected(EXIT_GAME); // exit game command
                case 4 -> menuItemSelected(SAVE_GAME); // save game command
                case 5 -> menuItemSelected(LOAD_GAME); // load game command
                case 6 -> menuItemSelected(RETURN_MENU); // return to main menu command
            }
            if (!menu.getGamePaused() && menu.getGameStarted()) {
                menu.getQuestStateMachine().textOfParagraph();
                while (menu.getGameIsActive()) { // game loop
                    switch (scanner.nextInt()) {
                        case 1 -> { // first branch of logic
                            menu.setQuestStateMachine(menu.getQuestStateMachine().firstState());
                            menu.getQuestStateMachine().textOfParagraph();
                            menu.setTitleOfChapter(menu.getQuestStateMachine().toString());
                        }
                        case 2 -> { // second branch of logic
                            menu.setQuestStateMachine(menu.getQuestStateMachine().secondState());
                            menu.getQuestStateMachine().textOfParagraph();
                            menu.setTitleOfChapter(menu.getQuestStateMachine().toString());
                        }
                        case 3 -> menuItemSelected(RETURN_MENU); // back to main menu command
                    }
                }
            }
        }
    }
}
