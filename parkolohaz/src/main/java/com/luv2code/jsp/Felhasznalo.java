package com.luv2code.jsp;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Felhasznalo {
    private int id;
    private String nev;
    private String email;
    private String jelszo;
    private String lakcim;
    private LocalDate szuletes;
    private String telefonszam;
    private LocalDateTime reg_datum;
    public int getId() {
        return id;
    }
    public Felhasznalo(){}
    public Felhasznalo(int id, String nev, String email, String jelszo, String lakcim, LocalDate szuletes, String telefonszam, LocalDateTime reg_datum){
        this.id = id; this.nev = nev; this.email = email; this.jelszo = jelszo; this.lakcim = lakcim; this.szuletes = szuletes; this.telefonszam = telefonszam; this.reg_datum = reg_datum;
    }
    public LocalDateTime getReg_datum() {
        return reg_datum;
    }
    public void setReg_datum(LocalDateTime reg_datum) {
        this.reg_datum = reg_datum;
    }
    public String getTelefonszam() {
        return telefonszam;
    }
    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }
    public LocalDate getSzuletes() {
        return szuletes;
    }
    public void setSzuletes(LocalDate szuletes) {
        this.szuletes = szuletes;
    }
    public String getLakcim() {
        return lakcim;
    }
    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
    public String getJelszo() {
        return jelszo;
    }
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
}
