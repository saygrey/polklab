package com.saygrey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Lab6_1 extends LabAbstr {
    private int max2value, min2value, max2Index, min2Index;
    private int v_min = 0;
    private int v_max = 0;
    private int n = 0;

    protected void labFront(){
        System.out.println("\nЛабораторная работа №6.\n Задание №1.\n");
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            n = readIntegerWVerify("n");
            v_min = readIntegerWVerify("v_min");
            v_max = readIntegerWVerify("v_max");
            if (n < 4 || v_max <= v_min) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        ArrayList<ArrayList<Integer>> out = labBack(n, v_min, v_max);
        System.out.printf("\nИзначальный вектор:\n");
        out.get(0).stream().forEach((x) -> System.out.print(x + " "));
        System.out.printf("\n\n   v2max   = %4d     v2min   = %4d \n" +
                "v2maxIndex = %4d  v2minIndex = %4d\n", max2value, min2value, max2Index, min2Index);
        System.out.printf("\nИзмененный вектор:\n");
        out.get(1).stream().forEach((x) -> System.out.print(x + " "));
        System.out.println();
    }

    protected ArrayList<ArrayList<Integer>> labBack(int n, int v_min, int v_max) {
        ArrayList<ArrayList<Integer>> outs = new ArrayList<ArrayList<Integer>>();
        outs.add(new ArrayList<Integer>());

        for (int i = 0; i < n; i++) {
            outs.get(0).add(rand.nextInt(v_max - v_min + 1) + v_min);
        }
        max2Find(outs.get(0));
        min2Find(outs.get(0));
        max2Index = outs.get(0).indexOf(max2value);
        min2Index = outs.get(0).indexOf(min2value);
        outs.add((ArrayList<Integer>) outs.get(0).clone());
        int minIndex = Math.min(max2Index, min2Index);
        int maxIndex = Math.max(max2Index, min2Index);
        int halfDiffMinMaxInd = (int) (maxIndex - minIndex) / 2;
        for (int i = 1; i <= halfDiffMinMaxInd; i++) {
            int temp = outs.get(0).get(i + minIndex);
            outs.get(1).set(i + minIndex, outs.get(1).get(maxIndex - i));
            outs.get(1).set(maxIndex - i, temp);
        }
        return outs;
    }

    protected void max2Find(ArrayList<Integer> in) {
        max2value = Collections.max(in.stream().filter((x) -> x != Collections.max(in) && x != Collections.min(in)).collect(Collectors.toList()));
    }

    protected void min2Find(ArrayList<Integer> in) {
        min2value = Collections.min(in.stream().filter((x) -> x != Collections.max(in) && x != Collections.min(in)).collect(Collectors.toList()));
    }

}
