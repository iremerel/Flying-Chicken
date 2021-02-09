
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(170,this);
    
    private Level level_1;
    private Level level_2;
    private Level level_3;
    private int level;
    private int eggnum1 = 10;
    private int eggnum2 = 15;
    private int eggnum3 = 20;
    private int point;
    private int p_1;
    private int p_2;
    private int p_3;
    private Target first;
    private Target second;
    private Target third;
    private BufferedImage grass;
    private BufferedImage sides;

    public Game() {
        
        level_1 = new Level(10, 10, 5);
        level_2 = new Level(15, 12, 7);
        level_3 = new Level(20, 14, 9);
        
        first = new Target(3, 600, 1);
        second = new Target(5, 500, 2);
        third = new Target(5, 420, 3);
                
        level = 1;
        point = 0;
        p_1 = 0;
        p_2 = 0;
        p_3 = 0;
        
        setBackground(Color.DARK_GRAY);
        
        try {
			grass = ImageIO.read(new FileImageInputStream(new File("grass.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			sides = ImageIO.read(new FileImageInputStream(new File("odun.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        timer.start();
    }
    
    public boolean cat_chicken() {
        
        if(level==1)    
            for (Cat cat : level_1.cats) {

                if(new Rectangle(cat.getX(), cat.getY()+12, 49, 34).intersects(new Rectangle(level_1.chicken.getX()+7, level_1.chicken.getY()+20, 48, 40)))
                    return true;

            }
        
        else if(level==2)    
            for (Cat cat : level_2.cats) {

                if(new Rectangle(cat.getX(), cat.getY()+12, 49, 34).intersects(new Rectangle(level_2.chicken.getX()+7, level_2.chicken.getY()+20, 48, 40)))
                    return true;

            }
        
        else if(level==3)    
            for (Cat cat : level_3.cats) {

                if(new Rectangle(cat.getX(), cat.getY()+12, 49, 34).intersects(new Rectangle(level_3.chicken.getX()+7, level_3.chicken.getY()+20, 48, 40)))
                    return true;

            }
        
        return false;
    }
    
    public void egg_target() {
        
        if(level == 1) {
            
            for(int i = 0; i < level_1.targets.size(); i++)  {
                
                for(int j = 0; j < level_1.shotsA.size(); j++) {
                    if(new Rectangle(level_1.targets.get(i).getX()+5,level_1.targets.get(i).getY()+10, 63, 63).intersects(new Rectangle(level_1.shotsA.get(j).getX()+1, level_1.shotsA.get(j).getY()+1, 17, 22))) {
                        point += level_1.targets.get(i).getWhich();
                        p_1 += level_1.targets.get(i).getWhich();
                        
                        level_1.targets.remove(i);
                        level_1.shotsA.remove(j);
                    }
                } 
            }
            
            for(int i = 0; i < level_1.targets.size(); i++)  {
                
                for(int j = 0; j < level_1.shotsD.size(); j++) {
                    if(new Rectangle(level_1.targets.get(i).getX()+5,level_1.targets.get(i).getY()+10, 63, 63).intersects(new Rectangle(level_1.shotsD.get(j).getX()+1, level_1.shotsD.get(j).getY()+1, 17, 22))) {
                        point += level_1.targets.get(i).getWhich();
                        p_1 += level_1.targets.get(i).getWhich();
                        
                        level_1.targets.remove(i);
                        level_1.shotsD.remove(j);
                    }
                } 
            }
        }
        
        else if(level == 2) {
            
            for(int i = 0; i < level_2.targets.size(); i++)  {
                
                for(int j = 0; j < level_2.shotsA.size(); j++) {
                    if(new Rectangle(level_2.targets.get(i).getX()+5,level_2.targets.get(i).getY()+10, 63, 63).intersects(new Rectangle(level_2.shotsA.get(j).getX()+1, level_2.shotsA.get(j).getY()+1, 17, 22))) {
                        point += level_2.targets.get(i).getWhich();
                        p_2 += level_2.targets.get(i).getWhich();
                        
                        level_2.targets.remove(i);
                        level_2.shotsA.remove(j);
                    }
                } 
            }
            
            for(int i = 0; i < level_2.targets.size(); i++)  {
                
                for(int j = 0; j < level_2.shotsD.size(); j++) {
                    if(new Rectangle(level_2.targets.get(i).getX()+5,level_2.targets.get(i).getY()+10, 63, 63).intersects(new Rectangle(level_2.shotsD.get(j).getX()+1, level_2.shotsD.get(j).getY()+1, 17, 22))) {
                        point += level_2.targets.get(i).getWhich();
                        p_2 += level_2.targets.get(i).getWhich();
                        
                        level_2.targets.remove(i);
                        level_2.shotsD.remove(j);
                    }
                } 
            }
        }
        
        else if(level == 3) {
            
            for(int i = 0; i < level_3.targets.size(); i++)  {
                
                for(int j = 0; j < level_3.shotsA.size(); j++) {
                    if(new Rectangle(level_3.targets.get(i).getX()+5,level_3.targets.get(i).getY()+10, 63, 63).intersects(new Rectangle(level_3.shotsA.get(j).getX()+1, level_3.shotsA.get(j).getY()+1, 17, 22))) {
                        point += level_3.targets.get(i).getWhich();
                        p_3 += level_3.targets.get(i).getWhich();
                        
                        level_3.targets.remove(i);
                        level_3.shotsA.remove(j);
                    }
                } 
            }
            
            for(int i = 0; i < level_3.targets.size(); i++)  {
                
                for(int j = 0; j < level_3.shotsD.size(); j++) {
                    if(new Rectangle(level_3.targets.get(i).getX()+5,level_3.targets.get(i).getY()+10, 63, 63).intersects(new Rectangle(level_3.shotsD.get(j).getX()+1, level_3.shotsD.get(j).getY()+1, 17, 22))) {
                        point += level_3.targets.get(i).getWhich();
                        p_3 += level_3.targets.get(i).getWhich();
                        
                        level_3.targets.remove(i);
                        level_3.shotsD.remove(j);
                    }
                } 
            }
        }
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*
            int a = 144+77;
            
            g.setColor(Color.GRAY);
            
            for (int i = 0; i < 8; i++) {
            
            g.fillRect(a, 0, 5, 800);
            a+=77;
            }
            
            int b = 0;
            
            for (int i = 0; i < 12; i++) {
            
            g.fillRect(144, b, 835-144, 5);
            b+=77;
            }
        */
        
        g.setColor(Color.BLACK);
        
        g.drawImage(grass, 144, 0, 691, 800, this);
        
        g.drawImage(sides,  0, 0, 144, 800, this);
        
        g.drawImage(sides,  835, 0, 200, 800, this);
        
        g.fillRect(144, 0, 5, 800);
        g.fillRect(835, 0, 5, 800);
        
        g.setColor(Color.WHITE);
        
        g.setFont(new Font("Arial", Font.BOLD, 13));
        
        g.drawImage(first.getImage(), first.getX(), first.getY(), first.getImage().getWidth()/first.getRate(), first.getImage().getHeight()/first.getRate(), this);
        g.drawString("+ 50 POINT", 75, 650);
        
        g.drawImage(second.getImage(), second.getX(), second.getY(), second.getImage().getWidth()/second.getRate(), second.getImage().getHeight()/second.getRate(),this);
        g.drawString("+ 30 POINT", 70, 550);
        
        g.drawImage(third.getImage(), third.getX(), third.getY(), third.getImage().getWidth()/third.getRate(), third.getImage().getHeight()/third.getRate(), this);
        g.drawString("+ 20 POINT", 70, 470);
        
        if(level == 1) {
            g.drawImage(level_1.chicken.getImage(), level_1.chicken.getX(), level_1.chicken.getY(), level_1.chicken.getImage().getWidth()/8, level_1.chicken.getImage().getHeight()/8, this);
        
            for(Target target : level_1.targets) {
                g.drawImage(target.getImage(), target.getX(), target.getY(), target.getImage().getWidth()/target.getRate(), target.getImage().getHeight()/target.getRate(), this);
            }
            
            for(Cat cat : level_1.cats) {
                g.drawImage(cat.getImage(), cat.getX(), cat.getY(), cat.getImage().getWidth()/2, cat.getImage().getHeight()/2, this);
            }
            
            for(int i = 0; i < level_1.shotsA.size(); i++) {
                if(level_1.shotsA.get(i).getX() < 160)
                    level_1.shotsA.remove(i);
            }

            for(int i = 0; i < level_1.shotsD.size(); i++) {
                if(level_1.shotsD.get(i).getX() > 800)
                    level_1.shotsD.remove(i);
            }

            for(Shot shot : level_1.shotsA) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), shot.getImage().getWidth()/15, shot.getImage().getHeight()/15, this);
            }

            for(Shot shot : level_1.shotsD) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), shot.getImage().getWidth()/15, shot.getImage().getHeight()/15, this);
            }
            
            Color brown = new Color(139,69,19);
            g.setColor(brown);
            g.fillRect(5, 20, 135, 70);
            
            g.fillRect(845, 60, 145, 30);
            
            g.setColor(Color.WHITE);
            g.drawString("LEVEL 1", 10, 40);
            g.drawString("TOTAL POINT = " + point, 10, 60);
            g.drawString("POINT = " + p_1, 10, 80);
            g.drawString("Remaining Eggs  = " + eggnum1, 850, 80);
            
        }
        
        else if(level == 2) {
            g.drawImage(level_2.chicken.getImage(), level_2.chicken.getX(), level_2.chicken.getY(), level_2.chicken.getImage().getWidth()/8, level_2.chicken.getImage().getHeight()/8, this);
        
            for(Target target : level_2.targets) {
                g.drawImage(target.getImage(), target.getX(), target.getY(), target.getImage().getWidth()/target.getRate(), target.getImage().getHeight()/target.getRate(), this);
            }
            
            for(Cat cat : level_2.cats) {
                g.drawImage(cat.getImage(), cat.getX(), cat.getY(), cat.getImage().getWidth()/2, cat.getImage().getHeight()/2, this);
            }
            
            for(int i = 0; i < level_2.shotsA.size(); i++) {
                if(level_2.shotsA.get(i).getX() < 160)
                    level_2.shotsA.remove(i);
            }

            for(int i = 0; i < level_2.shotsD.size(); i++) {
                if(level_2.shotsD.get(i).getX() > 800)
                    level_2.shotsD.remove(i);
            }

            for(Shot shot : level_2.shotsA) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), shot.getImage().getWidth()/15, shot.getImage().getHeight()/15, this);
            }

            for(Shot shot : level_2.shotsD) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), shot.getImage().getWidth()/15, shot.getImage().getHeight()/15, this);
            }
            
            Color brown = new Color(139,69,19);
            g.setColor(brown);
            g.fillRect(5, 20, 135, 70);
            
            g.fillRect(845, 60, 145, 30);
            
            g.setColor(Color.WHITE);
            g.drawString("LEVEL 2", 10, 40);
            g.drawString("TOTAL POINT = " + point, 10, 60);
            g.drawString("POINT = " + p_2, 10, 80);
            g.drawString("Remaining Eggs  = " + eggnum2, 850, 80);
            
        }
        
        else if(level == 3) {
            g.drawImage(level_3.chicken.getImage(), level_3.chicken.getX(), level_3.chicken.getY(), level_3.chicken.getImage().getWidth()/8, level_3.chicken.getImage().getHeight()/8, this);
        
            for(Target target : level_3.targets) {
                g.drawImage(target.getImage(), target.getX(), target.getY(), target.getImage().getWidth()/target.getRate(), target.getImage().getHeight()/target.getRate(), this);
            }
            
            for(Cat cat : level_3.cats) {
                g.drawImage(cat.getImage(), cat.getX(), cat.getY(), cat.getImage().getWidth()/2, cat.getImage().getHeight()/2, this);
            }
            
            for(int i = 0; i < level_3.shotsA.size(); i++) {
                if(level_3.shotsA.get(i).getX() < 160)
                    level_3.shotsA.remove(i);
            }

            for(int i = 0; i < level_3.shotsD.size(); i++) {
                if(level_3.shotsD.get(i).getX() > 800)
                    level_3.shotsD.remove(i);
            }

            for(Shot shot : level_3.shotsA) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), shot.getImage().getWidth()/15, shot.getImage().getHeight()/15, this);
            }

            for(Shot shot : level_3.shotsD) {
                g.drawImage(shot.getImage(), shot.getX(), shot.getY(), shot.getImage().getWidth()/15, shot.getImage().getHeight()/15, this);
            }
            
            Color brown = new Color(139,69,19);
            g.setColor(brown);
            g.fillRect(5, 20, 135, 70);
            
            g.fillRect(845, 60, 145, 30);
            
            g.setColor(Color.WHITE);
            g.drawString("LEVEL 3", 10, 40);
            g.drawString("TOTAL POINT = " + point, 10, 60);
            g.drawString("POINT = " + p_3, 10, 80);
            g.drawString("Remaining Eggs  = " + eggnum3, 850, 80);
            
        }
        
        if(cat_chicken()) {
            
            timer.stop();
            String message = "GAME OVER\nTry Again";
            
            JOptionPane.showMessageDialog(this, message);
            
            System.exit(0);
        }
        
        egg_target();
    }

    @Override
    public void repaint() {
        super.repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int c = e.getKeyCode();
        
        if(level == 1) {
        
            if (c == KeyEvent.VK_RIGHT) {

                if(level_1.chicken.getX() < 758)
                    level_1.chicken.setX(level_1.chicken.getX()+39);
            }

            else if (c == KeyEvent.VK_LEFT) {

                if(level_1.chicken.getX() > 150)
                    level_1.chicken.setX(level_1.chicken.getX()-39);

            }

            else if (c == KeyEvent.VK_A) {

                if(eggnum1 != 0) {
                    level_1.shotsA.add(new Shot(level_1.chicken.getX()+28,level_1.chicken.getY()+10));
                    eggnum1--;
                }

            }

            else if (c == KeyEvent.VK_D) {

                if(eggnum1 != 0) {
                    level_1.shotsD.add(new Shot(level_1.chicken.getX()+10,level_1.chicken.getY()+10));
                    eggnum1--;
                }
            }
        }
        
        if(level == 2) {
        
            if (c == KeyEvent.VK_RIGHT) {

                if(level_2.chicken.getX() < 758)
                    level_2.chicken.setX(level_2.chicken.getX()+39);
            }

            else if (c == KeyEvent.VK_LEFT) {

                if(level_2.chicken.getX() > 150)
                    level_2.chicken.setX(level_2.chicken.getX()-39);

            }

            else if (c == KeyEvent.VK_A) {

                if(eggnum2 != 0) {
                    level_2.shotsA.add(new Shot(level_2.chicken.getX()+28,level_2.chicken.getY()+10));
                    eggnum2--;
                }

            }

            else if (c == KeyEvent.VK_D) {

                if(eggnum2 != 0) {
                    level_2.shotsD.add(new Shot(level_2.chicken.getX()+10,level_2.chicken.getY()+10));
                    eggnum2--;
                }
            }
        }
        
        if(level == 3) {
        
            if (c == KeyEvent.VK_RIGHT) {

                if(level_3.chicken.getX() < 758)
                    level_3.chicken.setX(level_3.chicken.getX()+39);
            }

            else if (c == KeyEvent.VK_LEFT) {

                if(level_3.chicken.getX() > 150)
                    level_3.chicken.setX(level_3.chicken.getX()-39);

            }

            else if (c == KeyEvent.VK_A) {

                if(eggnum3 != 0) {
                    level_3.shotsA.add(new Shot(level_3.chicken.getX()+28,level_3.chicken.getY()+10));
                    eggnum3--;
                }

            }

            else if (c == KeyEvent.VK_D) {

                if(eggnum3 != 0) {
                    level_3.shotsD.add(new Shot(level_3.chicken.getX()+10,level_3.chicken.getY()+10));
                    eggnum3--;
                }
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(level == 1) {
            for(Shot shot : level_1.shotsA) {
                shot.setX(shot.getX()-25);
                shot.setY(shot.getY()+8);
            }

            for(Shot shot : level_1.shotsD) {
                shot.setX(shot.getX()+25);
                shot.setY(shot.getY()+8);
            }
            
            if(level_1.chicken.getY() >= 740) {

                if(p_1 < 70) {
                    
                    timer.stop();
                    String message = "You couldn't get 70 points\n" 
                            + "GAME OVER\n"
                            + "Try Again\n";

                    JOptionPane.showMessageDialog(this, message);

                    System.exit(0);
                }
                
                level++;

            }

            else
                level_1.chicken.setY(level_1.chicken.getY() + 5);
        }
        
        else if(level == 2) {
            for(Shot shot : level_2.shotsA) {
                shot.setX(shot.getX()-25);
                shot.setY(shot.getY()+8);
            }

            for(Shot shot : level_2.shotsD) {
                shot.setX(shot.getX()+25);
                shot.setY(shot.getY()+8);
            }
            
            if(level_2.chicken.getY() >= 740) {

                if(p_2 < 110) {
                    
                    timer.stop();
                    String message = "You couldn't get 110 points\n" 
                            + "GAME OVER\n"
                            + "Try Again\n";

                    JOptionPane.showMessageDialog(this, message);

                    System.exit(0);
                }
                
                level++;

            }

            else
                level_2.chicken.setY(level_2.chicken.getY() + 6);
        }
        
        else if(level == 3) {
            for(Shot shot : level_3.shotsA) {
                shot.setX(shot.getX()-25);
                shot.setY(shot.getY()+8);
            }

            for(Shot shot : level_3.shotsD) {
                shot.setX(shot.getX()+25);
                shot.setY(shot.getY()+8);
            }
            
            if(level_3.chicken.getY() >= 740) {

                if(p_3 < 150) {
                    
                    timer.stop();
                    String message = "You couldn't get 150 points\n" 
                            + "GAME OVER\n"
                            + "Try Again\n";

                    JOptionPane.showMessageDialog(this, message);

                    System.exit(0);
                }
                
                else {
                    
                    timer.stop();
                    String message = "YOU WIN!\n" 
                            + "GAME IS COMPLETED!\n";

                    JOptionPane.showMessageDialog(this, message);

                    System.exit(0);
                    
                }

            }

            else
                level_3.chicken.setY(level_3.chicken.getY() + 7);
        }
        
        repaint();
    }

	public BufferedImage getGrass() {
		return grass;
	}

	public void setGrass(BufferedImage grass) {
		this.grass = grass;
	}
    
}