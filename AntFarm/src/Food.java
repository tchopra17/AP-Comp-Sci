

import info.gridworld.actor.Actor;

/**
 * <code>Food</code> is the top level abstract class for different
 * types of food.  A food object waits for a
 * <code>WorkerAnt</code> to get food from it.  It does not act.
 */
public abstract class Food extends Actor implements Processable{
	
    private int BITE_SIZE;
    private int foodEaten;
    public Food(int bite)
    {
        BITE_SIZE=bite;
        foodEaten=0;
        setColor(null);
    }
    
    public void process(WorkerAnt ant){
ant.takeFood(BITE_SIZE);
ant.shareFoodLocation(getLocation());
    }
    
    @Override
    public void act(){
    }
  
    @Override
    public String toString(){
        return super.toString() +", BSize=" + BITE_SIZE+", FEaten="+foodEaten;
    }
}
