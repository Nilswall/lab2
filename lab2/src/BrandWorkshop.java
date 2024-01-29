public class BrandWorkshop extends Workshop {
    private final String model; // The allowed modelname

    public BrandWorkshop(Stack<Car> customerCars, int maxsize, Point2D point, String model){
        super(customerCars, maxsize, point);
        this.model = model;
    }

    public void checkModel (Car car) {
        if (Car.modelName != this.model) {
                throw new IllegalArgumentException("Invalid car model");
        }
    }

    public void loadCargo(Car car) {
        if (this.cargo.size() >= this.maxsize) {
            throw new RuntimeException("Workshop is full");
        } else if (avståndsFormeln(car.getpoint(), this.getPoint()) > 8) {
            throw new RuntimeException("Cargo not at workshop");

        } else {
            checkModel(); // Slänger compile time error?
            this.cargo.push(car);
            car.setPos(this.getpoint());
        }
    }
}