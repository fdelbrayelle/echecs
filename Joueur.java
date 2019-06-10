class Joueur
{
  private String nom, couleur;
  private Roi roi;
  public Joueur()
  {
  }
  public Joueur(String couleur)
  {
    this.couleur = couleur;
  }
  public void setRoi(Piece roi)
  {
    this.roi = (Roi) roi;
  }
  public Roi getRoi()
  {
    return roi;
  }
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  public String getCouleur()
  {
    return couleur;
  }
}
