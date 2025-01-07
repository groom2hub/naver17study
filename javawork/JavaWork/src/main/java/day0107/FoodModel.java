package day0107;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class FoodModel {
	MysqlConnect mysqlConnect = new MysqlConnect();

	public void foodMenuInsert(String foodName, int foodPrice, String foodSize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into foodrest (foodname,foodprice,foodsize) values (?,?,?)";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
			pstmt.setInt(2, foodPrice);
			pstmt.setString(3, foodSize);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	public List<Vector<String>> getAllMenus() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from foodrest order by num";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));

				list.add(data);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	public void foodOrderInsert(FoodOrderDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into foodorder (num,ordername,ordercnt,bookingday) values (?,?,?,?)";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getOrderName());
			pstmt.setInt(3, dto.getOrderCnt());
			pstmt.setString(4, dto.getBookingDay());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	public List<Vector<String>> getAllOrders() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = """
				select 
				   idx,ordername,foodname,foodprice,
				   foodsize,ordercnt,bookingday
				 from foodrest fr,foodorder fo
				 where fr.num=fo.num
				""";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("ordername"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				data.add(rs.getString("ordercnt"));
				data.add(rs.getString("bookingday"));

				list.add(data);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	public void deleteFoodMenu(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from foodrest where num=?";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	public void deleteOrder(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from foodorder where idx=?";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	public int getOrderMenuCount(int num) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) count from foodorder where num=?";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cnt=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		
		return cnt;
	}
}
