package mario;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import role.*;
import ui.GameFrame;

public class Mario2 extends Thread {
	public GameFrame gf;
	public boolean jumpFlag2 = true;
	public int blood2 = 3;
	public int score2 = 0;
	public int x2 = 50, y2 = 358;
	public int xspeed2 = 4, yspeed2 = 1;
	public boolean speedUp2 = false; // ���ٱ�ʶ
	public int width2 = 30, height2 = 32;
	public Image img2 = new ImageIcon("image/mario31.png").getImage();
	public boolean left2 = false, right2 = false, down2 = false, up2 = false;
	public String Dir_Up2 = "Up2", Dir_Left2 = "Left2", Dir_Right2 = "Right2", Dir_Down2 = "Down2";

	// ���һ���ֶ�����¼�����ƶ�����
	public enum Direction { LEFT, RIGHT };
	public Direction lastDirection2 = Direction.RIGHT; // ��ʼ����

	public Mario2(GameFrame gf) {
		this.gf = gf;
		this.Gravity();
	}

	public void run() {
		while (true) {
			if (left2) {
				lastDirection2= Mario2.Direction.LEFT; // ���������
				if (!speedUp2) {
					this.xspeed2 = 5; // �����ٶ�
				}
				if (hit(Dir_Left2)) {
					this.xspeed2 = 0; // �����ײ��ֹͣ
				}
				if (this.x2 >= 0) {
					this.x2 -= this.xspeed2; // �����ƶ�
					this.img2 = new ImageIcon("image/mario2_left.gif").getImage(); // ����ͼ��
				}
			}

			if (right2) {
				lastDirection2 = Mario2.Direction.RIGHT; // ���������
				if (hit(Dir_Right2)) {
					this.xspeed2 = 0; // �����ײ��ֹͣ
				}
				if (this.x2 < 600) {
					this.x2 += this.xspeed2; // �����ƶ�
					this.img2 = new ImageIcon("image/mario2_right.gif").getImage(); // ����ͼ��
				}
				if (this.x2 >= 600) {
					gf.bg.x -= this.xspeed2; // �ƶ�����
					if (gf.bg.x == -6500) {
						gf.bg.endflag = true; // ����ؿ�ĩβ
					}
					for (int i = 0; i < gf.eneryList.size(); i++) {
						Enemy enery = gf.eneryList.get(i);
						enery.x -= this.xspeed2; // �ƶ����е���
					}
					gf.mario.x -= this.xspeed2; // �ƶ��ڶ��������
					this.img2 = new ImageIcon("image/mario2_right.gif").getImage(); // ����ͼ��
				}
				this.xspeed2 = 5; // �����ٶ�
			}

			if (up2) {
				if (jumpFlag2 && !isGravity2) {
					jumpFlag2 = false;
					new Thread(() -> {
						jump(); // ִ����Ծ����
						jumpFlag2 = true;
					}).start();
				}
			}

			try {
				this.sleep(20); // ����ѭ���ٶ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void jump() {
		int jumpHeigh2 = 0;
		for (int i = 0; i < 150; i++) {
			gf.mario2.y2 -= this.yspeed2;
			jumpHeigh2++;
			if (hit(Dir_Up2)) {
				break;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < jumpHeigh2; i++) {
			gf.mario2.y2 += this.yspeed2;
			if (hit(Dir_Down2)) {
				this.yspeed2 = 0;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.yspeed2 = 1;
	}

	public void setPaused(boolean isPaused) {
		if (isPaused) {
			this.xspeed2 = 0;
		} else {
			this.xspeed2 = 5;
		}
	}

	public boolean hit(String dir) {
		Rectangle myrect = new Rectangle(this.x2, this.y2, this.width2, this.height2);
		Rectangle rect = null;

		for (int i = 0; i < gf.eneryList.size(); i++) {
			Enemy enery = gf.eneryList.get(i);

			if (dir.equals("Left2")) {
				rect = new Rectangle(enery.x + 5, enery.y, enery.width, enery.height);
			} else if (dir.equals("Right2")) {
				rect = new Rectangle(enery.x - 5, enery.y, enery.width, enery.height);
			} else if (dir.equals("Up2")) {
				rect = new Rectangle(enery.x, enery.y + 2, enery.width, enery.height);
			} else if (dir.equals("Down2")) {
				rect = new Rectangle(enery.x, enery.y - 2, enery.width, enery.height);
			}

			if (myrect.intersects(rect) && dir.equals("Up2")) {
				if (enery instanceof Coin) {
					Coin coin = (Coin) enery;
					if (!coin.isCollected()) {
						coin.setCollected(true); // ����Ϊ���ռ�״̬
						coin.img = new ImageIcon("image/coin_brick_null.png").getImage(); // �޸�ͼƬ
						score2=gf.score2;
						score2++; // ���ӵ÷�
						gf.score2 = score2;
						System.out.println("�÷����ӣ���ǰ������" + score2);
						// ��ʾ̫��ͼƬ
						coin.setShowSun(true);
						Timer timer = new Timer(200, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								coin.setShowSun(false); // ����̫��ͼƬ
								gf.repaint(); // ˢ�½�������ʧ̫��ͼ��
							}
						});
						timer.setRepeats(false);
						timer.start();
					}
					return true;
				}
			} else if (myrect.intersects(rect) && dir.equals("Down2")) {
				if (enery.getClass() == Wave.class) {
					gf.hitflag2 = true;
				}
				return true;
			}

			if (myrect.intersects(rect)) {
				if (enery.getClass() == Mogu.class) {
					score2 += 10;
					gf.score2 = score2;
					gf.eneryList.remove(i);
					System.out.println("�Ե�Ģ������10��");
				}
				return true;
			}
		}

		return false;
	}

	public boolean isGravity2 = false;

	public void Gravity() {
		new Thread(() -> {
            while (true) {
                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    if (!jumpFlag2) {
                        break;
                    }

                    if (hit(Dir_Down2)) {
                        break;
                    }

                    if (y2 >= 358) {
                        isGravity2 = false;
                    } else {
                        isGravity2 = true;
                        y2 += yspeed2;
                    }

                    try {
                        sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
	}
}
