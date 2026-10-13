abstract class Shape {
    abstract double area();
}

class Circle extends Shape {

    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double a, b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double area() {
        return a * b;
    }
}

class Triangle extends Shape {
    double h, b;

    Triangle(double h, double b) {
        this.h = h;
        this.b = b;
    }

    double area() {
        return (1 / 2) * h * b;
    }
}

class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Triangle(10, 20);
        shapes[3] = new Circle(3);

        double total = 0;
        double largest = 0;

        for(Shape i : shapes) {
            System.out.println(i.area());
            total += i.area();
            if( i.area() > largest) largest = i.area();
        }
        System.out.println("Total Area :" + total);
        System.out.println("Largest Area :" + largest);
    }
}