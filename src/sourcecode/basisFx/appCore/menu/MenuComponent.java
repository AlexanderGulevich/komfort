package basisFx.appCore.menu;

import java.util.ArrayList;

import basisFx.appCore.panels.Target;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class MenuComponent{ 
    
    private  ArrayList<MenuComponent> components=new ArrayList<>();
    protected Target target;
    protected String name;
    protected String metaInf;

    
    public enum composit{COMPOSITE, SIMPLE}
    protected String id;
    protected boolean isComposit=false;
    protected AnchorPane parent;

 
    public static MenuComponent create(String n,Target fm,composit c){
    
        MenuComponent mh=new MenuComponent(c);
        mh.setName(n);
        mh.setFactory(fm);
        return mh;
    
    }
    public static MenuComponent create(String n,Target fm,composit c, String metaInf){
    
        MenuComponent mh=new MenuComponent(c);
        mh.setName(n);
        mh.setFactory(fm);
        mh.setMeta(metaInf);
        return mh;
    
    }
    public static MenuComponent createHeadElement(){
       
       
       return create(null, null, MenuComponent.composit.COMPOSITE);
    
    }
  
    private MenuComponent(composit c) {
        if (c==composit.COMPOSITE) {
            this.isComposit=true;
        }
    }
    
    public MenuComponent addInerLevel(MenuComponent ... m){
        
        for (int i = 0; i < m.length; i++) {
            MenuComponent concrete = m[i];
            this.components.add(concrete);
            
        } 
        this.isComposit=true; 
        return this;
        
    };

    public String getId() {
        return id;
    }
    
    
    public MenuComponent setId(String id){
    
        this.id=id;
        return this;
        
    }
    private void setMeta(String metaInf) {
        this.metaInf=metaInf;
    }
    
    public MenuComponent remove(MenuComponent c ){
        components.remove(c);
        return this;
    }
    
    public MenuComponent setFactory(Target t ){
        this.target=t;
        return this;
    }

    public Target getTarget() {
        return target;
    }
    
        
    public MenuComponent setName(String n ){
        this.name=n;
        return this;
    }
    
    public  String getName( ){
        return this.name;
    }

    public String getMetaInf() {
        return metaInf;
    }
    

    public ArrayList<MenuComponent> getComponents() {
        return components;
    }

    public boolean isComposit() {
        return isComposit;
    }

    public AnchorPane getParent() {
        return parent;
    }
    
    
   
    
        
    
    
    
    
}
