package arkanoid;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;





public class Arkanoid extends Canvas {
	
	private List<Actor> actors = new ArrayList<Actor>(); 
	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	public int posX, posY, vX;
	public long usedTime;
	public static final int SPEED_FPS=60;
	private BufferStrategy strategy;

	Pelota pelota = new Pelota();
	Nave nave = new Nave();
	Ladrillo ladrillo = new Ladrillo();
	public Arkanoid() {

		actors.add(pelota);
		actors.add(nave);
		
		JFrame ventana = new JFrame("arkanoid");
		JPanel panel = (JPanel) ventana.getContentPane();
		setBounds(0, 0, WIDTH, HEIGHT);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(new BorderLayout());
		panel.add(this, BorderLayout.CENTER);
		ventana.setBounds(0, 0, WIDTH, HEIGHT);
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setResizable(false);

		requestFocus();

	}

	private static Arkanoid instance = null;

	public static Arkanoid getInstance() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Actor actor : this.actors) {
			actor.paint(g);
			int contador = 12;
			for (int i = 0; i < 12; i++) {
				g.setColor(Color.red);
				g.fillRect(contador, 15, 29, 15);

				contador += 30;

			}
		}

	}
	public void initWorld() {
	
		for (int i = 0; i < 10; i++){
			Pelota p = new Pelota();
			p.setX((int)(Math.random() * (this.getWidth() - p.getWidth())) ); 
			p.setY(i * 20);
			p.setVx((int)(Math.random() * (20 - 2) + 2));}
		}
	public void updateWorld() {

		
		for (Actor actor : this.actors) {
			actor.act();}
		}
//		this.pelota.xventana += velox;
//		this.pelota.yventana += veloy;
		
	//	}
//		strategy.show();
		
//	}

	public void game() {
		
		initWorld();
		
		
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();
			repaint();
			
			
			usedTime = System.currentTimeMillis()-startTime;

			try { 
				int millisToSleep = (int) (1000/SPEED_FPS - usedTime);
				if (millisToSleep < 0) {
					millisToSleep = 0;
				}
				Thread.sleep(millisToSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
