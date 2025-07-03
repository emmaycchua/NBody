

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 * @author Emma Chua eyc15
 *
 *
 */

public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;

	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Accessor for the y-velocity.
	 * @return value of this object's y-velocity
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double distanceSqrd = (this.myXPos - b.myXPos) * (this.myXPos - b.myXPos) + (this.myYPos - b.myYPos) * (this.myYPos - b.myYPos);
		return Math.sqrt(distanceSqrd);
	}

	public double calcForceExertedBy(CelestialBody b) {
		double G = 6.67*1e-11;
		double radiusSqrd = calcDistance(b) * calcDistance(b);
		double force = G * (this.myMass * b.myMass) / radiusSqrd;
		return force;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double F = calcForceExertedBy(b);
		double r = calcDistance(b);
		double dx = b.myXPos - this.myXPos;
		double F_x = F * (dx/r);
		return F_x;
	}
	public double calcForceExertedByY(CelestialBody b) {
		double F = calcForceExertedBy(b);
		double r = calcDistance(b);
		double dy = b.myYPos - this.myYPos;
		double F_y = F * (dy/r);
		return F_y;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody body: bodies){
			if (!body.equals(this)){
				double force = calcForceExertedByX(body);
				sum += force;
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody body: bodies){
			if (!body.equals(this)){
				double force = calcForceExertedByY(body);
				sum += force;
			}
		}
		return sum;
	}

	/**
	 * This is a mutator method, modifies state of a celestial body
	 * (position and velocity)
	 * @param deltaT the time-step used in updating
	 * @param xforce the force in the x-direction
	 * @param yforce the force in the y-direction
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		double a_x = xforce/this.myMass;
		double a_y = yforce/this.myMass;

		double nvx = myXVel + deltaT*a_x;
		double nvy = myYVel + deltaT*a_y;

		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;
		
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
