/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

/**
 *
 * @author user
 */
public class ReserveRecordBean {
    
    private int borrowID;
    private String equipname, borrowstatus, studname, techname, seniorname;
    private String application, borrow, returnTime, actual;

    public ReserveRecordBean() {
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public String getTechname() {
        return techname;
    }

    public void setTechname(String techname) {
        this.techname = techname;
    }

    public String getSeniorname() {
        return seniorname;
    }

    public void setSeniorname(String seniorname) {
        this.seniorname = seniorname;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public String getEquipname() {
        return equipname;
    }

    public void setEquipname(String equipname) {
        this.equipname = equipname;
    }

    public String getBorrowstatus() {
        return borrowstatus;
    }

    public void setBorrowstatus(String borrowstatus) {
        this.borrowstatus = borrowstatus;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getBorrow() {
        return borrow;
    }

    public void setBorrow(String borrow) {
        this.borrow = borrow;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }
    
    
    
    
}
