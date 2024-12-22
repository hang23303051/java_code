package role;

import java.awt.Image;
import java.awt.Rectangle;
import ui.GameFrame;

public class Mogu extends Enemy {
    private boolean isActive; // Ģ���Ƿ��ڳ�����
    public int speed = 2; // Ģ�����ƶ��ٶ�
    public boolean moveRight = true; // ��ʼ�����ƶ�

    public Mogu(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
        this.isActive = true;
    }

    // �ж��Ƿ񱻳Ե�
    public boolean isActive() {
        return isActive;
    }

    // Ģ�����Ե�
    public void consume() {
        isActive = false;
    }

    // Ģ�����ƶ��߼�
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
                break;
            }
        }

        // �߽���
        if (this.x <= 0 || this.x + this.width >= gf.getWidth()) {
            moveRight = !moveRight;
        }
    }

    // ��ȡĢ���ı߽�
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
}
