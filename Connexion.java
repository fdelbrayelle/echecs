import java.awt.event.*;
import javax.swing.*;

public class Connexion implements NetListener
{
  private JFrame frame;
  private Reseau reseau;
  private Plateau jeu;

  public Connexion(JFrame frame)
  {
    this.frame = frame;
    reseau = new Reseau(8080);
    initialisation();
    System.out.println("Serveur prêt ...");
    this.frame.getContentPane().removeAll();
    jeu = new Plateau(this, 1);
    this.frame.getContentPane().add(jeu);
  }

  public Connexion(String hote, JFrame frame)
  {
    this.frame=frame;
    reseau = new Reseau(hote, 8080);
    initialisation();
    this.frame.getContentPane().removeAll();
    jeu = new Plateau(this, 0);
    this.frame.getContentPane().add(jeu);	    
  }

  public void envoyer(String message)
  {    reseau.envoyer(message);
  }

  public void messageArrive(Object message)
  {
    if(message == null)
    {
      reseau.close();      System.exit(0);
    }
    else
    {
      String coord = message.toString();
      jeu.deplacerPiece(((int)coord.charAt(0)-48),((int)coord.charAt(2)-48), ((int)coord.charAt(4)-48),((int)coord.charAt(6)-48));
      jeu.changerJoueur();
    }
  }

  private void initialisation()
  {
    reseau.addNetListener(this);
    frame.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        reseau.close();
        System.exit(0);
      }
    });
  }
}
