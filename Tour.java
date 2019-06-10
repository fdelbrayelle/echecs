import java.util.LinkedList;

public class Tour extends Piece
{
  public Tour(int X, int Y, int i)
  {
    super(X, Y, i);
    setImage(getToolkit().getImage("../images/tour"+(i==0?"":"B")+".png"));
    setNom("tour");
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    LinkedList<Position> liste = new LinkedList<Position>();	
    boolean ok = true;
    int Xterateur = getCaseX();
    int Yterateur = getCaseY()+1;

    /* Ligne Bas */
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

    /* Ligne Haut */
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

    /* Ligne Gauche */
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

    /* Ligne Droite */
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
