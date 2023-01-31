package com.mycompany.teknikinformatika;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Matkul implements Crud {

    private String nama;

    public Matkul() {
    }

    public Matkul(String nama) {

        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean create() throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Insert Into matkul set nama_matkul = ?");
        ps.setString(1, getNama());
        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean update(Object id) throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Update matkul set nama_matkul =? where nama_matkul = ?");
        ps.setString(1, getNama());
        ps.setString(2, id.toString());
        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean delete() throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Delete from matkul where nama_matkul=?");
        ps.setString(1, getNama());
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
