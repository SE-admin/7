package se.smu;

import java.sql.*;
import java.util.Vector;

public class SubjectElement {
	public String name;
	public String prof;
	public String selectday;
	public int starthour;
	public String startminute;
	public int endhour;
	public String endminute;
	public int year;
	public String semester;
	DataBase DB = new DataBase();
	Vector<SubjectElement> SV = new Vector<SubjectElement>();
	
	
	public SubjectElement(String name, String prof, String selectDay, int startHour, String startMinute, int endHour,
			String endMinute, int year, String semester) { 
		this.name = name; // this.name=>public class Subject�� name
		this.prof = prof;
		this.selectday = selectDay;
		this.starthour = startHour;
		this.startminute = startMinute;
		this.endhour = endHour;
		this.endminute = endMinute;
		this.year = year;
		this.semester = semester;
	}
	
	public int DBrow(){
		int row = 0;
		Connection con = null;
		Statement stmt = null;
		String sql = "SELECT COUNT(*) FROM subjectdb";
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
	
	public void initDB(){
		int j=0;
		SubjectElement a = null ;
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from subjectdb limit " ;
		try {
			 Class.forName("org.mariadb.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
			    stmt = con.createStatement();
			    ResultSet rs = null;
			    
			    while(j<DBrow()){
				rs = stmt.executeQuery(sql+j+','+'1');
				rs.next();
				this.name = rs.getString("subject");
				this.prof = rs.getString("Prof");
				this.year = Integer.parseInt(rs.getString("Year"));
				this.semester = rs.getString("Semester");
				this.endhour = Integer.parseInt(rs.getString("End"))/100;
				this.starthour = Integer.parseInt(rs.getString("Start"))/100;
				this.selectday = rs.getString("Day");
				this.startminute = rs.getString("Start").substring(rs.getString("Start").length()-2,rs.getString("Start").length());
				this.endminute = rs.getString("End").substring(rs.getString("End").length()-2,rs.getString("End").length());
				a = new SubjectElement(name, prof, selectday, starthour, startminute, endhour, endminute, year, semester);
				DB.SubjectAdd(a);
				j++;
			    }
			    DB.MatrixSubject();
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
	
	public void changeDB(int j){
		Connection con = null;
		Statement stmt = null;
		String sql ="update subjectdb set subject = ";
		String sql2 =" where rownum = ";

		try {
			 Class.forName("org.mariadb.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
			    stmt = con.createStatement();
				ResultSet rs = null ;
				sql += 	"'" + new String(name) + "', Prof = "  +
						"'" + new String(prof) + "', Year = "	+
						"'" + new String(String.valueOf(year)) + "', Semester = "	+
						"'" + new String(semester) + "', Day =  "	+
						"'" + new String(selectday) +"', Start = "	+
						"'" + new String((String.valueOf(starthour)+startminute)) + "', End = "	+
						"'" + new String(String.valueOf(endhour)+endminute)+"'";
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
	
	public void insertDB(){
		Connection con = null;
		Statement stmt = null;
		String sql = "insert into subjectdb values";
		try {
		    sql += "('" + new String(name) + "','"  
		      + new String(prof) + "','"
		      + new String(String.valueOf(year)) + "','"
		      + new String(semester) + "','"
		      + new String(selectday) +"','"
		      + new String(String.valueOf(starthour+startminute)) + "','"
		      + new String(String.valueOf(endhour+endminute)) + "','"
		      + new String(String.valueOf(DBrow()+1)) + "')";
		 
		    
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
	
	public void deleteDB(int j){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "delete from subjectdb where rownum = ";
		String sql2 = "select * from subjectdb where rownum = ";
		try {
			sql2 += (j+1);
		    sql += (j+1);
		    Class.forName("org.mariadb.jdbc.Driver"); 
		    con = DriverManager.getConnection(
		      "jdbc:mariadb://211.253.25.2:3306/Turkey", "user", "1234");
		    stmt = (Statement) con.createStatement();
		    rs = stmt.executeQuery(sql2);
		    rs.next();
		    this.name = rs.getString("subject");
		    stmt.executeUpdate(sql);
		    for(int i=(j+1);i<=DBrow();i++){
		    	String sql1 = "update subjectdb set rownum = ";
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

	}

}
