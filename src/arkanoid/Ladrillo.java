package arkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Actor {
// comentario
	private static Ladrillo instance = null;

	public void paint(Graphics g, Color color) {

		int contador = 12;
		for (int i = 0; i < 12; i++) {
			g.setColor(color);
			g.fillRect(contador, 15, 29, 15);

			contador += 30;

		}

	}

	public static Ladrillo getInstance() {
		if (instance == null) {
			instance = new Ladrillo();
		}
		return instance;
	}

}
