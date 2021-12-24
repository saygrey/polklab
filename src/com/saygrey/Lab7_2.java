package com.saygrey;

import java.util.ArrayList;

public class Lab7_2 extends LabAbstr {
    private int v_min = 0;
    private int v_max = 0;
    private int n = 0;

    protected void labFront() {
        System.out.println("\nЛабораторная работа №7.\n Задание №2.\n");
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            n = readIntegerWVerify("n");
            v_min = readIntegerWVerify("v_min");
            v_max = readIntegerWVerify("v_max");
            if (n < 0 || v_max <= v_min) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        ArrayList<ArrayList<Integer>> out = labBack(n, v_min, v_max);
        System.out.printf("\nИзначальный вектор:\n");
        out.get(0).forEach((x) -> System.out.printf("%4d", x));
        if (out.get(2).get(0) == 1) {
            System.out.printf("\n\nОтсортированный вектор: \n");
            out.get(1).forEach((x) -> System.out.printf("%4d", x));
        } else
            System.out.printf("\n\nОдинаковые элементы не найдены.\n");
    }

    protected ArrayList<ArrayList<Integer>> labBack(int n, int v_min, int v_max) {
        ArrayList<ArrayList<Integer>> outs = new ArrayList<ArrayList<Integer>>();
        outs.add(new ArrayList<Integer>());
        outs.add(new ArrayList<Integer>());
        outs.add(new ArrayList<Integer>());
        boolean flagSimilarNumNotFound = true;
        int firstSimNumInd = 0;
        int secSimNumInd = 0;
        for (int i = 0; i < n; i++) {
            outs.get(0).add(rand.nextInt(v_max - v_min + 1) + v_min);
            if (flagSimilarNumNotFound && i != 0) {
                if (outs.get(0).indexOf(outs.get(0).get(i)) != i) {
                    firstSimNumInd = outs.get(0).indexOf(outs.get(0).get(i));
                    secSimNumInd = i;
                    flagSimilarNumNotFound = false;
                }
            }
        }
        System.out.println(firstSimNumInd + " " + secSimNumInd);
        outs.set(2, (ArrayList<Integer>) outs.get(0).clone());
        outs.add(new ArrayList<>());
        if (!flagSimilarNumNotFound) {
            boolean sorted = false;
            int temp;
            while (!sorted) {
                sorted = true;
                for (int i = firstSimNumInd + 1; i < secSimNumInd - 1; i++) {
                    if (outs.get(1).get(i) > outs.get(1).get(i + 1)) {
                        temp = outs.get(1).get(i);
                        outs.get(1).set(i, outs.get(1).get(i + 1));
                        outs.get(1).set(i + 1, temp);
                        sorted = false;
                    }
                }
            }
            outs.get(2).add(1);
        } else {
            outs.get(2).add(0);
        }
        return outs;
    }
}