import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.*;


public class Game extends JPanel implements ActionListener {
    static Random rand = new Random();
    static Timer timerObstacle;
    private BufferedImage image0,image1,image2,image3,image4,image5;
    static final int UNIT_SIZE = 8;
    static final int SCREEN_WIDTH = 1000;//(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
    static final int SCREEN_HEIGHT = 500;//(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()-40);
    static final int DIVISION_WIDTH = SCREEN_WIDTH/2;

    private int topX=rand.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    private int topdirX=2;
    private int topY=rand.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    private int topdirY=2;



    static int numberOfRows = SCREEN_HEIGHT/UNIT_SIZE; //y'lerin sayısı
    static int numberOfCols = SCREEN_WIDTH/UNIT_SIZE;  //x'lerin sayısı

    static int[][] mapMatrix = new int[numberOfCols][numberOfRows];


    ArrayList<String> namesOfObstacles = new ArrayList<>();

    ArrayList<String> namesOfChests = new ArrayList<>();
    static ArrayList<ArrayList<Obstacle>> obstacles = new ArrayList<>();

    static ArrayList<ArrayList<Chest>> chests = new ArrayList<>();
    static int obstacleTypes = 6;
    static int chestTypes = 4;
    static ArrayList<Integer> obstacleNum = new ArrayList<Integer>();
    static ArrayList<Integer> chestNum = new ArrayList<Integer>();

    static ArrayList<BufferedImage> images = new ArrayList<>();

    static ArrayList<Location> bannedLocs = new ArrayList<>();
    static Character c = new Character("Messi");

    int beex,beey;
    int birdx,birdy;
    int beeDir = 1;
    int birdDir = 1;

