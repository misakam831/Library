package DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * @author 胡博宇
 */
public class Function1 {



    Vector<Object> vector = new Vector<Object>();
    Vector data=new Vector();
    Function1(Connection connection, ResultSet resultSet, String table,JTable jTable){
        try {if(connection!=null){
            String sql="select * from "+ table;
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                vector.clear();
                vector.add(resultSet.getObject(1));
                vector.add(resultSet.getObject(2));
                vector.add(resultSet.getObject(3));
                vector.add(resultSet.getObject(4));
                data.add(vector.clone());
            }
            Vector names = new Vector();
            names.add("OSM_ID");
            names.add("名字");
            names.add("类型");
            names.add("geometry");
            JTable jt;
            jt = new JTable(data, names);
            jTable=jt;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
