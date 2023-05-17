package dao;

import Connector.KetNoiSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ThongTinNhanVien;

public class QuanLyNhanVienDAO {

    public List<ThongTinNhanVien> getAllThongTinNV() {
        List<ThongTinNhanVien> listNhanVien = new ArrayList<ThongTinNhanVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinNhanVien sv = new ThongTinNhanVien();
                sv.setMaNV(rs.getString("maNV"));
                sv.setTenNV(rs.getString("tenNV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setChucVu(rs.getString("chucVu"));
                listNhanVien.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    public List<ThongTinNhanVien> getAllThongTinNVSearch(String where, String text) {
        List<ThongTinNhanVien> listNhanVien = new ArrayList<ThongTinNhanVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where " + where + " like N'%" + text + "%'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinNhanVien sv = new ThongTinNhanVien();
                sv.setMaNV(rs.getString("maNV"));
                sv.setTenNV(rs.getString("tenNV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setChucVu(rs.getString("chucVu"));
                listNhanVien.add(sv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }
    
    public ThongTinNhanVien getAllThongTinNVTheoTenDN(String tendn) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where tenDangNhap='" + tendn + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               sv.setMaNV(rs.getString("maNV"));
                sv.setTenNV(rs.getString("tenNV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setChucVu(rs.getString("chucVu"));
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sv;
    }

    public boolean KiemTraMaSoSV(String masv) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where maNV ='" + masv + "'";
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
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where CCCD ='" + cccd + "'";
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
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where email ='" + email + "'";
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
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where soDienThoai ='" + sodienthoai + "'";
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
        String sql = "select * from thongtinnhanvien where tenDangNhap ='" + tendangnhap + "'";
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

    public ThongTinNhanVien getAllThongTinNVTheoemail(String email) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where email ='" + email + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sv.setMaNV(rs.getString("maNV"));
                sv.setTenNV(rs.getString("tenNV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setTenDangNhap(rs.getString("tenDangNhap"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setChucVu(rs.getString("chucVu"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }

    
    public boolean UpKiemTraEmailSV(String email,String test) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where email ='" + email + "'";
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
    
    public boolean UpKiemTraMaSoSV(String masv, String test) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where maNV='" + masv + "'";
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
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where CCCD ='" + cccd + "'";
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

    public boolean UpKiemTraSDTSV(String sodienthoai,String test) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinnhanvien where soDienThoai ='" + sodienthoai + "'";
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
