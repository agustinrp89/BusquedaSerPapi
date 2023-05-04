package com.equipo.mysql;

import java.sql.Connection;

import javax.swing.JOptionPane;
import java.sql.*;


public class conexion {
	Connection conn=null;
	String bd="top10";
	String user="root";
	String pass="cristian26.";
	String ip="localhost";
	String puerto="3306";
	Statement st=null;
	ResultSet rs=null;
	
	
	
	String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;


	public Connection miConexion() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(cadena,user,pass);
			st=conn.createStatement();
			rs=st.executeQuery("Select * from top10");
			while(rs.next())
			{
				int idtop10=rs.getInt(1);
				String nametop10=rs.getString(2);
				String titletop10=rs.getString(3);
				  System.out.println("id: " + idtop10);
				  System.out.println("Autor " + nametop10);
				  System.out.println("titulo: " + titletop10);
			}
			
			JOptionPane.showMessageDialog(null, "conexion realizada");
			
			} catch (Exception e) {
		
				JOptionPane.showMessageDialog(null, "conexion no realizada");
				e.printStackTrace();
			}
		return conn;
	}
}
