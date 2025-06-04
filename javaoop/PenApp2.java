import java.awt.*;
import java.awt.event.*;

public class PenApp2 extends Frame{
    public int oldx = 0;
    public int oldy = 0;
    public int newx = 0;
    public int newy = 0;
    public int count = 0;
    public String message = "";

    public static void main(String[] args) {
        PenApp2 window = new PenApp2();
        window.setVisible(true);
    }

    public PenApp2(){
        setSize(600,500);
        setTitle("Pen 응용");
        MouseKeeper mouse = new MouseKeeper();
        addMouseListener(mouse);
    }

    private class MouseKeeper extends MouseAdapter{

        public void mousePressed(MouseEvent e){
            newx = e.getX();
            newy = e.getY();
            repaint ();
        }
    }

    public void paint(Graphics g){
        message = count++ + "번째 선";
        g.drawLine(oldx, oldy, newx, newy);
        g.drawString(message, newx, newy);
        oldx = newx;
        oldy = newy;
    }
}
