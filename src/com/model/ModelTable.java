/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author OverLord
 */
public class ModelTable {
    private int id;
    private String hoSV;
    private String tenSV;
    private String mssv;
    private int khoa;
    private String maNganh;
    private String gioiTinh;
    private String ngaySinh;
    private String soDienThoai;

    public ModelTable(int id, String hoSV, String tenSV, String mssv, int khoa, String maNganh, String gioiTinh, String ngaySinh, String soDienThoai) {
        this.id = id;
        this.hoSV = hoSV;
        this.tenSV = tenSV;
        this.mssv = mssv;
        this.khoa = khoa;
        this.maNganh = maNganh;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
    }

    public ModelTable(String hoSV, String tenSV, String mssv, int khoa, String maNganh, String gioiTinh, String ngaySinh, String soDienThoai) {
        this.hoSV = hoSV;
        this.tenSV = tenSV;
        this.mssv = mssv;
        this.khoa = khoa;
        this.maNganh = maNganh;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
    }
    
      

    public ModelTable() {
        this.hoSV = "";
        this.tenSV = "";
        this.mssv = "";
        this.khoa = 0;
        this.maNganh = "";
        this.gioiTinh = "";
        this.ngaySinh = "";
        this.soDienThoai = "";
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoSV() {
        return hoSV;
    }

    public void setHoSV(String hoSV) {
        this.hoSV = hoSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    
}
