import java.util.LinkedList;

public class Pion extends Piece
{
  public Pion(int X, int Y, int i)
  {
    super(X, Y, i);
    setImage(getToolkit().getImage("../images/pion"+(i==0?"":"B")+".png"));
    setNom("pion");
  }
  public LinkedList<Position> posPossible(Piece[][] tab)
  {
    LinkedList<Position> liste = new LinkedList<Position>();  
    int sens = getCouleur()=="Noir"?1:-1;

    /* Avancer de 2 cases sur la 1ère ligne */
    if((getCaseY()==1 && sens==1) || (getCaseY()==6 && sens==-1))
    {
      if(tab[getCaseX()][getCaseY()+(2*sens)]==null)
        liste.add(new Position(getCaseX(),getCaseY()+(2*sens)));
    }

    /* Avancer d'une case */
    if(tab[getCaseX()][getCaseY()+(1*sens)]==null)
      liste.add(new Position(getCaseX(),getCaseY()+(1*sens)));

    /* Capturer à gauche */
    if(getCaseX()>0 && tab[getCaseX()-1][getCaseY()+(1*sens)]!=null)
    {
      if(tab[getCaseX()-1][getCaseY()+(1*sens)].getCouleur()!=getCouleur())
        liste.add(new Position(getCaseX()-1,getCaseY()+(1*sens)));  
    }

    /* Capturer à droite */
    if(getCaseX()<7 && tab[getCaseX()+1][getCaseY()+(1*sens)]!=null)
    {
      if(tab[getCaseX()+1][getCaseY()+(1*sens)].getCouleur()!=getCouleur())
        liste.add(new Position(getCaseX()+1,getCaseY()+(1*sens)));  
    }
    return liste; 
  }  
}
