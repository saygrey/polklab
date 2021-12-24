package com.saygrey;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class Lab4_2 extends LabAbstr {
    protected ArrayList<ArrayList<Double>> labBack(int n, double a1, double a2) {
        ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();
        out.add(new ArrayList<Double>());
        out.add(new ArrayList<Double>());
        out.add(new ArrayList<Double>());
        int i;
        double a;
        double s = a1 + a2;
        for (i = 3; i <= n; i++) {
            a = pow(a2, 1.0 / (i - 1)) / pow(a1, 1.0 / (i - 2));
            a1 = a2;
            a2 = a;
            s += a;
            out.get(0).add((double) i);
            out.get(1).add(a);
            out.get(2).add(s);
        }
        return out;
    }

    protected void labFront() {
        System.out.println("\nЛабораторная работа №4.\n Задание №2.\n");
        int n = 0;
        double a1 = 0;
        double a2 = 0;
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            n = readIntegerWVerify("n");
            a1 = readDoubleWVerify("a1");
            a2 = readDoubleWVerify("a2");
            if (n < 1 || a1<=0 || a2<=0) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        System.out.printf("|   k   |     a     |     s     |\n");
        ArrayList<ArrayList<Double>> out = labBack(n, a1, a2);
        for (int i = 0; i < n - 2; i++) {
            System.out.printf("| %9.4f | %9.4f | %9.4f |\n", out.get(0).get(i), out.get(1).get(i), out.get(2).get(i));
        }
    }
}
