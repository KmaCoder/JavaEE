package com.maksymnesterov.spring;

import java.util.List;

public class Printer {
    private List<String> ocenki;
    private int santimatrov;
    private String imya;

    public Printer(List<String> ocenki, int santimatrov, String imya) {
        this.ocenki = ocenki;
        this.santimatrov = santimatrov;
        this.imya = imya;
    }

    public void print() {
        System.out.println("Grades: ");
        ocenki.forEach(System.out::println);
        System.out.print("Height: ");
        System.out.println(santimatrov);
        System.out.print("Name: ");
        System.out.println(imya);
    }

    public List<String> getOcenki() {
        return ocenki;
    }

    public void setOcenki(List<String> ocenki) {
        this.ocenki = ocenki;
    }

    public int getSantimatrov() {
        return santimatrov;
    }

    public void setSantimatrov(int santimatrov) {
        this.santimatrov = santimatrov;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }
}
