package role;
import java.awt.Image;

//�����
public class Coin extends Enemy {
	private boolean isCollected = false; // �������ԣ���ʶ����Ƿ��ѱ��ռ�
	private boolean showSun = false; // �������ԣ���ʶ�Ƿ���ʾ̫��
	public Coin(int x, int y, int width, int height, Image img) {
		super(x, y, width, height, img);
	}
	public boolean isCollected() {
		return isCollected;
	}

	public void setCollected(boolean collected) {
		isCollected = collected;
	}
	public boolean isShowSun() {
		return showSun;
	}

	public void setShowSun(boolean showSun) {
		this.showSun = showSun;
	}
}

