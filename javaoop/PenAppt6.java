import java.awt.*;
import java.awt.event.*;

class Ptt6{
    int x;
    int y;
}
public class PenAppt6 extends Frame {
    public Ptt6 startPoint = null;
    public Ptt6 endPoint = null;
    public boolean firstClick = true;

    public static void main(String[] args) {
        PenAppt6 window = new PenAppt6();
        window.setVisible(true);
        }

    public PenAppt6() {
        setSize(600, 500);
        setTitle("Pen 응용");
        MouseKeeper mouse = new MouseKeeper();
        addMouseListener(mouse);

        startPoint = new Ptt6();
        endPoint = new Ptt6();
    }

    private class MouseKeeper extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if (firstClick){
                startPoint.x = e.getX();
                startPoint.y = e.getY();
                firstClick = false;
            } else{
                endPoint.x = e.getX();
                endPoint.y = e.getY();
                firstClick = true;
                repaint();
            }
        }
    }

    public void paint(Graphics g){
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, startPoint.y);
        g.drawLine(startPoint.x, startPoint.y, startPoint.x, endPoint.y);
        g.drawLine(endPoint.x, startPoint.y, endPoint.x, endPoint.y);
        g.drawLine(startPoint.x, endPoint.y, endPoint.x, endPoint.y);
    }
}
