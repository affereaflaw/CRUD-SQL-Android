package com.example.affereaflaw.databaseex;

/**
 * Created by Affe Reaflaw on 7/19/2017.
 */
public class Person {
    private int Id;
    private String name, kelas, telp, no;

    public Person() {
    }

    public Person(int id, String name, String kelas, String telp, String no) {
        Id = id;
        this.name = name;
        this.kelas = kelas;
        this.telp = telp;
        this.no = no;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
