package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;
import util.PasswordUtil;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private EnterFrame enterFrame; // ����EnterFrame

    public LoginFrame(EnterFrame enterFrame) {
        this.enterFrame = enterFrame; // ���洫���EnterFrameʵ��

        this.setSize(400, 300);
        this.setTitle("��¼");
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        // ���ñ�����ɫ
        this.getContentPane().setBackground(new Color(60, 63, 65));

        JLabel usernameLabel = new JLabel("�û���:");
        usernameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(50, 50, 80, 30);
        this.getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        usernameField.setBounds(140, 50, 200, 30);
        this.getContentPane().add(usernameField);

        JLabel passwordLabel = new JLabel("����:");
        passwordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(50, 100, 80, 30);
        this.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        passwordField.setBounds(140, 100, 200, 30);
        this.getContentPane().add(passwordField);

        loginButton = new JButton("��¼");
        loginButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
        loginButton.setBackground(new Color(0, 122, 204));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(140, 150, 100, 30);
        this.getContentPane().add(loginButton);
        loginButton.addActionListener(new LoginAction());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ��¼�߼�
            try (Connection conn = DatabaseUtil.getConnection()) {
                String sql = "SELECT id, password_hash, salt FROM users WHERE username = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    int userid = rs.getInt("id");
                    String storedHash = rs.getString("password_hash");
                    String salt = rs.getString("salt"); // �����ݿ��л�ȡ��ֵ

                    // ��֤����
                    if (PasswordUtil.checkPassword(password, storedHash, salt)) {
                        // �����û�����Ϸ��¼
                        String gameRecord = loadGameRecord(conn, username);
                        JOptionPane.showMessageDialog(null, "��¼�ɹ�", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);

                        // ����EnterFrame��״̬
                        enterFrame.updateLoginState(true, username, userid, gameRecord);

                        dispose(); // �رյ�¼����
                    } else {
                        JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "�û���������", "����", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "��¼ʧ��", "����", JOptionPane.ERROR_MESSAGE);
            }
        }

        private String loadGameRecord(Connection conn, String username) throws SQLException {
            String gameRecord;
            String sql = "SELECT * FROM game_records WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            // ����û��Ƿ�����Ϸ��¼
            if (rs.next()) {
                int level = rs.getInt("level");
                int blood = rs.getInt("blood");
                gameRecord = "�û�: " + username + " | ��¼:�� " + level + "��" + " | Ѫ��: " + blood;
            } else {
                gameRecord = "��ӭ, " + username + "! ������Ϸ��¼���뿪ʼ����Ϸ��";
            }
            return gameRecord;
        }
    }
}
