package arkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {

	private static Pelota instance = null;
	protected int vx = 4;
	protected int vy = 4;

	public Pelota() {
		super();
		x=100;
		y=100;
	}

	public void act() {
		super.act();
		
		this.x += this.vx;
		if (this.x < 0 || this.x > (Arkanoid.getInstance().getWidth() - this.getWidth())) {
			vx = -vx;
		}

		this.y += this.vy;
		if (this.y < 0 || this.y > (Arkanoid.getInstance().getHeight() - this.getHeight())) {
			vy = -vy;
		}
		
		System.out.println("act Pelota x: " + x + " y:" + y);
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	public void paint(Graphics g) {
		System.out.println("paint x: "+ this.x + " y: " + this.y);
		g.setColor(Color.white);
		g.fillOval(this.x, this.y, 10, 10);
	}

	public static Pelota getInstance() {
		if (instance == null) {
			instance = new Pelota();
		}
		return instance;
	}
}
