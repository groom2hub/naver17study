package simpleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class SimpleBoardDao {

    private final MysqlConnect db = new MysqlConnect();

    public List<SimpleBoardDto> getAllDatas() {
        List<SimpleBoardDto> list = new Vector<>();
        String sql = "SELECT * FROM simpleboard ORDER BY num DESC";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                SimpleBoardDto dto = new SimpleBoardDto();
                dto.setNum(rs.getInt("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setReadcount(rs.getInt("readcount"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertBoard(SimpleBoardDto dto) {
        String sql = "INSERT INTO simpleboard (writer, subject, content, writeday) VALUES (?, ?, ?, NOW())";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SimpleBoardDto getData(int num) {
        SimpleBoardDto dto = new SimpleBoardDto();
        String sql = "SELECT * FROM simpleboard WHERE num = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    dto.setNum(rs.getInt("num"));
                    dto.setWriter(rs.getString("writer"));
                    dto.setSubject(rs.getString("subject"));
                    dto.setContent(rs.getString("content"));
                    dto.setReadcount(rs.getInt("readcount"));
                    dto.setWriteday(rs.getTimestamp("writeday"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public void updateReadCount(int num) {
        String sql = "UPDATE simpleboard SET readcount = readcount + 1 WHERE num = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBoard(int num) {
        String sql = "DELETE FROM simpleboard WHERE num = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBoard(SimpleBoardDto dto) {
        String sql = "UPDATE simpleboard SET writer = ?, subject = ?, content = ? WHERE num = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.setInt(4, dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 
