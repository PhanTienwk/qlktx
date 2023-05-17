/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connector.KetNoiSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ThongTinHoaDon;
import model.ThongTinHoaDonSV;

/**
 *
 * @author PhanTien
 */
public class ThongTinHoaDonDAO {

    public ThongTinHoaDonDAO() {

    }

    public List<ThongTinHoaDon> getAllThongTinDichVu() {
        List<ThongTinHoaDon> list = new ArrayList<ThongTinHoaDon>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadon";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinHoaDon dichvu = new ThongTinHoaDon();
                dichvu.setMaPhong(rs.getString("maPhong"));
                dichvu.setSoDienCu(rs.getFloat("soDienCu"));
                dichvu.setSoDienMoi(rs.getFloat("soDienMoi"));
                dichvu.setSoNuocCu(rs.getFloat("soNuocCu"));
                dichvu.setSoNuocMoi(rs.getFloat("soNuocMoi"));
                dichvu.setTienThanhToan(rs.getDouble("tienThanhToan"));
                list.add(dichvu);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public double TienThanhToan(String maph) {
        double tiendichvu = 0;
        int soluongsv = new PhongDAO().SoLuongSV(maph);
        double tienphong = new PhongDAO().TienPhong(maph);
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadon where maPhong='" + maph + "'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tiendichvu = tienphong + rs.getDouble("tienThanhToan") / soluongsv;
            }
            con.close();
        } catch (Exception e) {
        }
        return tiendichvu;
    }
    
    public boolean KiemTraThangLapHoaDon(String thang, String masv){        
        Connection con =KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv where maSV='"+masv+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(thang.equals(rs.getString("thang"))){
                    return true;
                }
            }
        } catch (Exception e) {
        }
        
        
        return false;
    }
    
    public boolean KiemTraTienNo(String masv){
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dfmonth = new SimpleDateFormat("MM-yyyy");
        String date = String.valueOf(java.time.LocalDate.now());
        Date date1 = null;
        try {
            date1 = df.parse(date);
        } catch (ParseException ex) {
        }

        String datesave = dfmonth.format(date1);
        
        
        
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv where maSV='" + masv + "' and thanhToan='0'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               if(!datesave.equals(rs.getString("thang"))){
                   return true;
               }
            }
            con.close();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean KiemTraKhoanPhi(String masv){
         Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv where maSV='" + masv + "' and thanhToan='0'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                   return true;
            }
            con.close();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean KiemTraDongTien(String masv){
         
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv where maSV='" + masv + "' and thanhToan='10";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               
                   return true;
            }
            con.close();
        } catch (Exception e) {
        }
        return false;
    }

    
    public List<ThongTinHoaDonSV> getAllThongTinHoaDonSV() {
        List<ThongTinHoaDonSV> list = new ArrayList<ThongTinHoaDonSV>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setThang(rs.getString("thang"));
                hdsv.setMaSV(rs.getString("maSV"));
                hdsv.setMaPhong(rs.getString("maPhong"));
                hdsv.setTienPhi(rs.getDouble("tienPhi"));
                hdsv.setThanhToan(rs.getByte("thanhToan"));
                list.add(hdsv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<ThongTinHoaDonSV> getAllThongTinHoaDonSVChuaTT() {
        List<ThongTinHoaDonSV> list = new ArrayList<ThongTinHoaDonSV>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv where thanhToan='0'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setThang(rs.getString("thang"));
                hdsv.setMaSV(rs.getString("maSV"));
                hdsv.setMaPhong(rs.getString("maPhong"));
                hdsv.setTienPhi(rs.getDouble("tienPhi"));
                hdsv.setThanhToan(rs.getByte("thanhToan"));
                list.add(hdsv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<ThongTinHoaDonSV> getAllThongTinHoaDonSVTheoMaSV(String masv) {
        List<ThongTinHoaDonSV> list = new ArrayList<ThongTinHoaDonSV>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadonsv where maSV='"+masv+"'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setThang(rs.getString("thang"));
                hdsv.setMaSV(rs.getString("maSV"));
                hdsv.setMaPhong(rs.getString("maPhong"));
                hdsv.setTienPhi(rs.getDouble("tienPhi"));
                hdsv.setThanhToan(rs.getByte("thanhToan"));
                list.add(hdsv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public double TongTienHoaDon(int thanhtoan) {
        double soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select sum(tienPhi) as soluong from thongtinhoadonsv where thanhToan='"+ thanhtoan +"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong = rs.getDouble("soluong");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    
    
    public double TongSoDichVu(String dichvu) {
          
        double soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select sum("+dichvu+") as soluong from thongtinhoadon";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong = rs.getDouble("soluong");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    
    public double SoNuocTheoPhong(String maphong){
        double soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadon where maPhong='"+maphong+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong = rs.getFloat("soNuocMoi")-rs.getFloat("soNuocCu");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public double SoDienTheoPhong(String maphong){
        double soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtinhoadon where maPhong='"+maphong+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong = rs.getFloat("soDienMoi")-rs.getFloat("soDienCu");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
}
