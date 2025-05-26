package com.harsh.registration;


import com.harsh.registration.model.Student;
import com.harsh.registration.db.DBConnection;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student student) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO students (name, email, department) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getDepartment());
        ps.executeUpdate();
        conn.close();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM students";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Student s = new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department")
            );
            list.add(s);
        }
        conn.close();
        return list;
    }
}
