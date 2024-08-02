package com.domain;

import java.sql.*;
import java.util.ArrayList;

public class Student 
{
	private String url = "jdbc:mysql://localhost:3306/palle";
	private String username = "root";
	private String password = "sadhu";
	public void creating() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement s = con.createStatement();
			
			s.executeUpdate("CREATE TABLE STUDENT(SNO INT PRIMARY KEY AUTO_INCREMENT,SNAME VARCHAR(50) NOT NULL,SUB VARCHAR(40) NOT NULL,EMAIL VARCHAR(45) NOT NULL)");
			
			s.close();
			con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void inserting(String sname, String sub,String email) 
	{
		// By using PreparedStatement class
		try 
		{
			// Step 1:Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Establish the connection to database
			Connection con = DriverManager.getConnection(url,username,password);
			
			// Step 3: Prepare PreparedStatement
			PreparedStatement ps = con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
			
			// Step 4: Insert input values in preparedstatement
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			
			//Execute the Qurey or statement
			ps.executeUpdate();
			
			//close connection and preparedStatement
			ps.close();
			con.close();
	    } 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}
	
	public void updating(int sno,String sname,String sub,String email) 
	{
		PreparedStatement ps = null;
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		    ps = con.prepareStatement("update student set sname = ?,sub =?,email =? where sno = ?");
			
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.setInt(4, sno);
			
			ps.executeUpdate();
			
		
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null) 
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
			
			if(ps != null) 
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleting(int sno) 
	{
		PreparedStatement ps = null;
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		    ps = con.prepareStatement("delete from student where sno = ?");
			
		
			ps.setInt(1, sno);
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null) 
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
			
			if(ps != null) 
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Teacher> selecting() 
	{
		Connection con = null;
		Statement s = null;
		ArrayList<Teacher> al = new ArrayList<Teacher>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		    s = con.createStatement();
			
			ResultSet rs = s.executeQuery("select*from student");
			
			while(rs.next()) 
			{
				
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				String sub = rs.getString("sub");
				String email = rs.getString("email");
			   
				
				Teacher t = new Teacher(no,name,sub,email);
				
				al.add(t);
			}
			
	    } 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				s.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return al;
	
	}

}
