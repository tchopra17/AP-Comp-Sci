/**
 * Cookie.java  05/10/07
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 */

/**
 * A <code>Cookie</code> sits around and waits for a
 * <code>WorkerAnt</code> to get food from it.
 * It does not act.
 */
public class Cookie extends Food
{
    private static final int BITE=1;
    public Cookie(){
        super(BITE);
    }
}
