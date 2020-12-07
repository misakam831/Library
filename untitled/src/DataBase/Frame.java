package DataBase;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Vector;

/**
 * @author 胡博宇
 */

public class Frame extends JFrame {
    public static Connection conn = null;
    public static ResultSet rst=null;
    JTable jTable=null;
    JPanel jPanel = new JPanel();
    public static Vector<String> points = new Vector<String>();/**确定当前位置

    /***************************窗体***********************/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Frame frame = new Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Frame() {
        this.setTitle("空间数据查询系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        /**********************面板**********************/
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.white);
        this.setSize(1024, 700);
        this.setLocation(200, 200);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        JButton button_1 = new JButton("连接数据库");
        JButton button_2 = new JButton("查询各表");
        JButton button_3 = new JButton("查询两点间距离");
        JButton button_4 = new JButton("计算铁路造价");
        JButton button_5 = new JButton("查询建筑物类型");
        JButton button_6 = new JButton("人均住房面积与人口总数");
        JButton button_7 = new JButton("火车站位置显示");
        JButton button_8 = new JButton("显示呼包高速");
        add(button_1);
        add(button_2);
        add(button_3);
        add(button_4);
        add(button_5);
        add(button_6);
        add(button_7);
        add(button_8);

        /********************按钮***********************/
        button_1.setBounds(10,580,100,70);
        button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    conn = Getconnect.getConnectiont();
                    if (conn != null) {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }

                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }
        });

        button_2.setBounds(130,580,100,70);
        button_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (conn != null) {
                        jTable=funtion1();
                        JScrollPane jScrollPane=new JScrollPane(jTable);
                        add(jScrollPane);
                        jScrollPane.setLocation(170,70);
                        jScrollPane.setSize(600,450);
                    } else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }

                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }
        });
        button_3.setBounds(250,580,200,70);
        button_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (conn != null) {
                        funtion2();
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button_4.setBounds(470,580,150,70);
        button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (conn != null) {
                       funtion3();
                        JScrollPane jScrollPane = new JScrollPane(jTable);
                        add(jScrollPane);
                        jScrollPane.setLocation(170, 70);
                        jScrollPane.setSize(600, 450);
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }


                }catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button_5.setBounds(640,580,150,70);
        button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(conn!=null){
                        funtion4();
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button_6.setBounds(810,580,150,70);
        button_6.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(conn!=null){
                        funtion5();
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }
        });

        button_7.setBounds(810,480,150,70);
        button_7.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(conn!=null){
                        funtion6();
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        button_8.setBounds(810,380,150,70);
        button_8.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(conn!=null){
                        funtion7();
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }


    public JTable funtion1() {
        Vector<Object> vector = new Vector<Object>();
        Vector data = new Vector();
        try {
            if (conn != null) {
                Object[] possibilities = {"buildings", "places", "points", "railways", "landuse", "waterways", "natural", "roads"};
                String pname = (String) JOptionPane.showInputDialog(jPanel, "选择你要查询的表：", "查询数据", JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[0]);
                String sql = "select * from " + pname;
                Statement statement = conn.createStatement();
                ResultSet rst = statement.executeQuery(sql);
                rst = statement.executeQuery(sql);
                if (Objects.equals(pname, "buildings") | Objects.equals(pname, "natural") |
                        Objects.equals(pname, "railways") | Objects.equals(pname, "landuse")) {
                    while (rst.next()) {
                        vector.clear();
                        vector.add(rst.getObject(1));
                        vector.add(rst.getObject(2));
                        vector.add(rst.getObject(3));
                        vector.add(rst.getObject(4));
                        data.add(vector.clone());
                    }
                    Vector names = new Vector();
                    names.add("OSM_ID");
                    names.add("名字");
                    names.add("类型");
                    names.add("geometry");
                    jTable = new JTable(data, names);
                    jTable.clearSelection();
                }

                if (Objects.equals(pname, "roads")) {
                    jTable.invalidate();
                    while (rst.next()) {
                        vector.clear();
                        vector.add(rst.getObject(1));
                        vector.add(rst.getObject(2));
                        vector.add(rst.getObject(3));
                        vector.add(rst.getObject(4));
                        vector.add(rst.getObject(5));
                        vector.add(rst.getObject(6));
                        vector.add(rst.getObject(7));
                        vector.add(rst.getObject(8));
                        data.add(vector.clone());
                    }
                    Vector names = new Vector();
                    names.add("OSM_ID");
                    names.add("名字");
                    names.add("类型");
                    names.add("oneway");
                    names.add("bridge");
                    names.add("maxspeed");
                    names.add("geometry");
                    jTable = new JTable(data, names);
                    jTable.clearSelection();

                }

                if (Objects.equals(pname, "waterways")) {
                    while (rst.next()) {
                        vector.clear();
                        vector.add(rst.getObject(1));
                        vector.add(rst.getObject(2));
                        vector.add(rst.getObject(3));
                        vector.add(rst.getObject(4));
                        vector.add(rst.getObject(5));
                        data.add(vector.clone());
                    }
                    Vector names = new Vector();
                    names.add("OSM_ID");
                    names.add("名字");
                    names.add("类型");
                    names.add("waterways");
                    names.add("geometry");
                    jTable = new JTable(data, names);
                    jTable.clearSelection();
                }

                if (Objects.equals(pname, "places")) {
                    while (rst.next()) {
                        vector.clear();
                        vector.add(rst.getObject(1));
                        vector.add(rst.getObject(2));
                        vector.add(rst.getObject(3));
                        vector.add(rst.getObject(4));
                        vector.add(rst.getObject(5));
                        data.add(vector.clone());
                    }
                    Vector names = new Vector();
                    names.add("OSM_ID");
                    names.add("名字");
                    names.add("类型");
                    names.add("popular");
                    names.add("geometry");
                    jTable = new JTable(data, names);
                    jTable.clearSelection();
                }

                if (Objects.equals(pname, "points")) {
                    while (rst.next()) {
                        vector.clear();
                        vector.add(rst.getObject(1));
                        vector.add(rst.getObject(2));
                        vector.add(rst.getObject(3));
                        vector.add(rst.getObject(4));
                        vector.add(rst.getObject(5));
                        data.add(vector.clone());
                    }
                    Vector names = new Vector();
                    names.add("OSM_ID");
                    names.add("timestamp");
                    names.add("名字");
                    names.add("类型");
                    names.add("geometry");
                    jTable = new JTable(data, names);
                    jTable.clearSelection();
                }


                return jTable;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jTable;
    }

    public void funtion2()throws Exception {
            Vector<Object> vector = new Vector<Object>();
            Vector data=new Vector();
            try {
                if (conn != null) {
                    String sql ="call dist1(?,?,?)";
                    CallableStatement stat=conn.prepareCall(sql);
                    String pname1 = (String) JOptionPane.showInputDialog(jPanel, "输入地名", "查询距离",JOptionPane.PLAIN_MESSAGE);
                    stat.setString(1,pname1);
                    String pname2 = (String) JOptionPane.showInputDialog(jPanel, "输入地名", "查询距离",JOptionPane.PLAIN_MESSAGE);
                    stat.setString(2,pname2);
                    stat.registerOutParameter(3, OracleTypes.NUMBER);
                    stat.execute();
                    int length=stat.getInt(3);
                    JOptionPane.showMessageDialog(jPanel, length, "距离长为 单位（m）", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void funtion3()throws Exception{
        try {
            if (conn!=null){
                String pname = (String) JOptionPane.showInputDialog(jPanel, "输入查询的道路", "查询道路", JOptionPane.PLAIN_MESSAGE);
                String sql="call roads_length(?,?,?)";
                conn=Getconnect.getConnectiont();
                CallableStatement stat=conn.prepareCall(sql);
                stat.setString(1,pname);
                stat.registerOutParameter(2, OracleTypes.NUMBER);
                stat.registerOutParameter(3, OracleTypes.NUMBER);
                stat.execute();
                ResultSet resultSet = stat.getResultSet();
                String length=stat.getString(2);
                String wealth=stat.getString(3);
                Vector<Object> vector = new Vector<Object>();
                Vector data = new Vector();
                JOptionPane.showMessageDialog(jPanel, length, "距离长为  单位（m）", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(jPanel, wealth, "造价成本为 单位（千万）", JOptionPane.PLAIN_MESSAGE);
                while (resultSet.next()){
                    vector.clear();
                    vector.add(stat.getString(2));
                    vector.add(stat.getString(3));
                    data.add(vector.clone());
                    Vector names=new Vector();
                    names.add("距离");
                    names.add("价格");
                    jTable=new JTable(data,names);


                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void funtion4()throws Exception{
        Vector<Object> vector = new Vector<Object>();
        Vector data=new Vector();
        try {
            if (conn!=null){
                String sql="call testpro1(?,?)";
                String pname = (String) JOptionPane.showInputDialog(jPanel, "输入查询建筑物的名称", "查询类型", JOptionPane.PLAIN_MESSAGE);
                conn=Getconnect.getConnectiont();
                CallableStatement stat=conn.prepareCall(sql);
                stat.setString(1,pname);
                stat.registerOutParameter(2, OracleTypes.VARCHAR);
                stat.execute();
                String name=stat.getString(2);
                JOptionPane.showMessageDialog(jPanel, name, "查询结果", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void funtion5()throws Exception{
        if (conn!=null){
            int a=0;
            String sql1="select p.population from  places p where p.name='包头市' ";
            Statement statement = conn.createStatement();
            ResultSet rst = statement.executeQuery(sql1);
            rst = statement.executeQuery(sql1);
            while (rst.next()){
                int populartion=rst.getInt("population");
                System.out.println(populartion);
                a=populartion;
            }

            JOptionPane.showMessageDialog(jPanel, a, "人口查询", JOptionPane.PLAIN_MESSAGE);
            String sql="call prearea(?)";
            conn=Getconnect.getConnectiont();
            CallableStatement stat=conn.prepareCall(sql);
            stat.registerOutParameter(1, OracleTypes.NUMBER);
            stat.execute();
            double number=stat.getDouble(1);
            JOptionPane.showMessageDialog(jPanel, number/a,"人均住房面积", JOptionPane.PLAIN_MESSAGE);

        }

    }

    public void funtion6()throws Exception{
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("E:\\gitcode\\untitled\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        java.awt.Frame frame=new java.awt.Frame("包头市火车站缓冲区");
        frame.setSize(img.getWidth(),img.getHeight());
        frame.setLocation(500, 50);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        String sql="select p.geometry from points p where type='station'";
        try{
            Statement statement=conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                STRUCT st = (STRUCT) resultSet.getObject("geometry");
                JGeometry geom=JGeometry.load(st);
                int dimensionality=geom.getDimensions();
                double[] geomxy=geom.getFirstPoint();
                System.out.println(geomxy[0]);
                System.out.println(geomxy[1]);
                double pointx=(geomxy[0]-108.9932779)*808;
                double pointy=(41.6261756-geomxy[1])*380;
                System.out.println(pointx);
                System.out.println(pointy);

                Graphics2D g2d=(Graphics2D)img.getGraphics();
                g2d.setColor(Color.RED);
                g2d.setFont(new Font("宋体",Font.PLAIN,30));
                g2d.setStroke(new BasicStroke(12));
                g2d.fillOval((int)pointx,(int)pointy,10,10);
                JLabel label = new JLabel(new ImageIcon(img));
                frame.add(label);
                label.setBounds(0, 0,img.getWidth(),img.getHeight());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void funtion7()throws Exception{
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("E:\\gitcode\\untitled\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        java.awt.Frame frame=new java.awt.Frame("京包铁路路线图");
        frame.setSize(img.getWidth(),img.getHeight());
        frame.setLocation(500, 50);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        String sql="select p.geometry from railways p where name='京包铁路'";
        try{
            Statement statement=conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                STRUCT st = (STRUCT) resultSet.getObject("geometry");
                JGeometry geom=JGeometry.load(st);
                int dimensionality=geom.getDimensions();
                double[] geomxy=geom.getFirstPoint();
                double[] geomxy1=geom.getLastPoint();
                System.out.println(geomxy[0]);
                System.out.println(geomxy[1]);
                double pointx=(geomxy[0]-108.9932779)*808;
                double pointy=(41.6261756-geomxy[1])*380;
                double pointx1=(geomxy1[0]-108.9932779)*808;
                double pointy1=(41.6261756-geomxy1[1])*380;
                System.out.println(pointx);
                System.out.println(pointy);

                Graphics2D g2d=(Graphics2D)img.getGraphics();
                g2d.setColor(Color.RED);
                g2d.setFont(new Font("宋体",Font.PLAIN,20));
                g2d.setStroke(new BasicStroke(5));
                //g2d.fillOval((int)pointx,(int)pointy,30,30);
                g2d.drawLine( (int)pointx,(int)pointy,(int)pointx1,(int)pointy1);
                JLabel label = new JLabel(new ImageIcon(img));
                frame.add(label);
                label.setBounds(0, 0,img.getWidth(),img.getHeight());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
