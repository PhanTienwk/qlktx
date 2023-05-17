/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connector.KetNoiSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PhanTien
 */
public class DichVuDAO {
    
     public float GiaDichVu(String dichvu) {
        float soluong = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from thongtindichvu where dichVu='dichvu'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong= rs.getFloat(dichvu);
            }
            con.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    
}
