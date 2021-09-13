package tbp;

public class Tensor {
	
	private double x;
    private double y;

    
    public Tensor(double x, double y) {
    	this.x = x;
    	this.y = y;
    }
    
    public double getX() {
    	return this.x;
    }
    
    public double getY() {
    	return this.y;
    }
    
    public void setX(double x) {
    	this.x = x;
    }
    
    public void setY(double y) {
    	this.y = y;
    }
    
    public Tensor adds(Tensor anotherTensor) {
    	
    	return new Tensor(this.x + anotherTensor.x, this.y + anotherTensor.y);
    	
    }
    
    public Tensor subtracts(Tensor anotherTensor) {
    	return new Tensor(this.x - anotherTensor.x, this.y - anotherTensor.y);
    }
    
    public Tensor multipliesScalar(double scalar) {
    	return new Tensor(this.x*scalar, this.y*scalar); 
    }

}
