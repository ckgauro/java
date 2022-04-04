package com.gauro.java7;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Chandra
 */
public class JDBCEnhancements {

    public static void main(String[] args) throws Exception {
        viewResults();
        createJdbcRowset();

    }
    /**
     * Sample implementation from Java 7
     *
     * @throws Exception
     *
     */
    public static void viewResults() throws Exception{
        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "root");){
            Statement statement=con.createStatement();
            ResultSet rs=statement.executeQuery("select * from employer");
            while (rs.next()){
                System.out.println(rs.getString("Name")+" "+rs.getInt("Age")+" "+rs.getString("Department"));
            }

        }catch (Exception ex){
            throw ex;
        }

    }
    /**
     * Sample implementation from Java 7
     *
     * @throws Exception
     *
     */
    public  static void createJdbcRowset() throws Exception{
        try(JdbcRowSet jdbcRowSet= RowSetProvider.newFactory().createJdbcRowSet();){
            jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/organization");
            jdbcRowSet.setUsername("root");
            jdbcRowSet.setPassword("root");
            jdbcRowSet.setCommand("select * from employee");
            while(jdbcRowSet.next()){
                System.out.println(jdbcRowSet.getString("Name")+" "+jdbcRowSet.getInt("Age")+" "+jdbcRowSet.getString("Department"));
            }

        }catch (Exception e){
            throw e;
        }

    }


}
