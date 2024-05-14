package com.soroko.project.textQuest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.soroko.project.textQuest.Constants.*;

public class Menu {
    private boolean gameStarted;
    private boolean gameIsActive;
    private boolean gamePaused;
    private boolean gameSaved;
    private boolean gameLoaded;
    private boolean fileExists;
    private String titleOfChapter;
    private QuestStateMachine questStateMachine;
    private String username;

    public Menu(QuestStateMachine questStateMachine) {
        if (questStateMachine == null) throw new IllegalArgumentException();
        this.questStateMachine = questStateMachine;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }

    public boolean getGameIsActive() {
        return gameIsActive;
    }

    public boolean getGamePaused() {
        return gamePaused;
    }

    public void setTitleOfChapter(String titleOfChapter) {
        if ("".equals(titleOfChapter))
            throw new IllegalArgumentException("Название главы не может быть пустой строкой");
        this.titleOfChapter = titleOfChapter;
    }

    public QuestStateMachine getQuestStateMachine() {
        return questStateMachine;
    }

    public void setQuestStateMachine(QuestStateMachine questStateMachine) {
        this.questStateMachine = questStateMachine;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void startGame() {
        this.gameStarted = true;
        this.gameIsActive = true;
    }

    public void returnGame() {
        this.gameIsActive = true;
        this.gamePaused = false;
    }

    public void exitGame() {
        System.exit(0);
    }

    public void saveGame() {
        try (PrintWriter out = new PrintWriter(username + QUEST)) {
            out.print(this.titleOfChapter);
        } catch (IOException ex) {
            System.out.println("Ошибка при попытке чтения в файл");
        }
        gameSaved = true;
    }

    public void loadGame() {
        try {
            titleOfChapter = new String(Files.readAllBytes(Paths.get(username + QUEST)));
        } catch (IOException | NullPointerException ex) {
            System.out.println("Ошибка при попытке чтения из файла");
        }
        switch (titleOfChapter) {
            case "Introduction" -> questStateMachine = QuestStateMachine.Introduction;
            case "HappyEnd" -> questStateMachine = QuestStateMachine.HappyEnd;
            case "TryToSearch" -> questStateMachine = QuestStateMachine.TryToSearch;
            case "TryToAskLocals" -> questStateMachine = QuestStateMachine.TryToAskLocals;
            case "UnhappyEndSearch" -> questStateMachine = QuestStateMachine.UnhappyEndSearch;
            case "TryToAskTheOwl" -> questStateMachine = QuestStateMachine.TryToAskTheOwl;
            case "TryToAskTheWolf" -> questStateMachine = QuestStateMachine.TryToAskTheWolf;
            case "TrustTheOwl" -> questStateMachine = QuestStateMachine.TrustTheOwl;
            case "FindTheHoney" -> questStateMachine = QuestStateMachine.FindTheHoney;
            case "UnhappyEndSteal" -> questStateMachine = QuestStateMachine.UnhappyEndSteal;
            case "WaitForTheBees" -> questStateMachine = QuestStateMachine.WaitForTheBees;
            case "UnhappyEndRest" -> questStateMachine = QuestStateMachine.UnhappyEndRest;
            case "BringTheHoneyToTheBear" -> questStateMachine = QuestStateMachine.BringTheHoneyToTheBear;
            default -> throw new IllegalArgumentException("Неверное наименование главы");
        }
        gameLoaded = true;
    }

    public void returnMenu() {
        gameIsActive = false;
        gamePaused = true;
    }

    public void printMenu() {
        File f = new File(username + QUEST);
        if (f.exists() && !f.isDirectory()) {
            fileExists = true;
        }
        if (gameSaved || (gameStarted && fileExists)) {
            System.out.println("2. " + RETURN_GAME);
            System.out.println("3. " + EXIT_GAME);
            System.out.println("4. " + SAVE_GAME);
            System.out.println("5. " + LOAD_GAME);
        } else if (!fileExists && gameStarted) {
            System.out.println("2. " + RETURN_GAME);
            System.out.println("3. " + EXIT_GAME);
            System.out.println("4. " + SAVE_GAME);
        } else if (!gameLoaded && fileExists) {
            System.out.println("1. " + START_GAME);
            System.out.println("3. " + EXIT_GAME);
            System.out.println("4. " + SAVE_GAME);
            System.out.println("5. " + LOAD_GAME);
        } else if (gameLoaded && fileExists) {
            System.out.println("1. " + CONTINUE_GAME);
            System.out.println("3. " + EXIT_GAME);
            System.out.println("4. " + SAVE_GAME);
            System.out.println("5. " + LOAD_GAME);
        }  else {
            System.out.println("1. " + START_GAME);
            System.out.println("3. " + EXIT_GAME);
        }
    }
}
