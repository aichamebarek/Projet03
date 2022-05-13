package petudiants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class FenetreCollege extends JFrame {

	College college = new College("Ahuntsic INC.");
	Etudiant etudCourant; // etudiant courant

	/*********************************************/
	private JPanel panContenu = new JPanel();
	private JPanel panBoutons = new JPanel();
	private JButton btnLister = new JButton();
	private JButton btnAgumenter = new JButton();
	private JTextField txtTaux = new JTextField();
	private JLabel jLabel1 = new JLabel();
	private JButton btnffacer = new JButton();
	private JLabel jLabel2 = new JLabel();
	private JTextArea affichage = new JTextArea();
	private JButton btnQuitter = new JButton();
	ImageIcon imgLogo = new ImageIcon("ahuntsic.jpg");
	private JTextField textDate;
	private final JComboBox comboBox = new JComboBox();
	private final JTextField txtNomF = new JTextField();
	private final JLabel label = new JLabel("Prenom");
	private final JTextField txtPrenom = new JTextField();
	private final JRadioButton rdBtnPartiel = new JRadioButton("TPartiel");
	private final JRadioButton rdBtnComplet = new JRadioButton("TComplet");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblNom = new JLabel("Nom");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnAjouter = new JButton("Ajouter");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenetreCollege frame = new FenetreCollege();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public FenetreCollege() {

		initialize();

	}

	private void remplirComboNo() {
		comboBox.addActionListener(new ComboBoxActionListener());
		comboBox.removeAllItems();
		for (Etudiant etud : college.getListeEtudiants()) {
			if (etud != null) {
				comboBox.addItem(etud.getInfos().getNoDossier());
			}
		}
	}

	private void initialize() {
		addWindowListener(new ThisWindowListener());
		this.setContentPane(panContenu);
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(846, 535));

		this.setTitle("Gestion des etudiants");
		this.setFont(new Font("Dialog", 1, 14));
		btnQuitter.addActionListener(new BtnQuitterActionListener());
		btnQuitter.setText("Quitter");
		btnQuitter.setBounds(new Rectangle(5, 455, 186, 25));
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));

		panContenu.setBounds(new Rectangle(155, 70, 120, 60));
		panContenu.setBackground(new Color(132, 132, 255));

		// panBoutons
		panBoutons.setBounds(new Rectangle(0, 0, 228, 490));
		panBoutons.setLayout(null);
		panBoutons.setBackground(new Color(35, 255, 255));
		btnLister.addActionListener(new BtnListerActionListener());
		btnLister.setText("Lister");
		btnLister.setBounds(new Rectangle(5, 381, 186, 25));
		btnLister.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnAgumenter.addActionListener(new BtnAgumenterActionListener());
		btnAgumenter.setText("Augmenter Frais");
		btnAgumenter.setBounds(new Rectangle(5, 269, 186, 25));
		btnAgumenter.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTaux.setBounds(new Rectangle(5, 241, 186, 20));
		jLabel1.setText("Taux %");
		jLabel1.setBounds(new Rectangle(10, 221, 59, 15));
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnffacer.addActionListener(new BtnffacerActionListener());
		btnffacer.setText("Effacer");
		btnffacer.setBounds(new Rectangle(5, 419, 186, 25));
		btnffacer.setFont(new Font("Tahoma", Font.BOLD, 12));

		jLabel2.setBounds(new Rectangle(196, 0, 521, 61));
		jLabel2.setFont(new Font("Arial Narrow", 1, 15));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setIcon(new ImageIcon(FenetreCollege.class.getResource("/petudiants/ahuntsic.jpg")));
		jLabel2.setBorder(BorderFactory.createTitledBorder(""));
		jLabel2.setText("College " + college.getNom());

		panBoutons.add(btnQuitter, null);
		panBoutons.add(btnLister, null);
		panBoutons.add(btnAgumenter, null);
		panBoutons.add(jLabel1, null);
		panBoutons.add(txtTaux, null);
		panBoutons.add(btnffacer, null);
		scrollPane.setViewportBorder(
				new TitledBorder(null, "Liste des \u00E9tudiants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(241, 90, 584, 377);

		panContenu.add(scrollPane);
		affichage.setTabSize(10);
		scrollPane.setViewportView(affichage);
		affichage.setFont(new Font("Arial", Font.ITALIC, 11));
		this.getContentPane().add(panBoutons, null);

		JButton btnRapport = new JButton("Rapport");
		btnRapport.addActionListener(new BtnRapportActionListener());

		btnRapport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRapport.setBounds(5, 347, 186, 25);
		panBoutons.add(btnRapport);

		textDate = new JTextField();
		textDate.setBounds(5, 319, 82, 20);
		panBoutons.add(textDate);
		textDate.setColumns(10);

		JLabel lblDate = new JLabel("Annee");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 301, 46, 14);
		panBoutons.add(lblDate);

		comboBox.setBounds(5, 11, 186, 25);
		// comboBox.addActionListener(this);

		panBoutons.add(comboBox);
		txtNomF.setColumns(10);
		txtNomF.setBounds(new Rectangle(0, 67, 163, 20));
		txtNomF.setBounds(5, 52, 186, 22);

		panBoutons.add(txtNomF);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 73, 59, 15);

		panBoutons.add(label);
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(5, 88, 186, 22);

		panBoutons.add(txtPrenom);
		buttonGroup.add(rdBtnPartiel);
		rdBtnPartiel.setFont(new Font("Dialog", Font.BOLD, 12));
		rdBtnPartiel.setBounds(6, 118, 94, 23);

		panBoutons.add(rdBtnPartiel);
		buttonGroup.add(rdBtnComplet);
		rdBtnComplet.setFont(new Font("Dialog", Font.BOLD, 12));
		rdBtnComplet.setSelected(true);
		rdBtnComplet.setBounds(102, 118, 89, 23);

		panBoutons.add(rdBtnComplet);
		lblNom.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNom.setBounds(10, 38, 46, 14);

		panBoutons.add(lblNom);
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(5, 162, 186, 21);

		panBoutons.add(btnAjouter);
		this.getContentPane().add(jLabel2, null);

	}

	// m�thodes priv�es
	private void vider() {
		affichage.setText("");
		txtTaux.setText("");
	}

	// BOUTON LISTER les membres tri�s du college
	private class BtnListerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/*
			 * affichage.setText("Identite\tInscription\tFrais\tHeures" +
			 * "\tTotal P / I\n\n");
			 */
			college.trier();
			affichage.setText(college.toString());
		}
	}

	// BOUTON RAPPORT: afficher les etudiants inscrits dans une ann�e donn�e
	private class BtnRapportActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// saisir ann�e
				int annee = Integer.parseInt(textDate.getText());

				affichage.setText("\t\tRAPPORT DES ETUDIANTS PAR DATE\n\n");
				affichage.append(college.rapport(annee));
			} catch (NumberFormatException ex) {
				affichage.setText("Erreur dans la saisie de l'ann�e");
			}
		}
	}

	// BOUTON EFFACER
	private class BtnffacerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			vider();
		}
	}

	// BOUTON AUGMENTER: augmenter les frais de tous les etudiants
	private class BtnAgumenterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				double taux = Double.parseDouble(txtTaux.getText());
				college.augmenterFrais(taux);
				affichage.setText("\t\tLISTE DES ETUDIANTS\n\n");
				affichage.setText(college.toString());
			} catch (Exception ex) {
				affichage.setText("Erreur dansla saisie du taux");
			}
		}
	}

	// BOUTON QUITTER
	private class BtnQuitterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// EtudiantsData.path = "./resources/Ahuntsic.xml";
			EtudiantsData.enregistrerXML(college);
			System.exit(0);
		}
	}

	// COmbo des codes: afficher les infos de l'etudiant les s�lectionn�
	private class ComboBoxActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// int pos = comboBox.getSelectedIndex();
			// etudCourant = college.getEtudiant(pos);
			// OU
			String code = comboBox.getSelectedItem().toString();
			etudCourant = college.getEtudiant(code);

			// afficher etudCourant
			txtNomF.setText(etudCourant.getInfos().getNomFamille());
			txtPrenom.setText(etudCourant.getInfos().getPrenom());
			if (etudCourant instanceof EtudiantPartiel) {
				rdBtnPartiel.setSelected(true);
			} else if (etudCourant instanceof Etudiant) {
				rdBtnComplet.setSelected(true);
			}

		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowOpened(WindowEvent e) {
			// Charger le fichier des etudiants
			// EtudiantsData.charger(college);
			college = EtudiantsData.chargerXML();

			// Remplir la Liste des no d'etudiants
			remplirComboNo();
		}
	}
}
