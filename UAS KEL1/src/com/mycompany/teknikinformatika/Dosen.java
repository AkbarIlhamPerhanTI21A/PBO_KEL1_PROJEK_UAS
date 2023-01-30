package com.mycompany.teknikinformatika;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dosen implements Crud {

    private String nid;
    private String nama;

    public Dosen() {
    }

    public Dosen(String nid, String nama) {
        this.nid = nid;
        this.nama = nama;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean create() throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Insert Into dosen set nama = ?, nid = ?");
        ps.setString(1, getNama());
        ps.setString(2, getNid());

        boolean r = false;
        try {
            r = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean update(Object id) throws SQLException {
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Update dosen set nama =? where nid = ?");
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
        PreparedStatement ps = Koneksi.getConnection().prepareStatement("Delete From dosen where nid = ?");
        ps.setString(1, getNid());
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
