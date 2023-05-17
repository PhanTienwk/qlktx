package dao;

import Connector.KetNoiSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ThongTinPhong;

public class PhongDAO {

    public PhongDAO() {

    }

    public List<ThongTinPhong> getAllThongTinPhong() {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

    public List<ThongTinPhong> getAllThongTinPhongSearch(String where, String text) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where " + where + " like N'%" + text + "%'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

    public int SoLuongSV(String maPhong) {
        int soluongsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from thongtinsinhvien where maPhong='" + maPhong + "'";
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
    
    
     public int SoLuongPhong() {
        int soluongsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from thongtinphong";
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

    public int SoLuongSVPhong(String maPhong) {
        int soluongsv = 0;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where maPhong ='" + maPhong + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluongsv = rs.getInt("soLuongSVPhong");
            }
            conn.close();
        } catch (Exception e) {
        }
        return soluongsv;
    }

    public double TienPhong(String maph) {
        double tienphong = 0;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where maPhong ='" + maph + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tienphong = rs.getDouble("tienPhong");
            }
            conn.close();
        } catch (Exception e) {
        }
        return tienphong;
    }

    public boolean KiemTraMaSoPhong(String maphong) {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where maPhong ='" + maphong + "'";
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

    public List<ThongTinPhong> getAllThongTinPhongDK(String gioitinh, String loaiphong) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where gioitinh='" + gioitinh + "' and loaiphong='" + loaiphong + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

    public List<ThongTinPhong> getAllThongTinPhongGioiTinh(String gioitinh) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where gioitinh='" + gioitinh + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }
    
    
    public List<ThongTinPhong> getAllThongTinPhongGioiTinhLoaiPhong(String gioitinh,String loaiphong) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtinphong where gioiTinh='" + gioitinh + "' and loaiPhong='" + loaiphong + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }
    
    public int SoLuongPhongTheoGioiTinh(String gioitinh) {
        int soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from thongtinphong where gioiTinh='"+gioitinh+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong = rs.getInt("soluongSV");
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }

}
