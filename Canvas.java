package tbp;
import javax.swing.*;
import java.awt.*;  
import java.awt.geom.Line2D; 
public class Canvas extends JPanel{
	private JTextField[][] textFields;
	private JTextField textFieldForZoom;
	private JTextField textFieldForIterations;
	
	public void setTextFields(JTextField[][] textFields) {
		this.textFields = textFields;
	}
	
	public void setTextFieldForIterations(JTextField textFieldForIterations) {
		this.textFieldForIterations = textFieldForIterations;
	}
	
	public void setTextFieldForZoom(JTextField textFieldForZoom) {
		this.textFieldForZoom = textFieldForZoom;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    //g2.setColor(Color.CYAN);
		Setting setting = new Setting();
		setting.setInterval(0.01);
		
		String inputForIterations =textFieldForIterations.getText();
		setting.setIterations(Integer.valueOf(inputForIterations));
		
		String inputForZoom =textFieldForZoom.getText();
		setting.setMagnification(Double.valueOf(inputForZoom));
		String[] position1 = textFields[0][0].getText().split(",");
		Position positionPlanet1 = new Position(Double.valueOf(position1[0]), Double.valueOf(position1[1]));
		String[] position2 = textFields[1][0].getText().split(",");
		Position positionPlanet2 = new Position(Double.valueOf(position2[0]), Double.valueOf(position2[1]));
		String[] position3 = textFields[2][0].getText().split(",");
		Position positionPlanet3 = new Position(Double.valueOf(position3[0]), Double.valueOf(position3[1]));

		String mass1 = textFields[0][1].getText();
		double massPlanet1 = Double.valueOf(mass1);
		String mass2 = textFields[1][1].getText();
		double massPlanet2 = Double.valueOf(mass2);
		String mass3 = textFields[2][1].getText();
		double massPlanet3 = Double.valueOf(mass3);
		
		MovingPoint planet1 = new MovingPoint(positionPlanet1, new Velocity(0, 0), massPlanet1);
		MovingPoint planet2 = new MovingPoint(positionPlanet2, new Velocity(0, 0), massPlanet2);
		MovingPoint planet3 = new MovingPoint(positionPlanet3, new Velocity(0, 0), massPlanet3);
        
		double previousX = 0;
		double previousY = 0;
		for(int i = 0; i < setting.getIterations(); i++) {
			planet1.updateVelocity(planet2, setting);
			planet1.updateVelocity(planet3, setting);
			planet2.updateVelocity(planet1, setting);
			planet2.updateVelocity(planet3, setting);
			planet3.updateVelocity(planet1, setting);
			planet3.updateVelocity(planet2, setting);
		
			planet1.updatePosition(planet2, setting);
			planet1.updatePosition(planet3, setting);
			planet2.updatePosition(planet1, setting);
			planet2.updatePosition(planet3, setting);
			planet3.updatePosition(planet1, setting);
			planet3.updatePosition(planet2, setting);
			
			double posX=planet1.getPosition().getX();
	    	double posY=planet1.getPosition().getY();
	    	double setOff = setting.getWindowSideLength()/2;
		    if(i > 0) {
		    	double x = previousX + setting.getMagnification()*(posX-previousX)+setOff;
		    	double y = previousY + setting.getMagnification()*(posY-previousY)+setOff;
		    	Shape l = new Line2D.Double(x, y, x, y);
		    	g2.draw(l);
		    }
            previousX = posX;
            previousY = posY;
		}
		
	}
	


}
