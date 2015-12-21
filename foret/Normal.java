package foret;

public class Normal implements Etat
{
    private Arbre arbre;

    public Normal(Arbre arbre)
    {
        this.arbre = arbre;
    }

    public boolean appliqueEffet(int tour)
    {
        return false;
    }
}
