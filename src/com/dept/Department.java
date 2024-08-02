package com.dept;

public class Department 
{
	private int dno;
	private String dname;
	private String dloc;
	private int dstrength;
	
	public int getDno() 
	{
		return dno;
	}

	public void setDno(int dno) 
	{
		this.dno = dno;
	}

	public String getDname() 
	{
		return dname;
	}

	public void setDname(String dname) 
	{
		this.dname = dname;
	}

	public String getDloc() 
	{
		return dloc;
	}

	public void setDloc(String dloc) 
	{
		this.dloc = dloc;
	}

	public int getDstrength() 
	{
		return dstrength;
	}

	public void setDstrength(int dstrength) 
	{
		this.dstrength = dstrength;
	}

	public Department(int dno, String dname, String dloc, int dstrength) 
	{
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
		this.dstrength = dstrength;
	}

}
