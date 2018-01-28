package basisFx.appCore.elements;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.events.AppEvent;
import basisFx.appCustomLogic.settings.CSSID;
import basisFx.appCore.FontLogic;
import basisFx.appCustomLogic.settings.WindowsTitlesNames;
import basisFx.appCustomLogic.settings.FontsStore;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Alek
 */
public abstract class AppNode <T extends Node> {
    protected String id;
    protected T element;
    protected double width;
    protected double height;
    protected AnchorCoordinate coordinate;
    protected AppNode parentAppNode;
    protected AppNode childAppNode;
    protected ArrayList <AppNode> children=new ArrayList<>();
    protected ArrayList <AppEvent> events=new ArrayList<>();
    protected AppEvent event;
    protected Insets insects;
    protected AnchorPane parentAnchor;
    protected Font font;  
    protected boolean hasBond;
    protected Stage stage;
    protected String text;
    protected Insets insets;
    protected DropShadow dropShadow;
  

//    protected abstract void display();
    
    public void init (NodeBuilder builder){
        this.coordinate=builder.coordinate;
        this.height=builder.height;
        this.width=builder.width;
        this.id=builder.id;
        this.insects=builder.insects;
        this.parentAnchor=builder.parentAnchor;
        this.childAppNode=builder.childNode;
        this.hasBond=builder.hasBond;
        this.font=builder.font;
        this.events=builder.events;
        this.stage=builder.stage;
        this.text=builder.text;
        this.insets=builder.insects;
        this.dropShadow=builder.dropShadow;
        if(id!=null)element.setId(id);
        elocateEvents();
        bond(this);
        
        
        
    }
    public  String getId(){
        return this.id;
    };
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public AppNode getParent() {
        return parentAppNode;
    }
    public void setParent(AppNode parent) {
        this.parentAppNode = parent;
    }
    public void setEvent(AppEvent e) {
        this.events.add(e);
    }
    public void wrapToAnchor() {
        
    }
    public  T getElement(){
    
        return this.element;
    
    };
    public  void setElement(T el){
    
        this.element=el;
    
    };
    
    
    public void bond(AppNode n) {
        
         if(hasBond!=false){
        
             this.coordinate.setChildNode(n.getElement());
             this.coordinate.setParentAnchorPane(parentAnchor);
             this.coordinate.bonding();
      
        
        }
    }
    public Stage getStage() {
        
         return this.stage;
             
    }

 
    protected void elocateEvents() {
        
        if (!this.events.isEmpty()) {
           
            for (Iterator<AppEvent> iterator = events.iterator(); iterator.hasNext();) {
            AppEvent next = iterator.next();
            next.setElement(this);
            
        }
        }
       
        
    
             
    }

 
    
    
    public static class NodeBuilder{

        protected String id;
        protected double width;
        protected double height;
        protected AnchorCoordinate coordinate;
        protected AppNode parent;
        protected ArrayList <AppNode> children=new ArrayList<>();
        protected ArrayList <AppEvent> events=new ArrayList<>();
        protected Insets insects;
        protected AnchorPane parentAnchor;
        protected AppNode childNode;
        protected boolean hasBond;
        protected Font font;
        protected Stage stage;
        protected String text;
        protected DropShadow dropShadow;
        
        public static NodeBuilder create(){
            return new NodeBuilder();
        }
       
       
        public NodeBuilder setDropShadow(DropShadow d) {
            this.dropShadow=d;
            return this;
    }

       
        public NodeBuilder setCoordinate(Double top,Double right,Double bottom,Double left) {
            this.coordinate=new AnchorCoordinate();
            this.coordinate.setTop(top);
            this.coordinate.setBottom(bottom);
            this.coordinate.setLeft(left);
            this.coordinate.setRight(right);
            return this;
    }
       
        public NodeBuilder setCoordinate(AnchorCoordinate c) {
            this.coordinate=c;

            return this;
    }

       
        public NodeBuilder setCoordinate(AnchorPane ap,Double top,Double right,Double bottom,Double left) {
            setParentAnchor(ap);
            this.coordinate=new AnchorCoordinate();
            this.coordinate.setTop(top);
            this.coordinate.setBottom(bottom);
            this.coordinate.setLeft(left);
            this.coordinate.setRight(right);
 
            return this;
    }
        public NodeBuilder setId(CSSID css){
            this.id=css.get();
            return this;
    }
        public NodeBuilder setInsets(Insets i){
            this.insects=i;
            return this;
    }
        public NodeBuilder setWidth(double w){
            this.width=w;
            return this;
    }
        public NodeBuilder setHeight(double h){
            this.height=h;
            return this;
    }
        public NodeBuilder setInsects(Insets insects) {
             this.insects = insects;
             return this;
    }
        public NodeBuilder setParentAnchor(AnchorPane ap) {
            this.hasBond=true;
            this.parentAnchor=ap;
            return this;
         }
        protected NodeBuilder setNodeToBonding(AppNode appNode) {
           this.childNode=appNode;
           return this;
        
        }
        protected NodeBuilder hasBond(boolean b) {
           this.hasBond=b;
           return this;
        
        }

        public NodeBuilder setFont(FontsStore fs, double size){
    
        this.font=FontLogic.run().loadFont(fs, size);
        
        return this;
    }
        public NodeBuilder setSize(double width, double height) {
           
          this.width=width;
          this.height=height;
        
          return this;
          
          
        }
        public NodeBuilder setPadding(Insets i) {
           
          this.insects=i;
          return this;
          
          
        }
        public NodeBuilder setEvent(AppEvent e) {
           
          this.events.add(e);
          return this;
          
          
        }
        public NodeBuilder setStage(Stage stage) {
           
          this.stage=stage;
          return this;
          
          
        }
        
        
        public NodeBuilder setText(WindowsTitlesNames t){
            this.text=t.get();
            return this;
        }

        public NodeBuilder setText(String str){
            this.text=str;
            return this;
        }

          
          
          
        
    /////////  Fabric Methods  /////////
     public  NText  createNText(){
        return new<Text> NText(this);
    }
     public  NAnchor createNpAnchor(){
        return new <AnchorPane> NAnchor(this);
    }
     public  NButton createNButton(){
        return new<Button>  NButton(this);
    }

     public  NImgView createNImgView(){
        return new <ImageView>  NImgView(this);
    }
     public  NMenuBar createNMenuBar(){
        return new <MenuBar>  NMenuBar(this);
    }

       


   
   

 
        
    
    
    
    }
    

   
    
    
    
    
    
}
