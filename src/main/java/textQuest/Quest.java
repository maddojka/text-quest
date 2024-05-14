package com.soroko.project.textQuest;

/**
 * Quest logic goes here.
 *
 * @version 1.0 13 April 2024
 * @author Yuriy Soroko
 */

import java.util.Scanner;

import static com.soroko.project.textQuest.Constants.*;

public class Quest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Quest states - creation
        QuestStateMachine stateMachine = QuestStateMachine.Introduction;
        //Menu - creation
        Menu menu = new Menu(stateMachine);
        menu.setTitleOfChapter(stateMachine.toString());
        // Gameplay - creation
        GamePlay gamePlay = new GamePlay(menu);
        // commands creation
        StartGameCommand startGameCommand = new StartGameCommand(START_GAME);
        ReturnGameCommand returnGameCommand = new ReturnGameCommand(RETURN_GAME);
        ExitGameCommand exitGameCommand = new ExitGameCommand(EXIT_GAME);
        SaveGameCommand saveGameCommand = new SaveGameCommand(SAVE_GAME);
        LoadGameCommand loadGameCommand = new LoadGameCommand(LOAD_GAME);
        ReturnMenuCommand returnMenuCommand = new ReturnMenuCommand(RETURN_MENU);
        PrintMenuCommand printMenuCommand = new PrintMenuCommand(PRINT_MENU);
        // set commands
        gamePlay.setCommand(startGameCommand);
        gamePlay.setCommand(returnGameCommand);
        gamePlay.setCommand(exitGameCommand);
        gamePlay.setCommand(saveGameCommand);
        gamePlay.setCommand(loadGameCommand);
        gamePlay.setCommand(returnMenuCommand);
        gamePlay.setCommand(printMenuCommand);
        // start game loop
        gamePlay.startGameLoop();
    }
}



