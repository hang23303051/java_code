package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import mario.Mario;
import mario.Mario2;
import ui.*;
import role.*;
import javax.swing.*;

/**
 * ���̰��¼����࣬���ڴ�����Ϸ����İ����¼���
 */
public class KeyListener extends KeyAdapter {

	// ��Ϸ��������ã����ڷ��ʺ��޸���Ϸ״̬
	public GameFrame gf;

	/**
	 * ���캯������ʼ����Ϸ�������á�
	 *
	 * @param gf ��Ϸ�������
	 */
	public KeyListener(GameFrame gf) {
		this.gf = gf;
	}

	/**
	 * ���̰����¼����������ڴ���ͬ�����İ��²�����
	 *
	 * @param e �����¼�
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
			// ������
			case 39: // Key code for the right arrow key
				gf.mario.right = true; // �����ź�λΪ�棬��ʾ�����ƶ�
				break;
			// ������
			case 37: // Key code for the left arrow key
				gf.mario.left = true; // �����ź�λΪ�棬��ʾ�����ƶ�
				break;
			// �����ӵ�
			case 32: // Key code for the space bar
				addBoom(); // ���÷����ӵ�����
				break;
			// ������Ծ
			case 38: // Key code for the up arrow key
				gf.mario.up = true; // �����ź�λΪ�棬��ʾ��Ծ
				break;
			// �ڶ�����ɫ��mario2��������
			case 68: // Key code for the 'D' key
				gf.mario2.right2 = true; // �����ź�λΪ�棬��ʾ�����ƶ�
				break;
			// �ڶ�����ɫ��mario2��������
			case 65: // Key code for the 'A' key
				gf.mario2.left2 = true; // �����ź�λΪ�棬��ʾ�����ƶ�
				break;
			// ��ͣ�������Ϸ
			case 80: // Key code for the 'P' key
				gf.setPaused(!gf.isPaused()); // �л���Ϸ��ͣ״̬
				if (gf.isPaused()) {
					JOptionPane.showMessageDialog(null, "��Ϸ����ͣ���� P ������", "��ͣ", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			// �ڶ�����ɫ��mario2�������ӵ�
			case 83: // Key code for the 'S' key
				addBoom2(); // ���÷����ӵ�����
				break;
			// �ڶ�����ɫ��mario2��������Ծ
			case 87: // Key code for the 'W' key
				gf.mario2.up2 = true; // �����ź�λΪ�棬��ʾ��Ծ
				break;
		}
	}

	/**
	 * ������ǵ��ӵ���
	 */
	public void addBoom() {
		Boom b = new Boom(gf.mario.x, gf.mario.y + 5, 10);
		if (gf.mario.left) {
			b.speed = -6; // �����ٶ�
		} else if (gf.mario.right) {
			b.speed = 6; // �����ٶ�
		} else {
			// �����ɫû���ƶ����жϽ�ɫ���һ�εĳ���
			b.speed = gf.mario.lastDirection == Mario.Direction.LEFT ? -6 : 6;
		}
		gf.boomList.add(b);
	}

	/**
	 * ��ӵڶ�����ɫ���ӵ���
	 */
	public void addBoom2() {
		Boom b2 = new Boom(gf.mario2.x2, gf.mario2.y2 + 5, 10);
		if (gf.mario2.left2) {
			b2.speed = -6; // �����ٶ�
		} else if (gf.mario2.right2) {
			b2.speed = 6; // �����ٶ�
		} else {
			// �����ɫû���ƶ����жϽ�ɫ���һ�εĳ���
			b2.speed = gf.mario2.lastDirection2 == Mario2.Direction.LEFT ? -6 : 6;
		}
		gf.boomList2.add(b2);
	}

	/**
	 * �����ͷ��¼����������ڴ���ͬ�������ͷŲ�����
	 *
	 * @param e �����¼�
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 39) { // �Ҽ�ͷ���ͷ�
			gf.mario.right = false; // �����ź�λΪ�٣�ֹͣ�����ƶ�
			gf.mario.img = new ImageIcon("image/mari1.png").getImage(); // �ָ���ɫ��Ĭ��ͼ��
		}
		if (code == 37) { // ���ͷ���ͷ�
			gf.mario.left = false; // �����ź�λΪ�٣�ֹͣ�����ƶ�
			gf.mario.img = new ImageIcon("image/mari_left1.png").getImage(); // �ָ���ɫ��Ĭ��ͼ��
		}
		if (code == 38) { // �ϼ�ͷ���ͷ�
			gf.mario.up = false; // �����ź�λΪ�٣�ֹͣ��Ծ
		}
		// �ڶ�����ɫ��mario2�����ͷŴ���
		if (code == 68) { // 'D' ���ͷ�
			gf.mario2.right2 = false; // �����ź�λΪ�٣�ֹͣ�����ƶ�
			gf.mario2.img2 = new ImageIcon("image/mario31.png").getImage(); // �ָ���ɫ��Ĭ��ͼ��
		}
		if (code == 65) { // 'A' ���ͷ�
			gf.mario2.left2 = false; // �����ź�λΪ�٣�ֹͣ�����ƶ�
			gf.mario2.img2 = new ImageIcon("image/mario2_left1.png").getImage(); // �ָ���ɫ��Ĭ��ͼ��
		}
		if (code == 87) { // 'W' ���ͷ�
			gf.mario2.up2 = false; // �����ź�λΪ�٣�ֹͣ��Ծ
		}
	}
}
