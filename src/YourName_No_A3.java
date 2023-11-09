import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class YourName_No_A3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Olympics o = new Olympics();
        OlympicsFrame of = new OlympicsFrame();
    }
}

class Olympics{
    private int NO, rank;
    private String country;
    private double[] score;


}

class OlympicsFrame extends JFrame{
    String[] countrynames = {"USA", "SPAIN", "CHINA", "JAPAN", "ITALY", "GERMANY", "FRANCE", "BRAZIL", "NETHERLAND", "POLAND", "RUSSIA", "UKRAINE"};
    private JButton[] jbArray = new JButton[12];
    private ArrayList<Olympics> alist;

    OlympicsFrame(){
        super("Olympics 2023");
        this.setLayout(new GridLayout(4, 3));

        for(int i = 0; i < 12; i++){
            jbArray[i] = new JButton();
            jbArray[i].setText(countrynames[i]);
            this.add(jbArray[i]);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}