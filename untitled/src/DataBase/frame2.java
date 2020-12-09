package DataBase;

import oracle.jdbc.OracleTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class frame2 extends JFrame implements ActionListener{
    Connection conn;

    JPanel jPanel1, jPanel2, jPanel3=null;
    JLabel jLabel1, jLabel2=null;
    JButton jButton=null;
    JTextField jTextField1, jTextField2=null;

    public frame2(Connection co){
        conn = co;

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel("请起点输入地名");
        jLabel2 = new JLabel("请输入终点地名");
        jButton = new JButton();
        jButton.setText("计算");


        jTextField1 = new JTextField(10);
        jTextField2 = new JTextField(10);

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jButton);
        jButton.addActionListener(this);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);


        this.setLayout(new GridLayout(3, 1));
        this.setLocation(800, 500);
        this.setSize(800, 500);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() =="计算"){
            String pname1 = jTextField1.getText();
            String pname2 = jTextField2.getText();
            try {
                String sql = "call dist1(?,?,?)";
                CallableStatement stat = conn.prepareCall(sql);
                //String pname1 = (String) JOptionPane.showInputDialog(jPanel, "输入地名", "查询距离",JOptionPane.PLAIN_MESSAGE);
                stat.setString(1,pname1);
                //String pname2 = (String) JOptionPane.showInputDialog(jPanel, "输入地名", "查询距离",JOptionPane.PLAIN_MESSAGE);
                stat.setString(2, pname2);
                stat.registerOutParameter(3, OracleTypes.NUMBER);
                stat.execute();
                int length = stat.getInt(3);
                JOptionPane.showMessageDialog(null, length, "距离长为 单位（m）", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
