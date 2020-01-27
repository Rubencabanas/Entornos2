package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.imageio.ImageIO;

public class Nave extends Actor {

	private static Nave instance = null;

	public void paint(Graphics g) {
		g.drawImage(SpritesRepository.getInstance().getSprite(SpritesRepository.nave), 200, 530, null);

	}

	public static Nave getInstance() {
		if (instance == null) {
			instance = new Nave();
		}
		return instance;
	}
}