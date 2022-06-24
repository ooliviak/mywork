/** A class that represents a path via pursuit curves. */
public class Path {
    private Point curr;
    private Point next;
    private Point point;

    public Path(double x, double y) {
        this.next = new Point(x, y);
        this.curr = new Point(0,0);
    }

    public double getCurrX() {
        return curr.getX();
    }

    public double getCurrY() {
        return curr.getY();
    }
    public double getNextX() {
        return next.getX();
    }

    public double getNextY() {
        return next.getY();
    }

    public Point getCurrentPoint(){
        return new Point(getCurrX(), getCurrY());
    }

    public void setCurrentPoint(Point point) {
        curr = point;
    }

    public void iterate(double dx, double dy) {
        curr = next;
        next = new Point(curr.getX()+ dx, curr.getY() + dy );
    }




}
