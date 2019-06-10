import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.io.*;

public class Plateau extends JComponent
{
  private Piece[][] tabPlateau = new Piece[8][8];
  private Image carreNoir, carreBlanc;
  private int MouseBouge = 0, couleur = 0;
  private int[] coord = new int[2];
  private Joueur blanc, noir, tmp;
  private Connexion connexion;

  public Plateau()
  {
    revalidate();
    blanc = new Joueur("Blanc");
    noir = new Joueur("Noir");

    carreNoir = getToolkit().getImage("../images/carreNoir.png");
    carreBlanc = getToolkit().getImage("../images/carreBlanc.png");

    prepareImage(carreNoir,this);
    prepareImage(carreBlanc,this);

    for(int j=0; j<tabPlateau.length; j++)
      for(int i=0; i<tabPlateau.length; i++)
        tabPlateau[i][j] = null;

    /* Initialisation des pions blancs */
    tabPlateau[0][0] = new Tour(0,0,0);
    tabPlateau[1][0] = new Cavalier(1,0,0);
    tabPlateau[2][0] = new Fou(2,0,0);
    tabPlateau[3][0] = new Reine(3,0,0);
    tabPlateau[4][0] = new Roi(4,0,0);
    tabPlateau[5][0] = new Fou(5,0,0);
    tabPlateau[6][0] = new Cavalier(6,0,0);
    tabPlateau[7][0] = new Tour(7,0,0);
    for(int j=0;j< tabPlateau.length;j++)
      tabPlateau[j][1] = new Pion(j,1,0);

    /* Initialisation des pions noirs */
    tabPlateau[0][7] = new Tour(0,7,1);
    tabPlateau[1][7] = new Cavalier(1,7,1);
    tabPlateau[2][7] = new Fou(2,7,1);
    tabPlateau[3][7] = new Reine(3,7,1);
    tabPlateau[4][7] = new Roi(4,7,1);
    tabPlateau[5][7] = new Fou(5,7,1);
    tabPlateau[6][7] = new Cavalier(6,7,1);
    tabPlateau[7][7] = new Tour(7,7,1);
    for(int j=0;j< tabPlateau.length;j++)
      tabPlateau[j][6] = new Pion(j,6,1);

    blanc.setRoi(tabPlateau[4][0]);
    noir.setRoi(tabPlateau[4][7]);

    tmp = blanc;

    /* Initialisation du clic */
    addMouseListener(new clic());
    addMouseMotionListener(new traine());
  }

  public Plateau(Connexion connexion, int couleur)
  {
    this();
    this.connexion = connexion;
    this.tmp = (couleur==0?noir:blanc);
  }

  public Plateau(Piece[][] tabSauvegarde)
  {

  }

  public void ouvrir()
  {
    JFileChooser jfc = new JFileChooser();

    
  }

