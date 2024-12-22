package ui;

import java.awt.*;
import javax.swing.*;

public class EnterFrame extends JFrame {
    public JButton jb1, loginButton, registerButton;
    public JLabel userInfoLabel;
    private boolean isLoggedIn = false; // ����û��Ƿ�ɹ���¼
    private String username = ""; // �洢�ɹ���¼���û���
    private String gameRecord = ""; // �洢��Ϸ��¼��Ϣ
    private int userid = 0; // �洢�û�ID

    // ���캯����ʼ������
    public EnterFrame() {
        // ���ô��ڴ�С�����⡢���ɱ��С
        this.setSize(800, 450);
        this.setTitle("��������");
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        // ���ñ���ͼƬ
        JPanel myPanel = (JPanel) this.getContentPane();
        myPanel.setOpaque(false);
        ImageIcon icon = new ImageIcon("image/homePage.jpeg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        icon.setImage(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // ��������ӵ��������

        // "START GAME" ��ť����ʼ���ɼ�����¼��ɼ�
        jb1 = new JButton("��ʼ��Ϸ");
        jb1.setFont(new Font("΢���ź�", Font.PLAIN, 30));
        jb1.setForeground(Color.black);
        jb1.setBounds(260, 310, 290, 40);
        jb1.setHorizontalAlignment(JButton.CENTER);
        jb1.addActionListener(e -> startGame());
        jb1.setVisible(false); // ��ʼ���ɼ�
        this.getContentPane().add(jb1);

        // ��¼��ť
        loginButton = new JButton("��¼");
        loginButton.setFont(new Font("��������", Font.PLAIN, 20));
        loginButton.setBounds(200, 200, 150, 40);
        loginButton.addActionListener(e -> new LoginFrame(this)); // �򿪵�¼���ڲ���������
        this.getContentPane().add(loginButton);

        // ע�ᰴť
        registerButton = new JButton("ע��");
        registerButton.setFont(new Font("��������", Font.PLAIN, 20));
        registerButton.setBounds(450, 200, 150, 40);
        registerButton.addActionListener(e -> {
            try {
                new RegisterFrame(); // ��ע�ᴰ��
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.getContentPane().add(registerButton);

        // �û���Ϣ��ǩ��������ʾ��¼�����Ϸ��¼���߻�ӭ��Ϣ
        userInfoLabel = new JLabel("", SwingConstants.CENTER);
        userInfoLabel.setFont(new Font("��������", Font.PLAIN, 23));
        userInfoLabel.setForeground(Color.ORANGE);
        userInfoLabel.setBounds(100, 100, 600, 50);
        this.getContentPane().add(userInfoLabel);

        // ���ھ�����ʾ
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // ���µ�¼״̬����Ϸ��¼��Ϣ
    public void updateLoginState(boolean isLoggedIn, String username, int userid, String gameRecord) {
        this.isLoggedIn = isLoggedIn;
        this.username = username;
        this.userid = userid;
        this.gameRecord = gameRecord;
        refreshUI();
    }

    // ˢ�½���
    private void refreshUI() {
        // ���ص�¼��ע�ᰴť
        loginButton.setVisible(false);
        registerButton.setVisible(false);
        // ��ʾ�û���Ϸ��¼�� "START GAME" ��ť
        userInfoLabel.setText(gameRecord);
        jb1.setVisible(true);
    }

    // ��ʼ��Ϸ
    private void startGame() {
        // �رյ�ǰ���ڲ�����Ϸѡ�񴰿�
        dispose();
        try {
            new ChooseFrame(this.username, this.userid); // ��ѡ���
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
