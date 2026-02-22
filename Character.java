import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Character extends Thing{
    private String ID;
    private Location location;
    BufferedImage image;
    static final int VISION_RANGE = 7;
    public ArrayList<Point> characterPath= new ArrayList<>();
    Random rand = new Random();

    public Character(String ID) {
        super(null,null,null,null);
        this.ID = ID;
        setDimension(generateDimension());
        setLocation(generateLocation());
        try {
            setImage(ImageIO.read(new FileImageInputStream(new File("Messi.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public Dimensions generateDimension() {
        return new Dimensions(Game.UNIT_SIZE,Game.UNIT_SIZE);
    }

    public Location generateLocation(){
        Random rand = new Random();
        int randomX = rand.nextInt(Game.numberOfCols-getDimension().getWidht()/Game.UNIT_SIZE)*Game.UNIT_SIZE;
        int randomY = rand.nextInt(Game.numberOfRows-getDimension().getHeight()/Game.UNIT_SIZE)*Game.UNIT_SIZE;
        return new Location(randomX,randomY);
    }
    @Override
    public void createField() {

    }
    public void createCharacterOnMatrix(){
        int firstX = getLocation().getX()/Game.UNIT_SIZE;
        int diffX = 1;
        int firstY = getLocation().getY()/Game.UNIT_SIZE;
        int diffY = 1;
        for(int i = 0; i < diffX; i++){ //Karakterin x uzunluğu kadar döner
            for(int j = 0; j < diffY; j++){ //Karakterin y uzunluğu kadar döner
                Game.mapMatrix[firstX + i][firstY + j] = 4; //Karakterin ilk (x,y) değerinde son (x,y), değerine kadar
                // olan bölgeyi kapsayan alanı 4 ile doldurur.
            }
        }
    }

    public void moveRight(){
        int currentX = getLocation().getX();
        int currentY = getLocation().getY();

        int newX = currentX + Game.UNIT_SIZE;
        int newY = currentY;

        if(isValidMove(newX,newY)){
            getLocation().setX(newX);
            getLocation().setY(newY);
            characterPath.add(new Point(getLocation().getX(), getLocation().getY()));  // Yeni konumu characterPath'e ekleyin
            Game.mapMatrix[newX / Game.UNIT_SIZE][newY / Game.UNIT_SIZE] = 4;
        }
        else {
            int direction = rand.nextInt(4);

            switch (direction){
                case 0:
                    for (int i=0;i<5;i++){
                        moveUp();
                    }

                    break;
                case 1:
                    for (int i=0;i<5;i++){
                        moveDown();
                    }

                    break;
                case 2:
                    for (int i=0;i<5;i++){
                        moveLeft();
                    }

                    break;
                case 3:
                    for (int i=0;i<5;i++){
                        moveRight();
                    }

                    break;
                default:
                    System.out.println("Geçersiz yön!");
                    break;
            }
        }
    }
    public void moveLeft(){
        int currentX = getLocation().getX();
        int currentY = getLocation().getY();

        int newX = currentX - Game.UNIT_SIZE;
        int newY = currentY;



        if(isValidMove(newX,newY)){
            getLocation().setX(newX);
            getLocation().setY(newY);
            characterPath.add(new Point(getLocation().getX(), getLocation().getY()));  // Yeni konumu characterPath'e ekleyin
            Game.mapMatrix[newX / Game.UNIT_SIZE][newY / Game.UNIT_SIZE] = 4;
        }
        else {
            int direction = rand.nextInt(4);

            switch (direction){
                case 0:
                    for (int i=0;i<5;i++){
                        moveUp();
                    }

                    break;
                case 1:
                    for (int i=0;i<5;i++){
                        moveDown();
                    }

                    break;
                case 2:
                    for (int i=0;i<5;i++){
                        moveLeft();
                    }

                    break;
                case 3:
                    for (int i=0;i<5;i++){
                        moveRight();
                    }

                    break;
                default:
                    System.out.println("Geçersiz yön!");
                    break;
            }
        }
    }
    public void moveUp(){
        int currentX = getLocation().getX();
        int currentY = getLocation().getY();

        int newX = currentX;
        int newY = currentY + Game.UNIT_SIZE;

        if(isValidMove(newX,newY)){
            getLocation().setX(newX);
            getLocation().setY(newY);
            characterPath.add(new Point(getLocation().getX(), getLocation().getY()));  // Yeni konumu characterPathe ekleme
            Game.mapMatrix[newX / Game.UNIT_SIZE][newY / Game.UNIT_SIZE] = 4;
        }
        else {
            int direction = rand.nextInt(4);

            switch (direction){
                case 0:
                    for (int i=0;i<5;i++){
                        moveUp();
                    }

                    break;
                case 1:
                    for (int i=0;i<5;i++){
                        moveDown();
                    }

                    break;
                case 2:
                    for (int i=0;i<5;i++){
                        moveLeft();
                    }

                    break;
                case 3:
                    for (int i=0;i<5;i++){
                        moveRight();
                    }

                    break;
                default:
                    System.out.println("Geçersiz yön!");
                    break;
            }
        }
    }
    public void moveDown(){
        int currentX = getLocation().getX();
        int currentY = getLocation().getY();

        int newX = currentX;
        int newY = currentY - Game.UNIT_SIZE;

        if(isValidMove(newX,newY)){
            getLocation().setX(newX);
            getLocation().setY(newY);
            characterPath.add(new Point(getLocation().getX(), getLocation().getY()));  // Yeni konumu characterPath'e ekleyin
            Game.mapMatrix[newX / Game.UNIT_SIZE][newY / Game.UNIT_SIZE] = 4;
        }
        else {
            int direction = rand.nextInt(4);

            // Belirlenen yöne hareket et
            switch (direction){
                case 0:
                    for (int i=0;i<5;i++){
                        moveUp();
                    }

                    break;
                case 1:
                    for (int i=0;i<5;i++){
                        moveDown();
                    }

                    break;
                case 2:
                    for (int i=0;i<5;i++){
                        moveLeft();
                    }

                    break;
                case 3:
                    for (int i=0;i<5;i++){
                        moveRight();
                    }

                    break;
                default:
                    System.out.println("Geçersiz yön!");
                    break;
            }
        }
    }

    public void autonomousMove(){
        List<Point> visibleArea = checkVision(); // Görünen alanı arraylistte tutma

        int currentX = getLocation().getX();
        int currentY = getLocation().getY();


        int direction = rand.nextInt(4);

        // Belirlenen yöne hareket et
        switch (direction){
            case 0:
                for (int i=0;i<5;i++){
                    moveUp();
                }
                break;
            case 1:
                for (int i=0;i<5;i++){
                    moveDown();
                }
                break;
            case 2:
                for (int i=0;i<5;i++){
                    moveLeft();
                }
                break;
            case 3:
                for (int i=0;i<5;i++){
                    moveRight();
                }
                break;
            default:
                System.out.println("Geçersiz yön!");
                break;
        }
    }

    // Belirli bir konumdan itibaren belirli bir yöne kadar olan adım sayısını döndürür
    private int countStepsInDirection(int x, int y) {
        int count = 0;
        while (isValidMove(x, y)) {
            x += Game.UNIT_SIZE;
            count++;
        }
        return count;
    }

    public List<Point> checkVision() {
        List<Point> visibleArea = new ArrayList<>();//Görünen alanı tutan arraylist
        VisionOptimization vision = new VisionOptimization();//Optimize bir görüş açısı için oluşturulmuş sınıfın nesnesi
        List<Point> treasureLocations=  new ArrayList<>();//Sandıkların konumlarını tutan arraylist

        int currentX = getLocation().getX();
        int currentY = getLocation().getY();

        Point characterPosition = new Point(currentX, currentY); // Karakterin mevcut konumu

        vision.updateCharacterPosition(characterPosition);//Karakterin mevut konumunu güncelleme

        // Karakterin görüş açısının sınırlarını belirleme
        int startX = Math.max(0, currentX / Game.UNIT_SIZE - 3); // Sol sınır
        int endX = Math.min(Game.numberOfCols - 1, currentX / Game.UNIT_SIZE + 3); // Sağ sınır
        int startY = Math.max(0, currentY / Game.UNIT_SIZE - 3); // Üst sınır
        int endY = Math.min(Game.numberOfRows - 1, currentY / Game.UNIT_SIZE + 3); // Alt sınır

        // Görüş açısındaki her kareyi kontrol etme
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                // Engellere çarpmadan görülebilen kareleri listeye ekle
                if (x != currentX / Game.UNIT_SIZE || y != currentY / Game.UNIT_SIZE) {
                    if (Game.mapMatrix[x][y] == 0) { // Gidilebilen kare
                        visibleArea.add(new Point(x * Game.UNIT_SIZE, y * Game.UNIT_SIZE));
                    }
                }
                // Görüş alanı içindeki sandıkların konumunu kontrol et
                if (x != currentX / Game.UNIT_SIZE || y != currentY / Game.UNIT_SIZE) {
                    //Sandıklar görüş alanı içinde mi
                    if (Game.mapMatrix[x][y] == 3 && isVisibleForTreasures(characterPosition, new Point(x * Game.UNIT_SIZE, y * Game.UNIT_SIZE))) {
                        treasureLocations.add(new Point(x * Game.UNIT_SIZE, y * Game.UNIT_SIZE));
                        //Graph graph = new Graph(treasureLocations.size());
                        //graph.addEdge();
                        //DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
                    }
                }
            }
        }

        return visibleArea;
    }
    // Belirli bir noktanın görüş alanında olup olmadığını kontrol eder
    private boolean isVisibleForTreasures(Point characterPosition, Point treasurePosition) {
        int distanceX = Math.abs(characterPosition.x - treasurePosition.x) / Game.UNIT_SIZE;
        int distanceY = Math.abs(characterPosition.y - treasurePosition.y) / Game.UNIT_SIZE;
        return distanceX <= 3 && distanceY <= 3; // Görüş açısına bağlı olarak kontrol yap
    }

    public boolean isValidMove(int newX, int newY) {
        // Yeni pozisyonun ekran sınırlarının dışında olup olmadığını kontrol et
        if (newX < 0 || newX >= Game.numberOfCols * Game.UNIT_SIZE || newY < 0 || newY >= Game.numberOfRows * Game.UNIT_SIZE) {
            // Eğer yeni pozisyon ekranın dışındaysa, geçersiz bir hareket
            return false;
        }

        // Yeni pozisyonun engellerle çakışıp çakışmadığını kontrol et
        int newXIndex = newX / Game.UNIT_SIZE;
        int newYIndex = newY / Game.UNIT_SIZE;
        if (Game.mapMatrix[newXIndex][newYIndex] == 1 || Game.mapMatrix[newXIndex][newYIndex] == 2) {
            // Eğer yeni pozisyon bir engelle çakışıyorsa, geçersiz bir hareket
            return false;
        }

        // Geçerli bir hareket ise true döndür
        return true;
    }

}
