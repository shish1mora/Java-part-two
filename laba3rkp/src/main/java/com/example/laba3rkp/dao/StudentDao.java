package com.example.laba3rkp.dao;

import com.example.laba3rkp.MainApplication;
import com.example.laba3rkp.domains.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentDao implements Dao<Student, Long> {

    private final static String FIND_ALL = "SELECT * FROM students";
    private final static String SAVE = "INSERT INTO students (surname, name, patronym, city, age,  groupp) VALUES (?, ?, ?, ?, ?, ?)";
    private final static String DELETE = "DELETE FROM students WHERE surname=? AND name=? AND patronym=? AND city=? AND age=? AND groupp=?";
    private final static String FIND_BY_SURNAME = "SELECT * FROM students WHERE surname=?";
    private final static String UPDATE = "UPDATE student SET surname=?, name=?, patronym=?, city=?, age=?, groupp=? WHERE ";
    @Override
    public Student findById(Long id) {
        throw new UnsupportedOperationException("Метод еще не готов((");
    }
    public List<Student> findBySurname(String surname){
        List <Student> list = null;
        ResultSet rs = null;
        try(PreparedStatement statement = MainApplication.getConnection().prepareStatement(FIND_ALL)){
            statement.setString(1, surname);
            rs = statement.executeQuery();
            list = mapper(rs);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return list;
    }
    protected List<Student> mapper(ResultSet rs) {
        List<Student> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Student(
                        rs.getString("surname"),
                        rs.getString("name"),
                        rs.getString("patronym"),
                        rs.getInt("age"),
                        rs.getString("city"),
                        rs.getString("groupp")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }



    @Override
    public List<Student> findAll() {
        List <Student> list = null;
        ResultSet rs = null;
        try(PreparedStatement statement = MainApplication.getConnection().prepareStatement(FIND_ALL)){
            rs = statement.executeQuery();
            list = mapper(rs);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public Student save(Student student) {

        try(PreparedStatement statement = MainApplication.getConnection().prepareStatement(SAVE)){
            statement.setString(1, student.getSurname());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPatronym());
            statement.setString(4, student.getSity());
            statement.setInt(5, student.getAge());
            statement.setString(6, student.getGroup());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return student;
    }

    @Override
    public Student update(Student student) {
        try(PreparedStatement statement = MainApplication.getConnection().prepareStatement(UPDATE)){
            statement.setString(1, student.getSurname());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPatronym());
            statement.setString(4, student.getSity());
            statement.setInt(5, student.getAge());
            statement.setString(6, student.getGroup());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public void delete(Student student) {
        try(PreparedStatement statement = MainApplication.getConnection().prepareStatement(DELETE)){
        statement.setString(1, student.getSurname());
        statement.setString(2, student.getName());
        statement.setString(3, student.getPatronym());
        statement.setString(4, student.getSity());
        statement.setInt(5, student.getAge());
        statement.setString(6, student.getGroup());
        statement.execute();
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Метод еще не готов((");
    }
}
