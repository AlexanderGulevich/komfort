package basisFx.appCore.elements;


import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.interfaces.ValueAddToDomain;
import basisFx.appCore.controls.Edit;
import basisFx.appCore.interfaces.EditCreater;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.FontLogic;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Insets;


import java.util.ArrayList;
import java.util.Iterator;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 *
 * @author Alek
 *
 */
public abstract class AppNode  {
    protected String id;
    protected Node element;
    protected Double width;
    protected Double height;
    protected Coordinate coordinate;
    protected AppNode parentAppNode;
    protected AppNode childAppNode;
    protected ArrayList <AppNode> children=new ArrayList<>();
    protected ArrayList <AppEvent> events=new ArrayList<>();
    protected AppEvent event;
    protected Insets insects;
    protected AnchorPane parentAnchor;
    protected Group parentGroup;
    protected Font font;  
    protected boolean hasBond;
    protected Stage stage;
    protected String string;
    protected Insets insets;
    protected DropShadow dropShadow;
    protected String stringId;
    protected FlowPane parentFlowPane;
    protected Double maxHeight;
    protected Double maxWidth;
    protected Double minHeight;
    protected Double minWidth;
    protected Callback callback;
    protected ScrollPane scrollPane;
    protected Double widthPerCent=null;
    protected Pos pos=null;
    protected ValueAddToDomain valueAddToObservers;
    protected Edit editPoliticy;
    protected EditCreater editCreater;
    protected KindOfSubmitElement mark;
    