    static ArrayList<Location> beeLocs = new ArrayList<>();
    static ArrayList<Location> birdLocs = new ArrayList<>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.red);

        g.fillOval(topX,topY,20,20);


        //Engellerin png olarak yüklenmesi
        for(int k = 0; k < obstacleTypes; k++){
            for (int l = 0; l<obstacles.get(k).size();l++) {
                Obstacle obs = obstacles.get(k).get(l);
                if (obs instanceof Bee){
                    //g.drawImage(obstacles.get(k).get(l).getImage(), beex, beey, 2*UNIT_SIZE , 2*UNIT_SIZE , this);
                    g.drawImage(obstacles.get(k).get(l).getImage(), beeLocs.get(l).getX(), beeLocs.get(l).getY(), 2*UNIT_SIZE , 2*UNIT_SIZE , this);
                }else if (obs instanceof Bird){
                    //g.drawImage(obstacles.get(k).get(l).getImage(), birdx, birdy, 2*UNIT_SIZE , 2*UNIT_SIZE , this);
                    g.drawImage(obstacles.get(k).get(l).getImage(), birdLocs.get(l).getX(), birdLocs.get(l).getY(), 2*UNIT_SIZE , 2*UNIT_SIZE , this);
                }//else if (obs instanceof Mountain){
//                    if (obs instanceof WinterMountain){
//
//                    }else{
//
//                    }
//                }else if (obs instanceof Rock){
//                    if (obs instanceof WinterRock){
//
//                    }else{
//
//                    }
//                }else if (obs instanceof Tree){
//                    if (obs instanceof WinterTree){
//
//                    }else{
//
//                    }
//                }else if (obs instanceof Wall){
//                    if (obs instanceof WinterWall){
//
//                    }else{
//
//                    }
//                }else System.out.println("obstacles Listesine Geçersiz Bir Eleman Konulmuş. Engel Konmalı!!!\n");
                else {
                    g.drawImage(obstacles.get(k).get(l).getImage(), obstacles.get(k).get(l).getLocation().getX(), obstacles.get(k).get(l).getLocation().getY(), obstacles.get(k).get(l).getDimensions().getWidht(), obstacles.get(k).get(l).getDimensions().getHeight(), this);
                }
                //g.drawImage(obstacles.get(k).get(l).getImage(), obstacles.get(k).get(l).getLocation().getX(), obstacles.get(k).get(l).getLocation().getY(),  100,  100, this);

                //g.drawImage(image0,200,200,200,200,this);
            }
        }

        //Sandıkların png olarak yüklenmesi
        for(int k = 0; k < chestTypes; k++){
            for (int l = 0; l < chests.get(k).size();l++){
                g.drawImage(chests.get(k).get(l).getImage(), chests.get(k).get(l).getLocation().getX(), chests.get(k).get(l).getLocation().getY(), chests.get(k).get(l).getDimensions().getWidht(), chests.get(k).get(l).getDimensions().getHeight(), this);
            }
        }

        g.setColor(Color.ORANGE);
        for (Point point : c.characterPath) {
            int x = point.x;
            int y = point.y;
            g.fillRect(x, y, UNIT_SIZE, UNIT_SIZE);
        }

        // Daha sonra karakterin son konumunu çizin
        g.drawImage(c.getImage(), c.getLocation().getX(), c.getLocation().getY(),
                c.getDimension().getWidht(), c.getDimension().getHeight(), this);

    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Get the width and height of the panel
        int width = SCREEN_WIDTH;
        int height = SCREEN_HEIGHT;

        // Draw the first section with a color
        Color customColor1 = new Color(205,201,201);
        g.setColor(customColor1);
        g.fillRect(0, 0, DIVISION_WIDTH, height);

        // Draw the second section with a different color
        Color customColor2 = new Color(0,191,255);
        g.setColor(customColor2);
        g.fillRect(DIVISION_WIDTH, 0, width - DIVISION_WIDTH, height);
        draw(g);
    }
    public void draw(Graphics g){
        //Izgara çizilir.
        for (int col = 0; col < numberOfCols; col++) {
            for (int row = 0; row < numberOfRows; row++) {
                if (mapMatrix[col][row] == 1) {
                    g.setColor(Color.WHITE); // Kareyi beyaz renkte çiz
                    g.fillRect(col * UNIT_SIZE, row * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE); // Kareyi çiz
                } else if (mapMatrix[col][row] == 2){
                    g.setColor(Color.RED); // Kareyi kırmızı renkte çiz
                    g.fillRect(col * UNIT_SIZE, row * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE); // Kareyi çiz
                } else if (mapMatrix[col][row] == 3){
                    g.setColor(Color.YELLOW); // Kareyi sarı renkte çiz
                    g.fillRect(col * UNIT_SIZE, row * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE); // Kareyi çiz
                } else {
                    g.setColor(Color.BLACK);
                    g.drawRect(col * UNIT_SIZE, row * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE); // Kareyi çerçeve olarak çiz
                }
            }
        }
//        //Izgara çizilir.
//        for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
//            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//        }
//        for(int j = 0; j < SCREEN_WIDTH/UNIT_SIZE; j++){
//            g.drawLine(0, j*UNIT_SIZE, SCREEN_WIDTH, j*UNIT_SIZE);
//        }
    }

    public Game() {

        timerObstacle = new Timer(300,this);

        //mapMatrix'inin tüm elemanlarına başlangıç olarak 0 atama işlemi
        for (int i = 0; i < mapMatrix.length; i++) {
            for (int j = 0; j < mapMatrix[0].length; j++) {
                mapMatrix[i][j] = 0;
            }
        }



        for (int i = 0; i < obstacleTypes; i++){
            obstacles.add(new ArrayList<Obstacle>());
        }

        for (int j = 0; j < chestTypes; j++){
            chests.add(new ArrayList<Chest>());
        }

        namesOfObstacles.add("Bee");
        namesOfObstacles.add("Bird");
        namesOfObstacles.add("Mountain");
        namesOfObstacles.add("Rock");
        namesOfObstacles.add("Tree");
        namesOfObstacles.add("Wall");

        /*
        Bee      #0
        Bird     #1
        Mountain #2
        Rock     #3
        Tree     #4
        Wall     #5
         */

        obstacleNum.add(5); //Bee
        obstacleNum.add(5); //Bird
        obstacleNum.add(2); //Mountain
        obstacleNum.add(4); //Rock
        obstacleNum.add(4); //Tree
        obstacleNum.add(4); //Wall

        namesOfChests.add("Gold");
        namesOfChests.add("Silver");
        namesOfChests.add("Emerald");
        namesOfChests.add("Copper");

        /*
        Gold    #0
        Silver  #1
        Emerald #2
        Copper  #3
         */

        chestNum.add(5); //Gold
        chestNum.add(5); //Silver
        chestNum.add(5); //Emerald
        chestNum.add(5); //Copper

//        //Pngyi yükleme işlemi
//        try {
//            image0 = ImageIO.read(new FileImageInputStream(new File("Bee2.png")));
//            image1 = ImageIO.read(new FileImageInputStream(new File("Bird.png")));
//            image2 = ImageIO.read(new FileImageInputStream(new File("Mountain3.png")));
//            image3 = ImageIO.read(new FileImageInputStream(new File("Rock.png")));
//            image4 = ImageIO.read(new FileImageInputStream(new File("Tree.png")));
//            image5 = ImageIO.read(new FileImageInputStream(new File("Wall2.png")));
//            images.add(image0);
//            images.add(image1);
//            images.add(image2);
//            images.add(image3);
//            images.add(image4);
//            images.add(image5);
//            System.out.println("images size: "+images.size());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //character sınıfının metotları
        c.createCharacterOnMatrix();
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.autonomousMove();
                repaint();
            }
        });

        setBackground(Color.WHITE);

        generateRandomNumbersofObstacles();
        generateRandomNumbersofChests();

        timer.start(); // Zamanlayıcı başlatılır
        timerObstacle.start();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                for (int k = 0; k < 2; k++){
//                    for (int l = 0; l < obstacles.get(k).size(); l++){
//                        int imageX = obstacles.get(k).get(l).getLocation().getX();
//                        int imageY = obstacles.get(k).get(l).getLocation().getY();
//                        if (k == 0){
//
//                        } else {
//
//                        }
//                    }
//                }
//            }
//        };

    }

    public Dimensions generateDimensions(String key){
        if(key.equals("Tree")){
            int randomDimension = (rand.nextInt(4) + 2) * Game.UNIT_SIZE;
            return new Dimensions(randomDimension, randomDimension);
        } else if(key.equals("Rock")) {
            int randomDimension = (rand.nextInt(2) + 2) * Game.UNIT_SIZE;
            return new Dimensions(randomDimension, randomDimension);
        } else if(key.equals("Wall")){
            return new Dimensions(10*Game.UNIT_SIZE,Game.UNIT_SIZE);
        } else if(key.equals("Mountain")){
            return new Dimensions(15*Game.UNIT_SIZE,15*Game.UNIT_SIZE);
        } else if(key.equals("Bee")){
            return new Dimensions(8*Game.UNIT_SIZE,2*Game.UNIT_SIZE);
        } else if(key.equals("Bird")) {
            return new Dimensions(2*Game.UNIT_SIZE,12*Game.UNIT_SIZE);
        } else if(key.equals("Gold") || key.equals("Silver") || key.equals("Emerald") || key.equals("Copper")) {
            return new Dimensions(2*Game.UNIT_SIZE,2*Game.UNIT_SIZE);
        }//Eğer hiçbirine girmezse hatalıdır.
        return null;
    }

    public Location generateLocation(String key,Dimensions dimensions){
        int randomX,randomY,randomDimension;
//        if(key.equals("Tree")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Rock")) {
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Wall")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Mountain")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Bee")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Bird")) {
            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
            Location location = new Location(randomX,randomY);
                for (int i = randomX/UNIT_SIZE; i < (randomX+dimensions.getWidht())/UNIT_SIZE; i++){
                    for (int j = randomY/UNIT_SIZE; j < (randomY+dimensions.getHeight())/UNIT_SIZE; j++){
                        if (!bannedLocs.contains(location)) {
                        Location location1 = new Location(i,j);
                        bannedLocs.add(location1);
                        return location;
                        }
                    }
                } return generateLocation(key,dimensions);



////            if ((bannedXs.contains(randomX/UNIT_SIZE)) && (bannedYs.contains(randomY/UNIT_SIZE))){
////                generateLocation(key,dimensions);
////            }
////
////            for (int i = randomX / UNIT_SIZE; i < (randomX+dimensions.getWidht()) / UNIT_SIZE; i++) {
////                bannedXs.add(i);
////                for (int j = randomY / UNIT_SIZE; j < (randomY+dimensions.getHeight()) / UNIT_SIZE; j++) {
////                    bannedYs.add(j);
////                }
////            } return new Location(randomX, randomY);

//        }
        //Eğer hiçbirine girmezse hatalıdır.
        //return null;
    }
    private  int whichSideOfTheMap(Integer x){
        if (x < DIVISION_WIDTH){ //Sol taraf kış temalı
            return 0; //Kış
        } else if (x > DIVISION_WIDTH){ //Sağ taraf yaz temalı
            return 1; //Yaz
        } return 1; //Tam ortada ise yaz olduğunu varsayıyoruz.
    }

    //Gelen key e göre istenilen nesneyi yaratıp dönderir.
    private Obstacle generateInstanceOfObstacle(String key) throws IOException {
        int control;

        //System.out.println("secme baslat");

        if(key.equals("Tree")){
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            control = whichSideOfTheMap(location.getX());
            if (control == 0){
                return new WinterTree(location,dimensions);  //WinterTree(location,dimensions);
            }return new SummerTree(location,dimensions);
        } else if(key.equals("Rock")) {
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            control = whichSideOfTheMap(location.getX());
            if (control == 0){
                return new WinterRock(location,dimensions);
            }return new SummerRock(location,dimensions);
        } else if(key.equals("Wall")){
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            control = whichSideOfTheMap(location.getX());
            if (control == 0){
                return new WinterWall(location,dimensions);
            }return new SummerWall(location,dimensions);
        } else if(key.equals("Mountain")){
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            control = whichSideOfTheMap(location.getX());
            if (control == 0){
                return new WinterMountain(location,dimensions);
            }return new SummerMountain(location,dimensions);
        } else if(key.equals("Bee")){
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            return new Bee(location,dimensions);
        } else if(key.equals("Bird")) {
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            return new Bird(location,dimensions);
        }//Eğer hiçbirine girmezse hatalıdır.
        return null;
    }

    //Random bir sayı belirler ve bu sayı kadar nesneyi generateInstanceOfObstacle() metoduna
    //ürettirip bir arrayliste ekler
    public void generateRandomNumbersofObstacles(){
        for (int i = 0; i < obstacleTypes; i++){ //5'e kadar kere dönüyor.
            String key = namesOfObstacles.get(i);
            //int obstacleNum = rand.nextInt(5 - 3 + 1) + 3;
            for(int j = 0; j < obstacleNum.get(i); j++){ //random sayı kadar dönüyor
                try {
                    obstacles.get(i).add(generateInstanceOfObstacle(key));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("x : "+obstacles.get(i).get(j).getLocation().getX()+" y : "+obstacles.get(i).get(j).getLocation().getY());
            }
            System.out.println("Size: "+obstacles.get(i).size());
            System.out.println(key+" sayisi: "+obstacleNum.get(i));
        }

    }

    private Chest generateInstanceOfChest(String key) throws IOException {
         if(key.equals("Gold")){
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            return new GoldChest(location,dimensions);
        } else if(key.equals("Silver")) {
            Dimensions dimensions = generateDimensions(key);
            Location location = generateLocation(key,dimensions);
            return new SilverChest(location,dimensions);
        } else if(key.equals("Emerald")) {
             Dimensions dimensions = generateDimensions(key);
             Location location = generateLocation(key,dimensions);
             return new EmeraldChest(location,dimensions);
         } else if(key.equals("Copper")) {
             Dimensions dimensions = generateDimensions(key);
             Location location = generateLocation(key,dimensions);
             return new CopperChest(location,dimensions);
         }//Eğer hiçbirine girmezse hatalıdır.
        return null;
    }

    public void generateRandomNumbersofChests(){
        for (int i = 0; i < chestTypes; i++){ //4'e kadar kere dönüyor.
            String key = namesOfChests.get(i);
            //int obstacleNum = rand.nextInt(5 - 3 + 1) + 3;
            for(int j = 0; j < chestNum.get(i); j++){ //random sayı kadar dönüyor
                try {
                    chests.get(i).add(generateInstanceOfChest(key));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("x : "+chests.get(i).get(j).getLocation().getX()+" y : "+chests.get(i).get(j).getLocation().getY());
            }
            System.out.println("Size: "+chests.get(i).size());
            System.out.println(key+" sayisi: "+chestNum.get(i));
        }
        for (int i = 0; i < mapMatrix.length; i++) {
            for (int j = 0; j < mapMatrix[0].length; j++) {
                System.out.print(mapMatrix[i][j] + " ");
            }
            System.out.println(); // Her satırın sonunda yeni bir satıra geçmek için println kullan
        }
        System.out.println("matrix x: "+mapMatrix.length+" matrix y: "+mapMatrix[0].length);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Zamanlayıcının çağırdığı metot. Dairenin hareketini kontrol eder.
        for (int k = 0; k < 2; k++){
            for (int l = 0; l < obstacles.get(k).size(); l++){
                Obstacle obs = obstacles.get(k).get(l);
                switch (k){
                    case 0:
                        int leftWall = obs.getLocation().getX();
                        int rightWall = obs.getLocation().getX() + obs.getDimension().getWidht() - 2*UNIT_SIZE;
                        beex = beeLocs.get(l).getX();
                        if (beex >= rightWall) {
                            beeDir = -1;
                        } else if (beex <= leftWall){
                            beeDir = 1;
                        }
                        beex = beex + (UNIT_SIZE * beeDir);
                        // Klon oluşturarak beeLocs'u güncelle
                        try {
                            beeLocs.set(l, (Location) beeLocs.get(l).clone());
                            beeLocs.get(l).setX(beex);
                        } catch (CloneNotSupportedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 1:
                        int upperWall = obs.getLocation().getY();
                        int bottomWall = obs.getLocation().getY() + obs.getDimension().getHeight() - 2*UNIT_SIZE;
                        birdy = birdLocs.get(l).getY();
                        if (birdy >= bottomWall) {
                            birdDir = -1;
                        } else if (birdy <= upperWall){
                            birdDir = 1;
                        }
                        birdy = birdy + (UNIT_SIZE * birdDir);
                        // Klon oluşturarak birdLocs'u güncelle
                        try {
                            birdLocs.set(l, (Location) birdLocs.get(l).clone());
                            birdLocs.get(l).setY(birdy);
                        } catch (CloneNotSupportedException ex) {
                            ex.printStackTrace();
                        }
                        break;
                }
            }
        }
        repaint();
    }

}
