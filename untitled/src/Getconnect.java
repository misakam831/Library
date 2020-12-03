import java.sql.*;

/**
 * @author 胡博宇 2020/12/3
 */
public class Getconnect {
    public  static Connection getConnectiont(){
        Connection connection=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@//localhost:1521/orcl";
            String username="baotou";
            String password="baotou";
            connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
    public static void main(String[] args){
        //String sql="select sno,sname from student";
        String sql="select sno,sum(grade) sg from sc group by sno";
        Connection connection=getConnectiont();

        try {
            Statement statement= connection.createStatement();
            //ResultSet resultSet=statement.executeQuery(sql);
            System.out.println("链接成功");
            /*while(resultSet.next()){
                String sno=resultSet.getString("sno");
                double sg=resultSet.getDouble("sg");
                System.out.println(sno);
                System.out.println(sg);

            }*/

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("链接失败");
        }
    }
}
