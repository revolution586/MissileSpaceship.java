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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		updateMissile();
		updateSpaceShip();
		
		repaint();
	}
	
	private void updateMissiles() {
		List<Mis
		
		
			
		
