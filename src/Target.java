
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class Target {
    
    private int x;
    private int y;
    private BufferedImage image;
    private int rate;
    private int which;

    public Target(int x, int y, int num) {
       
        this.x = x;
        this.y = y;
        
        if(num == 1) {
            try {
                this.image = ImageIO.read(new FileImageInputStream(new File("gift1.png")));
            } catch (IOException ex) {
                Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
            }
            rate = 7;
            which = 50;
        }
        else if(num == 2) {
            try {
                this.image = ImageIO.read(new FileImageInputStream(new File("gift2.png")));
            } catch (IOException ex) {
                Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
            }
            rate = 8;
            which = 30;
        }
        else if(num == 3) {
            try {
                this.image = ImageIO.read(new FileImageInputStream(new File("gift3.png")));
            } catch (IOException ex) {
                Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
            }
            rate = 8;
            which = 20;
        }
    }

    public int getWhich() {
        return which;
    }

    public int getRate() {
        return rate;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}