package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header header;
    private JButton correcto, incorrecto, ayuda, salir;
    private JPanel palabras, nivel, nombre;
    private Words words;
    private Levels levels;

    /**
     * Constructor of myProject.GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new GridBagLayout());


    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the myProject.GUI class
     */

    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        //Create Listener Object and Control Object
        //Set up JComponent
        //JPanel panelHeader = new JPanel();
        //panelHeader.setLayout(new GridBagLayout());
        header = new Header("I Know That Word", Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridwidth=4;

        this.getContentPane().add(header,gbc);

        JButton help = new JButton("?");
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx=0;
        gbc1.gridy=1;
        gbc1.gridwidth=1;
        gbc1.fill=GridBagConstraints.NONE;
        gbc1.anchor=GridBagConstraints.LINE_START;
        this.getContentPane().add(help, gbc1);

        JButton salir = new JButton("Salir");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx=3;
        gbc2.gridy=1;
        gbc2.gridwidth=1;
        gbc2.fill=GridBagConstraints.NONE;
        gbc2.anchor=GridBagConstraints.LINE_END;
        this.getContentPane().add(salir, gbc2);

        JPanel contenedorPalabras = new JPanel();
        contenedorPalabras.setPreferredSize(new Dimension(450,200));
        contenedorPalabras.setBorder(BorderFactory.createTitledBorder("Palabras a Memorizar:"));
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx=0;
        gbc3.gridy=2;
        gbc3.gridwidth=2;
        gbc3.fill=GridBagConstraints.BOTH;
        gbc3.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(contenedorPalabras,gbc3);

        JLabel label = new JLabel();
        contenedorPalabras.add(label);

        final int[] index = {0};
        String[] palabras = secuenciaPalabras();

        Timer timer = new Timer(5000, e -> {
            if (index[0] < palabras.length) {
                label.setText(palabras[index[0]]);
                index[0]++;
            } else {
                ((Timer) e.getSource()).stop(); // Detener el Timer cuando se hayan mostrado todas las palabras
            }
        });
        timer.start();


        JButton correcto = new JButton("SI");
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx=0;
        gbc4.gridy=4;
        gbc4.gridwidth=1;
        gbc4.weightx=0.5;
        gbc4.fill=GridBagConstraints.BOTH;
        gbc4.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(correcto, gbc4);

        JButton incorrecto = new JButton("NO");
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx=1;
        gbc5.gridy=4;
        gbc5.gridwidth=1;
        gbc5.weightx=0.5;
        gbc5.fill=GridBagConstraints.BOTH;
        gbc5.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(incorrecto, gbc5);


        JPanel contenedorNivel = new JPanel();
        contenedorNivel.setPreferredSize(new Dimension(450,200));
        contenedorNivel.setBorder(BorderFactory.createTitledBorder("Nivel:"));
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx=0;
        gbc6.gridy=5;
        gbc6.gridwidth=2;
        gbc6.fill=GridBagConstraints.BOTH;
        gbc6.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(contenedorNivel,gbc6);

        //se debe obtener los niveles del archivo y pasarlo como parametro de entrada de la clase level
        levels = new Levels(1);

        JLabel labelLevel = new JLabel(String.valueOf(levels.getLevel()));
        contenedorNivel.add(labelLevel);



    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI myProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
/*
    public String[] secuenciaPalabras() {
        words = new Words();
        int level = 1;
        String[] palabras = words.getWords(level);
        //System.out.println(palabras[4]);

        return palabras ;
        }

 */
}
