/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.cj.protocol.Resultset;
import entity.Movie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author zhangjianwei
 */
public class MovieDao {


    public List<Movie> getMovies(String key, String keyword){
        Connection connection = null;
        List<Movie> result = null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Movie>> handler = new BeanListHandler<Movie>(Movie.class);
            String query = "SELECT * FROM movies where ";
            query+=(key + " = " + keyword + " ");
            result = queryRunner.query(connection, query, handler);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
    
    
    
    
     public int addMovie(String title, String actor, String actress,String genre,int year) {
        Connection connection = null;
        int result = 0;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();

            String query = "INSERT INTO movies (title, actor,actress,genre,year) VALUES( ?,?,?,?,?)";
            result = queryRunner.update(connection, query, title,actor, actress, genre, year);
            //System.out.println("result of insert"+result);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;

    }
}
