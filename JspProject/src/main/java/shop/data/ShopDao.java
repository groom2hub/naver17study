package shop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class ShopDao {
    MysqlConnect db = new MysqlConnect();
    
    public void insertShop(ShopDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO shop (sangpum, scolor, scnt, sprice, sphoto, ipgoday, writeday) VALUES (?, ?, ?, ?, ?, ?, NOW())";
        
        conn = db.getNaverCloudConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getSangpum());
            pstmt.setString(2, dto.getScolor());
            pstmt.setInt(3, dto.getScnt());
            pstmt.setInt(4, dto.getSprice());
            pstmt.setString(5, dto.getSphoto());
            pstmt.setString(6, dto.getIpgoday());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }
    
    public List<ShopDto> getAllSangpums(int order) {
        List<ShopDto> list = new Vector<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = getOrderSQL(order);
        
        conn = db.getNaverCloudConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ShopDto dto = new ShopDto();
                dto.setNum(rs.getInt("num"));
                dto.setSangpum(rs.getString("sangpum"));
                dto.setScolor(rs.getString("scolor"));
                dto.setScnt(rs.getInt("scnt"));
                dto.setSprice(rs.getInt("sprice"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setIpgoday(rs.getString("ipgoday"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    public ShopDto getSangpum(int num) {
        ShopDto dto = new ShopDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM shop WHERE num=?";
        
        conn = db.getNaverCloudConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setSangpum(rs.getString("sangpum"));
                dto.setScolor(rs.getString("scolor"));
                dto.setScnt(rs.getInt("scnt"));
                dto.setSprice(rs.getInt("sprice"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setIpgoday(rs.getString("ipgoday"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;
    }

    public void deleteShop(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM shop WHERE num=?";
        
        conn = db.getNaverCloudConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    public void updateShop(ShopDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE shop SET sangpum=?, scolor=?, scnt=?, sprice=?, sphoto=?, ipgoday=? WHERE num=?";
        
        conn = db.getNaverCloudConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getSangpum());
            pstmt.setString(2, dto.getScolor());
            pstmt.setInt(3, dto.getScnt());
            pstmt.setInt(4, dto.getSprice());
            pstmt.setString(5, dto.getSphoto());
            pstmt.setString(6, dto.getIpgoday());
            pstmt.setInt(7, dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }
    
    private String getOrderSQL(int order) {
        switch (order) {
            case 1:
                return "SELECT * FROM shop ORDER BY num";
            case 2:
                return "SELECT * FROM shop ORDER BY sprice DESC";
            case 3:
                return "SELECT * FROM shop ORDER BY sprice ASC";
            case 4:
                return "SELECT * FROM shop ORDER BY sangpum ASC";
            default:
                return "SELECT * FROM shop ORDER BY num";
        }
    }
}
