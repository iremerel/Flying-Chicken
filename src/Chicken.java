
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class Chicken {
    private BufferedImage image;
    private int x;
    private int y;
    private int step;
    private int level = 1;
    
    public Chicken() {
        
        try {
            this.image = ImageIO.read(new FileImageInputStream(new File("torchic.png")));
        } catch (IOException ex) {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.x = 460;
        this.y = 0;
        this.step = 5;
    }

    public int getLevel() {
        return level;
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}