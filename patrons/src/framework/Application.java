package framework; 
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import controleur.ControleurImage;
import controleur.ControleurPerspective;
import modele.PerspectiveModele;
import vues.ImageModele;
import vues.VuePerspective;
import vues.VuePerspective2;
import vues.VueThumbnail;


public class Application {

		
	private final static int HAUTEUR_FENETRE = 400;
	private final static int LARGEUR_FENETRE = 1000;

	private static String imageNom;
	private static Image image = null;
	protected static ImageModele imageModele = new ImageModele();
	protected static PerspectiveModele perspectiveModele = new PerspectiveModele();
	protected static PerspectiveModele perspectiveModele2 = new PerspectiveModele();
	protected static ControleurImage controleurImage = new ControleurImage();
	protected static ControleurPerspective controleurPerspective = new ControleurPerspective();


	public static void initApplication() {
		
		System.out.println("application");
		JFrame frame = new JFrame("Lab 4 : Les patrons");
		JPanel vueMain = new JPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JPanel());
		frame.setLayout(new BorderLayout());

		initModeles(frame);
		initVues(frame, image, vueMain);

		controleurImage.addModel(imageModele);
		controleurPerspective.addModel(perspectiveModele);
		controleurPerspective.addModel(perspectiveModele2);

		frame.getContentPane().add(vueMain);
		//frame.getContentPane().add(menu, BorderLayout.NORTH);
		frame.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);

		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static void initVues(JFrame frame, Image image, JPanel vueMain) {
		
		JPanel vueThumbnail = new JPanel();
		JPanel vuePerspective = new JPanel();
		JPanel vuePerspective2 = new JPanel();

		vueMain.setLayout(new GridLayout(1, 3, 3, 3));
		vueMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Vues",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

		vueThumbnail.setLayout(new GridLayout(1, 3, -1, -1));
		vueMain.add(vueThumbnail);
		vueThumbnail
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Thumbnail"));

		vuePerspective.setLayout(new GridLayout(1, 3, -1, -1));
		vueMain.add(vuePerspective);
		vuePerspective.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Perspective"));

		vuePerspective2.setLayout(new GridLayout(1, 3, -1, -1));
		vueMain.add(vuePerspective2);
		vuePerspective2.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Perspective"));


		VueThumbnail vue = new VueThumbnail();
		VuePerspective vue2 = new VuePerspective();
		VuePerspective2 vue3 = new VuePerspective2();

	
	}

	private static void initModeles(JFrame frame) {
		ImageModele imageModele = new ImageModele();
		PerspectiveModele prespective = new PerspectiveModele();
		// image= imageModele.getImage();
		image = imageModele.getImage();

	}

}


