package se.smu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class TodoElement {

	//"To do", "Subject", "Deadline", "Due date", "Completed", "Importance"
	public String Todo;
	public String Subject;
	public Calendar Deadline;
	public Calendar DueDate;
	public boolean Completed = false;
	public boolean Importance = false;
	public int comp = (Completed)? 1 : 0;
	public int impo = (Importance)? 1: 0;
	public SimpleDateFormat Dead_sdf=new SimpleDateFormat("yyyy.M.dd hh:mm a");     //Date출력 형식 지정 * 'a' is Am/pm marker
	public SimpleDateFormat Due_sdf=new SimpleDateFormat("yyyy.M.dd hh:mm a"); 
	public String Dead ;
	public String Due;
	public Date DDead;
	public Date DDue;
	DataBase database = new DataBase();
	
	public TodoElement(String Todo, String Subject, Calendar Deadline, 
			Calendar DueDate, boolean Completed, boolean Importance){
		this.Todo=Todo;
		this.Subject=Subject;
		this.Deadline=Deadline;
		this.DueDate=DueDate;
		this.Completed=Completed;
		this.Importance=Importance;
		this.comp = (Completed)? 1 : 0;
		this.impo = (Importance)? 1: 0;
	}
	
	public int todoDBrow(){
		int row = 0;
		Connection con = null;
		Statement stmt = null;
		String sql = "SELECT COUNT(*) FROM Tododb ";
		try {
			 Class.forName("org.mariadb.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
			 stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		row = Integer.parseInt(rs.getString("COUNT(*)"));
		rs.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
	 
	    try {
	 
	     if (stmt != null)
	      stmt.close();
	     if (con != null)
	      con.close();
	    } catch (Exception e) {
	     System.out.println(e.getMessage());
	    }
	   }
		return row;
}
	
	public void todoinitDB(){
		int j=0;
		TodoElement a = new TodoElement(null, null, null, null, false, false);
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from Tododb limit " ;
		try {
			 Class.forName("org.mariadb.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
			    stmt = con.createStatement();
			    ResultSet rs = null;
			    while(j<todoDBrow()){
				rs = stmt.executeQuery(sql+j+','+'1');
				rs.next();
				this.Todo = rs.getString("Todo");
				this.Subject = rs.getString("Subject");
				this.DDead = Dead_sdf.parse(rs.getString("Deadline"));
				this.DDue = Due_sdf.parse(rs.getString("Duedate"));
				this.Completed = rs.getBoolean("Completed");
				this.Importance = rs.getBoolean("Importance");
				Deadline = Calendar.getInstance();
				Deadline.setTime(DDead);
				DueDate = Calendar.getInstance();
				DueDate.setTime(DDue);
				a = new TodoElement(Todo, Subject, Deadline, DueDate, Completed, Importance);
				database.TodoAdd(a);
				j++;
			    }
			    
			    rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		 
		    try {
		 
		     if (stmt != null)
		      stmt.close();
		     if (con != null)
		      con.close();
		    } catch (Exception e ) {
		     System.out.println(e.getMessage());
		    }
		   }
	}
	
	public void todoinsertDB(){
		Connection con = null;
		Statement stmt = null;
		String sql = "insert into Tododb values";
		try {
		    sql += "('" + new String(Todo) + "','"  
		      + new String(Subject) + "','"
		      + new String(Dead_sdf.format(Deadline.getTime())) + "','"
		      + new String(Due_sdf.format(DueDate.getTime())) + "','"
		      + comp +"','"
		      + impo + "','"
		      + new String(String.valueOf(todoDBrow()+1)) + "')";
		    
		    
		    Class.forName("org.mariadb.jdbc.Driver"); 
		    con = DriverManager.getConnection(
		      "jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
		    stmt = (Statement) con.createStatement();
		    stmt.executeUpdate(sql);
		 
		   } catch (Exception e) {
		    System.out.println(e);

		   } finally {
		 
		    try {
		 
		     if (stmt != null)
		      stmt.close();
		     if (con != null)
		      con.close();
		    } catch (Exception e) {
		     System.out.println(e.getMessage());
		    }
		   }

	}
	
	public void todochangeDB(int j){
		Connection con = null;
		Statement stmt = null;
		String sql ="update Tododb set Todo = ";
		String sql2 =" where rownum = ";

		try {
			 Class.forName("org.mariadb.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
			    stmt = con.createStatement();
				ResultSet rs = null ;
				sql += 	"'" + new String(Todo) + "', Subject = "  +
						"'" + new String(Subject) + "', Deadline = "	+
						"'" + new String(Dead_sdf.format(Deadline.getTime())) + "', Duedate = "	+
						"'" + new String(Due_sdf.format(DueDate.getTime())) + "', Completed =  "	+
						"'" + comp +"', Importance = "	+
						"'" + impo +"'";
				sql2 += (j+1);
			    rs = stmt.executeQuery(sql + sql2);
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		 
		    try {
		 
		     if (stmt != null)
		      stmt.close();
		     if (con != null)
		      con.close();
		    } catch (Exception e) {
		     System.out.println(e.getMessage());
		    }
		   }
	}
	
	
	public void tododeleteDB(int j){
		Connection con = null;
		Statement stmt = null;
		String sql = "delete from Tododb where rownum = ";
		try {
		    sql += (j+1);
		    Class.forName("org.mariadb.jdbc.Driver"); 
		    con = DriverManager.getConnection(
		      "jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
		    stmt = (Statement) con.createStatement();
		    stmt.executeUpdate(sql);
		    for(int i=(j+1);i<=todoDBrow();i++){
		    	String sql1 = "update Tododb set rownum = ";
		    	sql1 += "'"+String.valueOf(i)+"'"+ " Where rownum = "+ "'"+String.valueOf(i+1)+"'";
		    	stmt.executeUpdate(sql1);
		    }
		   } catch (Exception e) {
		    System.out.println(e);

		   } finally {
		 
		    try {
		 
		     if (stmt != null)
		      stmt.close();
		     if (con != null)
		      con.close();
		    } catch (Exception e) {
		     System.out.println(e.getMessage());
		    }
		   }

//	}
//	public void subtododeleteDB(){
//		System.out.print(SE.name);
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String sql = "delete from Tododb where rownum = ";
//		String sql2 = "select * from subjectdb where Subject = ";
//		try {
//			sql2 += SE.name;
//			rs = stmt.executeQuery(sql2);
//			rs.next();
//			int j = Integer.parseInt(rs.getString("rownum"));
//		    sql += j;
//		    Class.forName("org.mariadb.jdbc.Driver"); 
//		    con = DriverManager.getConnection(
//		      "jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
//		    stmt = (Statement) con.createStatement();
//		    stmt.executeUpdate(sql);
//		    System.out.print(todoDBrow());
//		    for(int i=j;i<=todoDBrow();i++){
//		    	String sql1 = "update Tododb set rownum = ";
//		    	sql1 += "'"+String.valueOf(i)+"'"+ " Where rownum = "+ "'"+String.valueOf(i+1)+"'";
//		    	stmt.executeUpdate(sql1);
//		    }
//		   } catch (Exception e) {
//		    System.out.println(e);
//
//		   } finally {
//		 
//		    try {
//		 
//		     if (stmt != null)
//		      stmt.close();
//		     if (con != null)
//		      con.close();
//		    } catch (Exception e) {
//		     System.out.println(e.getMessage());
//		    }
//		   }
//
	}
	
}
