package application.vues;

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

		Menu menu = new Menu(this.controleurImage);
		frame.getContentPane().add(menu, BorderLayout.NORTH);

		JPanel vueMain = new JPanel();
		frame.add(vueMain);

		initVues(vueMain);

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

		perspective.addMouseListener(this.controleurPerspective);
		perspective.addMouseWheelListener(this.controleurPerspective);

		perspective2.addMouseListener(this.controleurPerspective);
		perspective2.addMouseWheelListener(this.controleurPerspective);
	}
}


