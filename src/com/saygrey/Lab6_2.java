package com.saygrey;

import java.util.ArrayList;

public class Lab6_2 extends LabAbstr {
    private int v_min = 0;
    private int v_max = 0;
    private int n = 0;
    private int k = 0;

    protected void labFront() {
        System.out.println("\nЛабораторная работа №6.\n Задание №2.\n");
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            n = readIntegerWVerify("n");
            v_min = readIntegerWVerify("v_min");
            v_max = readIntegerWVerify("v_max");
            k = readIntegerWVerify("k");
            if (n / 2 < k || n < 1 || v_max <= v_min) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        ArrayList<int[][]> out = labBack(n, v_min, v_max, k);
        System.out.printf("\nИзначальная матрица:\n");
        squareMatrixPrinter(out.get(0));
        System.out.printf("\n\nИзмененная матрица: \n");
        squareMatrixPrinter(out.get(1));
        System.out.println();
    }

    protected ArrayList<int[][]> labBack(int n, int v_min, int v_max, int k) {
        ArrayList<int[][]> outs = new ArrayList<int[][]>();
        outs.add(new int[n][n]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                outs.get(0)[i][j] = rand.nextInt(v_max - v_min + 1) + v_min;
            }
        }
        int[][] secChanged = new int[5][5];
        for (int i = 0; i < n; i++) {
            secChanged[i] = outs.get(0)[i].clone();
        }
        outs.add(secChanged);
        int kBack = n - k + 1;
        for (int i = k - 1; i < kBack - 1; i++) {
            outs.get(1)[i][kBack - 1] = outs.get(0)[k - 1][i];
            outs.get(1)[kBack - 1][n - i - 1] = outs.get(0)[i][kBack - 1];
            outs.get(1)[n - i - 1][k - 1] = outs.get(0)[kBack - 1][n - i - 1];
            outs.get(1)[k - 1][i] = outs.get(0)[n - i - 1][k - 1];
        }
        return outs;
    }

    protected void squareMatrixPrinter(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-5d", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
