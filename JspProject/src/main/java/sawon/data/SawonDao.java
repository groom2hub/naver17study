package sawon.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class SawonDao {

    MysqlConnect connect = new MysqlConnect();

    public List<SawonDto> getAllDatas(String search) {
        List<SawonDto> list = new Vector<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = (search == null || search.equals("")) 
                ? "select * from sawon order by num"
                : "select * from sawon where sname like '%" + search + "%' order by num";

        conn = connect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                SawonDto dto = new SawonDto();
                dto.setNum(rs.getInt("num"));
                dto.setSname(rs.getString("sname"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setIpsaday(rs.getString("ipsaday"));
                dto.setSbirth(rs.getInt("sbirth"));
                dto.setSblood(rs.getString("sblood"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return list;
    }

    public void insertSawon(SawonDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into sawon (sname, sphoto, ipsaday, sbirth, sblood, writeday) values (?,?,?,?,?,now())";

        conn = connect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getSname());
            pstmt.setString(2, dto.getSphoto());
            pstmt.setString(3, dto.getIpsaday());
            pstmt.setInt(4, dto.getSbirth());
            pstmt.setString(5, dto.getSblood());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }

    public SawonDto getSawon(String num) {
        SawonDto dto = new SawonDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from sawon where num=?";

        conn = connect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setSname(rs.getString("sname"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setIpsaday(rs.getString("ipsaday"));
                dto.setSbirth(rs.getInt("sbirth"));
                dto.setSblood(rs.getString("sblood"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return dto;
    }

    public void deleteSawon(String num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from sawon where num=?";

        conn = connect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }

    public void updateSawon(SawonDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update sawon set sname=?, sphoto=?, ipsaday=?, sbirth=?, sblood=? where num=?";

        conn = connect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getSname());
            pstmt.setString(2, dto.getSphoto());
            pstmt.setString(3, dto.getIpsaday());
            pstmt.setInt(4, dto.getSbirth());
            pstmt.setString(5, dto.getSblood());
            pstmt.setInt(6, dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }
}
