package basisFx.appCore.utils;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class ImgResize {
            public static void mainr( )
            {
                String result_message= resize("C:/Pics/iqbal.png","C:/Pics/resized_pic.png",200);
                System.out.println(result_message);

            }
            // This method will resize the image to the specified width and will maintain aspect ratio for the height of the picture to maintain quality
            public static String resize(String sourceFile, String ResizedFile, int width)
            {
                try
                {
                    File f = new File(sourceFile);
                    if (!f.exists())
                    {
                        return "File doesn’t exist";
                    }

                    BufferedImage bim=ImageIO.read(new FileInputStream(sourceFile));
                    Image resizedImg=bim.getScaledInstance(width,-1,Image.SCALE_FAST);
                    int scaled_height=resizedImg.getHeight(null);

                    BufferedImage rBimg=new BufferedImage(width,scaled_height,bim.getType());
                    Graphics2D g=rBimg.createGraphics();// Draw the resizedImg from 0,0 with no ImageObserver
                    g.drawImage(resizedImg,0,0,null);

                    g.dispose();

                    ImageIO.write(rBimg,ResizedFile.substring(ResizedFile.indexOf(".")+1),new FileOutputStream(ResizedFile));
                }
                catch (Exception e)
                {
                    return e.getMessage();
                }
                return "Picture Resized Successfully";
            }
        }
