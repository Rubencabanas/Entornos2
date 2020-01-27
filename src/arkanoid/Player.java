package arkanoid;

public class Player extends Actor {

	protected int vx;
	protected int vy;

	public Player() {
		super();
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
}
