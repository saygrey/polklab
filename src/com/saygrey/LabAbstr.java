package com.saygrey;

import java.util.Random;
import java.util.Scanner;

import static com.saygrey.Main.consoleIn;

public abstract class LabAbstr {
    protected boolean isInputValid = false;
    protected int powerOfStupid = 0;
    protected int idiotEntriesLimit = 3;
    Random rand = new Random();

    LabAbstr() {
        labFront();
    }

    protected void labFront() {
    }

    protected int idiotPrintNUp(int idiotPower) {
        System.out.println("Вы ввели некорректные данные.\nКоличество оставших попыток ввода - " + (3 - idiotPower)
                + ".\nДалее программа будет принудительно завершена.\n");
        return ++idiotPower;
    }

    protected void cleanScannerFromWaste() {
        Main.consoleIn = new Scanner(System.in);
    }

    protected Double readDoubleWVerify(String varName) {
        boolean isInputValidNow = false;
        Double out = -1.0;
        while (!isInputValidNow) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            System.out.printf("Уважаемый Полковник, введите ниже %s (разделитель - запятая) :\n", varName);
            cleanScannerFromWaste();
            if (consoleIn.hasNextDouble()) {
                out = consoleIn.nextDouble();
                isInputValidNow = true;
            } else {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            }
        }
        return out;
    }

    protected int readIntegerWVerify(String varName) {
        boolean isInputValidNow = false;
        int out = 0;
        while (!isInputValidNow) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            System.out.printf("Уважаемый Полковник, введите ниже %s :\n", varName);
            cleanScannerFromWaste();
            if (consoleIn.hasNextInt()) {
                out = consoleIn.nextInt();
                isInputValidNow = true;
            } else {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            }
        }
        return out;
    }

    protected String readStringWWordsNVerify(String varName) {
        boolean isInputValidNow = false;
        String out = "";
        while (!isInputValidNow) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            System.out.printf("Уважаемый Полковник, введите ниже %s :\n", varName);
            cleanScannerFromWaste();
            out = consoleIn.nextLine();
            if (out.matches("[a-zA-Z ]+")) {
                isInputValidNow = true;
            } else {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            }
        }
        return out;
    }
    protected String readString(String varName) {
        System.out.printf("Уважаемый Полковник, введите ниже %s :\n", varName);
        cleanScannerFromWaste();
        return consoleIn.nextLine();
    }
}
