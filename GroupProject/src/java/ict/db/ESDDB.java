/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author p5p53
 */
public class ESDDB {
    
    private String url = "";
    private String username = "";
    private String password = "";

    public ESDDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    
    public boolean addStudAC(StudentBean sb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO student (studname, password, studStatus) VALUES (?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, sb.getName());
            pStmnt.setString(2, sb.getPwd());
            pStmnt.setString(3, "A");
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public int getStudID() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        int StudID = 0;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM student";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                // set the record detail to the customer bean
                StudID = rs.getInt("studentID");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return StudID;
    }
    
    public boolean addEquipmentRecord(String name, int qty, String status) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO equipment (equipname, qty , availableqty, equipstatus)VALUES (?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setInt(2, qty);
            pStmnt.setInt(3, qty);
            pStmnt.setString(4, status);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public boolean addTechAC(TechnicianBean tb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO technician (techname, password, techStatus) VALUES (?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, tb.getName());
            pStmnt.setString(2, tb.getPwd());
            pStmnt.setString(3, "A");
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public int getTechID() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        int TechID = 0;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM technician";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                // set the record detail to the customer bean
                TechID = rs.getInt("techID");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return TechID;
    }
    
    public boolean addSeniorAC(String name, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO senior (name, password, seniorStatus) VALUES (?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, "A");
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public StudentBean queryStudByID(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        StudentBean sb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM student WHERE studentID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                // set the record detail to the customer bean
                sb = new StudentBean();
                sb.setStudID(rs.getInt("studentID"));
                sb.setName(rs.getString("studname"));
                sb.setPwd(rs.getString("password"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb;
    }
    
    public TechnicianBean queryTechByID(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        TechnicianBean tb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM technician WHERE techID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                // set the record detail to the customer bean
                tb = new TechnicianBean();
                tb.setTechID(rs.getInt("techID"));
                tb.setName(rs.getString("techname"));
                tb.setPwd(rs.getString("password"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tb;
    }
    
    public StudentBean queryTechByIDreturnStudent(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        StudentBean sb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM technician WHERE techID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                // set the record detail to the customer bean
                sb = new StudentBean();
                sb.setStudID(rs.getInt("techID"));
                sb.setName(rs.getString("techname"));
                sb.setPwd(rs.getString("password"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb;
    }
    
    public SeniorBean querySeniorByID(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        SeniorBean sb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM senior WHERE seniorID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                // set the record detail to the customer bean
                sb = new SeniorBean();
                sb.setSeniorID(rs.getInt("seniorID"));
                sb.setName(rs.getString("seniorname"));
                sb.setPwd(rs.getString("password"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb;
    }
    
    public EquipmentBean queryEquipmentByID(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        EquipmentBean eb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM equipment WHERE equipmentID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                // set the record detail to the customer bean
                eb = new EquipmentBean();
                eb.setEquipmentID(rs.getInt("equipmentID"));
                eb.setName(rs.getString("equipname"));
                eb.setQty(rs.getInt("qty"));
                eb.setAvaqty(rs.getInt("availableqty"));
                eb.setStatus(rs.getString("equipstatus"));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return eb;
    }
    
    public ArrayList querystudEquipment() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM equipment WHERE equipstatus=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "A");
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                EquipmentBean eb = new EquipmentBean();
                eb.setEquipmentID(rs.getInt("equipmentID"));
                eb.setName(rs.getString("equipname"));
                eb.setQty(rs.getInt("qty"));
                eb.setAvaqty(rs.getInt("availableqty"));
                eb.setStatus(rs.getString("equipstatus"));
                list.add(eb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public ArrayList queryTechEquipment() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM equipment WHERE equipstatus<>?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "D");
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                EquipmentBean eb = new EquipmentBean();
                eb.setEquipmentID(rs.getInt("equipmentID"));
                eb.setName(rs.getString("equipname"));
                eb.setQty(rs.getInt("qty"));
                eb.setAvaqty(rs.getInt("availableqty"));
                eb.setStatus(rs.getString("equipstatus"));
                list.add(eb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public ArrayList queryStud() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  student WHERE studStatus<>'D'";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                StudentBean sb = new StudentBean();
                sb.setStudID(rs.getInt("studentID"));
                sb.setName(rs.getString("studname"));
                sb.setPwd(rs.getString("password"));
                list.add(sb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public ArrayList queryTech() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  technician WHERE techStatus<>'D' ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                TechnicianBean tb = new TechnicianBean();
                tb.setTechID(rs.getInt("techID"));
                tb.setName(rs.getString("techname"));
                tb.setPwd(rs.getString("password"));
                list.add(tb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public boolean isValidStud(int user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM student WHERE studentID =? and password =? AND studStatus=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, user);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, "A");
            pStmnt.executeQuery();
            ResultSet rs = pStmnt.getResultSet();
            if (rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
    
    public boolean isValidTech(int user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM technician WHERE techID =? and password =? AND techStatus=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, user);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, "A");
            pStmnt.executeQuery();
            ResultSet rs = pStmnt.getResultSet();
            if (rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
    
    public boolean isValidSenior(int user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM senior WHERE seniorID =? and password =? AND seniorStatus='A'";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, user);
            pStmnt.setString(2, pwd);
            pStmnt.executeQuery();
            ResultSet rs = pStmnt.getResultSet();
            if (rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
    
    public boolean addBorrowrecord(int equipID, int studID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO borrow (equipmentID, studentID, borrowstatus) VALUES (?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, equipID);
            pStmnt.setInt(2, studID);
            pStmnt.setString(3, "W");
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            preQueryStatement = "UPDATE equipment SET availableqty = availableqty - 1 WHERE equipmentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, equipID);
            rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public int getBorrowID(int studID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        int BorrowID = 0;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  borrow WHERE studentID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setInt(1, studID);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                // set the record detail to the customer bean
                BorrowID = rs.getInt("borrowID");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return BorrowID;
    }
    
    public ArrayList queryStudRecord(int studID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT *\n" +
                                        "FROM equipment, borrow\n" +
                                        "WHERE equipment.equipmentID = borrow.equipmentID AND borrow.studentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, studID);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setEquipname(rs.getString("equipname"));
                rrb.setBorrowstatus(rs.getString("borrowstatus"));
                rrb.setApplication(rs.getString("applicationTime"));
                rrb.setBorrow(rs.getString("borrowTime"));
                rrb.setReturnTime(rs.getString("returnTime"));
                rrb.setActual(rs.getString("actualreturnTime"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public int editEquip(EquipmentBean eb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE equipment SET equipname=? ,qty=? ,equipstatus=? WHERE equipmentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, eb.getName());
            pStmnt.setInt(2, eb.getQty());
            pStmnt.setString(3, eb.getStatus());
            pStmnt.setInt(4, eb.getEquipmentID());
            //Statement s = cnnct.createStatement();
            int rs = pStmnt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) { }
            }
        }
        return 0;
    }
    
    public int delEquip(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE equipment SET equipstatus=? WHERE equipmentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "D");
            pStmnt.setInt(2, id);
            int rs = pStmnt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return 0;
    }
    
    public ArrayList queryTechRecord() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT *\n" +
                                        "FROM equipment, borrow, student\n" +
                                        "WHERE student.studentID = borrow.studentID AND equipment.equipmentID = borrow.equipmentID AND borrow.borrowstatus=\"W\"";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setEquipname(rs.getString("equipname"));
                rrb.setBorrowstatus(rs.getString("borrowstatus"));
                rrb.setApplication(rs.getString("applicationTime"));
                rrb.setStudname(rs.getString("studname"));
                rrb.setBorrowID(rs.getInt("borrowID"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public void borrowrequest(int borrowID, int techId, String borrowdate, String returndate) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE borrow SET borrowstatus=?,  techID=?, borrowTime=?, returnTime=? WHERE borrowID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "A");
            pStmnt.setInt(2, techId);
            pStmnt.setString(3, borrowdate);
            pStmnt.setString(4, returndate);
            pStmnt.setInt(5, borrowID);
            pStmnt.executeUpdate();
        }catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return;
    }
    
    public void borrowrequest(int borrowID, int techId) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE borrow SET borrowstatus=?,  techID=? WHERE borrowID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "R");
            pStmnt.setInt(2, techId);
            pStmnt.setInt(3, borrowID);
            pStmnt.executeUpdate();
        }catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return;
    }
    
    public int checkStudDue(int studID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        int due = 0;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * \n" +
                                        "FROM borrow \n" +
                                        "WHERE actualreturnTime IS NULL AND returnTime < NOW() AND studentID=?;";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, studID);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                due++;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return due;
    }
    
    public int checkTechDue() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        int due = 0;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * \n" +
                                        "FROM borrow \n" +
                                        "WHERE actualreturnTime IS NULL AND returnTime < NOW();";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                due++;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return due;
    }
    
    public ArrayList queryTechDue() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * \n" +
                                        "FROM borrow, student, equipment \n" +
                                        "WHERE student.studentID = borrow.studentID AND equipment.equipmentID = borrow.equipmentID AND actualreturnTime IS NULL AND returnTime < NOW();";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setEquipname(rs.getString("equipname"));
                rrb.setBorrow(rs.getString("borrowTime"));
                rrb.setReturnTime(rs.getString("returnTime"));
                rrb.setStudname(rs.getString("studname"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public ArrayList queryborrow() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT *\n" +
                                        "FROM borrow, equipment, student, technician\n" +
                                        "WHERE student.studentID = borrow.studentID AND equipment.equipmentID = borrow.equipmentID AND technician.techID = borrow.techID";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setEquipname(rs.getString("equipname"));
                rrb.setBorrowstatus(rs.getString("borrowstatus"));
                rrb.setApplication(rs.getString("applicationTime"));
                rrb.setStudname(rs.getString("studname"));
                rrb.setActual(rs.getString("actualreturnTime"));
                rrb.setReturnTime(rs.getString("returnTime"));
                rrb.setTechname(rs.getString("techname"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public void editStud(StudentBean sb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE student SET studname=? ,password=? WHERE studentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, sb.getName());
            pStmnt.setString(2, sb.getPwd());
            pStmnt.setInt(3, sb.getStudID());
            //Statement s = cnnct.createStatement();
            pStmnt.executeUpdate();
            return;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) { }
            }
        }
        return;
    }
    
    public void editTech(TechnicianBean tb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE technician SET techname=? ,password=? WHERE techID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, tb.getName());
            pStmnt.setString(2, tb.getPwd());
            pStmnt.setInt(3, tb.getTechID());
            //Statement s = cnnct.createStatement();
            pStmnt.executeUpdate();
            return;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) { }
            }
        }
        return;
    }
    
    public void delStud(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE student SET studStatus=? WHERE studentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "D");
            pStmnt.setInt(2, id);
            //Statement s = cnnct.createStatement();
            pStmnt.executeUpdate();
            return;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) { }
            }
        }
        return;
    }
    
    public void delTech(int id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE technician SET techStatus=? WHERE techID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "D");
            pStmnt.setInt(2, id);
            //Statement s = cnnct.createStatement();
            pStmnt.executeUpdate();
            return;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) { }
            }
        }
        return;
    }
    
    public ArrayList queryReturnList() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * \n" +
                                        "FROM borrow, student, equipment \n" +
                                        "WHERE student.studentID = borrow.studentID AND equipment.equipmentID = borrow.equipmentID AND actualreturnTime IS NULL AND borrowstatus = 'A';";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setBorrowID(rs.getInt("borrowID"));
                rrb.setEquipname(rs.getString("equipname"));
                rrb.setBorrow(rs.getString("borrowTime"));
                rrb.setReturnTime(rs.getString("returnTime"));
                rrb.setStudname(rs.getString("studname"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public void techReturnEquip(int id, String returndate) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE borrow SET actualreturnTime=? WHERE borrowID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, returndate);
            pStmnt.setInt(2, id);
            pStmnt.executeUpdate();
            preQueryStatement = "UPDATE equipment SET availableqty = availableqty + 1 WHERE equipmentID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, id);
            pStmnt.executeUpdate();
        }catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return;
    }
    
    public ArrayList<ReserveRecordBean> querySelectMonth(int month, int year) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT equipment.equipname, COUNT(borrow.equipmentID) AS count\n" +
                                        "FROM borrow, equipment\n" +
                                        "WHERE borrow.borrowstatus = 'A' AND MONTH(borrow.applicationTime)=? AND YEAR(borrow.applicationTime)=? AND borrow.equipmentID = equipment.equipmentID\n" +
                                        "GROUP BY borrow.equipmentID";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, month);
            pStmnt.setInt(2, year);
            ResultSet rs = pStmnt.executeQuery();
            ArrayList list = new ArrayList();
            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setEquipname("equipname");
                rrb.setCount(rs.getInt("count"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public ArrayList<ReserveRecordBean> querySelectYear(int year) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT equipname, COUNT(equipmentID) AS count\n" +
                                        "FROM borrow, equipment\n" +
                                        "WHERE borrow.borrowstatus = 'A' AND YEAR(borrow.applicationTime)=? AND borrow.equipmentID = equipment.equipmentID\n" +
                                        "GROUP BY equipmentID";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, year);
            ResultSet rs = pStmnt.executeQuery();
            ArrayList list = new ArrayList();
            while (rs.next()) {
                ReserveRecordBean rrb = new ReserveRecordBean();
                rrb.setEquipname("equipname");
                rrb.setCount(rs.getInt("count"));
                list.add(rrb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
}
