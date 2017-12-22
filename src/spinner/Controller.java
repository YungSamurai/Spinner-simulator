package spinner;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import spinner.Files.FileWorker;
import spinner.Objects.Spinner;
import spinner.Scenes.Game;

import java.io.*;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable{
    public static Label[] prices;
    public static Label[] prices1;
    private static int e;
    public List<Double> speeds;
    private static int x;
    private static int xx;
    private static int x1;
    private static int xx1;
    private float c;
    private float c1;
    private final Image EMPTY_IMAGE = new Image("Empty.png");
    private List<Image> imgs;
    private List<Image> images;
    private List<Integer> priceList;
    private List<Integer> pricesList;
    private ImageView[] imageViews;
    private static List<Image> imgs1;
    private List<Image> images1;
    private List<Integer> priceList1;
    private List<Integer> pricesList1;
    private ImageView[] imageViews1;
    @FXML private Label price0,price1,price2,price3,price4,price5,price6,price7,price8,pric1,priceo0,priceo1,priceo2,priceo3,priceo4,
            priceo5,priceo6,priceo7,priceo8;
    @FXML private ImageView iv0,iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,
            ivo0,ivo1,ivo2,ivo3,ivo4,ivo5,ivo6,ivo7,ivo8;
    @FXML private ProgressBar progressBar,progressoBar;
    @FXML private Button nextBt,nextBt1;

    public void spinButton(ActionEvent actionEvent)
    {
        Game.g = Spinner.getSpeed();
    }
    public void stopButton(ActionEvent actionEvent)
    {
        Game.g = 0;
    }


    public void Buy1(MouseEvent mouseEvent) {
        setBearing(0);
        //if(Game.setSpinnerSkin(0,0));
    }

    public void Buy2(MouseEvent mouseEvent) {
        setBearing(1);
        //if(Game.setSpinnerSkin(1,300)) price1.setText("");
    }

    public void Buy3(MouseEvent mouseEvent) {
        setBearing(2);
        //if(Game.setSpinnerSkin(2,500)) price2.setText("");
    }

    public void Buy4(MouseEvent mouseEvent) {
        setBearing(3);
        //if(Game.setSpinnerSkin(3,700)) price3.setText("");
    }

    public void Buy5(MouseEvent mouseEvent) {
        setBearing(4);
        //if(Game.setSpinnerSkin(4,900)) price4.setText("");
    }

    public void Buy6(MouseEvent mouseEvent) {
        setBearing(5);
        //if(Game.setSpinnerSkin(5,1500)) price5.setText("");
    }

    public void Buy7(MouseEvent mouseEvent) {
        setBearing(6);
        //if(Game.setSpinnerSkin(6,2000)) price6.setText("");
    }

    public void Buy8(MouseEvent mouseEvent) {
        setBearing(7);
    }

    public void Buy9(MouseEvent mouseEvent) {
        setBearing(8);
    }

    public void Buys1(MouseEvent mouseEvent) {
        setSkin(0);
    }
    public void Buys2(MouseEvent mouseEvent) { setSkin(1); }
    public void Buys3(MouseEvent mouseEvent) { setSkin(2); }
    public void Buys4(MouseEvent mouseEvent) { setSkin(3); }
    public void Buys5(MouseEvent mouseEvent) { setSkin(4); }
    public void Buys6(MouseEvent mouseEvent) { setSkin(5); }
    public void Buys7(MouseEvent mouseEvent) { setSkin(6); }
    public void Buys8(MouseEvent mouseEvent) { setSkin(7); }
    public void Buys9(MouseEvent mouseEvent) { setSkin(8); }


    public void bgBuy1(MouseEvent mouseEvent) {
        if(Game.setBackgrond(0,0));
    }

    public void bgBuy2(MouseEvent mouseEvent) {
        if(Game.setBackgrond(1,500)) pric1.setText("");
    }

    public void createBearings(int a) {
        float l = priceList.size()/6;

        images.clear();
        pricesList.clear();

        imageViews[0].setImage(new Image("Empty.png"));
        imageViews[1].setImage(new Image("Empty.png"));
        imageViews[2].setImage(new Image("Empty.png"));
        imageViews[3].setImage(new Image("Empty.png"));
        imageViews[4].setImage(new Image("Empty.png"));
        imageViews[5].setImage(new Image("Empty.png"));
        imageViews[6].setImage(new Image("Empty.png"));
        imageViews[7].setImage(new Image("Empty.png"));
        imageViews[8].setImage(new Image("Empty.png"));

        prices[0].setText("");
        prices[1].setText("");
        prices[2].setText("");
        prices[3].setText("");
        prices[4].setText("");
        prices[5].setText("");
        prices[6].setText("");
        prices[7].setText("");
        prices[8].setText("");
        if(!imgs.isEmpty())
        {
            x=0;
            if(a==-1) if(!((xx-6)<0)) { xx-=6; c-=(1/l); }
            if(a==1)  if(xx<priceList.size()) { xx+=6; c +=(1/l); }
            if(c<0) c=0;
            progressBar.setProgress(c);
            if((imgs.size()<=9)) nextBt1.setDisable(true);
            for (int i=xx;i<imgs.size();i++)
            {
                try {
                    if (!(priceList.get(i) == null)) {
                        if (i < (xx + 9)) {
                            if(!(priceList.get(i)==0)) {
                                prices[x].setText(priceList.get(i) + "฿");
                            }
                            pricesList.add(priceList.get(i));
                            if (!(imgs.get(i) == null)) {
                                Image img = imgs.get(i);
                                imageViews[x].setImage(img);
                                images.add(img);
                                x++;
                            }
                        }
                    }
                }catch (RuntimeException e)
                {
                    System.out.println("WARNING!!! Enought prices");
                }
            }
        }
    }

    private void createSkins(int a)
    {
        float l = priceList1.size()/6;

        images1.clear();
        pricesList1.clear();

        imageViews1[0].setImage(new Image("Empty.png"));
        imageViews1[1].setImage(new Image("Empty.png"));
        imageViews1[2].setImage(new Image("Empty.png"));
        imageViews1[3].setImage(new Image("Empty.png"));
        imageViews1[4].setImage(new Image("Empty.png"));
        imageViews1[5].setImage(new Image("Empty.png"));
        imageViews1[6].setImage(new Image("Empty.png"));
        imageViews1[7].setImage(new Image("Empty.png"));
        imageViews1[8].setImage(new Image("Empty.png"));

        prices1[0].setText("");
        prices1[1].setText("");
        prices1[2].setText("");
        prices1[3].setText("");
        prices1[4].setText("");
        prices1[5].setText("");
        prices1[6].setText("");
        prices1[7].setText("");
        prices1[8].setText("");

        if(!imgs1.isEmpty())
        {
            x1=0;
            if(a==-1) if(!((xx1-6)<0)) { xx1-=6; c1-=(1/l); }
            if(a==1)  if(xx1<priceList1.size()) { xx1+=6; c1 +=(1/l); }
            if(c1<0) c1=0;
            progressoBar.setProgress(c1);
            if((imgs1.size()<=9)) nextBt.setDisable(true);
            for (int i=xx1;i<imgs1.size();i++)
            {
                try {
                    if (!(priceList1.get(i) == null)) {
                        if (i < (xx1 + 9)) {
                            if(!(priceList1.get(i)==0)) {
                                    prices1[x1].setText(priceList1.get(i) + "฿");
                            }
                            pricesList1.add(priceList1.get(i));
                            if (!(imgs1.get(i) == null)) {
                                e=pricesList1.size();
                                Image img = imgs1.get(i);
                                imageViews1[x1].setImage(img);
                                images1.add(img);
                                x1++;
                            }
                        }
                    }
                }catch (RuntimeException e)
                {
                    System.out.println("WARNING!!! Enought prices");
                }
            }
        }
    }

    private void setBearing(int a) {
        if(!images.isEmpty()) {
            if(Game.sendMoney(pricesList.get(a))) {
                if (images.size() >= a) {
                    if (!(images.get(a) == EMPTY_IMAGE)) {
                        if(!(Spinner.getSpeed()==speeds.get(a))) {
                            Spinner.setSpeed(speeds.get(a));
                        }
                    }
                }
            }
        }
    }

    private void setSkin(int a)
    {
        if(!images1.isEmpty()) {
                if (Game.setSpinnerSkin(images1.get(a), pricesList1.get(a))) {
                    prices1[a].setText("");
                }
            }
        }

    public static int getImgsS()
    {
        return e;
    }

    public static List<Image> getImages()
    {
        return imgs1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        imgs = new ArrayList<Image>();
        images = new ArrayList<Image>();
        priceList = new ArrayList<Integer>();
        pricesList = new ArrayList<Integer>();
        speeds = new ArrayList<Double>();

        imgs1 = new ArrayList<Image>();
        images1 = new ArrayList<Image>();
        priceList1 = new ArrayList<Integer>();
        pricesList1 = new ArrayList<Integer>();

        imageViews1 = new ImageView[9];
        imageViews1[0] = ivo0;
        imageViews1[1] = ivo1;
        imageViews1[2] = ivo2;
        imageViews1[3] = ivo3;
        imageViews1[4] = ivo4;
        imageViews1[5] = ivo5;
        imageViews1[6] = ivo6;
        imageViews1[7] = ivo7;
        imageViews1[8] = ivo8;

        imageViews = new ImageView[9];
        imageViews[0] = iv0;
        imageViews[1] = iv1;
        imageViews[2] = iv2;
        imageViews[3] = iv3;
        imageViews[4] = iv4;
        imageViews[5] = iv5;
        imageViews[6] = iv6;
        imageViews[7] = iv7;
        imageViews[8] = iv8;

        prices1 = new Label[9];
        prices1[0] = priceo0;
        prices1[1] = priceo1;
        prices1[2] = priceo2;
        prices1[3] = priceo3;
        prices1[4] = priceo4;
        prices1[5] = priceo5;
        prices1[6] = priceo6;
        prices1[7] = priceo7;
        prices1[8] = priceo8;

        prices = new Label[9];
        prices[0] = price0;
        prices[1] = price1;
        prices[2] = price2;
        prices[3] = price3;
        prices[4] = price4;
        prices[5] = price5;
        prices[6] = price6;
        prices[7] = price7;
        prices[8] = price8;

        String path = getClass().getResource("/").toString();
        File path1 = new File(path.replace("file:/","")+"Bearings/");
        String[] names = path1.list();

        String path3 = getClass().getResource("/").toString();
        File path2 = new File(path3.replace("file:/","")+"Spinners/");
        System.out.println(path2.list());
        String[] name1 = path2.list();
        for(int i = 0; i < names.length; i++)
        {
            if(names[i].endsWith(".png"))
            {
                String str = "/Bearings/" + names[i].replace(path, "");
                Image img = new Image(getClass().getResource(str).toExternalForm());
                System.out.println(str);
                imgs.add(img);
            }
            else if(names[i].endsWith(".dpd"))
            {
                int[] strings = new int[2];
                try {

                    strings = FileWorker.readInteger(path.replace("file:/","")+"Bearings/"+names[i]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                speeds.add((double) strings[0]);
                priceList.add(strings[1]);
            }
        }

        for(int i = 0; i < name1.length; i++)
        {
            if(name1[i].endsWith(".png"))
            {
                String str = "/Spinners/" + name1[i].replace(path3, "");
                Image img = new Image(getClass().getResource(str).toExternalForm());
                System.out.println(str);
                imgs1.add(img);
            }
            else if(name1[i].endsWith(".dpd"))
            {
                int[] strings = new int[2];
                try {

                    strings = FileWorker.readInteger(path3.replace("file:/","")+"Spinners/"+name1[i]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                priceList1.add(strings[0]);
            }
        }
        float b = priceList.size()/6;
        c=(1/b);
        float d = priceList1.size()/6;
        c1=(1/d);
        createSkins(0);
        createBearings(0);
        Spinner.setSpeed(speeds.get(0));
    }

    public void nextButton(ActionEvent actionEvent) {
        createBearings(1);
    }

    public void previousButton(ActionEvent actionEvent) {
        createBearings(-1);
    }

    public void nextoButton(ActionEvent actionEvent) {
        createSkins(1);
    }
    public void previousoButton(ActionEvent actionEvent) {
        createSkins(-1);
    }
}