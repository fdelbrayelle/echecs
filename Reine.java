import java.util.LinkedList;

public class Reine extends Piece
{
  public Reine(int X, int Y, int i)
  {
    super(X, Y, i);
    setImage(getToolkit().getImage("../images/reine"+(i==0?"":"B")+".png"));
    setNom("reine");
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    LinkedList<Position> liste = new LinkedList<Position>();
    boolean ok = true;
    int Xterateur = getCaseX()-1;
    int Yterateur = getCaseY()-1;

    /* Diagonale Haut Gauche */
    while(ok && Xterateur>=0 && Yterateur>=0)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok = false;
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
        ok = false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
        liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Xterateur++;
      Yterateur++;
    }

    ok = true;
    Xterateur = getCaseX();
    Yterateur = getCaseY()+1;

    /* Diagonale Ligne Bas */
    while(ok && Yterateur<8)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok = false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
          liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Yterateur++;
    }

    ok = true;
    Xterateur = getCaseX();
    Yterateur = getCaseY()-1;

    /* Diagonale Ligne Haut */
    while(ok && Yterateur>=0)
    {
      if(tab[Xterateur][Yterateur]!=null)
      {
        ok = false;
        if(tab[Xterateur][Yterateur].getCouleur()!=getCouleur())
          liste.add(new Position(Xterateur,Yterateur));
      }
      else
        liste.add(new Position(Xterateur,Yterateur));
      Yterateur--;
    }

    ok = true;
    Xterateur = getCaseX()-1;
    Yterateur = getCaseY();

    /* Diagonale Ligne Gauche */
    while(ok && Xterateur>=0)
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
    }

    ok = true;
    Xterateur = getCaseX()+1;
    Yterateur = getCaseY();

    /* Diagonale Ligne Droite */
    while(ok && Xterateur<8)
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
    }
    return liste;
  }
}
