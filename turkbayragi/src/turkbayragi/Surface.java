
package turkbayragi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Surface extends JPanel
{
    private int G;
    private void Draw(Graphics g)
    {
        G=this.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        Color renk = new Color(227, 10, 23);
        
        g2d.setColor(renk);
        g2d.fillRect((G*1/30), 0, (int) (this.getWidth())-G*1/30, this.getHeight());
        
        g2d.setColor(Color.WHITE);
        g2d.fillOval((int) (G * 1/2)-(int)(G*1/4)+(G*1/30),
                                     G-(int)(G*3/4),
                                                           G*1/2,
                                                           G*1/2);
        
        g2d.setColor(renk);
        g2d.fillOval((int) (G * 1/2 - G * 1/8+G * 1/30),
                (int) (G * 1/2 - G * 1/5),
                                                    (int) (G*2/5),
                                                   (int) (G*2/5));
        g2d.setColor(Color.BLUE);
        
        /*
        g2d.fillOval((int) (G*17/24 + G*1/30),
                (int) (G*1/2 - G*1/8),
                                                    (int) (G*1/4),
                                                   (int) (G*1/4));
        */
        Point center = new Point(G*17/24 + G*1/30+G*1/8, G*1/2 - G*1/8+G*1/8);
        int counter=0;
        
        Point[] koseler = new Point[5];
        
        g2d.setColor(Color.WHITE);
        for(int radius = G*1/8; radius>0; radius--)
        {
            counter=0;
            for(int a=36; a<360; a+=72)
            {
                koseler[counter]=CalcPoint(center, radius, a);
                counter++;
            }
            for(int a = 0; a<5; a++)
            {
                Line2D l1 = new Line2D.Double(koseler[a], koseler[(a+2)%5]){};
                Line2D l2 = new Line2D.Double(koseler[(a+1)%5], koseler[(a+4)%5]){};
                
                g2d.draw(l1);
                g2d.draw(l2);
            }
        }
    }
    
    private Point CalcPoint(Point p, int radius, int angle)
    {
        int newX, newY;
        newX = (int) (p.x + radius * Math.cos(Math.toRadians(angle)));
        newY = (int) (p.y + radius * Math.sin(Math.toRadians(angle)));
    
        return new Point(newX, newY);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Draw(g);
    }
}