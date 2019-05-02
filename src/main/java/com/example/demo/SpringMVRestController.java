package com.example.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringMVRestController {
	@RequestMapping(value="users",method= {RequestMethod.GET,RequestMethod.POST})
	public List<user> getUsers() throws ClassNotFoundException, SQLException{
		ArrayList<user> userList=new ArrayList<user>();
		String dburl = "jdbc:sqlserver://itkmssql.ad.ilstu.edu:1433;databaseName=djtown1Test;integratedSecurity=true;domain=adilstu;";
		String dbuser = "IT353S902";
        String dbpass = "climate56";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con= null;	     
        con = DriverManager.getConnection(dburl, dbuser, dbpass);
        
        String sql = "select * from usertable";			
		PreparedStatement ps = null;			
		ResultSet rs = null;			
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
//		if(rs.next()) {
			while(rs.next()) {
				userList.add(new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
//		}
		return userList;
	}
}
