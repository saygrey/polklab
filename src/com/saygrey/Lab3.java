package com.saygrey;

import java.util.ArrayList;

public class Lab3 extends LabAbstr {
    protected ArrayList<ArrayList<Double>> labBack(Double x, Double x_kon, Double delta_x, Double eps) {
        ArrayList<ArrayList<Double>> outs = new ArrayList<ArrayList<Double>>();
        Double s, f, t;
        Double n;
        while (x <= x_kon && x != 0) {
            outs.add(new ArrayList<Double>());
            t = 1.0;
            s = 1.0;
            n = 1.0;
            f = Math.sin(x) / x;
            while (Math.abs(t) > eps) {
                t *= -x * x / (2.0 * n * (2.0 * n + 1.0));
                s += t;
                n++;
            }
            outs.get(outs.size() - 1).add(x);
            outs.get(outs.size() - 1).add(n);
            outs.get(outs.size() - 1).add(s);
            outs.get(outs.size() - 1).add(f);
            x += delta_x;
        }
        return outs;
    }

    protected void labFront() {
        System.out.println("\nЛабораторная работа №3.\n");
        double x_nach = 0.0;
        double x_kon = 0.0;
        double delta_x = 0.0;
        double eps = 0.0;
        while (!isInputValid) {
            if (powerOfStupid > idiotEntriesLimit) {
                System.out.println("Goodbye...");
                System.exit(-1);
            }
            x_nach = readDoubleWVerify("x_nach");
            x_kon = readDoubleWVerify("x_kon");
            delta_x = readDoubleWVerify("delta_x");
            eps = readDoubleWVerify("eps");
            if (x_kon < x_nach) {
                x_nach += (x_kon - (x_kon = x_nach));
                delta_x = -delta_x;
            }
            if ((x_kon - x_nach < delta_x) || (eps < 0)) {
                powerOfStupid = idiotPrintNUp(powerOfStupid);
            } else {
                isInputValid = true;
            }
        }
        System.out.printf("|     x     |     s     |     n     |     f     |\n");
        labBack(x_nach, x_kon, delta_x, eps).stream().forEach((x) -> System.out.printf("| %9.4f | %9.4f | %9.4f | %9.4f |\n", x.get(0), x.get(1), x.get(2), x.get(3)));
    }
}
