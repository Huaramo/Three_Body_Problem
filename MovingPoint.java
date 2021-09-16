package tbp;
import java.lang.Math;

public class MovingPoint {
    private double mass;
    private Tensor position, velocity;
    /*
     * Getters and setters.
     * */
    public MovingPoint(Position position, Velocity velocity, double mass) {
    	this.position = position;
    	this.velocity = velocity;
    	this.mass = mass;
    	
    }
    
    public double getMass() {
    	return this.mass;
    }
    
    public Tensor getPosition() {
    	return this.position;
    }
    
    public Tensor getVelocity() {
    	return this.velocity;
    }
    
    public void setMass(double mass) {
    	this.mass = mass;
    }
    
    public void setPosition(Tensor position) {
    	this.position = position;
    }
    
    public void setVelocity(Tensor velocity) {
    	this.velocity = velocity;
    }
    
    
    
    public double distance(MovingPoint anotherPoint) {
   
    	double xDistance = Math.abs(this.directionFrom(anotherPoint).getX());
    	double yDistance = Math.abs(this.directionFrom(anotherPoint).getY());
    	return Math.hypot(xDistance, yDistance);
    	
    }
    
   public Tensor directionFrom(MovingPoint anotherPoint) {
	   return this.getPosition().subtracts(anotherPoint.getPosition());
   }
    
    public Velocity accelerationFrom(MovingPoint anotherPoint) {
    	double dist = this.distance(anotherPoint);
    	double anotherPointMass = anotherPoint.getMass();
    	Tensor direction = this.directionFrom(anotherPoint);
    	double coefficients = -1*anotherPointMass/Math.pow(dist, 2);
    	
    	return new Velocity(coefficients*direction.getX(), coefficients*direction.getY());
    	
    }
    
    
    public void updateVelocity(MovingPoint anotherPoint, Setting setting) {
    	Tensor deltaV = this.accelerationFrom(anotherPoint).multipliesScalar(setting.getInterval());
    	Tensor updatedV = this.getVelocity().adds(deltaV);
    	this.setVelocity(updatedV);
    }
    
    public void updatePosition(MovingPoint anotherPoint, Setting setting) {
    	this.updateVelocity(anotherPoint, setting);
    	Tensor delta = this.getVelocity().multipliesScalar(setting.getInterval());
    	Tensor updated = this.getPosition().adds(delta); 
    	this.setPosition(updated);
    }
    
    
}
