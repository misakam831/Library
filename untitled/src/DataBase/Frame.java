package DataBase;
import oracle.jdbc.OracleTypes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        JButton button_2 = new JButton("");
        JButton button_3 = new JButton("");
        JButton button_4 = new JButton("");
        JButton button_5 = new JButton("");
        JButton button_6 = new JButton("");
        add(button_1);
        add(button_2);
        add(button_3);
        add(button_4);
        add(button_5);
        add(button_6);

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
                        JScrollPane jScrollPane = new JScrollPane(jTable);
                        add(jScrollPane);
                        jScrollPane.setLocation(170, 70);
                        jScrollPane.setSize(600, 450);
                    }else {
                        JOptionPane.showMessageDialog(jPanel, "数据库连接失败", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button_4.setBounds(470,580,200,70);
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

        button_5.setBounds(590,580,100,70);
        button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    funtion4();

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button_6.setBounds(710,580,100,70);
        button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        this.setVisible(true);
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
                    String sql = "select t.name,t.type,sdo_nn_distance(1) distance\n" +
                            "from points f,buildings t\n" +
                            "where f.name='包头' and sdo_nn(t.geometry,f.geometry,\n" +
                            "       'sdo_num_res=100 unit=m',1)='TRUE'\n" +
                            "       and t.name is not null\n" +
                            "order by distance asc";
                    Statement statement = conn.createStatement();
                    ResultSet rst = statement.executeQuery(sql);
                    rst = statement.executeQuery(sql);
                    while (rst.next()) {
                        vector.clear();
                        vector.add(rst.getObject(1));
                        vector.add(rst.getObject(2));
                        vector.add(rst.getObject(3));
                        data.add(vector.clone());
                    }
                    Vector names = new Vector();
                    names.add("名字");
                    names.add("类型");
                    names.add("距离");
                    jTable = new JTable(data, names);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void funtion3()throws Exception{
        try {
            if (conn!=null){
                String pname = (String) JOptionPane.showInputDialog(jPanel, "输入查询的铁路", "查询铁路", JOptionPane.PLAIN_MESSAGE);
                String sql="call roads_length(?,?,?)";
                conn=Getconnect.getConnectiont();
                CallableStatement stat=conn.prepareCall(sql);
                stat.setString(1,pname);
                //ResultSet resultSet=stat.executeQuery(sql);
                stat.registerOutParameter(2, OracleTypes.NUMBER);
                stat.registerOutParameter(3, OracleTypes.NUMBER);
                stat.execute();
                String length=stat.getString(2);
                String wealth=stat.getString(3);
                JOptionPane.showMessageDialog(jPanel, length, "距离长为", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(jPanel, wealth, "距离长为", JOptionPane.PLAIN_MESSAGE);

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
                conn=Getconnect.getConnectiont();
                CallableStatement stat=conn.prepareCall(sql);
                JTextField aTextField=new JFormattedTextField();
                stat.setString(1, "ATC");
                stat.registerOutParameter(2, OracleTypes.VARCHAR);
                stat.execute();
                String name=stat.getString(2);
                JOptionPane.showMessageDialog(jPanel, name, "提示", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
    }