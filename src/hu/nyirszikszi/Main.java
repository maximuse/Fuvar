package hu.nyirszikszi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Fuvar> list = Actions.readList("fuvar.csv");

        System.out.println("3. feladat: " + list.size() + " fuvar");

        System.out.println("4. feladat: " + Actions.task4(list, 6185));

        System.out.println("5. feladat:");
        Actions.task5(list);

        System.out.println("6. feladat: " + Actions.task6(list));

        System.out.println("7. feladat: " + Actions.task7(list));
    }
}