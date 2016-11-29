/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificao_metas;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.InputEvent;
import static java.awt.event.InputEvent.BUTTON1_MASK;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Screen;
import javax.swing.JOptionPane;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.exceptions.NativeException;

/**
 *
 * @author Meirinaldo
 */
public class Notificao_Metas_Videos {
    
     static public String texto = "";
     static public Robot robot = null;
     static public String time;
     
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, IllegalAccessException, URISyntaxException {
        
        try {
            
            
         URL url = new URL("http://metas.uneb.org.br/notificacao/notificacao_video.html");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

               time = in.readLine();               
               System.err.println(in.readLine());
        in.close();
      
    try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       Desktop desktop = null;  
       desktop = Desktop.getDesktop();  
        URI uri = null;  
        
       robot.keyPress(KeyEvent.VK_WINDOWS);
       robot.keyPress(KeyEvent.VK_D);
        
        try {  
        uri = new URI("http://metas.uneb.org.br/notificacao/notificacao_video.html");  
           desktop.browse(uri);  
            }  
            catch(IOException ioe) {  
                       ioe.printStackTrace();  
            }  
            catch(URISyntaxException use) {  
                       use.printStackTrace();  
            }  
        
        //movimentar teclado e mouse
        
       
        
         int i = 0;
         while(i <= 5){     
             
             inputs_move();
             i++;
         }  
        
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
       
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_D);
       
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Não foi possível se conectar ao servidor de mensagens da UNeB, contacte seu TI.", "Departamento de TI ds UNeB", JOptionPane.ERROR_MESSAGE);
        }
        
        //sair do sistema
        System.exit(0);-
        
        
    }
        
public static  void inputs_move() throws IllegalAccessException{
        
        
        int stop = 0;
        while (stop <= 1000){
            
            robot.mouseMove(1500, 1000);
            
            //PRESSIONA MOUSE
            robot.mousePress(InputEvent.BUTTON1_MASK);
                
                
            robot.keyPress(KeyEvent.VK_SHIFT);
            
            stop++;
            try {
                Thread.sleep(1);            
                robot.keyRelease(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F5);
                robot.keyRelease(KeyEvent.VK_ALT);

                robot.mousePress(InputEvent.BUTTON1_MASK);

                 
                
            } catch (InterruptedException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               
             
        }               
        
    }
    
       
    
}