  public void sauvegarder()
  {
    DataOutputStream dos = null;

    String nomFichier = JOptionPane.showInputDialog("Nom de fichier ?");

    try
    {
      dos = new DataOutputStream(new FileOutputStream(nomFichier+".dat"));
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }

    for(int i=0; i<tabPlateau.length; i++)
      for(int j=0; j<tabPlateau.length; j++)
      {
        if(tabPlateau[i][j]!=null)
        {
          try
          {
            dos.writeShort(tabPlateau[i][j].getCaseX());
            dos.writeBytes(",");
            dos.writeShort(tabPlateau[i][j].getCaseY());
            dos.writeBytes(" ");
          }
          catch(IOException e)
          {
            e.printStackTrace();
          }
        }
      }
    try
    {
      dos.close();
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }

  public boolean echec()
  {
    for(int i=0; i<tabPlateau.length; i++)
      for(int j=0; j<tabPlateau.length; j++)
        if(tabPlateau[i][j]!=null && tabPlateau[i][j].getCouleur().equals(tmp.getCouleur()))
          for(int k=0; k<tabPlateau[i][j].posPossible(tabPlateau).size(); k++)
            if(tabPlateau[i][j].posPossible(tabPlateau).get(k).equals(new Position(tmp.getRoi().getCaseX(),tmp.getRoi().getCaseY())))
              return true;
    return false;
  }

  class traine implements MouseMotionListener
  {
    public void mouseMoved(MouseEvent e)
    {
    }
    public void mouseDragged(MouseEvent e)
    {
      if(MouseBouge==1)
      {
        tabPlateau[coord[0]][coord[1]].setX(e.getX()-tabPlateau[coord[0]][coord[1]].getTareX());
        tabPlateau[coord[0]][coord[1]].setY(e.getY()-tabPlateau[coord[0]][coord[1]].getTareY());
        repaint();
      }
    }
  }

  class clic implements MouseListener
  {
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
      int x = e.getX();
      int y = e.getY();
      int caseX = x/44;
      int caseY = y/44;

      if(caseX<8 && caseY<8)
      {
        if(tabPlateau[caseX][caseY]!=null)
        {
          if(tabPlateau[caseX][caseY].getCouleur()==tmp.getCouleur())
          {
            tabPlateau[caseX][caseY].setTareX(e.getX()-tabPlateau[caseX][caseY].getX());
            tabPlateau[caseX][caseY].setTareY(e.getY()-tabPlateau[caseX][caseY].getY());
            coord[0] = caseX;
            coord[1] = caseY;
            MouseBouge = 1;
          }
        }
      }
    }
    public void mouseReleased(MouseEvent e)
    {
      if(MouseBouge==1)
      {
        MouseBouge = 0;
        int nX = e.getX()/44;
        int nY = e.getY()/44;

        boolean ok = false;
        LinkedList<Position> liste = tabPlateau[coord[0]][coord[1]].posPossible(tabPlateau);
        int i = 0;

        while(ok==false && i<liste.size())
        {
          if(liste.get(i).getX()==nX)
            if(liste.get(i).getY()==nY)
              ok = true;
              i++;
        }

        if(ok)
        {
          if(tabPlateau[coord[0]][coord[1]].getNom()=="pion" && (nY==0||nY==7))
          {
            tabPlateau[nX][nY] = new Reine(nX,nY,tabPlateau[coord[0]][coord[1]].getCouleur()=="Blanc"?1:0);
            tabPlateau[coord[0]][coord[1]] = null;
          }
          else
          {
            tabPlateau[nX][nY] = tabPlateau[coord[0]][coord[1]];
            tabPlateau[nX][nY].setCaseX(nX);
            tabPlateau[nX][nY].setCaseY(nY);
            tabPlateau[nX][nY].setX(tabPlateau[nX][nY].getCaseX()*44);
            tabPlateau[nX][nY].setY(tabPlateau[nX][nY].getCaseY()*44);
            tabPlateau[coord[0]][coord[1]]=null;
          }

          if(echec())
            JOptionPane.showMessageDialog(null, "Le roi " + (tmp.getCouleur()=="Blanc"?"Noir":"Blanc") + " est échec !", "Attention", JOptionPane.WARNING_MESSAGE);

          changerJoueur();
          if(connexion!=null)
            connexion.envoyer(coord[0]+","+coord[1]+":"+nX+","+nY);
        }

        else
        {
          tabPlateau[coord[0]][coord[1]].setX(tabPlateau[coord[0]][coord[1]].getCaseX()*44);
          tabPlateau[coord[0]][coord[1]].setY(tabPlateau[coord[0]][coord[1]].getCaseY()*44);
        }

        repaint();
      }
    }
  }

  public void changerJoueur()
  {
    tmp = (tmp.getCouleur().equals("Blanc")?noir:blanc);
    repaint();
  }

  public void deplacerPiece(int aX, int aY, int nX, int nY)
  {
    tabPlateau[nX][nY]=tabPlateau[aX][aY];
    tabPlateau[nX][nY].setCaseX(nX);
    tabPlateau[nX][nY].setCaseY(nY);
    tabPlateau[nX][nY].setX(tabPlateau[nX][nY].getCaseX()*44);
    tabPlateau[nX][nY].setY(tabPlateau[nX][nY].getCaseY()*44);
    tabPlateau[aX][aY]=null;
  }

  public void paint(Graphics g)
  {
    /* Dessin du plateau */
    for(int j=0; j<tabPlateau.length; j++)
      for(int i=0; i<tabPlateau.length; i++)
        if((i+j)%2 == 1)
          g.drawImage(carreNoir, i*44, j*44, this);
        else
          g.drawImage(carreBlanc, i*44, j*44, this);

    /* Griser les cases */
    if(MouseBouge==1)
    {
      tabPlateau[coord[0]][coord[1]].casePossible(g,tabPlateau);
    }

    /* Afficher les pieces */
    for(int j=0;j<tabPlateau.length;j++)
      for(int i=0;i<tabPlateau.length;i++)
        if(tabPlateau[i][j]!=null)
          g.drawImage(tabPlateau[i][j].getImage(), tabPlateau[i][j].getX(), tabPlateau[i][j].getY(), this);

    g.drawString("Les " + tmp.getCouleur() + "s doivent jouer !", 20, 8*44+15);
  }
}
