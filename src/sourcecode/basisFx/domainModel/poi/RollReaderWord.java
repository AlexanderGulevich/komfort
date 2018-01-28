package basisFx.domainModel.poi;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel.poi;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import javafx.scene.control.TextArea;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
///**
// *
// * @author Alek
// */
//public class RollReaderWord {
//    
//    private static ArrayList<ArrayList> allOrders=new ArrayList<>();  
//    private  ArrayList<HashMap> concreateOrder;
//    private static TextArea textArea;
//    private static String textContent="";
//    private StringHandler strHandler=new StringHandler();
//    private String[] fileData;
//
//    public ArrayList<HashMap> getConcreateOrder() {
//        return concreateOrder;
//    }
//    
//    public static ArrayList <ArrayList> getAllOrders(){
//        return RollReaderWord.allOrders;
//    }
//    
//    public RollReaderWord(File file,TextArea textArea) throws IOException, FileNotFoundException, InvalidFormatException {
//        
//       concreateOrder=new ArrayList(); 
//       RollReaderWord.textArea=textArea;
//   
//        try
//        {
// 
//        WordExtractor extractor = null;
//        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//        HWPFDocument document = new HWPFDocument(fis);
//        extractor = new WordExtractor(document);
//        fileData = extractor.getParagraphText();
//        }
//        catch (Exception exep)
//        {
//            putTextToTextArea("не удалось загрузить файл ");
//        }
//        
//        RollReaderWord.getAllOrders().add(concreateOrder);
//        iteration();
//        
//       
//       
//       
//     
//    }
//    
//      private void putTextToTextArea(String str) {
//    
//        RollReaderWord.textContent="\n"+RollReaderWord.textContent+str+"\n\n";
//            
//        textArea.setText(RollReaderWord.textContent);
//    
//    }
//    
//
//    
//    private void iteration() {
//        
//    
//         HashMap<String,String> row=null;
//         String str=null;
//         String allString="";
//         String count="";
//     
//     
//            
//            for (int i = 0; i < fileData.length; i++){
//                if (fileData[i] != null)
//
//                row=new HashMap<>();
//                allString=fileData[i];
//                str=fileData[i];
//
//
//                if(str.contains("ЗАЯВКА")){
//                    str=strHandler.delDimension(str, "ЗАЯВКА", "№");
//                    str=strHandler.clearEdges(str);
//                    
//                    row.put("order",str);
//                    concreateOrder.add(row);
//                    
//                    putTextToTextArea("Читаю заявку "+str);
//                            }
//                
//                if((str.contains("Рулон"))
//                        &&(str.contains("Содержание текста:"))
//                        &&(str.contains("ираж"))){
//
//                    row.put("typeOfTicket", "Рулонный");
//
//                    //вырезать главную строку 
//                    str=(str.substring(
//                            str.indexOf("Содержание текста:")+"Содержание текста:".length(), 
//                            str.indexOf("РУП")-2
//                    ));
//
//                    str=strHandler.changeWord(str,  "КОНТРОЛЬНЫЙ БИЛЕТ", "к/б");
//                    str=strHandler.changeWord(str,  "КОНТРОЛЬНЫЙ  БИЛЕТ", "к/б");
//                    str=strHandler.changeWord(str,  "копеек", "коп");
//                    str=strHandler.changeWord(str,  "рубля", "руб");
//                    str=strHandler.changeWord(str,  "копейка", "коп");
//                    str=strHandler.changeWord(str,  "копейки", "коп");
//                    str=strHandler.changeWord(str,  "рублей", "руб");
//                    str=strHandler.changeWord(str,  "рубль", "руб");
//                    str=strHandler.delDimension(str, "БИЛЕТ", ",");
//                    str=strHandler.delDimension(str, "ИНН", ",");
//                    str=strHandler.delDimension(str, "КПП", ",");
//                    str=strHandler.delDimension(str, "ОГРН", ",");
//                    str=strHandler.delDimension(str, "Договор обязательного страхования", ",");
//                    str=strHandler.delDimension(str, "г.", ","); 
//
//                    row.put("mainInf", str);
//                    
//                    // тираж
//                    count=allString;
//                  if((count.contains("ираж"))&&(count.contains("штук"))){
//
//                    count=count.substring(allString.indexOf("ираж")+"ираж".length()+2,
//                             allString.indexOf("штук")
//                             ); 
//                    
//                   count=  strHandler.delAllSpace(count);
//                      
//                   count=  strHandler.delText(count, "-");
//                   count=  strHandler.delText(count, "–");
//                        try {
//                            count=  ((Integer)(Integer.parseInt(count)/1000)).toString()    ;
//                        } catch (Exception e) {
//                          
//                            putTextToTextArea("ОШИБКА В \n"+
//                                    allString+
//                                    "  \n "
//                                    +"в " +count
//                                    );
//                            
//                        }
//
//                    row.put("count", count);
//
//                   
//                
//                    }
//                    if((count.contains("ираж"))&&(count.contains("шт"))){
//
//                    count=count.substring(allString.indexOf("ираж")+"ираж".length()+2,
//                             allString.indexOf("шт")
//                             ); 
//                    
//                   count=  strHandler.delAllSpace(count);
//                      
//                   count=  strHandler.delText(count, "-");
//                   count=  strHandler.delText(count, "–");
//                        try {
//                            count=  ((Integer)(Integer.parseInt(count)/1000)).toString()    ;
//                        } catch (Exception e) {
//                          
//                            putTextToTextArea("ОШИБКА В \n"+
//                                    allString+
//                                    "  \n "
//                                    +"в " +count
//                                    );
//                            
//                        }      
//                   
//                    row.put("count", count);
//
//                
//                    }
// 
//
//                    concreateOrder.add(row);
//
//                }
//
//           }
//            
//            putTextToTextArea("---прочел");
//            
//            
//
//    }
//                    
//                    
//                    
//                    
//                    
//                    
//                
//           
//      
//    
//    
//    
//    
//  
// 
//}
