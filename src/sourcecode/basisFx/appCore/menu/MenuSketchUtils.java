package basisFx.appCore.menu;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class MenuSketchUtils{ 
    
    private  ArrayList<MenuSketchUtils> components=new ArrayList<>();
    protected TargetFM factory;
    protected String name;
    public enum composit{COMPOSITE, SIMPLE}
    protected String id;
    protected boolean isComposit=false;
    protected AnchorPane parent;

 
    public static MenuSketchUtils create(String n,TargetFM fm,composit c){
    
        MenuSketchUtils mh=new MenuSketchUtils(c);
        mh.setName(n);
        mh.setFactory(fm);
        return mh;
    
    }
    public static MenuSketchUtils createHeadElement(){
       
       
       return create(null, null, MenuSketchUtils.composit.COMPOSITE);
    
    }
  
    private MenuSketchUtils(composit c) {
        if (c==composit.COMPOSITE) {
            this.isComposit=true;
        }
    }
    
    public MenuSketchUtils add(MenuSketchUtils ... m){
        
        for (int i = 0; i < m.length; i++) {
            MenuSketchUtils concrete = m[i];
            this.components.add(concrete);
            
        } 
        this.isComposit=true; 
        return this;
        
    };

    public String getId() {
        return id;
    }
    
    
    public MenuSketchUtils setId(String id){
    
        this.id=id;
        return this;
        
    }
    
    public MenuSketchUtils remove(MenuSketchUtils c ){
        components.remove(c);
        return this;
    }
    
    public MenuSketchUtils setFactory(TargetFM factory ){
        this.factory=factory;
        return this;
    }

    public TargetFM getFactory() {
        return factory;
    }
    
        
    public MenuSketchUtils setName(String n ){
        this.name=n;
        return this;
    }
    
    public  String getName( ){
        return this.name;
    }
    

    public ArrayList<MenuSketchUtils> getComponents() {
        return components;
    }
    
    
   
    
        
    
    
    
    
}
