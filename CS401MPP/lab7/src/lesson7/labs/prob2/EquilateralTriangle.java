package lesson7.labs.prob2;

public class EquilateralTriangle implements Polygon {
	private double length;

	public EquilateralTriangle(double length) {
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double[] getSides() {
		double[] d = { length, length, length };
		return d;
	}
}
