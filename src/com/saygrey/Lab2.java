package com.saygrey;

public class Lab2 extends LabAbstr {
    private double labBack(double x) {
        x -= Math.floor(x / 2) * 2;
        if (x < 1) {
            return -Math.sqrt(1 - Math.pow(x, 2)) + 1;
        } else {
            return Math.sqrt(1 - Math.pow((x - 1), 2));
        }
    }

    protected void labFront() {
        System.out.println("\nЛабораторная работа №2.\n");
        System.out.printf("Ваш ответ:\ny = %5.4f\n", labBack(readDoubleWVerify("x")));
    }
}
