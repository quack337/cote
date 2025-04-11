package etcc.net.skhu.oo.racing.v8;
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveForwardBySteps(int steps) {
        this.position += steps;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(":");
        for (int d = 0; d < position; ++d)
            builder.append("-");
        return builder.toString();
    }
}