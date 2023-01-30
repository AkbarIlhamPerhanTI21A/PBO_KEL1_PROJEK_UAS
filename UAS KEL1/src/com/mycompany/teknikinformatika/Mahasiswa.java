package com.mycompany.teknikinformatika;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mahasiswa implements Crud {

    private String nim;
    private String nama;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean create() throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Insert Into mahasiswa set nama = ?, nim = ?");
        ps.setString(1, getNama());
        ps.setString(2, getNim());
        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean update(Object id) throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Update mahasiswa set nama =? where nim = ?");
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
        PreparedStatement ps = Koneksi.getConnection().prepareStatement(" Delete from mahasiswa where nim = ?");
        ps.setString(1, getNim());
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
