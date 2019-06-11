package lesson7.labs.prob2;

public class Ellipse implements ClosedCurve {
	private double semiMajorAxis;
	private double ellipIntegralAtEccentricity;

	public Ellipse(double semiMajorAxis, double ellipIntegralAtEccentricity) {
		this.semiMajorAxis = semiMajorAxis;
		this.ellipIntegralAtEccentricity = ellipIntegralAtEccentricity;
	}

	public double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(double semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	public double getEllipIntegralAtEccentricity() {
		return ellipIntegralAtEccentricity;
	}

	public void setEllipIntegralAtEccentricity(double ellipIntegralAtEccentricity) {
		this.ellipIntegralAtEccentricity = ellipIntegralAtEccentricity;
	}

	@Override
	public double computePerimeter() {
		return 4 * semiMajorAxis * ellipIntegralAtEccentricity;
	}
}
