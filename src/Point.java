import java.io.Serializable;

public class Point implements Serializable{
	/*
	 * Cette classe d�finit des points qui repr�senteront les coordonn�es de
	 * d�part et d'ariv�e des diff�rentes Figures.
	 */
	
	// Si Point n'impl�mente pas Serializable, m�me si Figure le fait, nous ne
	// pourrons pas s�rialiser de Figure, car elles contiennent un Point.
	protected int x;
	protected int y;
	
	public Point() {
		this.setX(0);
		this.setY(0);
	}
	
	public Point(int a, int b) {
		this.setX(a);
		this.setY(b);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
