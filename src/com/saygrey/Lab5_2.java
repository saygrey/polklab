package com.saygrey;

public class Lab5_2 extends LabAbstr {
    protected void labFront() {
        System.out.println("\nЛабораторная работа №5.\n Задание №2.\n");
        System.out.printf("\nСамая длинная последовательность символов, стоящих по возрастанию: \n%s\n", labBack(readString(" исходную строку")));
    }

    protected String labBack(String inStr) {
        char[] inStrToCharArr = (inStr + " ").toCharArray();
        String temp = "", maxstr = "";
        for (int i = 0; i < inStr.length(); i++) {
            if (inStrToCharArr[i] < inStrToCharArr[i + 1])
                temp += inStrToCharArr[i];
            else {
                temp += inStrToCharArr[i];
                if (temp.length() > maxstr.length())
                    maxstr = temp;
                temp = "";
            }
        }
        return maxstr;
    }
}
