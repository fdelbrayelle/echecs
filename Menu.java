import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JMenuBar
{
  private JFrame frame;
  private Jeu jeu;
  private Plateau plateau;

  private MyActionListener mal = new MyActionListener();

  private ImageIcon echec= new ImageIcon("../images/echecs.gif");
  private ImageIcon croix = new ImageIcon("../images/croix.png");
  private JMenu menu = new JMenu("Fichier");
  private JMenu reseau = new JMenu("Réseau");
  private JMenu about = new JMenu("?");
  private JMenuItem credits = new JMenuItem("À propos");
  private JMenuItem serveur = new JMenuItem("Créer un serveur");
  private JMenuItem rejoindre = new JMenuItem("Rejoindre une partie");
  private JMenuItem nouvellePartie = new JMenuItem("Nouvelle partie", echec);
  private JMenuItem ouvrir = new JMenuItem("Ouvrir");
  private JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
  private JMenuItem exit = new JMenuItem("Quitter",croix);

  public Menu(JFrame frame, Plateau plateau, Jeu jeu)
  {
    nouvellePartie.addActionListener(mal);
    ouvrir.addActionListener(mal);
    sauvegarder.addActionListener(mal);    credits.addActionListener(mal);
    serveur.addActionListener(mal);
    rejoindre.addActionListener(mal);
    exit.addActionListener(mal);

    menu.add(nouvellePartie);
    menu.addSeparator();
    menu.add(ouvrir);
    menu.add(sauvegarder);
    menu.addSeparator();
    menu.add(exit);
    reseau.add(serveur);
    reseau.add(rejoindre);
    about.add(credits);
    this.add(menu);
    this.add(reseau);
    this.add(about);

    this.frame = frame;
    this.jeu = jeu;
    this.plateau = plateau;
  }

  class MyActionListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==nouvellePartie)
      {
        JOptionPane jop = new JOptionPane();
        int choix = jop.showConfirmDialog(null, "Voulez-vous vraiment commencer une nouvelle partie ?", "Nouvelle partie", JOptionPane.OK_CANCEL_OPTION);
        if(choix==JOptionPane.OK_OPTION)
          jeu.reset();
        revalidate();
      }
      if(e.getSource()==ouvrir)
      {
        plateau.ouvrir();
      }
      if(e.getSource()==sauvegarder)
      {
        plateau.sauvegarder();
      }
      if(e.getSource()==credits)
      {
        JOptionPane.showMessageDialog(null, "Projet de synthèse 2007-2008", "A propos", JOptionPane.WARNING_MESSAGE);
      }
      if(e.getSource()==exit)
      {
        JOptionPane jop = new JOptionPane();
        int choix = jop.showConfirmDialog(null, "Voulez-vous vraiment quitter la partie en cours ?", "Quitter le jeu", JOptionPane.OK_CANCEL_OPTION);
        if(choix==JOptionPane.OK_OPTION)
          System.exit(0);
      }
      if(e.getSource()==serveur)
      {
        frame.getContentPane().removeAll();
        new Connexion(frame);
        revalidate();
      }
      if(e.getSource()==rejoindre)
      {
        frame.getContentPane().removeAll();
        String hote = JOptionPane.showInputDialog("Adresse ?");
        new Connexion(hote, frame);
        revalidate();
      }
    }  }
}
