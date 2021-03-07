package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	private List<Alien> aliens;
	private Connection con = null;

	public AlienRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/restdb?serverTimezone=UTC";
			con = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Alien> getAliens() {
		try {
			aliens = new ArrayList<Alien>();
			Statement st = con.createStatement();
			String sql = "select * from alien1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setPoints(rs.getInt(2));
				alien.setName(rs.getString(3));
				System.out.println(alien);
				aliens.add(alien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aliens;
	}

	public Alien getAlien(int id) {
		try {
			aliens = new ArrayList<Alien>();
			Statement st;

			st = con.createStatement();

			String sql = "select * from alien where id=" + id;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setPoints(rs.getInt(3));
				return alien;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Alien();
	}

	public void create(Alien alien) {
		try {
			String sql = "insert into alien values (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, alien.getId());
			st.setString(2, alien.getName());
			st.setInt(3, alien.getPoints());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
