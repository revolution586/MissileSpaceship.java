package MissileSpaceShip;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent;
import java.util.List;
import java.swing.JPanel;
import java.swing.Timer;

public class Board extends JPanel implements ActionListener {
    
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int DELAY = 10;
    private Timer timer;
    private SpaceShip spaceShip;
    
    public Board() {
        
        initBoard();
	}
	
	private	void initBoard() {
		
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);
		
		spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
					  spaceShip.getY(), this);
		
		List<Missiles> missiles = spaceShip.getMissiles();
		
		for (Missile missile: missiles) {
			
		g2d.drawImage(missile.getImage(), missile.getX(),
					  missile.getY(), this);
		}
	}
//In the doDrawing() method, we draw the craft and all the available missiles//
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		updateMissile();
		updateSpaceShip();
		
		repaint();
	}
	
	private void updateMissiles() {
		List<Missile> missiles = spaceShip.getMissiles();
		
		for (int i = 0; i < misiles.size(); i++) {
			Missile missile = missiles.get(i);
			
			if (missiles.isVisible()) {
				
				missile.move();
			} else {
				missiles.remove(i);
			}
		}
	}

//In the updateMissiles() method we parse all missiles from the missiles list//
//Depending on what the isVisible() method returns, we either move the missile or remove it from the container//
	
	private void updateSpaceShip() {
		
		spaceShip.move();
	}
	
	private class TAdapter extends keyAdapter {
		
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			spaceShip.keyPressedd(e);
		}
	}
}
			
			
		
		
			
		
