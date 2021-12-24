package com.saygrey;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lab7_1 extends LabAbstr {
    private int v_min = 0;
    private int v_max = 0;
    private int n = 0;
    private int m = 0;

    protected void labFront() {
        System.out.println("\nЛабораторная работа №7.\n Задание №1.\n");
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            n = readIntegerWVerify("n");
            m = readIntegerWVerify("m");
            v_min = readIntegerWVerify("v_min");
            v_max = readIntegerWVerify("v_max");
            if (n <= 0 || m <=0 || v_max <= v_min) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        ArrayList<int[][]> out = labBack(n, m, v_min, v_max);
        System.out.printf("\nИзначальная матрица:\n");
        matrixPrinter(out.get(0));
        if (out.get(1)[0][1] == 1)
            System.out.printf("\n\nМаксимальный элемент, встречающийся более одного раза = %d \n", out.get(1)[0][0]);
        else
            System.out.printf("\n\nМаксимальный элемент, встречающийся более одного раза, не найден. \n");
    }

    protected ArrayList<int[][]> labBack(int n, int m, int v_min, int v_max) {
        ArrayList<int[][]> outs = new ArrayList<int[][]>();
        outs.add(new int[m][n]);
        outs.add(new int[1][2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                outs.get(0)[i][j] = rand.nextInt(v_max - v_min + 1) + v_min;
            }
        }
        int[] flatArr = Stream.of(outs.get(0))
                .flatMapToInt(IntStream::of)
                .sorted()
                .toArray();
        int tempMax = 0;
        boolean flagMaxNotInit = true;
        for (int i = 0; i < flatArr.length - 1; i++) {
            if (flatArr[i] == flatArr[i + 1] && (flatArr[i] > tempMax || flagMaxNotInit)) {
                tempMax = flatArr[i];
            }
        }
        outs.get(1)[0][0] = tempMax;
        if (flagMaxNotInit)
            outs.get(1)[0][1] = 0;
        else
            outs.get(1)[0][1] = 1;
        return outs;
    }

    protected void matrixPrinter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%-5d", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}