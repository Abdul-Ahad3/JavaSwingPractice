import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class YourName_No_A3 {
    public static void main(String[] args) {
        String[] countrynames = {"USA", "SPAIN", "CHINA", "JAPAN", "ITALY", "GERMANY", "FRANCE", "BRAZIL", "NETHERLAND", "POLAND", "RUSSIA", "UKRAINE"};

        OlympicsFrame of = new OlympicsFrame(countrynames);
    }
}

class Olympics{
    private int NO = 5, rank;
    private String country;
    private double[] score = new double[NO];

    Olympics(String name){
        country = name;
        processScores();
    }

    //Function to generate random scores
    void processScores(){
        for(int i = 0; i < NO; i++){
            score[i] = (Math.random() * 100);
        }
    }

    //Function to return the total scores of each country
    double totalScores(){
        double s = 0;
        for(int i = 0; i < 5; i++){
            s = s + score[i];
        }

        return s;
    }

    //Function to set the rank as per the scores
    void set(int rank){}

    //Function to return rank of a country
    int getRank(){return this.rank;}

    //Function to get country name
    String getName(){return country;}

    //Function to return the individual scores
    double[] getScoreArray(){return score;}
}

//Olympic GUI
class OlympicsFrame extends JFrame{
    private JButton[] jbArray = new JButton[12];
    private Icon[] countryflags = new Icon[12];
    private ArrayList<Olympics> alist;
    //double[] finalScores;

    OlympicsFrame(String[] names){
        super("Olympics 2023");
        this.setLayout(new GridLayout(4, 3));

        for(int i = 0; i < 12; i++){
            Olympics olympicTeam = new Olympics(names[i]);
            ConstructAList(olympicTeam);

            ImageIcon iicon = new ImageIcon(Objects.requireNonNull(getClass().getResource(names[i] + ".jpg")));
            Image img = iicon.getImage();
            Image newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            countryflags[i] = new ImageIcon(newimg);

            jbArray[i] = new JButton(names[i], countryflags[i]);

            final int in = i;
            jbArray[i].addActionListener(e -> {jbArray[in].setText(names[in] + " ==> Rank: " + getRank(alist.get(in).getScoreArray(), alist.get(in).totalScores()));});

            this.add(jbArray[i]);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    //Function to add Olympic objects to the Arraylist
    void ConstructAList(Olympics e){
        alist.add(e);
    }

    String getCountry(ArrayList<Olympics> a, int n){
        return a.get(n).getName();
    }

    //Function to get the total score os a team
    double getScores(ArrayList<Olympics> a, String name){
        double score = 0;
        for(int i = 0; i < 12; i++){
            if(a.get(i).getName() == name){
                score = a.get(i).totalScores();
            }
        }

        return score;
    }

    //Function to get rank
    private int getRank(double[] scoreArray, double d){


        return 0;
    }
}