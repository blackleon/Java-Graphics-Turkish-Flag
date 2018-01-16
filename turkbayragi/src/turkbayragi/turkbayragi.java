package turkbayragi;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class turkbayragi extends JFrame
{
    public turkbayragi()
    {
        initialise();
    }
    
    private void initialise()
    {
        final int WindowSizeX = 765;
        final int WindowSizeY = 500;
        
        add(new Surface());
        
        setTitle("Template");
        setSize(WindowSizeX, WindowSizeY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                turkbayragi b2 = new turkbayragi();
                b2.setVisible(true);
            }
        });
        
    }
    
}
