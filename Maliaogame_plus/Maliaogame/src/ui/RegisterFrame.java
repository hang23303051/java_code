package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DatabaseUtil;
import util.PasswordUtil;

public class RegisterFrame extends JFrame {
    private JTextField usernameField; // �û��������
    private JPasswordField passwordField; // ���������
    private JButton registerButton; // ע�ᰴť

    public RegisterFrame() {
        // ���ô��ڴ�С
        this.setSize(400, 300);
        // ���ô��ڱ���
        this.setTitle("ע��");
        // ��ֹ�������ڴ�С
        this.setResizable(false);
        // ʹ�þ��Բ���
        this.getContentPane().setLayout(null);

        // ���ñ�����ɫ
        this.getContentPane().setBackground(new Color(60, 63, 65));

        // ����������û�����ǩ
        JLabel usernameLabel = new JLabel("�û���:");
        usernameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        usernameLabel.setForeground(Color.WHITE); // ����������ɫΪ��ɫ
        usernameLabel.setBounds(50, 50, 80, 30); // ����λ�úʹ�С
        this.getContentPane().add(usernameLabel);

        // ����������û��������
        usernameField = new JTextField();
        usernameField.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        usernameField.setBounds(140, 50, 200, 30);
        this.getContentPane().add(usernameField);

        // ��������������ǩ
        JLabel passwordLabel = new JLabel("����:");
        passwordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE); // ����������ɫΪ��ɫ
        passwordLabel.setBounds(50, 100, 80, 30); // ����λ�úʹ�С
        this.getContentPane().add(passwordLabel);

        // ������������������
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        passwordField.setBounds(140, 100, 200, 30);
        this.getContentPane().add(passwordField);

        // ���������ע�ᰴť
        registerButton = new JButton("ע��");
        registerButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
        registerButton.setBackground(new Color(0, 122, 204)); // ���ð�ť������ɫ
        registerButton.setForeground(Color.WHITE); // ���ð�ť������ɫ
        registerButton.setBounds(140, 150, 100, 30); // ����λ�úʹ�С
        this.getContentPane().add(registerButton);
        registerButton.addActionListener(new RegisterAction()); // ��Ӱ�ť����¼�

        // ���ô��ھ�����ʾ
        this.setLocationRelativeTo(null);
        // ���ô��ڹر�ʱ�Ĳ���
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // ���ô��ڿɼ�
        this.setVisible(true);
    }

    // ע������ľ���ʵ��
    private class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ��ȡ�û�������û���������
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // ����û����������Ƿ�Ϊ��
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ������ֵ����������
            String salt = PasswordUtil.generateSalt(); // ������ֵ
            String hashedPassword = PasswordUtil.hashPassword(password, salt); // ʹ���μ�������

            try (Connection conn = DatabaseUtil.getConnection()) {
                // �������û���Ϣ�����ݿ�
                String sql = "INSERT INTO users (username, password_hash, salt) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username); // �����û���
                pstmt.setString(2, hashedPassword); // ���ü��ܺ������
                pstmt.setString(3, salt); // ������ֵ

                int rows = pstmt.executeUpdate(); // ִ��SQL��䲢����Ӱ�������
                if (rows > 0) {
                    // ע��ɹ���ʾ
                    JOptionPane.showMessageDialog(null, "ע��ɹ�", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // �ر�ע�ᴰ��
                }
            } catch (Exception ex) {
                // ע��ʧ����ʾ
                JOptionPane.showMessageDialog(null, "ע��ʧ��", "����", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); // ��ӡ�쳣��Ϣ
            }
        }
    }
}
