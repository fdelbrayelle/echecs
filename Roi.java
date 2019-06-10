import java.util.LinkedList;

public class Roi extends Piece
{
  public Roi(int X, int Y, int i)
  {
    super(X, Y, i);
    setImage(getToolkit().getImage("../images/roi"+(i==0?"":"B")+".png"));
    setNom("roi");
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    LinkedList<Position> liste = new LinkedList<Position>();

    /* Mouvement en haut */
    if(getCaseY()<7 && (tab[getCaseX()][getCaseY()+1]==null || tab[getCaseX()][getCaseY()+1].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX(),getCaseY()+1));

    /* Mouvement en haut à droite */
    if(getCaseX()<7 && getCaseY()>0 && (tab[getCaseX()+1][getCaseY()-1]==null || tab[getCaseX()+1][getCaseY()-1].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX()+1,getCaseY()-1));

    /* Mouvement à droite */
    if(getCaseX()<7 && (tab[getCaseX()+1][getCaseY()]==null || tab[getCaseX()+1][getCaseY()].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX()+1,getCaseY()));

    /* Mouvement en bas à droite */
    if(getCaseX()<7 && getCaseY()<7 && (tab[getCaseX()+1][getCaseY()+1]==null || tab[getCaseX()+1][getCaseY()+1].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX()+1,getCaseY()+1));

    /* Mouvement en bas */
    if(getCaseY()>0 && (tab[getCaseX()][getCaseY()-1]==null || tab[getCaseX()][getCaseY()-1].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX(),getCaseY()-1));

    /* Mouvement en bas à gauche */
    if(getCaseX()>0 && getCaseY()<7 && (tab[getCaseX()-1][getCaseY()+1]==null || tab[getCaseX()-1][getCaseY()+1].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX()-1,getCaseY()+1));

    /* Mouvement en gauche */
    if(getCaseX()>0 && (tab[getCaseX()-1][getCaseY()]==null || tab[getCaseX()-1][getCaseY()].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX()-1,getCaseY()));

    /* Mouvement en haut à gauche */
    if(getCaseX()>0 && getCaseY()>0 && (tab[getCaseX()-1][getCaseY()-1]==null || tab[getCaseX()-1][getCaseY()-1].getCouleur()!=getCouleur()))
      liste.add(new Position(getCaseX()-1,getCaseY()-1));

    return liste;
  }
}
