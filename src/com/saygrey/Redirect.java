package com.saygrey;

import java.util.Scanner;

import static com.saygrey.Main.consoleIn;

public class Redirect {
    public Redirect(int labNum) {
        redirect(labNum);
    }

    public static void redirect(int labNum) {
        boolean isInputValidWelcome = false;
        int powerOfStupid = 0;
        while (!isInputValidWelcome) {
            if (powerOfStupid > 3) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            System.out.println("Уважаемый Полковник, введите ниже номер задания (1-2) для проверки :");
            cleanScannerFromWaste();
            if (consoleIn.hasNextInt()) {
                isInputValidWelcome = true;
                switch (consoleIn.nextInt()) {
                    case (1):
                        switch (labNum) {
                            case (4):
                                new Lab4_1();
                                break;
                            case (5):
                                new Lab5_1();
                                break;
                            case (6):
                                new Lab6_1();
                                break;
                            case (7):
                                new Lab7_1();
                                break;
                            default:
                                break;
                        }
                        break;
                    case (2):
                        switch (labNum) {
                            case (4):
                                new Lab4_2();
                                break;
                            case (5):
                                new Lab5_2();
                                break;
                            case (6):
                                new Lab6_2();
                                break;
                            case (7):
                                new Lab7_2();
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        isInputValidWelcome = false;
                        powerOfStupid = idiotPrintNUp(powerOfStupid);
                        break;
                }
            } else {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            }
        }
    }

    private static int idiotPrintNUp(int idiotPower) {
        System.out.println("Вы ввели некорректный номер задания.\nКоличество оставших попыток ввода - " + (3 - idiotPower)
                + ".\nДалее программа будет принудительно завершена.\n");
        return ++idiotPower;
    }

    private static void cleanScannerFromWaste() {
        consoleIn = new Scanner(System.in);
    }
}
