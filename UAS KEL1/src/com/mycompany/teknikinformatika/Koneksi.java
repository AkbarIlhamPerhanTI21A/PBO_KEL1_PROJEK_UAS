/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teknikinformatika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kii
 */
public class Koneksi {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teknik_informatika", "root", "");
        }
        return connection;
    }

    public static ArrayList<Mahasiswa> getMahasiswa() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("select * from mahasiswa");
        ArrayList<Mahasiswa> data = new ArrayList<>();
        while (rs.next()) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNim(rs.getString("nim"));
            mahasiswa.setNama(rs.getString("nama"));
            data.add(mahasiswa);

        }
        return data;
    }

    public static ArrayList<Dosen> getDosen() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("select * from dosen");
        ArrayList<Dosen> data = new ArrayList<>();
        while (rs.next()) {
            Dosen dosen = new Dosen();
            dosen.setNid(rs.getString("nid"));
            dosen.setNama(rs.getString("nama"));
            data.add(dosen);

    }
        return data;

    }

    public static ArrayList<Matkul> getMatkul() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("select * from matkul");
        ArrayList<Matkul> data = new ArrayList<>();
        while (rs.next()) {
            Matkul matkul = new Matkul();
            matkul.setNama(rs.getString("nama_matkul"));
            data.add(matkul);

        }
        return data;
    }

    public static ArrayList<Ujian> getUjian() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("select *, mahasiswa.nama as nama_mahasiswa, dosen.nama as nama_dosen from ujian left join mahasiswa on mahasiswa.nim=ujian.nim left join dosen on dosen.nid=ujian.nid ");
        
        ArrayList<Ujian> data = new ArrayList<>();
        while (rs.next()) {
            Ujian ujian = new Ujian();
            ujian.setIdUjian(rs.getInt("id_ujian"));
            ujian.setNim(rs.getString("nim"));
            ujian.setNid(rs.getString("nid"));
            ujian.setNamaMatkul(rs.getString("nama_matkul"));
            ujian.setNamaDosen(rs.getString("nama_dosen"));
            ujian.setNamaMahasiswa(rs.getString("nama_mahasiswa"));
            ujian.setNilai(rs.getInt("nilai"));
            data.add(ujian);
        }
        return data;
    }
            
}
