package spinner.Scenes;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import spinner.Controller;
import spinner.Objects.Spinner;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class Game extends Scene
{
    static Controller controller = new Controller();
    public static double g;
    private static int score = 5002;
    private static int spinnersSize;
    private static List<Image> buyedSpinners;
    private static int[] buyedBgs = new int[7];
    private static int[] buyedS;
    private static Random r = new Random();
    private static String message;
    private static Image background;
    private Image hand0,hand1;
    private MediaView mv;
    private File path;
    private static Font font;
    private static GraphicsContext gc;
    static Spinner spinner;

    public Game(Group root) throws IOException, InterruptedException {
        super(root, 790, 440);
        Canvas canvas = new Canvas(800,450);
        gc = canvas.getGraphicsContext2D();
        font = Font.font("Times New Roman", FontWeight.BOLD, 22);
        Parent styles = FXMLLoader.load(getClass().getResource("Layouts/Game.fxml"));
        try {
            path = new File(getClass().getResource("/Music/").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        final List<MediaPlayer> players = new ArrayList<MediaPlayer>();
        for(String file : path.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        })) players.add(createPlayer("file:/" + (path+"\\" + file).replace("\\", "/").replaceAll(" ","%20"))); //medias.add(new AudioClip(path.toString().replace("\\", "/")));            //players.add(createPlayer("file:///" + (dir+"\\" + file).replace("\\", "/").replaceAll(" ","%20")));

        mv = new MediaView();
        mv.setMediaPlayer(players.get(0));
        mv.getMediaPlayer().play();

        for(int i = 0;i<players.size();i++)
        {
            final MediaPlayer player = players.get(i);
            final MediaPlayer nextPlayer = players.get((i+1) % players.size());
            player.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    mv.setMediaPlayer(nextPlayer);
                    System.out.println("next media");
                    nextPlayer.play();
                }
            });
        }

        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();
        ImageView iv3 = new ImageView();

        spinnersSize = controller.getImgsS();
        buyedS = new int[spinnersSize];
        buyedSpinners = new ArrayList<Image>();
        buyedSpinners = controller.getImages();
        for(int i=0;i<spinnersSize;i++)
        {
            buyedSpinners.add(new Image("/Empty.png"));
        }
        buyedSpinners.set(0,new Image("/Spinners/Spinner0.png"));

        background = new Image("/Backgrounds/Background0.jpg");
        hand0 = new Image("/hand0.png");
        hand1 = new Image("/hand1.png");
        spinner = new Spinner(buyedSpinners.get(0));

        iv2.setImage(hand0);
        iv3.setImage(hand1);
        spinner.setSpinnerImage(buyedSpinners.get(0));
        buyedS[0]=1;
        updateScore(gc);
        root.getChildren().addAll(iv1,iv2,spinner,iv3,canvas,styles,mv);
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                if(iv1.getImage()==background) {}else{
                    iv1.setImage(background);
                    System.out.println("RedrawBG");
                }

                if(g >= 100000) g-=100;
                if(g>=95000&&g<100000) g-=90;
                if(g>=90000&&g<95000) g-=80;
                if(g>=85000&&g<90000) g-=70;
                if(g>=80000&&g<85000) g-=60;
                if(g>=50000&&g<80000) g-=50;
                if(g>=45000&&g<50000) g-=40;
                if(g>=25000&&g<45000) g-=35;
                if(g>=15000&&g<25000) g-=30;
                if(g>=10000&&g<15000) g-=25;
                if(g>=5000&&g<10000) g-=20;
                if(g>=2500&&g<5000) g-=15;
                if(g>=1000&&g<2500) g-=10;
                if(g>=500&&g<1000) g-=5;
                if(g<500&&g>0) g-=2.5;

                if(score<0) score=0;

                if(!(spinner.getSpinnerRotate()==(g/8))) spinner.setSpinnerRotate((g/8));
                if(!(spinner.getImage()==spinner.getSpinnerImage())) spinner.setImage(spinner.getSpinnerImage());
                addMoney();
            }
        }.start();
    }

    private MediaPlayer createPlayer(String s) {
        final MediaPlayer player = new MediaPlayer(new Media(s));
        return player;
    }

    public static boolean setSpinnerSkin(Image spinner, int price)
    {
        int x = 1;
        //Spinner.setSpinnerImage(buyedSpinners.get(0));
        /*if(buyedSpinners[] == 0 && !(buyedSpinners[sColor] == sColor))
        {
            if(sColor==0)
            {
                Spinner.setSpinnerImage(new Image("/Spinners/Spinner0.png"));
            }else
            if(Game.sendMoney(price))
            {
                buyedSpinners[sColor] = sColor;
                Spinner.setSpinnerImage(new Image("/Spinners/Spinner0" + sColor + ".png"));
                return true;
            }
        }else
        {
            Spinner.setSpinnerImage(new Image("/Spinners/Spinner0" + sColor + ".png"));
            Game.message("You choosed skin");
            return false;
        }*/
        for(int i=-2;i<(spinnersSize+1);i++) {
            if (i >= 0) {
                if (buyedSpinners.get(i) == spinner) {
                    if (!(buyedS[i] == 1)) {
                        if (sendMoney(price))
                        System.out.println(i);{
                            buyedS[i] = 1;
                            Spinner.setSpinnerImage(buyedSpinners.get(i));
                            return true;
                        }
                    }
                    if (buyedS[i] == 1) {
                        Spinner.setSpinnerImage(buyedSpinners.get(i));
                        System.out.println("Hhh");
                        Game.message("You choosed skin");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean setBackgrond(int sColor, int price)
    {
        if(buyedBgs[sColor] == 0 && !(buyedBgs[sColor] == sColor))
        {
            if(sColor==0)
            {
                background = new Image("/Backgrounds/Background0.jpg");
            }else
            if(Game.sendMoney(price))
            {
                buyedBgs[sColor] = sColor;
                background = new Image("/Backgrounds/Background" + sColor + ".jpg");
                return true;
            }
        }else
        {
            background = new Image("/Backgrounds/Background" + sColor + ".jpg");
            Game.message("You choosed background");
            return false;
        }
        System.out.println(buyedBgs.toString());
        return false;
    }

    public void addMoney() {
        int sc = getScore();
            if (g >= 90000 && g < 95000)
            {
                score=(sc+= r.nextInt((int) (Spinner.getSpeed()/50000)));
                updateScore(gc);
            }
            if (g >= 1000 && g < 2500)
            {
                score=(sc+= r.nextInt((int) (Spinner.getSpeed()/50000)));
                updateScore(gc);
            }

    }

    public static void addMoney(int money)
    {
        int sc = getScore();
        setScore(sc+=money);
    }

    public static void setScore(int sc)
    {
        score = sc;
        updateScore(gc);
    }

    public static boolean sendMoney(int money)
    {
        int sc = getScore();
        if((sc-=money)>=0)
        {
            score=(getScore()-money);
            Game.message("" + -money);
            updateScore(gc);
            return true;
        }
        else
        {
            Game.message("Not enoght money");
            return false;
        }
    }

    public static int getScore()
    {
        return score;
    }

    protected static void setMessage(String msg)
    {
        message = msg;
        updateMessage(gc);
    }

    public static void message(String message) {
        setMessage(message);
    }

    private static void updateScore(GraphicsContext gc)
    {
        gc.setFont(font);
        gc.clearRect(0,0,100,50);
        gc.setFill(Color.rgb(255,0,255));
        gc.fillText(getScore() + " ฿",10,20);
    }
    public static int[] getBuyedSpinners(){
        return buyedS;
}
    private static void updateMessage(GraphicsContext gc)
    {
        gc.setFont(font);
        gc.clearRect(0,320,400,400);
        gc.fillText(message,10,350);
    }
}
