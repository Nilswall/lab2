public class Workshop implements Loading{
    private Stack<Car> cargo;
    private final int maxsize;
    private Point2D point;

    public Workshop(int maxsize) {
        this.cargo = new Stack<>();
        this.maxsize = maxsize;
        this.point = point;
    }

    private getPoint() {return this.point;} // Ärva från nåt, tsm med avståndsformeln?

    public void loadCargo(Car car) {
        if (this.cargo.size() >= this.maxsize) {
            throw new RuntimeException("Workshop is full");

        } else if (avståndsFormeln(car.getpoint(), this.getPoint()) > 8) {
            throw new RuntimeException("Cargo not at workshop");

        } else {
            this.cargo.push(car);
            car.setPos(this.getpoint());
        }
    }

    public void offLoadCargo(Car car) {
        Car a_car = this.cargo.pop();
        Point2D point1 = new Point2D.Double(this.getpoint().getX()-2, this.getpoint().getY()-2);
        a_car.setPos(point1);
    }
}