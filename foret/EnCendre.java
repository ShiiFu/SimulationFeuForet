package foret;

public class EnCendre implements Etat
{
    private Arbre arbre;

    public EnCendre(Arbre arbre)
    {
        this.arbre = arbre;
    }

    public boolean appliqueEffet(int tour)
    {
        return false;
    }
}
