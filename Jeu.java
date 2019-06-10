import java.awt.*;
import javax.swing.*;

public class Jeu
{
  private JFrame frame;
  private Plateau plateau;

  public Jeu()
  {
    frame = new JFrame("Jeu d'échecs");
    plateau = new Plateau();
    JMenuBar menu = new Menu(frame, plateau, this);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setJMenuBar(menu);
    frame.setSize(44*8,420);
    frame.getContentPane().add(plateau);
    frame.setLocation((screenSize.width-frame.getWidth())/2, ((screenSize.height-frame.getHeight())/2));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void reset()
  {
    if(frame!=null)
      frame.dispose();
    new Jeu();
  }

  public static void main(String[] args)
  {
    Jeu jeu = new Jeu();
  }
}
