/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.db.ESDDB;

/**
 *
 * @author p5p53
 */
public class TestLogin {
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/esd";
        String username = "root";
        String password = "";
        ESDDB db = new ESDDB(url, username, password);
        Boolean Valid = db.isValidStud(1000000, "12345678");
        System.out.println(Valid);
    }
}
