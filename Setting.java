package tbp;

public class Setting {
	private double interval;
	private int iterations;
	private double magnification;
	private final double windowSideLength = 600;

	public double getInterval() {
		return interval;
	}
	
	public int getIterations() {
		return iterations;
	}
	
	public double getMagnification() {
		return magnification;
	}
	
	public double getWindowSideLength() {
		return windowSideLength;
	}
	
	public void setInterval(double interval) {
		this.interval = interval;
	}
	
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	
	public void setMagnification(double magnification) {
		this.magnification = magnification;
	}
}
