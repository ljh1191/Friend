package friend;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

public class FriendDBAimpl implements FriendDBA {
	// ?λΉμ?
	String url, user, pwd;

	public FriendDBAimpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// μΉκ΅¬μΆκ?
	@Override // ?΄?Έ??΄? - μ»΄ν?Ό?¬?κ²? λΆ?λͺ¨μκ²? ?? ?¨??Έμ§? ?λ‘μ ? ?? ?¨??Έμ§? ?? €μ£ΌκΈ° ??΄ ???¨.
	public void friendInsert(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into friend values(friend_seq.nextval,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// μΉκ΅¬? μ²΄λ³΄κΈ?
	@Override
	public ArrayList<Friend> friendView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arr;
	}

	// μΉκ΅¬κ²??
	@Override
	public ArrayList<Friend> friendSearch(String key, String str) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend where " + key + " like '%" + str + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
	//??Έλ³΄κΈ°
	public Friend friendSelect(int num ) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Friend f = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend where num = "+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				f = new Friend();
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	//?? 
	public void friendUpdate(Friend f, int i) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update friend set name = ?,birth = ?,phone = ?,addr = ? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.setInt(5, i);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//?­? 
	public void friendDelete(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from friend where num ="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			try { 
				if (st != null) 
				st.close(); 
				if (con != null) 
				con.close(); 
				if (rs != null) 
					rs.close(); 
				} catch (SQLException e) { 
				e.printStackTrace(); 
				} 
				}
	}
}
