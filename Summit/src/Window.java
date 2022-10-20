import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Window {
    
    private JFrame frame;
    private Canvas canvas;

    private boolean closed;

    private int width;
    private int height;

    public Window(String title, int w, int h){

        width = w;
        height = h;

        frame = new JFrame(title);
        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);

        GraphicsConfiguration graphicsConfiguration = 
                GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();

        canvas = new Canvas(graphicsConfiguration);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setSize(width, height);
        canvas.setIgnoreRepaint(true);
        frame.add(canvas);

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed = true;
                super.windowClosing(e);
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                super.windowGainedFocus(e);
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                super.windowLostFocus(e);
            }
        });
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                width = canvas.getWidth();
                height = canvas.getHeight();
            }
        });

        frame.setVisible(true);
    }
}
