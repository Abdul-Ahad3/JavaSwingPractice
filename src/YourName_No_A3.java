import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class YourName_No_A3 {
    public static void main(String[] args) {
        String[] countrynames = {"USA", "SPAIN", "CHINA", "JAPAN", "ITALY", "GERMANY", "FRANCE", "BRAZIL", "NETHERLAND", "POLAND", "RUSSIA", "UKRAINE"};

        for(int i = 0; i < 12; i++){

        }

        OlympicsFrame of = new OlympicsFrame(countrynames);
    }
}

class Olympics{
    private int NO, rank;
    private String country;
    private double[] score = new double[NO];

    Olympics(String name){
        country = name;
        NO = 5;
        processScores();
    }

    void processScores(){
        for(int i = 0; i < NO; i++){
            score[i] = (Math.random() / 100);
        }
    }
    double totalScores(){return 0;}
    void set(int rank){}
    int getRank(){return this.rank;}
    String getName(){return country;}
    double[] getScoreArray(){return score;}
    double getFinalScore(){
        double s = 0;
        for(int i = 0; i < 5; i++){
            s = s + score[i];
        }

        return s;
    }
}

class OlympicsFrame extends JFrame{
    private JButton[] jbArray = new JButton[12];
    private Icon[] countryflags = new Icon[12];
    private ArrayList<Olympics> alist;
    double[] finalScores;

    OlympicsFrame(String[] names){
        super("Olympics 2023");
        this.setLayout(new GridLayout(4, 3));

        for(int i = 0; i < 12; i++){
            new Olympics(names[i]);
            finalScores[i] = 4;
            ImageIcon iicon = new ImageIcon(Objects.requireNonNull(getClass().getResource(names[i] + ".jpg")));
            Image img = iicon.getImage();
            Image newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            countryflags[i] = new ImageIcon(newimg);

            jbArray[i] = new JButton(names[i], countryflags[i]);

            this.add(jbArray[i]);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}