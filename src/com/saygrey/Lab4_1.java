package com.saygrey;

import java.util.ArrayList;

public class Lab4_1 extends LabAbstr {
    protected ArrayList<Double> labBack(int n) {
        ArrayList<Double> out = new ArrayList<Double>();
        Double s = 0.0;
        for (int i = 1; i <= n; i++) {
            s += 1.0 / ((2.0 * i - 1.0) * (2.0 * i + 1.0));
            out.add(s);
        }
        return out;
    }

    protected void labFront() {
        System.out.println("\nЛабораторная работа №4.\n Задание №1.\n");
        int n = 0;
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            n = readIntegerWVerify("n");
            if (n < 1) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        System.out.printf("|   i   |     s     |     f     |\n");
        ArrayList<Double> out = labBack(n);
        for (int i = 0; i < n; i++) {
            System.out.printf("| %5d | %9.4f | %9.4f |\n", i + 1, out.get(i), 0.5);
        }
    }
}
