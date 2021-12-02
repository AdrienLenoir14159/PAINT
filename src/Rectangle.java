import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure{
	/*
	 * Cette classe sert � d�finir un rectangle, et dans le cas particulier, un carr�.
	 */
	public Rectangle() {}
	
	public Rectangle(int px, int py, Color c ) {
		this.color = c;
		this.width = px;
		this.height = py;
	}

	public void setBoundingBox(int widthBB, int heightBB) {
		this.width = widthBB;
		this.height = heightBB;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.point.x, this.point.y, this.width, this.height);
	}

	public void setColor(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return null;
	}

	public void setPoint(Point p) {
		this.point = p;
	}
	
	public Point getPoint() {
		return null;
	}

	public String toString() {
		return "posX: " + this.point.x + ", posY: " + this.point.y + ", largeur: " + this.width + ", hauteur: " + this.height + ", couleur: " + this.color;
	}
}
