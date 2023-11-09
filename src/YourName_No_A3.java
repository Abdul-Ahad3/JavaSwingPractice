import javax.swing.*;
import java.util.ArrayList;

public class YourName_No_A3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Olympics o = new Olympics();
    }
}

class Olympics{
    private int NO, rank;
    private String country;
    private double[] score;

    OlympicsFrame of = new OlympicsFrame();
}

class OlympicsFrame extends JFrame{
    private JFrame frame = new JFrame("Olympics 2023");
    private JButton[] jbArray;
    private ArrayList<Olympics> alist;

    OlympicsFrame(){
        for(int i = 0; i < 12; i++){
            jbArray[i] = new JButton();
            frame.add(jbArray[i]);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
    }
}