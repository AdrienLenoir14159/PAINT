import java.awt.Color;

public class Cercle extends Ellipse{
	/*
	 * Cas particulier du cercle.
	 */
	public Cercle() {}
	
	public Cercle(int px, int py, Color c ) {
		super(px,py,c);
		if (px<py) this.setBoundingBox(px,px);
		else this.setBoundingBox(py,py);
	}
}
