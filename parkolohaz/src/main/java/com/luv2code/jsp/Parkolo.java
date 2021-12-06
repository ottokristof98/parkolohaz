package com.luv2code.jsp;
public class Parkolo {
    private int idparkolo;
    private String cim;
    private String nev;
    private int osszhely;
    private int percdij;
    private int extra_percdij;
    private String kep;
    public int getIdParkolo() {
        return idparkolo;
    }
    public Parkolo(){
        
    }
    public Parkolo(int idparkolo, String cim, String nev, int osszhely, int percdij, int extra_percdij, String kep){
    this.idparkolo = idparkolo;
    this.cim = cim; this.nev = nev; this.osszhely = osszhely; 
    this.percdij = percdij; this.extra_percdij = extra_percdij;
    this.kep = kep;
    }
    public String getCim() {
        return cim;
    }
    public void setCim(String cim) {
        this.cim = cim;
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
    public int getOsszhely() {
        return osszhely;
    }
    public void setOsszhely(int osszhely) {
        this.osszhely = osszhely;
    }
    public String getKep() {
        return kep;
    }
    public void setKep(String kep) {
        this.kep = kep;
    }
    public void setIdParkolo(int idparkolo) {
        this.idparkolo = idparkolo;
    }
    public int getPercdij() {
        return percdij;
    }
    public void setPercdij(int percdij) {
        this.percdij = percdij;
    }
    public int getExtraPercdij() {
        return extra_percdij;
    }
    public void setExtraPercdij(int extra_percdij) {
        this.extra_percdij = extra_percdij;
    }
    
    }