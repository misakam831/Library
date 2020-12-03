package DataBase;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

/**
 * @author 胡博宇
 */

public class Frame extends JFrame {
    public Connection conn = null;


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
        String[] headers={};
        Object[][] cellData = {};
        DefaultTableModel model = new DefaultTableModel(cellData, headers);
        JTable jTable=new JTable(model);

        JScrollPane jScrollPane=new JScrollPane(jTable);
        add(jScrollPane);
        add(jTable);
        jTable.setBounds(40,50,900,500);
        jPanel.setBackground(Color.white);
        this.setSize(1024, 700);
        this.setLocation(200, 200);
        //显示
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
            }
        });

        button_3.setBounds(250,580,100,70);
        button_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_4.setBounds(370,580,100,70);
        button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_5.setBounds(490,580,100,70);
        button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        button_6.setBounds(610,580,100,70);
        button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        this.setVisible(true);
    }
}