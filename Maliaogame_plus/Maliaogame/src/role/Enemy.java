package role;
import java.awt.Image;
import java.awt.Rectangle;
//�ϰ���ĳ�����
public abstract class Enemy {
	public int x,y;
	public int width,height;
	public Image img;
	public Enemy(int x, int y, int width, int height, Image img) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img=img;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	//�޸�ͼƬ�������������ײ��ı仯
	public void setImg(Image img) {
		this.img=img;
	}
	public Image getImg() {
		return img;
	}
}