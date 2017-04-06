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
	protected ImageModele imageModele;
	protected  PerspectiveModele perspectiveModele;
	protected  PerspectiveModele perspectiveModele2 ;

	protected VueThumbnail vue;
	protected VuePerspective vue2;
	protected VuePerspective vue3;

	protected  ControleurImage controleurImage;
	protected  ControleurPerspective controleurPerspective;


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
	protected void initControleurs() {
		this.controleurImage = new ControleurImage();
		this.controleurPerspective = new ControleurPerspective();
	}

	@Override
	protected void initModeles() {
		this.imageModele = new ImageModele();
		this.perspectiveModele = new PerspectiveModele();
		this.perspectiveModele2 = new PerspectiveModele();
	}

	@Override
	protected void start(JFrame frame) {
		System.out.println("Starting the application...");
		frame.setTitle("Lab 4 : Les patrons");
		frame.setResizable(false);
		frame.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);

		Menu menu = new Menu(this.imageModele);
		frame.getContentPane().add(menu, BorderLayout.NORTH);

		JPanel vueMain = new JPanel();
		frame.add(vueMain);

		initVues(vueMain);


		VueThumbnail vue = new VueThumbnail();
		VuePerspective vue2 = new VuePerspective();
		VuePerspective vue3 = new VuePerspective();

		//tell Model about View
		this.imageModele.addObserver(vue);
		this.perspectiveModele.addObserver(vue2);
		this.perspectiveModele2.addObserver(vue3);

//		perspectiveModele.addObserver(vue2);
//		perspectiveModele2.addObserver(vue3);
//****************************************************************
//		//tell View about Controller (DOESNT WORK???? not jpanel)
//		vue.addMouseListener(this.controleurImage);
//
//		vue2.addMouseListener(this.controleurPerspective);
//		vue2.addMouseWheelListener(this.controleurPerspective);
//
//		vue3.addMouseListener(this.controleurPerspective);
//		vue3.addMouseWheelListener(this.controleurPerspective);
//
//		vue3.addMouseListener(controleurPerspective);
//		vue3.addMouseWheelListener(controleurPerspective);

	}

	private void initVues(JPanel jPanel){
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


		this.vue = new VueThumbnail();
		this.vue2 = new VuePerspective();
		this.vue3 = new VuePerspective();

		thumbnail.add(vue);
		perspective.add(vue2);
		perspective2.add(vue3);

		//tell View about Controller (on the jpanel???)
		thumbnail.addMouseListener(this.controleurImage);
//
		perspective.addMouseListener(this.controleurPerspective);
		perspective.addMouseWheelListener(this.controleurPerspective);

		perspective2.addMouseListener(this.controleurPerspective);
		perspective2.addMouseWheelListener(this.controleurPerspective);
	}
}


