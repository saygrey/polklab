package com.saygrey;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lab5_1 extends LabAbstr {
    protected void labFront() {
        System.out.println("\nЛабораторная работа №5.\n Задание №1.\n");
        System.out.printf("\nСлова в обратной последовательности: \n%s\n", labBack(readStringWWordsNVerify("строку из слов")));
    }

    protected String labBack(String inNotFormatted) {
        String[] out = {""};
        String[] wordsArr = inNotFormatted.split("( )+");
        List<String> words = Arrays.asList(wordsArr);
        Collections.reverse(words);
        words.stream().forEach((x) -> out[0] += x + " ");
        return out[0];
    }
}
