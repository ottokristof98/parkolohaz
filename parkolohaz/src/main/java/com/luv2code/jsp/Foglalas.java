package com.luv2code.jsp;

import java.time.LocalDateTime;

import com.google.protobuf.Timestamp;

public class Foglalas {
    private int parkolohely;
    private LocalDateTime kezdes;
    private LocalDateTime meddig;
    private String rendszam;
    private int fizetes_tranzakcio_szam;
    private int parkolo_idparkolo;
    private int felhasznalo_idfelhasznalo;
    public Foglalas(){}
    public Foglalas(int parkolohely,LocalDateTime kezdes, LocalDateTime meddig, String rendszam, int fizetes_tranzakcio_szam, int parkolo_idparkolo, int felhasznalo_idfelhasznalo){
        this.parkolohely = parkolohely; this.kezdes = kezdes; this.meddig = meddig;
        this.rendszam = rendszam; this.fizetes_tranzakcio_szam = fizetes_tranzakcio_szam;
        this.parkolo_idparkolo = parkolo_idparkolo; this.felhasznalo_idfelhasznalo = felhasznalo_idfelhasznalo;
    }
    public int getParkolohely() {
        return parkolohely;
    }
    public int getFelhasznalo_idfelhasznalo() {
        return felhasznalo_idfelhasznalo;
    }
    public void setFelhasznalo_idfelhasznalo(int felhasznalo_idfelhasznalo) {
        this.felhasznalo_idfelhasznalo = felhasznalo_idfelhasznalo;
    }
    public int getParkolo_idparkolo() {
        return parkolo_idparkolo;
    }
    public void setParkolo_idparkolo(int parkolo_idparkolo) {
        this.parkolo_idparkolo = parkolo_idparkolo;
    }
    public int getFizetes_tranzakcio_szam() {
        return fizetes_tranzakcio_szam;
    }
    public void setFizetes_tranzakcio_szam(int fizetes_tranzakcio_szam) {
        this.fizetes_tranzakcio_szam = fizetes_tranzakcio_szam;
    }
    public String getRendszam() {
        return rendszam;
    }
    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }
    public LocalDateTime getMeddig() {
        return meddig;
    }
    public void setMeddigs(LocalDateTime meddig) {
        this.meddig = meddig;
    }
    public LocalDateTime getKezdes() {
        return kezdes;
    }
    public void setKezdes(LocalDateTime kezdes) {
        this.kezdes = kezdes;
    }
    public void setParkolohely(int parkolohely) {
        this.parkolohely = parkolohely;
    }
}
