package application;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import application.controleur.ControleurImage;
import application.controleur.ControleurPerspective;
import application.modele.PerspectiveModele;
import application.modele.ImageModele;
import application.vues.VuePerspective;
import application.vues.VuePerspective2;
import application.vues.VueThumbnail;
import application.vues.Menu;

public class Application extends framework.Application{

	private final int LARGEUR_FENETRE = 1000;
	private final int HAUTEUR_FENETRE = 400;


	private  String imageNom;
	private  Image image = null;
	protected  ImageModele imageModele = new ImageModele();
	protected  PerspectiveModele perspectiveModele = new PerspectiveModele();
	protected  PerspectiveModele perspectiveModele2 = new PerspectiveModele();
	protected  ControleurImage controleurImage = new ControleurImage();
	protected  ControleurPerspective controleurPerspective = new ControleurPerspective();

//
//	public  void initApplication() {
//
//		System.out.println("application");
//		JFrame frame = new JFrame("Lab 4 : Les patrons");
//		JPanel vueMain = new JPanel();
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(new JPanel());
//		frame.setLayout(new BorderLayout());
//
//		initModeles(frame);
//		initVues(frame, image, vueMain);
//
//		controleurImage.addModel(imageModele);
//		controleurPerspective.addModel(perspectiveModele);
//		controleurPerspective.addModel(perspectiveModele2);
//
//		frame.getContentPane().add(vueMain);
//		//frame.getContentPane().add(menu, BorderLayout.NORTH);
//		frame.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
//
//		frame.setResizable(false);
//	//	frame.pack();
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//	}

	private  void initVues(JFrame frame, Image image, JPanel vueMain) {
//
//		JPanel vueThumbnail = new JPanel();
//		JPanel vuePerspective = new JPanel();
//		JPanel vuePerspective2 = new JPanel();
//
//		vueMain.setLayout(new GridLayout(1, 3, 3, 3));
//		vueMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Vues",
//				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
//
//		vueThumbnail.setLayout(new GridLayout(1, 3, -1, -1));
//		vueMain.add(vueThumbnail);
//		vueThumbnail
//				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Thumbnail"));
//
//		vuePerspective.setLayout(new GridLayout(1, 3, -1, -1));
//		vueMain.add(vuePerspective);
//		vuePerspective.setBorder(
//				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Perspective"));
//
//		vuePerspective2.setLayout(new GridLayout(1, 3, -1, -1));
//		vueMain.add(vuePerspective2);
//		vuePerspective2.setBorder(
//				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Perspective"));
//
//
//		VueThumbnail vue = new VueThumbnail();
//		VuePerspective vue2 = new VuePerspective();
//		VuePerspective2 vue3 = new VuePerspective2();

	
	}

//	private  void initModeles(JFrame frame) {
//		ImageModele imageModele = new ImageModele();
//		PerspectiveModele prespective = new PerspectiveModele();
//		// image= imageModele.getImage();
//		imageModele = imageModele.getImage();
//
//	}

	@Override
	protected void start(JFrame frame) {


		System.out.println("Starting the application...");
		frame.setTitle("Lab 4 : Les patrons");
		frame.setResizable(false);
		frame.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);

		Menu menu = new Menu(imageModele);
		frame.getContentPane().add(menu, BorderLayout.NORTH);

		JPanel vueMain = new JPanel();
		frame.add(vueMain);

		setJPanelLayout(vueMain);


		VueThumbnail vue = new VueThumbnail();
		VuePerspective vue2 = new VuePerspective();
		VuePerspective2 vue3 = new VuePerspective2();
	}

	private void setJPanelLayout(JPanel jPanel){
		JPanel vueMain = jPanel;

		JPanel thumbnail = new JPanel();
		JPanel perspective = new JPanel();
		JPanel perspective2 = new JPanel();

		vueMain.setLayout(new GridLayout(1, 3, 3, 3));
		vueMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Vues",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

		thumbnail.setLayout(new GridLayout(1, 3, -1, -1));
		vueMain.add(thumbnail);
		thumbnail
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Thumbnail"));

		perspective.setLayout(new GridLayout(1, 3, -1, -1));
		vueMain.add(perspective);
		perspective.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Perspective"));

		perspective2.setLayout(new GridLayout(1, 3, -1, -1));
		vueMain.add(perspective2);
		perspective2.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Vue Perspective"));
	}
}


