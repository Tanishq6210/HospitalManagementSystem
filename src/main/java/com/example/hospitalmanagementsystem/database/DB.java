package com.example.hospitalmanagementsystem.database;

import com.example.hospitalmanagementsystem.model.Appointment;
import com.example.hospitalmanagementsystem.model.Doctor;
import com.example.hospitalmanagementsystem.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.sql.*;

public class DB {

    public static void showMessage(String content, Alert.AlertType type) {
        Alert alert = new Alert(type, content, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    public static void register(String user, String pwd){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into user(username, password) values ('"+user+"','"+ pwd +"')";
            showMessage("Inserted Successfully", Alert.AlertType.NONE);
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean isUser(String user, String pwd) {
        boolean userFound = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from user where username=('"+user+"') and password='"+pwd+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                userFound = true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return userFound;
    }

    public static void logOut(){
    }

    public static void insertPatient(int id, String firstName, String lastName, String gen, String ph_no, String add) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into patient(pat_id, pat_first_name, pat_last_name, pat_gen, pat_ph_no, pat_address) values ('"+id+"','"+ firstName +"','"+lastName+"','"+gen+"','"+ph_no+"', '"+add+"')";
            showMessage("Inserted Successfully", Alert.AlertType.NONE);
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
            showMessage("Inserted Successfully", Alert.AlertType.NONE);
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

    public static Patient getPatient(int id) {
        Patient patient = new Patient();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from patient where pat_id =('"+id+"');");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int s1 = Integer.parseInt(rs.getString(1));
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                patient.setId(s1);
                patient.setFirstName(s2);
                patient.setLastName(s3);
                patient.setGender(s4);
                patient.setPhone_no(s5);
                patient.setAddress(s6);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    public static void deletePatient(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "delete from patient where pat_id=('"+id+"')";
            showMessage("Deleted Successfully", Alert.AlertType.NONE);
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updatePatient(Patient patient) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "update patient set pat_first_name=('"+patient.getFirstName()+"') , " +
                    "pat_last_name=('"+patient.getLastName()+"'), " +
                    "pat_ph_no=('"+patient.getPhone_no()+"')," +
                    "pat_gen=('"+patient.getGender()+"')," +
                    "pat_address=('"+patient.getAddress()+"')" +
                    "where pat_id=('"+patient.getId()+"')";
            System.out.println(patient.getGender());
            showMessage("Updated Successfully", Alert.AlertType.NONE);
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Doctor getDoctor(int id) {
        Doctor doctor = new Doctor();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from doctor where doc_id =('"+id+"');");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int s1 = Integer.parseInt(rs.getString(1));
                String s2 = rs.getString(2);
                String  s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                doctor.setId(s1);
                doctor.setFirstName(s2);
                doctor.setLastName(s3);
                doctor.setGender(s4);
                doctor.setPhone_no(s5);
                doctor.setAddress(s6);
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public static void deleteDoctor(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "delete from doctor where doc_id=('"+id+"')";
            showMessage("Deleted Successfully", Alert.AlertType.NONE);
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateDoctor(Doctor doctor) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "update doctor set doc_first_name=('"+doctor.getFirstName()+"') , " +
                    "doc_last_name=('"+doctor.getLastName()+"'), " +
                    "doc_ph_no=('"+doctor.getPhone_no()+"')," +
                    "doc_gen=('"+doctor.getGender()+"')," +
                    "doc_address=('"+doctor.getAddress()+"')" +
                    "where doc_id=('"+doctor.getId()+"')";
            System.out.println(doctor.getGender());
            showMessage("Updated Successfully", Alert.AlertType.NONE);
            statement.execute(insertS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ObservableList<Patient> searchInPatient(String name) {
        ObservableList<Patient> list = FXCollections.observableArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from patient where pat_first_name=('"+name+"')");
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

    public static ObservableList<Doctor> searchInDoctor(String name) {
        ObservableList<Doctor> list = FXCollections.observableArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select * from doctor where doc_first_name=('"+name+"')");
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

    public static int getCountPatient() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS recordCount FROM patient");
            r.next();
            count = r.getInt("recordCount");
            r.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCountDoctor() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS recordCount FROM doctor");
            r.next();
            count = r.getInt("recordCount");
            r.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCountAppointment() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS recordCount FROM patient natural join (appointment natural join doctor)");
            r.next();
            count = r.getInt("recordCount");
            r.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void bookAppointment(int pat_id, int doc_id, Date date) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            Statement statement = con.createStatement();
            String insertS = "insert into appointment(pat_id, doc_id, app_date) values ('"+pat_id+"','"+doc_id+"', '"+date+"')";
            showMessage("Appointment Booked", Alert.AlertType.NONE);
            statement.execute(insertS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Appointment> getAppointments() {
        ObservableList<Appointment> list = FXCollections.observableArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select pat_id, pat_first_name, doc_id, doc_first_name, app_date from patient natural join (appointment natural join doctor)");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                int  s3 = rs.getInt(3);
                String s4 = rs.getString(4);
                Date s5 = rs.getDate(5);
                list.add(new Appointment(s1, s2, s3, s4, s5));
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Appointment> searchInAppointment(String name) {
        ObservableList<Appointment> list = FXCollections.observableArrayList();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            PreparedStatement statement = con.prepareStatement("select pat_id, pat_first_name, doc_id, doc_first_name, app_date from patient  natural join (doctor natural join appointment)where pat_first_name=('"+name+"')");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int s1 = rs.getInt(1);
                String s2 = rs.getString(2);
                int  s3 = rs.getInt(3);
                String s4 = rs.getString(4);
                Date s5 = rs.getDate(5);
                list.add(new Appointment(s1, s2, s3, s4, s5));
                System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}