
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameScreen extends JFrame {

    public GameScreen(String title) throws HeadlessException {
        super(title);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        GameScreen Screen = new GameScreen("Flying Chicken");
        
        Screen.setResizable(false);
        Screen.setFocusable(false);
        Screen.setSize(1000,825); //Size of the Frame
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        BufferedImage inp = ImageIO.read(new FileImageInputStream(new File("inp.png")));
        
        JPanel start = new JPanel();
        
        JLabel im = new JLabel(new ImageIcon(inp.getScaledInstance(1000, 825, Image.SCALE_FAST)));
        
        start.add(im);
        Screen.add(start);
        
        Screen.setVisible(true);
        
        start.addMouseListener(new MouseAdapter() {
            
        	public void mouseClicked(MouseEvent e) {
        		int x = e.getX();
        		int y = e.getY();
                if (x > 742 && x < 890 && y > 230 && y < 336) {
                	
                	Screen.getContentPane().removeAll();
                	
                	Game game = new Game();
                    game.requestFocus();
                    game.addKeyListener(game);
                    game.setFocusable(true);
                    game.setFocusTraversalKeysEnabled(false);
                    
                    Screen.add(game);
                    Screen.validate();
                    
                    game.requestFocus();
                }
            }
        });
        
    }
    
}