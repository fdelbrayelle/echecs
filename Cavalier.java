import java.util.LinkedList;

public class Cavalier extends Piece
{
  public Cavalier(int X, int Y, int i)
  {
    super(X, Y, i);
    setImage(getToolkit().getImage("../images/cavalier"+(i==0?"":"B")+".png"));
    setNom("cavalier");
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    LinkedList<Position> liste = new LinkedList<Position>();	
    if(getCaseY()>2)
    {
      if(getCaseX()>0 && (tab[getCaseX()-1][getCaseY()-2]==null || tab[getCaseX()-1][getCaseY()-2].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()-1,getCaseY()-2));
      if(getCaseX()<7 && (tab[getCaseX()+1][getCaseY()-2]==null || tab[getCaseX()+1][getCaseY()-2].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()+1,getCaseY()-2));
    }
    if(getCaseY()>1)
    {
      if(getCaseX()>1 && (tab[getCaseX()-2][getCaseY()-1]==null || tab[getCaseX()-2][getCaseY()-1].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()-2,getCaseY()-1));
      if(getCaseX()<6 && (tab[getCaseX()+2][getCaseY()-1]==null || tab[getCaseX()+2][getCaseY()-1].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()+2,getCaseY()-1));
    }
    if(getCaseY()<6)
    {
      if(getCaseX()>1 && (tab[getCaseX()-2][getCaseY()+1]==null || tab[getCaseX()-2][getCaseY()+1].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()-2,getCaseY()+1));
      if(getCaseX()<6 && (tab[getCaseX()+2][getCaseY()+1]==null || tab[getCaseX()+2][getCaseY()+1].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()+2,getCaseY()+1));
    }
    if(getCaseY()<7)
    {
      if(getCaseX()>0 && (tab[getCaseX()-1][getCaseY()+2]==null || tab[getCaseX()-1][getCaseY()+2].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()-1,getCaseY()+2));
      if(getCaseX()<7 && (tab[getCaseX()+1][getCaseY()+2]==null || tab[getCaseX()+1][getCaseY()+2].getCouleur()!=getCouleur()))
        liste.add(new Position(getCaseX()+1,getCaseY()+2));
    }
    return liste;
  }
}
