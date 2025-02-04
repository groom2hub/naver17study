package shop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class ShopDao {
    private MysqlConnect db = new MysqlConnect();

    public void insertShop(ShopDto dto) {
        String sql = "INSERT INTO shop (sangpum, scolor, scnt, sprice, sphoto, ipgoday, writeday) VALUES (?, ?, ?, ?, ?, ?, NOW())";
        try (Connection conn = db.getNaverCloudConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, dto.getSangpum());
            pstmt.setString(2, dto.getScolor());
            pstmt.setInt(3, dto.getScnt());
            pstmt.setInt(4, dto.getSprice());
            pstmt.setString(5, dto.getSphoto());
            pstmt.setString(6, dto.getIpgoday());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ShopDto> getAllSangpums(int order) {
        List<ShopDto> list = new Vector<>();
        String sql = getOrderQuery(order);

        try (Connection conn = db.getNaverCloudConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

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
        }
        return list;
    }

    private String getOrderQuery(int order) {
        return switch (order) {
            case 2 -> "SELECT * FROM shop ORDER BY sprice DESC";
            case 3 -> "SELECT * FROM shop ORDER BY sprice ASC";
            case 4 -> "SELECT * FROM shop ORDER BY sangpum ASC";
            default -> "SELECT * FROM shop ORDER BY num";
        };
    }
}
