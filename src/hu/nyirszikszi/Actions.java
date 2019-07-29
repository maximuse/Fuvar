package hu.nyirszikszi;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Actions {
    static ArrayList<Fuvar> readList(String fileName) {
        ArrayList<Fuvar> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();
            String[] slice;
            String utf;

            while (row != null) {
                utf = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                slice = utf.split(";");

                list.add(new Fuvar(Integer.parseInt(slice[0]), slice[1], Integer.parseInt(slice[2]), Double.parseDouble(slice[3]), Double.parseDouble(slice[4]), Double.parseDouble(slice[5]), slice[6]));

                row = raf.readLine();
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    static String task4(ArrayList<Fuvar> list, int taxiId) {
        int counter = 0;
        double total = 0.0;

        for (Fuvar fuvar : list) {
            if (fuvar.getTaxiId() == taxiId) {
                counter++;
                total += fuvar.getViteldij();
            }
        }

        return counter + " fuvar alatt: $" + String.format("%.2f", total);
    }

    static void task5(ArrayList<Fuvar> list) {
        int counter = 0;
        TreeSet<String> paymentMethods = new TreeSet<>();
        Map<String, Integer> data = new HashMap<>();

        for (Fuvar fuvar : list) {
            paymentMethods.add(fuvar.getFizetesModja());
        }

        for (String paymentMethod : paymentMethods) {
            for (Fuvar fuvar : list) {
                if (fuvar.getFizetesModja().equals(paymentMethod)) {
                    counter++;
                }
            }
            data.put(paymentMethod, counter);
            counter = 0;
        }


        data.forEach((key, value) -> System.out.println("\t" + key + ": " + value + " fuvar"));
    }

    static String task6(ArrayList<Fuvar> list) {
        double distance = 0.0;

        for (Fuvar fuvar : list) {
            distance += fuvar.getTavolsag() * 1.6;
        }

        return String.format("%.2f", distance) + " km";
    }

    static String task7(ArrayList<Fuvar> list) {
        String data = "Leghosszabb fuvar:\n";
        int index = 0;
        int period = list.get(index).getIdotartam();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getIdotartam() > period) {
                period = list.get(i).getIdotartam();
                index = i;
            }
        }

        data += "\tFuvar hossza: " + list.get(index).getIdotartam() + " másodperc\n" +
                "\tTaxi azonosítója: " + list.get(index).getTaxiId() + "\n" +
                "\tMegtett távolság: " + String.format("%.2f", list.get(index).getTavolsag()) + " km\n" +
                "\tViteldíj: $" + String.format("%.2f", list.get(index).getViteldij());

        return data;
    }

    static String task8(ArrayList<Fuvar> list, String fileName) {
        ArrayList<String> results = new ArrayList<>();

        list.sort(Comparator.comparing(Fuvar::getIndulas));

        for (Fuvar fuvar : list) {
            if (fuvar.getIdotartam() > 0.0 && fuvar.getViteldij() > 0.0 && fuvar.getTavolsag() == 0.0) {
                results.add(fuvar.getTaxiId() + ";" + fuvar.getIndulas() + ";" + fuvar.getIdotartam() + ";" +
                            fuvar.getTavolsag() + ";" + fuvar.getViteldij() + ";" + fuvar.getBorravalo() + ";" +
                            fuvar.getFizetesModja());
            }
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

            raf.writeBytes("taxi_id;indulas;idotartam;tavolsag;viteldij;borravalo;fizetes_modja\r\n");
            for (String result : results) {
                raf.writeBytes(result + "\r\n");
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileName;
    }
}