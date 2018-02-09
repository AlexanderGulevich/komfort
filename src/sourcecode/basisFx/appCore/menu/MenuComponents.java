package basisFx.appCore.menu;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class MenuComponents{ 
    
    private  ArrayList<MenuComponents> components=new ArrayList<>();
    protected TargetFM factory;
    protected String name;
    protected String metaInf;

    
    public enum composit{COMPOSITE, SIMPLE}
    protected String id;
    protected boolean isComposit=false;
    protected AnchorPane parent;

 
    public static MenuComponents create(String n,TargetFM fm,composit c){
    
        MenuComponents mh=new MenuComponents(c);
        mh.setName(n);
        mh.setFactory(fm);
        return mh;
    
    }
    public static MenuComponents create(String n,TargetFM fm,composit c, String metaInf){
    
        MenuComponents mh=new MenuComponents(c);
        mh.setName(n);
        mh.setFactory(fm);
        mh.setMeta(metaInf);
        return mh;
    
    }
    public static MenuComponents createHeadElement(){
       
       
       return create(null, null, MenuComponents.composit.COMPOSITE);
    
    }
  
    private MenuComponents(composit c) {
        if (c==composit.COMPOSITE) {
            this.isComposit=true;
        }
    }
    
    public MenuComponents addInerLevel(MenuComponents ... m){
        
        for (int i = 0; i < m.length; i++) {
            MenuComponents concrete = m[i];
            this.components.add(concrete);
            
        } 
        this.isComposit=true; 
        return this;
        
    };

    public String getId() {
        return id;
    }
    
    
    public MenuComponents setId(String id){
    
        this.id=id;
        return this;
        
    }
    private void setMeta(String metaInf) {
        this.metaInf=metaInf;
    }
    
    public MenuComponents remove(MenuComponents c ){
        components.remove(c);
        return this;
    }
    
    public MenuComponents setFactory(TargetFM factory ){
        this.factory=factory;
        return this;
    }

    public TargetFM getFactory() {
        return factory;
    }
    
        
    public MenuComponents setName(String n ){
        this.name=n;
        return this;
    }
    
    public  String getName( ){
        return this.name;
    }

    public String getMetaInf() {
        return metaInf;
    }
    

    public ArrayList<MenuComponents> getComponents() {
        return components;
    }

    public boolean isComposit() {
        return isComposit;
    }

    public AnchorPane getParent() {
        return parent;
    }
    
    
   
    
        
    
    
    
    
}
