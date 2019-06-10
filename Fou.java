import java.util.LinkedList;

public class Fou extends Piece
{
  public Fou(int X, int Y, int i)
  {
    super(X, Y, i);
    setImage(getToolkit().getImage("../images/fou"+(i==0?"":"B")+".png"));
    setNom("fou");
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    LinkedList<Position> liste = new LinkedList<Position>();	
    boolean ok = true;
    int Xterateur=getCaseX()-1;
    int Yterateur=getCaseY()-1;

    /* Diagonale Haut Gauche */
    while(ok && Xterateur>=0 && Yterateur>=0)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok =false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
          liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Yterateur--;
      Xterateur--;
    }

    ok = true;
    Xterateur = getCaseX()-1;
    Yterateur = getCaseY()+1;

    /* Diagonale Bas Gauche */
    while(ok && Xterateur>=0 && Yterateur<8)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok = false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
          liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Xterateur--;
      Yterateur++;
    }

    ok = true;
    Xterateur = getCaseX()+1;
    Yterateur = getCaseY()-1;

    /* Diagonale Haut Droite */
    while(ok && Xterateur<8 && Yterateur>=0)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok = false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
          liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Xterateur++;
      Yterateur--;
    }

    ok = true;
    Xterateur = getCaseX()+1;
    Yterateur = getCaseY()+1;

    /* Diagonale Bas Droite */
    while(ok && Xterateur<8 && Yterateur<8)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok=false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
          liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Xterateur++;
      Yterateur++;
    }

    return liste;
  }
}
