package application.vues;

/**
 * Created by Khoi on 2017-04-05.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;

import application.controleur.ControleurImage;
import application.controleur.ControleurPerspective;
import application.modele.ImageModele;
import com.sun.glass.events.KeyEvent;
import framework.Controleur;

public class Menu extends JMenuBar {
    private ControleurImage controleurImage;
    private ControleurPerspective controleurPerspective;
    private ControleurPerspective controleurPerspective2;
    /**
     * Constructeur
     */
    public Menu(ControleurImage controleurImage, ControleurPerspective controleurPerspective, ControleurPerspective
            controleurPerspective2) {
        this.controleurImage = controleurImage;
        this.controleurPerspective = controleurPerspective;
        this.controleurPerspective2 = controleurPerspective2;
        System.out.println("Menu createur");
        initialiserMenu();

    }

    private void initialiserMenu(){

        System.out.println("Menu Init");
        final JMenuBar menuBar = new JMenuBar();


        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuEdition = new JMenu("Edition");

        JMenuItem itemOuvrir = new JMenuItem("Ouvrir");
        itemOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                ActionEvent.CTRL_MASK));

        JMenuItem itemCharger = new JMenuItem("Charger");
        itemCharger.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                ActionEvent.CTRL_MASK));

        JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
        itemSauvegarder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK));

        JMenuItem itemDefaire = new JMenuItem("Defaire");
        itemDefaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                ActionEvent.CTRL_MASK));

        initialiserListener(itemOuvrir, itemCharger, itemSauvegarder, itemDefaire);

        menuFichier.add(itemOuvrir);
        menuFichier.add(itemCharger);
        menuFichier.add(itemSauvegarder);
        menuEdition.add(itemDefaire);

        this.add(menuFichier);
        this.add(menuEdition);

    }

    private void initialiserListener(JMenuItem itemOuvrir, JMenuItem itemCharger, JMenuItem itemSauvegarder,
                                     JMenuItem itemDefaire){

        itemSauvegarder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sauvegarder");

            }});

        itemDefaire.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Defaire");

            }});


        itemOuvrir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ouvrir");
                choisirFichierAOuvrir();

            }});

        itemCharger.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Charger");

        //        imageModele.chargerImage();

            }});
    }

    public void choisirFichierAOuvrir() {
        JFileChooser fc = new JFileChooser();

        javax.swing.filechooser.FileFilter imageFilter = new FileNameExtensionFilter(
                "Fichiers image", ImageIO.getReaderFileSuffixes());

        fc.setFileFilter(imageFilter);
        fc.setCurrentDirectory(new File("."));
        fc.setDialogTitle("Choisir une Image");

        int response = fc.showOpenDialog(new JFrame());

        if (response == JFileChooser.APPROVE_OPTION) {
            //		String filePath = fc.getCurrentDirectory().toString() + "/" + fc.getSelectedFile().getName();
            File fichierImage = fc.getSelectedFile();

            Image image = controleurImage.ouvrirFichier(fichierImage);
            controleurPerspective.ouvrirFichier(image);
            controleurPerspective2.ouvrirFichier(image);
        } else if (response == JFileChooser.CANCEL_OPTION){
            System.out.println("L'opération a été annulée.");
        }

//		setChanged();
//		notifyObservers();
    }
}