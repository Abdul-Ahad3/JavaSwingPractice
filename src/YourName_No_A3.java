import javax.swing.*;
import java.awt.*;
import java.util.*;

//Main Class
public class YourName_No_A3 {
    public static void main(String[] args) {
        //Array for the names of countries participating
        String[] countrynames = {"USA", "SPAIN", "CHINA", "JAPAN", "ITALY", "GERMANY", "FRANCE", "BRAZIL", "NETHERLAND", "POLAND", "RUSSIA", "UKRAINE"};

        //Main frame for the GUI
        OlympicsFrame of = new OlympicsFrame(countrynames);
    }
}

//Class for handling backend
class Olympics{
    //Private variables
    private int NO = 5, rank;
    private String country;
    private double[] score = new double[NO];

    //Constructor
    Olympics(String name){
        country = name;
        processScores();
        set(rank);

    }

    //Method to generate random scores
    void processScores(){
        for(int i = 0; i < NO; i++){
            score[i] = (Math.random() * 100);
        }
    }

    //Method to return the total scores of each country
    double totalScores(){
        double s = 0;
        for(int i = 0; i < 5; i++){
            s = s + score[i];
        }

        return s;
    }

    //Method to set the rank as per the scores
    void set(int rank){
        rank = getRank();

        this.rank = rank;
    }

    //Method to return rank of a country
    int getRank(){return this.rank;}

    //Method to get country name
    String getName(){return country;}

    //Method to return the individual scores
    double[] getScoreArray(){return score;}
}

//Olympic GUI class
class OlympicsFrame extends JFrame{
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    private JButton[] jbArray = new JButton[12];
    private Icon[] countryflags = new Icon[12];
    private ArrayList<Olympics> alist = new ArrayList<>(12);
    double[] finalScores = new double[12];

    //Constructor
    OlympicsFrame(String[] names){
        super("Olympics 2023");
        this.setLayout(new GridLayout(4, 3));

        for(int i = 0; i < 12; i++){
            Olympics olympicTeam = new Olympics(names[i]);
            ConstructAList(olympicTeam);
            finalScores[i] = alist.get(i).totalScores();

            ImageIcon iicon = new ImageIcon(Objects.requireNonNull(getClass().getResource(names[i] + ".jpg")));
            Image img = iicon.getImage();
            Image newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            countryflags[i] = new ImageIcon(newimg);

            jbArray[i] = new JButton(names[i], countryflags[i]);

            this.add(jbArray[i]);

            final int in = i;
            //Event handling
            jbArray[i].addActionListener(e -> {
                jbArray[in].setText(names[in] + " ==> Rank: " + getRank(alist.get(in).getScoreArray(), alist.get(in).totalScores()));

                JFrame ranks = new JFrame();
                ranks.setLayout(new FlowLayout());

                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel();

                panel1.setLayout(new FlowLayout());
                panel2.setLayout(new GridLayout(13, 1));

                ImageIcon ii = new ImageIcon(Objects.requireNonNull(getClass().getResource("Trophy.jpg")));

                panel1.add(new JLabel(ii));
                panel2.add(new JLabel("Final Rankings: "));
                for(int x = 0; x < 12; x++){
                    //Arranging the array in descending order
                    Arrays.sort(finalScores);
                    Double[] reversedFinalScores = Arrays.stream(finalScores).boxed().toArray(Double[]::new);
                    Arrays.sort(reversedFinalScores, Collections.reverseOrder());

                    //Adding elements of aList according to the descending scores
                    for(int y = 0; y < 12; y++){
                        if(reversedFinalScores[x] == alist.get(y).totalScores()){
                            panel2.add(new JLabel("Rank " + (x+1) + ":  " + getCountry(alist, y) + "(" + getScores(alist, alist.get(y).getName()) + ")"));

                        }
                    }
                }

                ranks.add(panel1);
                ranks.add(panel2);

                ranks.setBounds(this.getWidth(), this.getY(), 600, 400);
                ranks.setSize(600, 400);
                ranks.setVisible(true);
            });
        }
        //panel2.add(showRank);
        Arrays.sort(finalScores);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setVisible(true);
    }

    //Method to add Olympic objects to the Arraylist
    void ConstructAList(Olympics e){
        alist.add(e);
    }

    //Method to get country name
    String getCountry(ArrayList<Olympics> a, int n){
        return a.get(n).getName();
    }

    //Method to get the total score os a team
    double getScores(ArrayList<Olympics> a, String name){
        double score = 0;
        for(int i = 0; i < 12; i++){
            if(a.get(i).getName() == name){
                score = a.get(i).totalScores();
            }
        }

        return score;
    }

    //Method to get rank
    private int getRank(double[] scoreArray, double d){

        int rank = Arrays.binarySearch(finalScores, d);

        return rank + 1;
    }
}