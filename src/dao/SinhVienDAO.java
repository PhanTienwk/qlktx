package dao;

import Connector.KetNoiSQL;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.ThongTinSinhVien;

public class SinhVienDAO {

    private Connection conn;

    public SinhVienDAO() {
    }

    public List<ThongTinSinhVien> getAllThongTinSV() {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setMaPhong(rs.getString("maPhong"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                listSinhVien.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSinhVien;
    }

    public List<ThongTinSinhVien> getAllThongTinSVTheoPhong(String maPhong) {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where maPhong='" + maPhong + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setMaPhong(rs.getString("maPhong"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                listSinhVien.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSinhVien;
    }

    public List<ThongTinSinhVien> getAllThongTinSVSearch(String where, String text) {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where " + where + " like N'%" + text + "%'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setMaPhong(rs.getString("maPhong"));
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

    public ThongTinSinhVien getAllThongTinSVTheoemail(String email) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where email ='" + email + "'";
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
                sv.setMaPhong(rs.getString("maPhong"));
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

    public ThongTinSinhVien getAllThongTinSVTheoTenDN(String tendn) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where tenDangNhap='" + tendn + "'";
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
                sv.setMaPhong(rs.getString("maPhong"));
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

    public boolean KiemTraMaSoSV(String masv) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where maSV ='" + masv + "'";
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

    public boolean KiemTraCCCDSV(String cccd) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where CCCD ='" + cccd + "'";
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

    public boolean KiemTraEmailSV(String email) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where email ='" + email + "'";
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
        String sql = "select * from thongtinsinhvien where soDienThoai ='" + sodienthoai + "'";
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

    public boolean KiemTraTenDN(String tendangnhap) {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where tenDangNhap ='" + tendangnhap + "'";
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

    public int SoLuongSVTheoGioiTinh(String gioitinh) {
        int soluongsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from thongtinsinhvien where gioiTinh='" + gioitinh + "'";
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

    public int SoLuongSVKTX() {
        int soluongsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from thongtinsinhvien";
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

    public boolean UpKiemTraMaSoSV(String masv, String test) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinsinhvien where maSV ='" + masv + "'";
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
        String sql = "select * from thongtinsinhvien where CCCD ='" + cccd + "'";
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
        String sql = "select * from thongtinsinhvien where email ='" + email + "'";
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
        String sql = "select * from thongtinsinhvien where soDienThoai ='" + sodienthoai + "'";
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


    
}
