import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class OvalDraw extends Oval {
    public OvalDraw() {
        super(0,0,0,0);
    }

public OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn) {
    super(positionXIn, positionYIn, widthIn, heightIn);
}

public void paintComponent(Graphics g) {
    g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
    System.out.format("Ovaldraw.paintComponent(x=%d, y=%d, w=%d, h=%d)\n",
        getPositionX(), getPositionY(), getWidth(), getHeight());
}

}

class SmileyFace extends OvalDraw {
    private OvalDraw eye;

    public SmileyFace() {
        super(0,0,0,0);
        eye = new OvalDraw(10,10,100,100);
    }

    public SmileyFace(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
        
        int eyeHeight = heightIn / 6;
        int eyeWidth = eyeHeight /2;
        int eyePositionX = positionXIn + (widthIn /3)-(eyeWidth/2);
        int eyePositionY = positionYIn + (heightIn /3)-(eyeHeight/2);       
        eye = new OvalDraw(eyePositionX,eyePositionY,eyeWidth,eyeHeight);
        
    }


     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        eye.paintComponent(g);
        g.drawArc(getPositionX(), getPositionY()+ (getHeight()/2), getWidth()-10, getHeight()-10, 45, 90);
    }
}

class SmileyPanel extends JPanel {
    private SmileyFace mySmileyFace;

    public SmileyPanel() {
        mySmileyFace = new SmileyFace(100,100,80,160);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mySmileyFace.paintComponent(g);


    }
}

public class FaceDraw {
    public static void main(String[] args) {
        System.out.println("FaceDraw");


        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame myFrame = new JFrame("Smiley");
        myFrame.setBounds(100,100,600,400);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        SmileyPanel mySmileyPanel = new SmileyPanel();
        myFrame.add(mySmileyPanel);
        myFrame.setVisible(true);

    }
}