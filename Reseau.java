import java.io.*;
import java.net.*;
import java.util.Vector;

public class Reseau implements Runnable
{
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private Vector<NetListener> ecouteurs;
  
  /* Serveur */
  public Reseau(int port)
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(port); 
      socket = serverSocket.accept();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    initialisation();
  }

  /* Client */
  public Reseau(String hote, int port)
  {
    try
    {
      socket = new Socket(hote, port);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    initialisation();
  }

  /**
   * Ajouter un nouveau ecouteur qui sera averti chaque fois
   * qu'un objet est disponible.
   */
  public void addNetListener(NetListener listener)
  {
    ecouteurs.add(listener);
  }
    
  /**
   * Enlever un ecouteur.
   */
  public void removeNetListener(NetListener listener)
  {
    ecouteurs.remove(listener);
  }
    
  /**
   * Envoyer l'objet au partenaire.
   */
  public void envoyer(Object message)
  {
    try
    {
      out.writeObject(message);
      out.flush();
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
  }

  /* Fin de connexion */
  public void close()
  {
    try
    {
      socket.close();
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
  }

  public void run()
  {
    try
    {
      while(true) delivrerMessage(in.readObject());
    }
    catch (Exception e)
    {
      delivrerMessage(null);
    }
  }

  private void initialisation()
  {
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
      ecouteurs = new Vector<NetListener>();
      Thread lanceur = new Thread(this);
      lanceur.start();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }       

  private void delivrerMessage(Object message)
  {
    for (int i=0; i<ecouteurs.size(); i++)
    {
      ((NetListener)ecouteurs.elementAt(i)).messageArrive(message);
    }
  }
}
