
package basisFx.appCore.menu;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class MenuSketch{ 
    
    private  ArrayList<MenuSketch> components=new ArrayList<>();
    protected TargetFM factory;
    protected String name;
    public enum composit{COMPOSITE, SIMPLE}
    protected String id;
    protected boolean isComposit=false;
    protected AnchorPane parent;

 

    
    public static MenuSketch create(String n,TargetFM fm,composit c){
    
        MenuSketch mh=new MenuSketch(c);
        mh.setName(n);
        mh.setFactory(fm);
        return mh;
    
    }
    public static MenuSketch createHeadElement(){
       
       
       return create(null, null, MenuSketch.composit.COMPOSITE);
    
    }
  
    private MenuSketch(composit c) {
        if (c==composit.COMPOSITE) {
            this.isComposit=true;
        }
    }
    
    public MenuSketch add(MenuSketch ... m){
        
        for (int i = 0; i < m.length; i++) {
            MenuSketch concrete = m[i];
            this.components.add(concrete);
            
        } 
        this.isComposit=true; 
        return this;
        
    };

    public String getId() {
        return id;
    }
    
    
    public MenuSketch setId(String id){
    
        this.id=id;
        return this;
        
    }
    
    public MenuSketch remove(MenuSketch c ){
        components.remove(c);
        return this;
    }
    
    public MenuSketch setFactory(TargetFM factory ){
        this.factory=factory;
        return this;
    }

    public TargetFM getFactory() {
        return factory;
    }
    
        
    public MenuSketch setName(String n ){
        this.name=n;
        return this;
    }
    
    public  String getName( ){
        return this.name;
    }
    

    public ArrayList<MenuSketch> getComponents() {
        return components;
    }
    
    
   
    
        
    
    
    
    
}
