import java.awt.*;

class Node implements Comparable<Node> {
    private final Point point; // Point nesnesini içeriyoruz
    private final int weight;

    public Node(Point point, int weight) {
        this.point = point;
        this.weight = weight;
    }

    public Point getPoint() {
        return point;
    }

    public int getWeight() {
        return weight;
    }
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}