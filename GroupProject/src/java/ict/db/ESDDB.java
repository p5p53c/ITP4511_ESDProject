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
    
    public boolean addStudAC(String name, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO student (name, password) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setString(2, pwd);
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
    
    public boolean addTechAC(String name, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO technician (name, password) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setString(2, pwd);
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
    
    public boolean addSeniorAC(String name, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO senior (name, password) VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setString(2, pwd);
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
                sb.setName(rs.getString("name"));
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
                tb.setName(rs.getString("name"));
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
                sb.setName(rs.getString("name"));
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
            String preQueryStatement = "SELECT * FROM  student";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                StudentBean sb = new StudentBean();
                sb.setStudID(rs.getInt("studentID"));
                sb.setName(rs.getString("name"));
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
    
    public boolean isValidStud(int user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM student WHERE studentID =? and password =?";
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
    
    public boolean isValidTech(int user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM technician WHERE techID =? and password =?";
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
    
    public boolean isValidSenior(int user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isValid = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM senior WHERE seniorID =? and password =?";
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
                } catch (SQLException sqlEx) {
                }
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
}
