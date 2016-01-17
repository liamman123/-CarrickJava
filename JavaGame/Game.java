import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.Image;
import java.awt.Toolkit;


/**
* My First Game  
* 
* @author Liam 
* @version 001
*/
public class Game extends JPanel
{
   int x = 50;
   int y = 50;
   int deltaX=1;
   int deltaY=1;
   public Game(){
       addMouseListener(new MyMouseListener(this));
    }
   private void moveBall() {
       x = x + deltaX;
       y = y + deltaY;
       
   
   }
   Image img = Toolkit.getDefaultToolkit().createImage("Ball.jpg");
   Image img2 = Toolkit.getDefaultToolkit().createImage("TomandJerry.jpg");
   
   
   @Override
   
   public void paint(Graphics g){
   super.paint(g);
   Graphics2D g2d = (Graphics2D) g;
   g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
   RenderingHints.VALUE_ANTIALIAS_ON);
   //g2d.setColor(Color.RED);
   //g2d.fillOval(x-15, y-15, -15, -15);
   //g2d.setColor(Color.BLACK);
   //g2d.fillOval(x-2, y-2, 5, 5);
   
   g2d.drawImage(img2,0,0,800,1200,null,null);
   g2d.drawImage(img,x-15,y-15,30,30,null,null);
  }
   
   
  private void pointTowardsMouse() {
   Point mouse = getMousePosition();
   if(mouse!=null)
   {
       
       if(mouse.x<x){
           deltaX=-1;
       
       }
       else{
           deltaX=1;
       }
         if(mouse.y<y){
           deltaY=-1;
       
       }
       else{
           deltaY=1;
       }
   }
   else{
       deltaX=0;
       deltaY=0;
       }
   }  
       
       
   
   
   public static void main(String[] args) throws InterruptedException {
       JFrame
        frame = new JFrame("My Game Frame");
       frame.setSize(60000, 6000);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       Game game = new Game();
       frame.add(game);
       
       while (true) {
           
           game.moveBall();
           game.pointTowardsMouse();
           game.repaint();
           Thread.sleep(10);
          
           
           
       }    
       
       
   }
       
     
}
   
   
   
   
   
   
   