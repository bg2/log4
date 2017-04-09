package application.vues;

/**
 * Created by Khoi on 2017-04-05.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;

import application.controleur.ControleurImage;
import application.controleur.ControleurPerspective;
import application.controleur.ControleurPerspective2;
import application.modele.ImageModele;

import java.awt.event.*;
import java.util.ArrayList;
//import com.sun.glass.events.KeyEvent;
import application.modele.PerspectiveModele;
import framework.Controleur;

public class Menu extends JMenuBar {
    private ControleurImage controleurImage;
    private ControleurPerspective controleurPerspective;
    private ControleurPerspective2 controleurPerspective2;

    private ImageModele imageModele;
    private PerspectiveModele perspectiveModele;
    private PerspectiveModele perspectiveModele2;

    /**
     * Constructeur
     */
    public Menu(ImageModele imageModele, PerspectiveModele perspectiveModele, PerspectiveModele perspectiveModele2,
                ControleurImage controleurImage, ControleurPerspective controleurPerspective, ControleurPerspective2
                        controleurPerspective2) {
        this.imageModele = imageModele;
        this.perspectiveModele = perspectiveModele;
        this.perspectiveModele2 = perspectiveModele2;
        this.controleurImage = controleurImage;
        this.controleurPerspective = controleurPerspective;
        this.controleurPerspective2 = controleurPerspective2;
        System.out.println("Menu createur");
        initialiserMenu();

    }

    private void initialiserMenu() {

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

        JMenuItem itemDefaire = new JMenuItem("Defaire Vue Perspective 1");
        itemDefaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                ActionEvent.CTRL_MASK));

        JMenuItem itemDefaire2 = new JMenuItem("Defaire Vue Perspective 2");
        itemDefaire2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                ActionEvent.CTRL_MASK));

        JMenuItem itemRefaire = new JMenuItem("Refaire Vue Perspective 1");
        itemRefaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                ActionEvent.CTRL_MASK));

        JMenuItem itemRefaire2 = new JMenuItem("Refaire Vue Perspective 2");
        itemRefaire2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
                ActionEvent.CTRL_MASK));


        initialiserListener(itemOuvrir, itemCharger, itemSauvegarder, itemDefaire, itemDefaire2, itemRefaire,
                itemRefaire2);

        menuFichier.add(itemOuvrir);
        menuFichier.add(itemCharger);
        menuFichier.add(itemSauvegarder);
        menuEdition.add(itemDefaire);
        menuEdition.add(itemRefaire);
        menuEdition.add(itemDefaire2);
        menuEdition.add(itemRefaire2);

        this.add(menuFichier);
        this.add(menuEdition);

    }

    private void initialiserListener(JMenuItem itemOuvrir, JMenuItem itemCharger, JMenuItem itemSauvegarder,
                                     JMenuItem itemDefaire, JMenuItem itemDefaire2, JMenuItem itemRefaire,
                                     JMenuItem itemRefaire2) {

        itemSauvegarder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sauvegarder");
                save();
            }
        });

        itemDefaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Defaire Vue 1");
                controleurPerspective.defaire();
            }
        });

        itemDefaire2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Defaire Vue 2");
                controleurPerspective2.defaire();
            }
        });

        itemRefaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Refaire Vue 1");
                controleurPerspective.refaire();
            }
        });

        itemRefaire2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Refaire Vue 2");
                controleurPerspective2.refaire();
            }
        });


        itemOuvrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ouvrir");
                choisirFichierAOuvrir();

            }
        });

        itemCharger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Charger");
                charger();
            }
        });
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
            File fichierImage = fc.getSelectedFile();

            controleurImage.ouvrirFichier(fichierImage);
            controleurPerspective.ouvrirFichier(fichierImage);
            controleurPerspective2.ouvrirFichier(fichierImage);
        } else if (response == JFileChooser.CANCEL_OPTION) {
            System.out.println("L'opération a été annulée.");
        }

    }

    public void charger() {
        JFileChooser fc = new JFileChooser();

        javax.swing.filechooser.FileFilter serFilter = new FileNameExtensionFilter(
                "Fichiers SER", "ser");

        fc.setFileFilter(serFilter);
        fc.setCurrentDirectory(new File("."));
        fc.setDialogTitle("Charger un fichier");

        int response = fc.showOpenDialog(new JFrame());

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ArrayList<Object> deserialized;
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);

                BufferedImage image = ImageIO.read(ois);
                deserialized = (ArrayList<Object>) ois.readObject();

                fis.close();
                ois.close();

                PerspectiveModele perspectiveModele = (PerspectiveModele) deserialized.get(0);
                PerspectiveModele perspectiveModele2 = (PerspectiveModele) deserialized.get(1);

                controleurImage.chargerImageModele(image);
                controleurPerspective.chargerPerspectiveModele(perspectiveModele, image);
                controleurPerspective2.chargerPerspectiveModele(perspectiveModele2, image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (response == JFileChooser.CANCEL_OPTION) {
            System.out.println("L'opération a été annulée.");
        }

    }

    public void save() {

        // open dialog for choosing a directory first
        final JFileChooser fc = new JFileChooser();
        //     fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File("."));
        fc.setDialogTitle("Sauvegarder");

        //set it to be a save dialog
        fc.setDialogType(JFileChooser.SAVE_DIALOG);

        javax.swing.filechooser.FileFilter serFilter = new FileNameExtensionFilter(
                "Fichiers SER", "ser");

        fc.setFileFilter(serFilter);

        int response = fc.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            String path = fc.getCurrentDirectory().toString() + "\\"
                    + fc.getSelectedFile().getName();

            System.out.println("Le fichier a ete sauvegarde dans: " + path);
        } else {
            System.out.println("L'opération a été annulée.");
            return;
        }

        String fileName = fc.getSelectedFile().getName();
        if (fileName.isEmpty() || fileName.equals(""))
            fileName = "monFichier";

        Image image = imageModele.getImage();

        ArrayList<Object> data = new ArrayList<Object>();
        data.add(perspectiveModele);
        data.add(perspectiveModele2);

        try {
            File file = new File(fc.getCurrentDirectory().toString()
                    + "\\" + fileName + ".ser");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            if (image != null)
              ImageIO.write((BufferedImage) image, "jpg", oos);
            else
                System.out.println("Rien a sauvegarder!");
            oos.writeObject(data);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
