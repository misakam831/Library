package DataBase;

import oracle.jdbc.OracleDatabaseMetaData;
import oracle.net.ns.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class Frame extends JFrame {
    public static Connection conn ;

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

        /**********************面板**********************/
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.white);
        this.setSize(1000, 1000);
        this.setLocation(200, 200);
        this.add(jPanel);
        //显示
        this.setVisible(true);
        //this.setLocationRelativeTo(null);
        JButton button_1 = new JButton("连接数据库");
        JButton button_2 = new JButton("");
        JButton button_3 = new JButton("");
        JButton button_4 = new JButton("");
        JButton button_5 = new JButton("");
        JButton button_6 = new JButton("");
        jPanel.add(button_1);
        jPanel.add(button_2);
        jPanel.add(button_3);
        jPanel.add(button_4);
        jPanel.add(button_5);
        jPanel.add(button_6);

        /********************按钮***********************/
        button_1.setSize(10000,1000);
        button_1.setPreferredSize(new Dimension(100,50));
        button_1.setLocation(1000,1000);
        button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Getconnect.getConnectiont();
                JOptionPane.showMessageDialog(jPanel,"数据库连接成功","提示",JOptionPane.PLAIN_MESSAGE);

            }
        });

        button_2.setSize(10000,1000);
        button_2.setPreferredSize(new Dimension(100,50));
        button_2.setLocation(1000,1000);
        button_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_3.setSize(10000,1000);
        button_3.setPreferredSize(new Dimension(100,50));
        button_3.setLocation(1000,1000);
        button_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_4.setSize(10000,1000);
        button_4.setPreferredSize(new Dimension(100,50));
        button_4.setLocation(1000,1000);
        button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_5.setSize(10000,1000);
        button_5.setPreferredSize(new Dimension(100,50));
        button_5.setLocation(1000,1000);
        button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_6.setSize(10000,1000);
        button_6.setPreferredSize(new Dimension(100,50));
        button_6.setLocation(1000,1000);
        button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }
}