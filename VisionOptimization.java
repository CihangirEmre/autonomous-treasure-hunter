import java.awt.*;
import java.util.*;

public class VisionOptimization {
    private Set<Point> visibleArea; // Görülebilen karelerin saklanacağı küme
    Character c = new Character("Messi");

    public VisionOptimization() {
        visibleArea = new HashSet<>();
        // Başlangıçta karakterin konumunu görülebilir karelere ekle
        updateVisibleTiles(new Point(c.getLocation().getX(),c.getLocation().getY())); // Örnek olarak (0, 0) karakterin başlangıç konumu
    }

    // Karakterin konumunu güncelleyerek görüş alanını günceller
    public void updateCharacterPosition(Point newPosition) {
        // Karakterin yeni konumunu güncelle ve görüş alanını yeniden hesapla
        updateVisibleTiles(newPosition);
    }

    // Belirli bir konumda görülebilecek kareleri günceller
    private void updateVisibleTiles(Point position) {
        // Görüş alanını temizle
        visibleArea.clear();

        // Karakterin etrafındaki kareleri görüş alanına ekle
        for (int dx = -3; dx <= 3; dx++) {
            for (int dy = -3; dy <= 3; dy++) {
                Point tile = new Point(position.x + dx, position.y + dy);
                visibleArea.add(tile);
            }
        }
    }

    // Test için main metodu
    /*public static void main(String[] args) {
        VisionOptimization vision = new VisionOptimization();

        // Karakterin hareketi simüle ediliyor
        Point newPosition = new Point(5, 5); // Örnek olarak yeni konum (5, 5)
        vision.updateCharacterPosition(newPosition);

        // Görülebilen kareleri yazdır
        System.out.println("Görülebilen Kareler:");
        for (Point tile : vision.visibleTiles) {
            System.out.println("(" + tile.x + ", " + tile.y + ")");
        }
    }*/
}
