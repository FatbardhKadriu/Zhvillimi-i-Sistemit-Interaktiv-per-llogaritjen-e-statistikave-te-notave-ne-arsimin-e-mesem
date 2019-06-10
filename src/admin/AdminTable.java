package admin;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminTable {

	private static DBConnection database = new DBConnection();
	private static Connection connection = database.getConnection();
	private int id;
	private String name;
	private String surname;
	private String phone;

	public AdminTable(int id, String name, String surname, String phone) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getPhone() {
		return this.phone;
	}

	public static boolean addStudents(int id, String name, String surname, String phone) {
		String query = "INSERT INTO students(id, name, surname, phone) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, surname);
			preparedStatement.setString(4, phone);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateStudents(int id, String name, String surname, String phone) {
		String query = "UPDATE students SET name=?, surname=?, phone=? WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, phone);
			preparedStatement.setInt(4, id);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteStudents(int id) {
		String query = "Delete from students where id=?";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<AdminTable> getStudents() {
		List<AdminTable> studentList = new ArrayList();

		String query = "Select * from students";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				AdminTable students = new AdminTable(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4));
				studentList.add(students);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return studentList;
	}
}