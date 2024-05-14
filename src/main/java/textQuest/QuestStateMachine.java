package com.soroko.project.textQuest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.soroko.project.textQuest.Constants.CHAPTERS;

public enum QuestStateMachine {

    Introduction {
        @Override
        public QuestStateMachine firstState() {
            return HappyEnd;
        }

        @Override
        public QuestStateMachine secondState() {
            return TryToSearch;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 0; i < 7; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    HappyEnd {
        @Override
        public QuestStateMachine firstState() {
            return this;
        }

        @Override
        public QuestStateMachine secondState() {
            return this;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 8; i < 11; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
            System.exit(0);
        }
    },
    TryToSearch {
        @Override
        public QuestStateMachine firstState() {
            return TryToAskLocals;
        }

        @Override
        public QuestStateMachine secondState() {
            return UnhappyEndSearch;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 12; i < 18; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    TryToAskLocals {
        @Override
        public QuestStateMachine firstState() {
            return TryToAskTheOwl;
        }

        @Override
        public QuestStateMachine secondState() {
            return TryToAskTheWolf;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 19; i < 25; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    UnhappyEndSearch {
        @Override
        public QuestStateMachine firstState() {
            return this;
        }

        @Override
        public QuestStateMachine secondState() {
            return this;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 26; i < 28; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
            System.exit(0);
        }
    },
    TryToAskTheOwl {
        @Override
        public QuestStateMachine firstState() {
            return TrustTheOwl;
        }

        @Override
        public QuestStateMachine secondState() {
            return UnhappyEndSearch;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 29; i < 35; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    TryToAskTheWolf {
        @Override
        public QuestStateMachine firstState() {
            return HappyEnd;
        }

        @Override
        public QuestStateMachine secondState() {
            return UnhappyEndSearch;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 36; i < 42; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    TrustTheOwl {
        @Override
        public QuestStateMachine firstState() {
            return UnhappyEndSearch;
        }

        @Override
        public QuestStateMachine secondState() {
            return FindTheHoney;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 43; i < 49; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    FindTheHoney {
        @Override
        public QuestStateMachine firstState() {
            return WaitForTheBees;
        }

        @Override
        public QuestStateMachine secondState() {
            return UnhappyEndSteal;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 50; i < 56; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    WaitForTheBees {
        @Override
        public QuestStateMachine firstState() {
            return UnhappyEndRest;
        }

        @Override
        public QuestStateMachine secondState() {
            return BringTheHoneyToTheBear;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 57; i < 63; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    },
    UnhappyEndRest {
        @Override
        public QuestStateMachine firstState() {
            return this;
        }

        @Override
        public QuestStateMachine secondState() {
            return this;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 66; i < 68; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
            System.exit(0);
        }
    },
    UnhappyEndSteal {
        @Override
        public QuestStateMachine firstState() {
            return this;
        }

        @Override
        public QuestStateMachine secondState() {
            return this;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 64; i < 66; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
            System.exit(0);
        }
    },
    BringTheHoneyToTheBear {
        @Override
        public QuestStateMachine firstState() {
            return UnhappyEndSearch;
        }

        @Override
        public QuestStateMachine secondState() {
            return HappyEnd;
        }

        @Override
        public void textOfParagraph() {
            try {
                for (int i = 69; i < 75; i++) {
                    String line = Files.readAllLines(Paths.get(CHAPTERS)).get(i);
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
            }
        }
    };

    public abstract QuestStateMachine firstState();

    public abstract QuestStateMachine secondState();

    public abstract void textOfParagraph();
}
