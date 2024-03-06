package org.example;

import org.apache.commons.math3.stat.StatUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHall {
    public static void game() {
        int doors = 3;
        List<Integer> winsStay = new ArrayList<>();
        List<Integer> winsSwitch = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int choice = random.nextInt(doors);
            int car = random.nextInt(doors);

            if (play(choice, car, false)) {
                winsStay.add(1);
            }

            if (play(choice, car, true)) {
                winsSwitch.add(1);
            }
        }

        System.out.println("Вероятность победы при сохранении выбора: " + StatUtils.sum(winsStay.stream().mapToDouble(i -> i).toArray())/1000);
        System.out.println("Вероятность победы при смене выбора: " + StatUtils.sum(winsSwitch.stream().mapToDouble(i -> i).toArray())/1000);
    }

    public static boolean play(int choice, int car, boolean switchChoice) {
        if (choice == car) {
            return switchChoice;
        } else {
            return !switchChoice;
        }
    }

}
