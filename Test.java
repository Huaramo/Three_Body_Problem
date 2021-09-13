package tbp;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
public class Test {
    private ControlPanel frame;
    
    public ControlPanel getFrame() {
    	return frame;
    }
    
    public  void setFrame() {
    	this.frame = new ControlPanel();
    	this.frame.setSubPanels();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.setFrame();
		test.getFrame().setSize(300, 300);
		test.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.getFrame().setVisible(true);
		
		

	}

}
