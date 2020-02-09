package com.sb.part1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection con;
    public static Connection connect()
    {
        // TODO Auto-generated method stub
        try{
           // Class.forName("com.mysql.jdbc.Driver");
        //    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Mobiledoc$12");
        //    System.out.println("db connection successful");
        }
        catch(Exception e)
        { System.out.println(e);
        }
        return con;
    }
}
