import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;

public class Piece extends JComponent
{
  int x, y, caseX, caseY, tareX, tareY;
  Image image, grise;
  String couleur, nom;

  public int getTareX()
  {
    return tareX;
  }
  public void setTareX(int tareX)
  {
    this.tareX = tareX;
  }
  public int getTareY()
  {
    return tareY;
  }
  public void setTareY(int tareY)
  {
    this.tareY = tareY;
  }
  public Piece(int X, int Y, int couleur)
  {
    this.couleur = (couleur==1?"Blanc":"Noir");
    grise = getToolkit().getImage("../images/grise.png");
    caseX = X;
    caseY = Y;
    x = X*44;
    y = Y*44;
  }
  public Image getGrise()
  {
    return grise;
  }
  public Image getImage()
  {
    return image;
  }
  public void setImage(Image image)
  {
    this.image = image;
  }
  public int getX()
  {
    return x;
  }
  public void setX(int x)
  {
    this.x = x;
  }
  public int getY()
  {
    return y;
  }
  public void setY(int y)
  {
    this.y = y;
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    return null;
  }
  public void casePossible(Graphics g, Piece [][] tab)
  {
    LinkedList<Position> liste = posPossible(tab);
    for(int i=0; i<liste.size(); i++)
    {
      g.drawImage(getGrise(),liste.get(i).getX()*44,liste.get(i).getY()*44,this);
    }
  }
  public void paint(Graphics g)
  {
    g.drawImage(image, x, y, this);
  }
  public String getNom()
  {
    return nom;
  }
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  public int getCaseX()
  {
    return caseX;
  }
  public void setCaseX(int caseX)
  {
    this.caseX = caseX;
  }
  public int getCaseY()
  {
    return caseY;
  }
  public void setCaseY(int caseY)
  {
    this.caseY = caseY;
  }
  public String getCouleur()
  {
    return couleur;
  }
  public String toString()
  {
    return getNom() + " (" + getCaseX() + "," + getCaseY() + ")";
  }
}
