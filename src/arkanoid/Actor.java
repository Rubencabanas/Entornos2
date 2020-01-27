package arkanoid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Actor {
	protected int x, y;
	protected int width, height;
	protected List<BufferedImage> sprites = new ArrayList<BufferedImage>();
	protected BufferedImage spriteActual = null;
	private int unidadDeTiempo = 0;
	protected int velocidadDeCambioDeSprite = 0;

	public Actor() {
	}

	public Actor(String spriteNames[]) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}

	public Actor(String spriteNames[], int velocidadDeCambioDeSprite) {
		this.velocidadDeCambioDeSprite = velocidadDeCambioDeSprite;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}

	private void cargarImagenesDesdeSpriteNames(String spriteNames[]) {

		for (String sprite : spriteNames) {
			this.sprites.add(SpritesRepository.getInstance().getSprite(sprite));
		}
		// ajusto el primer sprite del actor
		if (this.sprites.size() > 0) {
			this.spriteActual = this.sprites.get(0);
		}
		adjustHeightAndWidth();
	}

	private void adjustHeightAndWidth() {

		if (this.sprites.size() > 0) {
			this.height = this.sprites.get(0).getHeight();
			this.width = this.sprites.get(0).getWidth();
		}
		for (BufferedImage sprite : this.sprites) {

			if (sprite.getWidth() > this.width) {
				this.width = sprite.getWidth();
			}

			if (sprite.getHeight() > this.height) {
				this.height = sprite.getHeight();
			}
		}
	}

	public void paint(Graphics g) {
		g.drawImage(this.spriteActual, this.x, this.y, null);
	}

	public void act() {

		System.out.println("act de Actor");
		
		if (this.sprites != null && this.sprites.size() > 0) {

			unidadDeTiempo++;

			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0) {

				unidadDeTiempo = 0;

				int indiceSpriteActual = sprites.indexOf(this.spriteActual);

				int indiceSiguienteSprite = (indiceSpriteActual + 1) % sprites.size();

				this.spriteActual = sprites.get(indiceSiguienteSprite);
			}
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getSpriteActual() {
		return spriteActual;
	}

	public void setSpriteActual(BufferedImage spriteActual) {
		this.spriteActual = spriteActual;
	}

	public int getVelocidadDeCambioDeSprite() {
		return velocidadDeCambioDeSprite;
	}

	public void setVelocidadDeCambioDeSprite(int velocidadDeCambioDeSprite) {
		this.velocidadDeCambioDeSprite = velocidadDeCambioDeSprite;
	}

}
