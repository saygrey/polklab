package com.saygrey;

import java.util.Scanner;

public class Main {
    public static Scanner consoleIn=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Вариант №5.\nАвтор - Апрелков Д.Н.\n");

        boolean isInputValidWelcome=false;
        int powerOfStupid=0;
        while(!isInputValidWelcome){
            if (powerOfStupid>3){
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            System.out.println("Уважаемый Полковник, введите ниже номер лабораторной (2-7) для проверки :");
            cleanScannerFromWaste();
            if(consoleIn.hasNextInt()){
                isInputValidWelcome=true;
                switch (consoleIn.nextInt()){
                    case(2):
                        new Lab2();
                        break;
                    case(3):
                        new Lab3();
                        break;
                    case(4):
                        new Redirect(4);
                        break;
                    case(5):
                        new Redirect(5);
                        break;
                    case(6):
                        new Redirect(6);
                        break;
                    case(7):
                        new Redirect(7);
                        break;
                    default:
                        isInputValidWelcome=false;
                        powerOfStupid=idiotPrintNUp(powerOfStupid);
                        break;
                }
            }
            else {
                powerOfStupid=idiotPrintNUp(powerOfStupid);
            }
        }
    }
    private static int idiotPrintNUp(int idiotPower){
        System.out.println("Вы ввели некорректный номер лабораторной.\nКоличество оставших попыток ввода - " +(3-idiotPower)
                + ".\nДалее программа будет принудительно завершена.\n");
        return ++idiotPower;
    }
    private static void cleanScannerFromWaste(){
        consoleIn=new Scanner(System.in);
    }
}
