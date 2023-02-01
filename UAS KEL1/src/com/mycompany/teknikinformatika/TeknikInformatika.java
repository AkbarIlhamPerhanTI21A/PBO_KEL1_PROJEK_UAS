/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.teknikinformatika;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kii
 */
public class TeknikInformatika {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        boolean ulang = true;
        do {
            System.out.println("Pilih Menu Di Bawah Ini ");
            System.out.println("1. Kelola Matkul");
            System.out.println("2. Kelola Dosen ");
            System.out.println("3. Kelola Mahasiswa ");
            System.out.println("4. Kelola Nilai ");
            System.out.println("5. Exit ");
            System.out.print("Masukan Pilihan : ");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    kelolaMatkul();
                    break;
                case 2:
                    kelolaDosen();
                    break;
                case 3:
                    kelolaMahasiswa();
                    break;
                case 4:
                    kelolaUjian();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }

        } while (ulang);

    }

    private static void kelolaMatkul() throws SQLException {

        System.out.println("Pilih Kelola ");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("3. List ");
        System.out.println("4. Exit");
        System.out.print("Masukan Pilihan : ");

        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1: {
                Matkul matkul = new Matkul();
                System.out.print("Masukan Nama Matkul :");
                matkul.setNama(scanner.nextLine());
                if (matkul.create()) {
                    System.out.println("Behasil Tambah Matkul");
                } else {
                    System.out.println("Gagal Tambah Matkul");
                }

                break;
            }

            case 2: {
                Matkul matkul = new Matkul();
                System.out.print("Masukan Nama Matkul Lama :");
                matkul.setNama(scanner.nextLine());
                if (matkul.delete()) {
                    System.out.println("Berhasil Hapus Matkul");
                } else {
                    System.out.println("Gagal Hapus Matkul");
                }

                break;
            }
            case 3: {
                ArrayList<Matkul> daftar = Koneksi.getMatkul();
                if (daftar.isEmpty()) {
                    System.out.println("Tidak ada ");
                }
                
                for (int i = 0; i < daftar.size(); i++) {
                    Matkul matkul = daftar.get(i);
                    System.out.println(i + 1 + " " + matkul.getNama());
                }
                System.out.println("Jumlah Matkul: "+daftar.size());
                break;
                
            }
            case 4: {
                System.exit(0);
            }
        }
    }

    private static void kelolaDosen() throws SQLException {

        System.out.println("Pilih Kelola ");
        System.out.println("1. Tambah");
        System.out.println("2. Edit");
        System.out.println("3. Hapus");
        System.out.println("4. List ");1
        System.out.println("5. Exit");
        System.out.print("Masukan Pilihan : ");

        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1: {
                Dosen dosen = new Dosen();
                System.out.print("Masukan NID Dosen : ");
                dosen.setNid(scanner.nextLine());
                System.out.print("Masukan Nama Dosen :");
                dosen.setNama(scanner.nextLine());

                if (dosen.create()) {
                    System.out.println("Berhasil Tambah Dosen");
                } else {
                    System.out.println("Gagal Tambah Dosen");
                }

                break;
            }
            case 2: {
                Dosen dosen = new Dosen();
                System.out.print("Masukan NID Dosen :");
                dosen.setNid(scanner.nextLine());
                System.out.print("Masukan Nama Dosen :");
                dosen.setNama(scanner.nextLine());

                if (dosen.update(dosen.getNid())) {
                    System.out.println("Berhasil Edit Dosen");
                } else {
                    System.out.println("Gagal Edit Dosen");
                }

                break;
            }
            case 3: {
                Dosen dosen = new Dosen();
                System.out.print("Masukan NID :");
                dosen.setNid(scanner.nextLine());
                if (dosen.delete()) {
                    System.out.println("Berhasil Hapus Dosen");
                } else {
                    System.out.println("Gagal Hapus Dosen");
                }

                break;
            }
            case 4: {
                ArrayList<Dosen> daftar = Koneksi.getDosen();
                if (daftar.isEmpty()) {
                    System.out.println("Tidak Ada");
                }
                for (int i = 0; i < daftar.size(); i++) {
                    Dosen dosen = daftar.get(i);
                    System.out.println(i + 1 + " " + dosen.getNama() + " - " + dosen.getNid());
                }
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
    }

    private static void kelolaMahasiswa() throws SQLException {

        System.out.println("Pilih Kelola ");
        System.out.println("1. Tambah");
        System.out.println("2. Edit");
        System.out.println("3. Hapus");
        System.out.println("4. List ");
        System.out.println("5. Exit");
        System.out.print("Masukan Pilihan : ");

        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1: {
                Mahasiswa mahasiswa = new Mahasiswa();
                System.out.print("Masukan NIM Mahasiswa :");
                mahasiswa.setNim(scanner.nextLine());
                System.out.print("Masukan Nama Mahasiswa :");
                mahasiswa.setNama(scanner.nextLine());

                if (mahasiswa.create()) {
                    System.out.println("Behasil Tambah Mahasiswa");
                } else {
                    System.out.println("Gagal Tambah Mahasiswa");
                }

                break;
            }
            case 2: {
                Mahasiswa mahasiswa = new Mahasiswa();
                System.out.print("Masukan NIM Mahasiswa :");
                mahasiswa.setNim(scanner.nextLine());
                System.out.print("Masukan Nama Mahasiswa :");
                mahasiswa.setNama(scanner.nextLine());

                if (mahasiswa.update((mahasiswa.getNim()))) {
                    System.out.println("Behasil Edit Mahasiswa");
                } else {
                    System.out.println("Gagal Edit Mahasiswa");
                }

                break;
            }
            case 3: {
                Mahasiswa mahasiswa = new Mahasiswa();
                System.out.print("Masukan NIM Mahasiswa :");
                mahasiswa.setNim(scanner.nextLine());
                if (mahasiswa.delete()) {
                    System.out.println("Berhasil Hapus Mahasiswa");

                } else {
                    System.out.println("Gagal Hapus Mahasiswa");

                }

                break;
            }
            case 4: {
                ArrayList<Mahasiswa> daftar = Koneksi.getMahasiswa();
                if (daftar.isEmpty()) {
                    System.out.println("Tidak Ada");

                }
                for (int i = 0; i < daftar.size(); i++) {
                    Mahasiswa mahasiswa = daftar.get(i);
                    System.out.println(i + 1 + " " + mahasiswa.getNama() + " - " + mahasiswa.getNim());
                }
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
    }

    private static void kelolaUjian() throws SQLException {

        System.out.println("Pilih Kelola ");
        System.out.println("1. Tambah");
        System.out.println("2. Edit");
        System.out.println("3. Hapus");
        System.out.println("4. List ");
        System.out.println("5. Exit");
        System.out.print("Masukan Pilihan : ");

        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1: {
                Ujian ujian = new Ujian();
                System.out.print("Masukan NIM Mahasiswa :");
                ujian.setNim(scanner.nextLine());
                System.out.print("Masukan Nama Matkul : ");
                ujian.setNamaMatkul(scanner.nextLine());
                System.out.print("Masukan NID Dosen : ");
                ujian.setNid(scanner.nextLine());
                System.out.print("Masukan Nilai Mahasiswa :");
                ujian.setNilai(Integer.parseInt(scanner.nextLine()));
                if (ujian.create()) {
                    System.out.println("Behasil Tambah Ujian");
                } else {
                    System.out.println("Gagal Tambah Ujian");
                }

                break;
            }
            case 2: {
                    
                Ujian ujian = new Ujian();
                System.out.print("Masukan ID Ujian : ");
                ujian.setIdUjian(Integer.parseInt(scanner.nextLine()));
                System.out.print("Masukan NIM Mahasiswa :");
                ujian.setNim(scanner.nextLine());
                System.out.print("Masukan Nama Matkul : ");
                ujian.setNamaMatkul(scanner.nextLine());
                System.out.print("Masukan NID Dosen : ");
                ujian.setNid(scanner.nextLine());
                System.out.print("Masukan Nilai Mahasiswa :");
                ujian.setNilai(Integer.parseInt(scanner.nextLine()));
                if (ujian.update(ujian.getIdUjian())) {
                    System.out.println("Behasil Edit Ujian");
                } else {
                    System.out.println("Gagal Edit Ujian");
                }

                break;
            }
            case 3: {
                Ujian ujian = new Ujian();
                System.out.print("Masukan ID Ujian : ");
                ujian.setIdUjian(Integer.parseInt(scanner.nextLine()));
                if (ujian.delete()) {
                    System.out.println("Berhasil Hapus Ujian");

                } else {
                    System.out.println("Gagal Hapus Ujian");

                }

                break;
            }
            case 4: {
                ArrayList<Ujian> daftar = Koneksi.getUjian();
                if (daftar.isEmpty()) {
                    System.out.println("Tidak Ada");

                }
                for (int i = 0; i < daftar.size(); i++) {
                    Ujian ujian = daftar.get(i);
                    System.out.println(i + 1 +" ID Ujian: " + ujian.getIdUjian() + "  Nama :" + ujian.getNamaMahasiswa() + "  Matkul : " + ujian.getNamaMatkul() + "  Nama Dosen :  " + ujian.getNamaDosen() + " Nilai : " + ujian.getNilai());
                }
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
    }
}
