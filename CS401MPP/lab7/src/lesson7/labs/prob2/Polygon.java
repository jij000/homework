package lesson7.labs.prob2;

public interface Polygon extends ClosedCurve {

	public double[] getSides();

	public default double computePerimeter() {
		double perimeter = 0.0;
		double[] dArr = getSides();

		for (double d : dArr) {
			perimeter += d;
		}

		return perimeter;
	}
}
