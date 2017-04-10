/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe: 02
 Projet: Laboratoire #4
 Étudiant(e)s:
 Alexandre Trepanier
 Vanessa Baquero
 Nam Vu Khanh
 Khoi Tran-Quang
 Professeur : Francis Cardinal
 Nom du fichier: .java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package application.vues;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import application.controleur.ControleurImage;
import application.controleur.ControleurPerspective;
import application.controleur.ControleurPerspective2;
import application.modele.PerspectiveModele;
import application.modele.ImageModele;

/**
 * Classe de l'application (ses vues, modèles et controleurs)
 */
public class Application extends framework.Application{

	private final int LARGEUR_FENETRE = 1000;
	private final int HAUTEUR_FENETRE = 400;

	protected ImageModele imageModele;
	protected  PerspectiveModele perspectiveModele;
	protected  PerspectiveModele perspectiveModele2 ;

	protected VueThumbnail vue;
	protected VuePerspective vue2;
	protected VuePerspective2 vue3;

	protected  ControleurImage controleurImage;
	protected  ControleurPerspective controleurPerspective;
	protected ControleurPerspective2 controleurPerspective2;

	/**
	 * Initialise les controleurs
	 */
	@Override
	protected void initControleurs() {
		this.controleurImage = new ControleurImage(imageModele, vue);
		this.controleurPerspective = new ControleurPerspective(perspectiveModele, vue2);
		this.controleurPerspective2 = new ControleurPerspective2(perspectiveModele2, vue3);
	}

	/**
	 * Initialise les modèles
	 */
	@Override
	protected void initModeles() {
		this.imageModele = new ImageModele();
		this.perspectiveModele = new PerspectiveModele();
		this.perspectiveModele2 = new PerspectiveModele();
	}

	/**
	 * Démarre l'application
	 *
	 * @param frame The main frame of the {@link Application}.
	 */
	@Override
	protected void start(JFrame frame) {

		frame.setTitle("Lab 4 : Les patrons");
		frame.setResizable(false);
		frame.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);

		Menu menu = new Menu(this.imageModele, this.perspectiveModele, this.perspectiveModele2,this.controleurImage,
				this.controleurPerspective, this.controleurPerspective2);
		frame.getContentPane().add(menu, BorderLayout.NORTH);

		JPanel vueMain = new JPanel();
		frame.add(vueMain);

		initVues(vueMain);

		//tell Model about View
		this.imageModele.addObserver(vue);
		this.perspectiveModele.addObserver(vue2);
		this.perspectiveModele2.addObserver(vue3);
	}

	/**
	 * Initialise les vues
	 *
	 * @param jPanel Panel principal
	 */
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


		this.vue = new VueThumbnail(imageModele, controleurImage);
		this.vue2 = new VuePerspective(perspectiveModele, controleurPerspective);
		this.vue3 = new VuePerspective2(perspectiveModele2, controleurPerspective2);

		thumbnail.add(vue);
		perspective.add(vue2);
		perspective2.add(vue3);

		//tell View about Controller
		thumbnail.addMouseListener(this.controleurImage);

		perspective.addMouseListener(this.controleurPerspective);
		perspective.addMouseWheelListener(this.controleurPerspective);

		perspective2.addMouseListener(this.controleurPerspective2);
		perspective2.addMouseWheelListener(this.controleurPerspective2);
	}
}


