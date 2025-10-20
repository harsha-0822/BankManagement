package com.cec.driverclass; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.Scanner; 
 
import com.cec.factory.MyFactory; 
 
public class Main { 
 
 private static Scanner scan = null; 
 private static Connection conn = null; 
 private static Statement stmnt = null; 
 private static ResultSet res; 
 private static PreparedStatement pstmnt; 
 public static void main(String[] args) { 
  System.out.println("Select The Operation :"); 
  System.out.println(" 1. Select \n 2. Insert \n 3. Update \n 4. Delete \n 5. Exit \n "); 
  scan = new Scanner(System.in); 
  switch (scan.nextInt()) { 
  case 1: 
   Display(); 
   main(args); 
   break; 
 
  case 2: 
   InsertRecord(); 
   main(args); 
   break; 
 
  case 3: 
   UpdateRecord(); 
   main(args); 
   break; 
 
  case 4: 
   DeleteRecord(); 
   main(args); 
   break; 
    
  case 5: 
    System.exit(0); 
     
  default: 
    System.out.println("Please Enter a Valid Input"); 
    main(args); 
  } 
 
 } 
 
 private static void DeleteRecord() { 
  conn = MyFactory.getMyConnection(); 
  if (conn != null) { 
   String sql = "delete from `bank` where `ID`=?"; 
   try { 
    pstmnt = conn.prepareStatement(sql); 
    System.out.println("enter ID"); 
    int id = scan.nextInt(); 
    pstmnt.setInt(1, id); 
    int i = pstmnt.executeUpdate(); 
    if (i == 1) { 
     System.out.println("Record has been Deleted"); 
    } else { 
     System.out.println("Failed to Delete record"); 
    } 
   } catch (SQLException e) { 
    // TODO Auto-generated catch block 
    e.printStackTrace(); 
   } 
  } 
 } 
 
 private static void UpdateRecord() { 
  conn = MyFactory.getMyConnection(); 
  if (conn != null) { 
   String sql = "update  `bank` set `AccHolderName`=? where `ID`=?"; 
   try { 
    pstmnt = conn.prepareStatement(sql); 
    System.out.println("enter ID"); 
    int ID = scan.nextInt(); 
    System.out.println("Enter Name"); 
    String AccHolderName = scan.next(); 
 
    pstmnt.setString(1, AccHolderName); 
    pstmnt.setInt(2, ID); 
    int i = pstmnt.executeUpdate(); 
    if (i == 1) { 
     System.out.println("Record has been Updated"); 
    } else { 
     System.out.println("Failed to Update record"); 
    } 
   } catch (SQLException e) { 
    // TODO Auto-generated catch block 
    e.printStackTrace(); 
   } 
  } 
 } 
 
 private static void InsertRecord() { 
  conn = MyFactory.getMyConnection(); 
  if (conn != null) { 
   String sql = "insert into `bank` (`ID`,`AccHolderName`,`AccNo`,`BranchName`,`PhoneNo`) values (?,?,?,?,?)"; 
   try { 
    pstmnt = conn.prepareStatement(sql); 
    System.out.println("enter ID"); 
    int ID = scan.nextInt(); 
    System.out.println("Enter Name"); 
    String AccHolderName = scan.next(); 
    System.out.println("Enter AccNo"); 
    int AccNo = scan.nextInt(); 
    System.out.println("Enter BranchName"); 
    String BranchName = scan.next(); 
    System.out.println("enter phone number"); 
    int PhoneNo= scan.nextInt(); 
    pstmnt.setInt(1, ID); 
    pstmnt.setString(2, AccHolderName); 
    pstmnt.setInt(3, AccNo); 
    pstmnt.setString(4, BranchName); 
    pstmnt.setInt(5,PhoneNo); 
    int i = pstmnt.executeUpdate(); 
    if (i == 1) { 
     System.out.println("Record has been inserted"); 
    } else { 
     System.out.println("Failed to insert record"); 
    } 
   } catch (SQLException e) { 
    // TODO Auto-generated catch block 
    e.printStackTrace(); 
   } 
  } 
 } 
 
 private static void Display() { 
  conn = MyFactory.getMyConnection(); 
  if (conn != null) { 
   String sql = "select * from `bank`"; 
   try { 
    stmnt = conn.createStatement(); 
    res = stmnt.executeQuery(sql); 
    System.out.printf(String.format("%-20s%-20s%20s%-20s%-20s\n", "ID", "AccHolderName", "AccNo","BranchName", 
"PhoneNo")); 
    while (res.next()) { 
     System.out.printf(String.format("%-20s%20s%-20s%-20s%-20s\n", res.getInt(1), res.getString(2), res.getInt(3), res.getString(4),res.getInt(5))); 
    } 
   } catch (SQLException e) { 
    // TODO Auto-generated catch block 
    e.printStackTrace(); 
   } 
  } 
 } 
 
} 