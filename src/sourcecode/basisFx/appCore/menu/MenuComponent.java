package basisFx.appCore.menu;

import java.util.ArrayList;

import basisFx.domainModel.targets.Target;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class MenuComponent {
    
    private  ArrayList<MenuComponent> components=new ArrayList<>();
    protected Target target;
    protected String name;
    protected String metaInf;
    protected FontsStore fontsStore;
    protected double size;

    
    public enum composit{COMPOSITE, SIMPLE}
    protected String id;
    protected boolean isComposit=false;
    protected AnchorPane parent;


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setFontsStore(FontsStore fontsStore) {
        this.fontsStore = fontsStore;
    }

    public FontsStore getFontsStore() {
        return fontsStore;
    }

    public static MenuComponent create(String name, Target fm, composit composit){
    
        MenuComponent mh=new MenuComponent(composit);
        mh.setName(name);
        mh.setTarget(fm);
        return mh;
    
    }
    public static MenuComponent createCompositLevel(String name, Target target, composit c, String iconFontName){

        MenuComponent mh=new MenuComponent(c);
        mh.setName(name);
        mh.setTarget(target);
        mh.setMeta(iconFontName);
        return mh;

    }
    public static MenuComponent createCompositLevel(String name, Target target, composit c, String iconFontName, FontsStore fontsStore, double size){

        MenuComponent mh=new MenuComponent(c);
        mh.setName(name);
        mh.setTarget(target);
        mh.setMeta(iconFontName);
        mh.setFontsStore(fontsStore);
        mh.setSize(size);
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
    
    public MenuComponent addInerLevel(MenuComponent... m){
        
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
    
    public MenuComponent setTarget(Target t ){
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
