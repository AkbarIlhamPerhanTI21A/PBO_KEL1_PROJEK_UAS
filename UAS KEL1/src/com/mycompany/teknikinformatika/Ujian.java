package com.mycompany.teknikinformatika;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ujian implements Crud {

    private String nim;
    private String nid;
    private String namaMatkul;
    private String namaMahasiswa;
    private String namaDosen;
    private int idUjian;
    private int nilai;

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public void setIdUjian(int idUjian) {
        this.idUjian = idUjian;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public String getNim() {
        return nim;
    }

    public String getNid() {
        return nid;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public int getIdUjian() {
        return idUjian;
    }

    public int getNilai() {
        return nilai;
    }

    public Ujian() {
    }

    public Ujian(String nim, String nid, String namaMatkul, String namaMahasiswa, String namaDosen, int idUjian, int nilai) {
        this.nim = nim;
        this.nid = nid;
        this.namaMatkul = namaMatkul;
        this.namaMahasiswa = namaMahasiswa;
        this.namaDosen = namaDosen;
        this.idUjian = idUjian;
        this.nilai = nilai;
    }

    @Override
    public boolean create() throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Insert Into ujian set nama_matkul = ?, nim = ?, nid = ?, nilai = ?");
        ps.setString(1, getNamaMatkul());
        ps.setString(2, getNim());
        ps.setString(3, getNid());
        ps.setInt(4, getNilai());
        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean update(Object id) throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Update ujian set nama_matkul =?,nim = ?, nid = ?, nilai = ? where id_ujian = ?");
        ps.setString(1, getNamaMatkul());
        ps.setString(2, getNim());
        ps.setString(3, getNid());
        ps.setInt(4, getNilai());
        ps.setInt(5, Integer.parseInt(id.toString()));
        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean delete() throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Delete from ujian where id_ujian = ?");
        ps.setInt(1, getIdUjian());
        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void find(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}