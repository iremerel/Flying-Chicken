
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class Shot {
    
    private int x;
    private int y;
    private BufferedImage image;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
        
        try {
            this.image = ImageIO.read(new FileImageInputStream(new File("egg.png")));
        } catch (IOException ex) {
            Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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