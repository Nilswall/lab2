public interface Loading {
    private Stack<Car> cargo;

    private int maxsize;

    void loadCargo();

    void offLoadCargo();

    public double avståndsFormeln(Point2D point1, Point2D point2) {
        double dx = point2.getX() - point1.getX();
        double dy = point2.getY() - point1.getY();
        return sqrt(dx * dx + dy * dy);
    }
}