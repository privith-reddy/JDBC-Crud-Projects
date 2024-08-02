package com.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class A 
{
	private String url = "jdbc:mysql://localhost:3306/palle";
	private String username = "root";
	private String password = "sadhu";
	
	public ArrayList<Department> f1()
	{
		Connection con = null;
		Statement s = null;
		ArrayList<Department> al = new ArrayList<Department>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			s = con.createStatement();
			
			ResultSet rs = s.executeQuery("select * from dept");
			
			while(rs.next()==true) 
			{
				int no = rs.getInt("dno");
				String name = rs.getString("dname");
				String loc = rs.getString("dlocation");
				int strength = rs.getInt("dstrength");
				
				Department d = new Department(no,name,loc,strength);
				
				al.add(d);
			}
			
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
	
	public void f2(int dno) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("select * from dept where dno = ?");
			
			ps.setInt(1, dno);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()== true) 
			{
				System.out.println(rs.getString("dname"));
				System.out.println(rs.getString("dlocation"));
				System.out.println(rs.getInt("dstrength"));
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
				ps.close();
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
	}
	
	public void f3(int dno, String dname) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("update dept set dname = ? where dno = ?");
			
			ps.setString(1, dname);
			ps.setInt(2, dno);
			
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
			try 
			{
				ps.close();
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
		
		
	}
}
