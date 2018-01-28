package basisFx.domainModel.old;

//package hepo.domainModel;
//
//import hepo.appCore.AbstractTab;
//import hepo.appCore.FileChoose;
//import hepo.domainModel.poi.WriteRoll;
//import hepo.domainModel.poi.RollReaderExel;
//import hepo.domainModel.poi.RollReaderWord;
//import hepo.domainModel.DirectoryChooserWrapper;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
//
//public class RollTab extends AbstractTab{
//
//    protected Button openExel;
//    protected Button openWord;
//    protected Button save;
//    protected TextArea textArea;
//
//    private ArrayList<ArrayList> allOrders;  
//
//    protected List<File> files;
//    
//    
//    
//    public RollTab(String id, String name, boolean closeable) {
//        super(id, name, closeable);
//        buildContent();
//    }
//
//    @Override
//    public void buildContent() {
//       createButtons();  
//    }
//    
// 
//    private  void createButtons(){
//    
//        openExel= new Button("Открыть файл Exel");
//        openWord= new Button("Открыть файл Word");
//        save= new Button("Сохранить");
//        textArea=new TextArea();
//
//        
//        openExel.setId("mybut1");
//        openWord.setId("mybut2");
//        save.setId("mybut3");
//        
//        
//        anchorHandler(anchorPane, openExel, 10.0, null, null, 10.0);
//        anchorHandler(anchorPane, openWord, 10.0, null, null, 150.0);
//        anchorHandler(anchorPane, save,     10.0, 10.0, null, null);
//        anchorHandler(anchorPane, textArea, 50.0, 10.0,  20.0, 10.0);
// 
//        
//        setOpenExelEvent();
//        setOpenWordEvent();
//        setOpenWordEvent();
//        setSaveEvent();
//       
//    
//        }
//    private void setOpenExelEvent() {
//       
//    
//         openExel.setOnAction((final ActionEvent e) -> {
//            files=new FileChoose().getFiles();
//            
//            if(files!=null){
//                
//                for(File concreteFile:files){
//                    
//                    
//                    try {
//                        try {
//                            new RollReaderExel(concreteFile);
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(RollTab.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (InvalidFormatException ex) {
//                            Logger.getLogger(RollTab.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
//                    } catch (IOException ex) {
//                        Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                 
//                    
//                }
//                
//                    try {
//                        new WriteRoll(RollReaderExel.getAllOrders(), new DirectoryChooserWrapper().getPath());
//
//                    
//                    } catch (IOException ex) {
//                        Logger.getLogger(RollTab.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                
//            }
//        });
//    
//    
//    }
//    private void setOpenWordEvent() {
//       
//    
//         openWord.setOnAction((final ActionEvent e) -> {
//            files=new FileChoose().getFiles();
//            
//            if(files!=null){
//                
//                for(File concreteFile:files){
//                    
//                  
//                    try {
//                       new RollReaderWord(concreteFile,textArea);
//                    
//                        
//                    } catch (IOException ex) {
//                        Logger.getLogger(RollTab.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InvalidFormatException ex) {
//                        Logger.getLogger(RollTab.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                       
//            }
//            }
//         }
//         );
//    }
//    private void setSaveEvent() {
//    
//         save.setOnAction((final ActionEvent e) -> {
//
//             
//             
//             try {    
//                 new WriteRoll(   RollReaderWord.getAllOrders()   , new DirectoryChooserWrapper().getPath());
//             } catch (IOException ex) {
//                 Logger.getLogger(RollTab.class.getName()).log(Level.SEVERE, null, ex);
//             }
//    
//       });
//     }
//  
//    
//   
//    
//}
