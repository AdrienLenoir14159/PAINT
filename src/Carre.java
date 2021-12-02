import java.awt.Color;

public class Carre extends Rectangle{
	/*
	 * Cas particulier du rectangle.
	 */
	public Carre() {}
	
	public Carre(int px, int py, Color c ) {
		super(px,py,c);
		if (px<py) this.setBoundingBox(px,px);
		else this.setBoundingBox(py,py);
	}
}
