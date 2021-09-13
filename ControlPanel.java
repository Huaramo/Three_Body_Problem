package tbp;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  

/*
 * The button does not show up in the canvas.
 * */

public class ControlPanel extends JFrame implements ActionListener{
	private JFrame frameForCanvas;
	private JButton confirm, clearAll;
    private JPanel panelTheGreat;
	private JTextField[][] textFields = new JTextField[3][2];
	private JTextField textFieldForZoom;
	private JTextField textFieldForIterations;
	
	
	public ControlPanel() {
	    super("Initial Settings");
	    
	    panelTheGreat = new JPanel();
	    panelTheGreat.setLayout(new FlowLayout());
	    panelTheGreat.setBackground(Color.WHITE);
	    
	    frameForCanvas = new JFrame("Trajectory");
	        
	}
	
	public JTextField[][] getTextFields(){
		return this.textFields;
	}
	
	public void actionPerformed(ActionEvent event){
		Object click = event.getSource();
		if(click == confirm) {
			setFrameForCanvas();
		}
		
		if(click == clearAll) {
			panelTheGreat.removeAll();
			setSubPanels();
		}
}
	
	public void setSubPanels() {
		JPanel panelForInputs = new JPanel();
	    panelForInputs.setLayout(new GridLayout(4,4));
	    panelForInputs.add(new JLabel("Parameter"));
	    panelForInputs.add(new JLabel("Position"));
	    panelForInputs.add(new JLabel("Mass"));
	    
	    for(int i = 0; i < 3; i++) {
	    	panelForInputs.add(new JLabel("Object"+String.valueOf(i+1)));
	    	for(int j = 0; j < 2; j++) {
	    	textFields[i][j] = new JTextField(10);
	    	textFields[i][j].setFont(new Font("Arial", Font.PLAIN, 10));
	    	panelForInputs.add(textFields[i][j]);
	    	}
	    	
	    }
	    
	    JPanel panelForIterations = new JPanel();
	    panelForIterations.setLayout(new GridLayout(1,2));
	    panelForIterations.add(new JLabel("Iterations"));
	    textFieldForIterations = new JTextField(10);
	    textFieldForIterations.setFont(new Font("Arial", Font.PLAIN, 10));
	    panelForIterations.add(textFieldForIterations);
	 
	    JPanel panelForZoom = new JPanel();
	    panelForZoom.setLayout(new GridLayout(1,2));
	    panelForZoom.add(new JLabel("Zoom"));
	    textFieldForZoom = new JTextField(10);
	    textFieldForZoom.setFont(new Font("Arial", Font.PLAIN, 10));
	    panelForZoom.add(textFieldForZoom);
	    
	    JPanel panelForButton = new JPanel();
	    panelForButton.setLayout(new GridLayout(1,1));
	    
	    
	    confirm = new JButton("Confirm");
	    confirm.addActionListener(this);
	    confirm.setFont(new Font("Arial", Font.PLAIN, 25));
	    panelForButton.add(confirm);
	    
	    JPanel panelForClearAll = new JPanel();
	    panelForClearAll.setLayout(new GridLayout(1,1));
	    clearAll = new JButton("Clear All");
	    clearAll.addActionListener(this);
	    clearAll.setFont(new Font("Arial", Font.PLAIN, 25));
	    panelForClearAll.add(clearAll);
	    
	    panelTheGreat.add(panelForInputs);
	    panelTheGreat.add(panelForIterations);
	    panelTheGreat.add(panelForZoom);
	    panelTheGreat.add(panelForButton);
	    panelTheGreat.add(panelForClearAll);
	    
	    setContentPane(panelTheGreat);
	}
	
	public void setFrameForCanvas() {
		Canvas canvas=new Canvas();
		canvas.setTextFields(this.getTextFields());
		canvas.setTextFieldForIterations(textFieldForIterations);
		canvas.setTextFieldForZoom(textFieldForZoom);
		canvas.setBackground(Color.WHITE);
		frameForCanvas.add(canvas);
		frameForCanvas.setSize(600, 600);
		frameForCanvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameForCanvas.setVisible(true);
	}
	
	
	

}
