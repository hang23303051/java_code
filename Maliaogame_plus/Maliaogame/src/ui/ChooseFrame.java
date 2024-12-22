package ui;

import util.KeyListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 * ChooseFrame����һ������ѡ����Ϸ�ؿ��Ĵ��ڡ�
 * ����չ��JFrame����ʵ����ActionListener�ӿ�������ť����¼���
 */
public class ChooseFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L; // ���л�ID
    private JButton[] buttons; // ��ť�������ڴ洢�ؿ���ť
    private int userid; // �û�ID
    private String username; // �û���

    /**
     * �������Ĺ��캯�������ڳ�ʼ��ѡ�񴰿ڡ�
     *
     * @param username �û���
     * @param userid �û�ID
     * @throws Exception ��������쳣
     */
    public ChooseFrame(String username, int userid) throws Exception {
        this.userid = userid; // ��ʼ���û�ID
        this.username = username; // ��ʼ���û���

        // ��ʼ�������������
        this.setSize(800, 450); // ���ô��ڴ�С
        this.setTitle("��������"); // ���ô��ڱ���
        this.setResizable(false); // ��ֹ�������ڴ�С
        this.getContentPane().setLayout(null); // ʹ�þ��Բ���

        // ���ñ���ͼƬ����Ӱ�찴ť���
        JPanel myPanel = (JPanel) this.getContentPane();
        myPanel.setOpaque(false); // ʹ���͸��

        ImageIcon icon = new ImageIcon("image/mario1.jpg"); // ��ȡ����ͼƬ
        JLabel label = new JLabel(icon); // ʹ��JLabel��ʾͼƬ
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // ����ͼƬ��С�봰��ƥ��
        icon.setImage(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)); // ƽ������ͼƬ
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // ��ӱ���ͼƬ��������

        // ���尴ť�ı�����ɫ
        Color mycolor = new Color(190, 141, 41);

        // ��ʼ����ť����
        buttons = new JButton[5];
        Font buttonFont = new Font("��������", Font.PLAIN, 30); // ��ť����

        // ʹ��ѭ�����������ö����ť
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1)); // ��ť�ı�Ϊ�ؿ����
            buttons[i].setFont(buttonFont); // ���ð�ť����
            buttons[i].setForeground(Color.yellow); // ���ð�ťǰ��ɫ
            buttons[i].setBackground(mycolor); // ���ð�ť����ɫ
            buttons[i].setBounds(10 + 101 * i, 95, 65, 65); // ���ð�ťλ�úʹ�С
            buttons[i].setHorizontalAlignment(JButton.CENTER); // ���ð�ť�ı�����
            buttons[i].addActionListener(this); // Ϊ��ť��Ӷ�������
            this.getContentPane().add(buttons[i]); // ����ť��ӵ��������
        }

        // ���ô��ھ�����ʾ
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Ĭ�Ϲ��캯����
     */
    public ChooseFrame() {
    }

    /**
     * ��д�Ķ����¼���������
     * ���ݰ�ť�Ķ�������ִ�в�ͬ�Ĳ�����
     *
     * @param e �����¼�����
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int level = Integer.parseInt(command); // ����ť�Ķ�������ת��Ϊ�����Ա�ʾ�ؿ�

        dispose(); // �رյ�ǰ����
        try {
            // ����һ���µ���Ϸ���ڣ���Ϊ����Ӽ��̼�����
            GameFrame g = new GameFrame(level, this.userid, this.username);
            KeyListener kl = new KeyListener(g);
            g.addKeyListener(kl);
        } catch (Exception e1) {
            e1.printStackTrace(); // ��ӡ�쳣��Ϣ
        }
    }
}
