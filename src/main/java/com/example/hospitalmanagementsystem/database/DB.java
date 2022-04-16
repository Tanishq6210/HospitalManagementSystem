package com.example.hospitalmanagementsystem.database;

import com.example.hospitalmanagementsystem.model.Doctor;
import com.example.hospitalmanagementsystem.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DB {

    public static void register(){

    }

    public static void logOut(){
    }

    public static void insertPatient(int id, String firstName, String lastName, String gen, String ph_no, String add) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into patient(pat_id, pat_first_name, pat_last_name, pat_gen, pat_ph_no, pat_address) values ('"+id+"','"+ firstName +"','"+lastName+"','"+gen+"','"+ph_no+"', '"+add+"')";
            System.out.println("Inserted Successfully!");
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertDoctor(int id, String firstName, String lastName, String gen, String ph_no, String add) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into doctor(doc_id, doc_first_name, doc_last_name, doc_gen, doc_ph_no, doc_address) values ('"+id+"','"+ firstName +"','"+lastName+"','"+gen+"','"+ph_no+"', '"+add+"')";
            System.out.println("Inserted Successfully!");
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ObservableList<Patient> getPatients(){
        ObservableList<Patient> list = FXCollections.observableArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from patient");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int s1 = Integer.parseInt(rs.getString(1));
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                list.add(new Patient(s1, s2, s3, s4, s5, s6));
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Doctor> getDoctors(){
        ObservableList<Doctor> list = FXCollections.observableArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from doctor");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int s1 = Integer.parseInt(rs.getString(1));
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                list.add(new Doctor(s1, s2, s3, s4, s5, s6));
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