    public void init (NodeBuilder builder){
        this.coordinate=builder.coordinate;
        this.height=builder.height;
        this.width=builder.width;
        this.id=builder.id;
        this.insects=builder.insects;
        this.parentAnchor=builder.parentAnchor;
        this.parentFlowPane=builder.parentFlowPane;
        this.childAppNode=builder.childNode;
        this.hasBond=builder.hasBond;
        this.font=builder.font;
        this.events=builder.events;
        this.stage=builder.stage;
        this.string =builder.text;
        this.insets=builder.insects;
        this.dropShadow=builder.dropShadow;
        this.minHeight=builder.minHeight;
        this.minWidth=builder.minWidth;
        this.maxHeight=builder.maxHeight;
        this.maxWidth=builder.maxWidth;
        if(id!=null)element.setId(id);
        if(this.stringId!=null)element.setId(stringId);
        this.callback=builder.callback;
        this.scrollPane= builder.scrollPane;
        this.widthPerCent= builder.widthPerCent;
        this.pos=builder.pos;
        this.valueAddToObservers =builder.valueAddToDomain;
        this.editPoliticy=builder.editPoliticy;
        this.editCreater=builder.editCreater;
        this.mark=builder.mark;



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
    public  Node getElement(){
    
        return this.element;
    
    };
    public  void setElement(Node el){
    
        this.element=el;
    
    };
    
   
  
    public void bond(AppNode n) {
        
         if(hasBond!=false){


             
             if(this.parentAnchor!=null){
             
                    this.coordinate.setChildNode(n.getElement());
                    this.coordinate.setParentAnchorPane(parentAnchor);
                    this.coordinate.bonding();
                    
             }
             if(this.parentFlowPane!=null){


                 this.parentFlowPane.getChildren().add(n.getElement());


             }

             if(this.scrollPane!=null){


                 this.scrollPane.setPannable(true);
                 this.scrollPane.setContent(n.getElement());

             }

             if(this.parentGroup!=null){


                 this.parentGroup.getChildren().addAll(n.getElement());


             }

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
        protected Double width;
        protected Double height;
        protected Coordinate coordinate;
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
        protected String stringId;
        protected FlowPane parentFlowPane;
        protected Double maxHeight;
        protected Double maxWidth;
        protected Double minHeight;
        protected Double minWidth;
        protected Callback callback;
        protected ScrollPane scrollPane;
        protected Double widthPerCent=null;
        protected Pos pos=null;
        protected ValueAddToDomain valueAddToDomain;
        protected Edit editPoliticy;
        protected EditCreater editCreater;
        protected KindOfSubmitElement mark;

        public static NodeBuilder create(){
            return new NodeBuilder();
        }

        public NodeBuilder setEditCreater(EditCreater editCreater) {
            this.editCreater = editCreater;
            return this;
        }

        public void setValueAddToDomain(ValueAddToDomain valueAddToDomain) {
            this.valueAddToDomain = valueAddToDomain;
        }

        public NodeBuilder setDropShadow(DropShadow d) {
            this.dropShadow=d;
            return this;
    }

        public NodeBuilder setWidthPerCent(double widthPerCent) {
            this.widthPerCent = widthPerCent;
            return this;
        }

        public NodeBuilder setEditPoliticy(Edit editPoliticy) {
            this.editPoliticy = editPoliticy;
            return this;
        }

        public NodeBuilder setCoordinate(Double top, Double right, Double bottom, Double left) {
            this.coordinate=new Coordinate();
            this.coordinate.setTop(top);
            this.coordinate.setBottom(bottom);
            this.coordinate.setLeft(left);
            this.coordinate.setRight(right);
            return this;
    }
       
        public NodeBuilder setCoordinate(Coordinate c) {
            this.coordinate=c;
//            if (c.getParentAnchorPane() != null) {
//                this.parentAnchor=c.getParentAnchorPane();
//            }


            return this;
    }
       
        public NodeBuilder setCoordinate(AnchorPane ap,Double top,Double right,Double bottom,Double left) {
            setParent(ap);
            this.coordinate=new Coordinate();
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
        public NodeBuilder setId(String id){
            this.stringId=id;
            return this;
    }
        public NodeBuilder setInsets(Insets i){
            this.insects=i;
            return this;
    }
        public NodeBuilder setWidth(Double w){
            this.width=w;
            return this;
    }
        public NodeBuilder setHeight(Double h){
            this.height=h;
            return this;
    }
        public NodeBuilder setInsects(Insets insects) {
             this.insects = insects;
             return this;
    }
        public NodeBuilder setParent(AnchorPane ap) {
            this.hasBond=true;
            this.parentAnchor=ap;
            return this;
         }
         public NodeBuilder setPosToLabel(Pos pos){
            this.pos=pos;

             return this;
         }
        public NodeBuilder setParent(FlowPane fp) {
            this.hasBond=true;
            this.parentFlowPane=fp;
            return this;
        }

        public NodeBuilder setParent(ScrollPane scrollPanep) {
            this.hasBond=true;
            this.scrollPane=scrollPanep;
            return this;
        }

        public NodeBuilder setCallback(Callback c) {
            this.callback=c;
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

        public NodeBuilder setText(String str){
            this.text=str;
            return this;
        }
        
          public NodeBuilder setMaxHeight(Double maxHeight) {
            this.maxHeight = maxHeight;
             return this;
        }

            public NodeBuilder setMaxWidth(Double maxWidth) {
                this.maxWidth = maxWidth;
                return this;
            }

            public NodeBuilder setMinHeight(Double minHeight) {
                this.minHeight = minHeight;
                return this;
            }


            public NodeBuilder setKindOfSubmitElement(KindOfSubmitElement mark) {
                this.mark=mark;
                return this;

            }

            public NodeBuilder setMinWidth(Double minWidth) {
                this.minWidth = minWidth;
                return this;
            }

        /////////  Fabric Methods  /////////
        public TextWrapper createText(){
            return new<Text>TextWrapper(this);
        }
        public LabelWrapper createLabel(){
            return new<Label>LabelWrapper(this);
        }
        public AnchorWrapper createAnchorPanelWrapper(){
            return new <AnchorPane>AnchorWrapper(this);
        }
        public  ButtonWrapper createNButton(){
            return new<Button>  ButtonWrapper(this);
        }
        public ImgViewWrapper createNImgView(){
            return new <ImageView>ImgViewWrapper(this);
        }
        public  NMenuBar createNMenuBar(){
            return new <MenuBar>  NMenuBar(this);
        }
        public  NFlowPane createNFlowPane(){
            return new <FlowPane>  NFlowPane(this);
        }
        public   <T> TableWrapper createTableViewWrapper  (){
            return new TableWrapper< >(this);
        }
        public   <T> ComboBoxWrapper createComboBoxWrapper  (){
            return new  ComboBoxWrapper<>(this);
        }
        public   <T> TilePaneWrapper createTilePaneWrapper  (){
            return new  TilePaneWrapper<>(this);
        }
        public   <T> ScrollPaneWrapper createScrollPaneWrapper  (){
            return new  ScrollPaneWrapper<>(this);
        }
        public    DatePickerWrapper createDatePickerWrapper  (){
            return new  DatePickerWrapper(this);
        }
        public    GroupWrapper createGroupWrapper  (){
            return new  GroupWrapper(this);
        }
        public    GridPaneWrapper createGridPaneWrapper  (){
            return new  GridPaneWrapper(this);
        }
        public    TextAreaWrapper createTextAreaWrapper (){
            return new  TextAreaWrapper(this);
        }
        public    AreaChartWrapper createAreaChartWrapper (){return new  AreaChartWrapper(this); }


    }

       


   
   

 
        
    
    
    
    }
    

   
    
    
