package dao;

import Connector.KetNoiSQL;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThongTinSinhVien;
import model.ThongTinSinhVienDangKy;

/**
 *
 * @author PhanTien
 */
public class SinhVienDangKyDAO {

    private Connection conn;

    public SinhVienDangKyDAO() {
        
    }

    public List<ThongTinSinhVienDangKy> getAllThongTinSinhVienDangKy() {
        List<ThongTinSinhVienDangKy> listSinhVien = new ArrayList<ThongTinSinhVienDangKy>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVienDangKy sv = new ThongTinSinhVienDangKy();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                listSinhVien.add(sv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSinhVien;
    }

    public boolean KiemTraMaSoSV(String masv) {
        ThongTinSinhVienDangKy sv = new ThongTinSinhVienDangKy();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where maSV ='" + masv + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

     public int SoLuongSVDK() {
        int soluongsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from thongtinsinhviendangky";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluongsv = rs.getInt("soluongSV");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluongsv;
    }
    
    public boolean KiemTraCCCDSV(String cccd) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where CCCD ='" + cccd + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public ThongTinSinhVienDangKy getAllThongTinSVTheoTenDN(String tendn) {
        ThongTinSinhVienDangKy sv = new ThongTinSinhVienDangKy();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where tenDangNhap='" + tendn + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sv;
    }

    public boolean KiemTraEmailSV(String email) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where email ='" + email + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean KiemTraSDTSV(String sodienthoai) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where soDienThoai ='" + sodienthoai + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public String LayThongTinLoaiPhong(String tendangnhap) {
        String loaiphong = null;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where tenDangNhap ='" + tendangnhap + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                 loaiphong = rs.getString("loaiPhong");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiphong;
    }

    
    public String LayThongTinGioiTinh(String tendangnhap) {
        String gioitinh=null;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where tenDangNhap ='" + tendangnhap + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                 gioitinh = rs.getString("gioiTinh");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gioitinh;
    }
    
    public List<ThongTinSinhVienDangKy> getAllThongTinSVSearch(String where, String text) {
        List<ThongTinSinhVienDangKy> listSinhVien = new ArrayList<ThongTinSinhVienDangKy>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where " + where + " like N'%" + text + "%'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVienDangKy sv = new ThongTinSinhVienDangKy();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                listSinhVien.add(sv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSinhVien;
    }
    
    
     public ThongTinSinhVienDangKy getAllThongTinSVTheoemail(String email) {
        ThongTinSinhVienDangKy sv = new ThongTinSinhVienDangKy();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where email ='" + email + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sv;
    }
     
     
     
      public boolean UpKiemTraMaSoSV(String masv, String test) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where maSV ='" + masv + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (!test.equals(masv)) {
                    return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean UpKiemTraCCCDSV(String cccd,String test) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where CCCD ='" + cccd + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                 if (!test.equals(cccd)) {
                    return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean UpKiemTraEmailSV(String email,String test) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where email ='" + email + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                 if (!test.equals(email)) {
                    return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean UpKiemTraSDTSV(String sodienthoai,String test) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhviendangky where soDienThoai ='" + sodienthoai + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (!test.equals(sodienthoai)) {
                    return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    
    public int SoLuongDKTheoLoaiPhong(String loaiphong){
        int soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluong from thongtinsinhviendangky where loaiPhong='"+loaiphong+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong = rs.getInt("soluong");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }
}
