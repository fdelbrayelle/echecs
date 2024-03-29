public class Position
{
  private int x, y;
  public Position(int x, int y)
  {
    this.x = x;
    this.y = y;
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
  public boolean equals(Object o)
  {
    Position tmp;
    if(!(o instanceof Position))
      return false;
    else
    {
      tmp = (Position) o;
      return this.getX()==tmp.getX() && this.getY()==tmp.getY();
    }
  }
  public String toString()
  {
    return "("+getX()+","+getY()+")";
  }
}
