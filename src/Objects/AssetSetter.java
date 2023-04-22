package Objects;

import java.util.ArrayList;
import java.util.Collections;

import main.GamePanel;

public class AssetSetter{
    GamePanel gp;
    private Obj_big ob;
    private ArrayList<SuperObjects> listob;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        ob = new Obj_big(gp, 200, 450, gp.tileSize, gp.tileSize+30);
        Collections.addAll(listob, ob);
    }
    
    public GamePanel getGp() {
        return gp;
    }
    public void setGp(GamePanel gp) {
        this.gp = gp;
    }
    public Obj_big getOb() {
        return ob;
    }
    public void setOb(Obj_big ob) {
        this.ob = ob;
    }
    public ArrayList<SuperObjects> getListob() {
        return listob;
    }
    public void setListob(ArrayList<SuperObjects> listob) {
        this.listob = listob;
    }
    
}
