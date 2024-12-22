package role;

import ui.GameFrame;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Turtle extends Enemy {
    public int speed = 2; // �ڹ���ƶ��ٶ�
    public boolean moveRight = true; // ��ʼ�����ƶ�
    public boolean isDead = false; // �ж��ڹ��Ƿ񱻻���

    // �ڹ��ͼƬ
    private Image rightImage;
    private Image leftImage;

    public Turtle(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
        // ��ʼ���ڹ��ͼƬ
        this.rightImage = new ImageIcon("image/Ltortoise2right.png").getImage();
        this.leftImage = new ImageIcon("image/Ltortoise2.png").getImage();
        this.img = rightImage; // Ĭ�������ƶ���ͼƬ
    }

    // �ڹ���ƶ��߼�
    public void move() {
        if (moveRight) {
            this.x += speed;
        } else {
            this.x -= speed;
        }
    }

    // ����Ƿ������ϰ����߽磬�����ƶ�
    public void checkCollision(GameFrame gf) {
        for (Enemy e : gf.eneryList) {
            if (e != this && this.getBounds().intersects(e.getBounds())) {
                moveRight = !moveRight; // ��ײ�����ƶ�
                updateImage(); // ����ͼƬ����
                break;
            }
        }

        // �߽���
        if (this.x <= 0 || this.x + this.width >= gf.getWidth()) {
            moveRight = !moveRight;
            updateImage(); // ����ͼƬ����
        }
    }

    // �����ڹ��ͼƬ����
    private void updateImage() {
        if (moveRight) {
            this.img = rightImage; // �����ƶ�ʱʹ������ͼƬ
        } else {
            this.img = leftImage; // �����ƶ�ʱʹ������ͼƬ
        }
    }

    // ����Ƿ��ӵ�����
    public boolean isHitByBullet(ArrayList<Boom> boomList) {
        for (Boom boom : boomList) {
            if (this.getBounds().intersects(boom.getBounds())) {
                isDead = true;
                return true; // ���ӵ�����
            }
        }
        return false;
    }

    // ��ȡ�ڹ�ı߽�
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
}
