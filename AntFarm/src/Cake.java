
/**
 * A <code>Cake</code> sits around and waits for a
 * <code>WorkerAnt</code> to get food from it.
 * It does not act.
 */
public class Cake extends Food
{
    private static final int BITE=2;
    public Cake(){
        super(BITE);
    }
}
