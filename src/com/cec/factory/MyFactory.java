package com.cec.factory; 
 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.ResourceBundle; 
 
public class MyFactory { 
 
 private static ResourceBundle bundle=null; 
 private static String url=null; 
 private static String username=null; 
 private static String password=null; 
 private static Connection conn=null; 
 
 static { 
  bundle = ResourceBundle.getBundle("com.cec.utilities.mysqlinfo"); 
  url = bundle.getString("url"); 
  username = bundle.getString("username"); 
  password = bundle.getString("password"); 
 } 
  
 public static Connection getMyConnection() 
 { 
  try { 
   conn = DriverManager.getConnection(url, username, 
password); 
  } catch (SQLException e) { 
   // TODO Auto-generated catch block 
   e.printStackTrace(); 
  } 
  return conn; 
 } 
 
} 