package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User 
{
	private int userID;
	private String phoneNo;
	private String ic;
	private String name;
	private String email;
	private int userType;
}