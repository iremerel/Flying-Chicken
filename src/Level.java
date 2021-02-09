
import java.util.ArrayList;
import java.util.Random;

public class Level {
    
    public Chicken chicken;
    public ArrayList<Shot> shotsA;
    public ArrayList<Shot> shotsD;
    public int shotNum;
    public ArrayList<Cat> cats;
    public ArrayList<Target> targets;
    public int[] tiles; 
    public int num = 0;

    public int find_random() {
        
        int low = 1;
        int high = 81;
        
        Random x = new Random();
        int xresult = x.nextInt(high-low) + low;
        
        for(int i = 0; i < num ; i++) {
            
            if(tiles[i] == xresult)
                return find_random();
            
        }
        
        tiles[num] = xresult;
        num++;
        return xresult;
    }
    
    public Level(int shotnum, int catnum, int targetnum) {
        
        this.shotNum = shotnum;
        
        this.chicken = new Chicken();
        
        shotsA = new ArrayList<Shot>();
        shotsD = new ArrayList<Shot>();
        cats = new ArrayList<Cat>();
        targets = new ArrayList<Target>();
        tiles = new int[81];
        
        int xlow = 1;
        int xhigh = 81;
        
        for (int i = 0 ; i < catnum ; i++) {
            int x = find_random();
            
            Tile tile = new Tile(x);
            
            cats.add(new Cat(tile.getX()+10, tile.getY()+10));
            
        }
        
        for (int i = 0 ; i < targetnum-3 ; i++) {
            int x = find_random();
            
            Tile tile = new Tile(x);
            
            targets.add(new Target(tile.getX()+5, tile.getY()+2, 3));
        }
        
        int x = find_random();
        Tile tile = new Tile(x);
        
        Target first = new Target(tile.getX(), tile.getY(), 1);
        
        int x1 = find_random();
        Tile tile1 = new Tile(x1);
        
        Target second = new Target(tile1.getX()+5, tile1.getY()+3, 2);
        
        int x2 = find_random();
        
        Tile tile2 = new Tile(x2);
        
        Target third = new Target(tile2.getX()+5, tile2.getY()+3, 2);
        
        targets.add(first);
        targets.add(second);
        targets.add(third);
    }
   
}