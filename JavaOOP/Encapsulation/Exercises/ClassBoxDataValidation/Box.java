package OOP.Encapsulation.Exercises.ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }


    private boolean isValidSide(double parameter) {
        return parameter > 0;
    }

    private void setLength(double length) {
        if (!isValidSide(length)) {
            throw new IllegalStateException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    private void setWidth(double width) {
        if (!isValidSide(width)) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    private void setHeight(double height) {
        if (!isValidSide(height)) {
            throw new IllegalStateException("Height cannot be zero or negative.");
        }

        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
