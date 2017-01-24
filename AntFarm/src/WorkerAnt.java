
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>WorkerAnt</code> is a critter who's mission is
 * to take food from <code>Cake and Cookie</code> objects and to
 * deliver it to a <code>QueenAnt</code> object.
 * Initially it looks for food.  After it finds food, it looks for
 * a queen.
 * Worker ants share the location of food and the queen
 * with other ants they encounter.
 * Worker ants with food are red.  If they don't have food,
 * they are black.
 */
public class WorkerAnt extends Critter implements Processable
{
    private int isCarrying;
    private Location foodLoc;
    private Location queenLoc;
        
    public WorkerAnt(){
        setColor(Color.BLACK);
        int r = ((int)(Math.random() * 8)) * 45;
        setDirection(r);
        foodLoc = null;
        queenLoc = null;
        isCarrying = 0;

    }
 
    public void process(WorkerAnt ant){
       if(foodLoc != null){
          ant.shareFoodLocation(foodLoc);
       }
       if(queenLoc != null){
           ant.shareQueenLocation(queenLoc);
       }
    }
 
    public void takeFood(int fQty){
       isCarrying = fQty;
    }

    public int giveFood(){    
        int tempFood = isCarrying;
        isCarrying = 0;
        return tempFood;
    }
 
    public void shareFoodLocation(Location fLoc){
    	if (foodLoc == null){
    		foodLoc = fLoc;
    	}
    }
    public void shareQueenLocation(Location qLoc){
    	if (queenLoc == null){
    		queenLoc = qLoc;
    	}
    }
 
   
    @Override
    public void processActors(ArrayList<Actor> actors){
        for (Actor a: actors){
                ((Processable)a).process(this);
        }
    }
 
   
    @Override
    public ArrayList<Location> getMoveLocations(){
            int dir = getDesiredDirecton();
            ArrayList<Location> validLoc = new ArrayList<Location>();
            for (int i = dir + Location.HALF_LEFT; i <= dir + Location.HALF_RIGHT; i+= 45){
                    Location adloc = this.getLocation().getAdjacentLocation(i);
                        if(getGrid().isValid(adloc) && getGrid().get(adloc) == null){
                                validLoc.add(adloc);
                        }
            }
            return validLoc;
    }
 
    @Override
    public void makeMove(Location loc){
        Location selectedLocation = selectMoveLocation(getMoveLocations());
        if (!selectedLocation.equals(getMoveLocations()) && selectedLocation != null){      
                setDirection(getLocation().getDirectionToward(selectedLocation));
                moveTo(selectedLocation);
        }
        else{
        
                double rand = Math.random();
                if (rand <= .5){
                    setDirection(getDirection() + Location.HALF_LEFT);
                }
                else{
                    setDirection(getDirection() + Location.HALF_RIGHT);
                }
        }
        if (isCarrying > 0){
            setColor(Color.RED);
        }
        else{
            setColor(Color.BLACK);      
        }
    }
 
    private int getDesiredDirecton(){
        if(queenLoc != null && isCarrying!= 0){
           return getLocation().getDirectionToward(queenLoc);
        }
        else if(foodLoc != null && isCarrying == 0){
           return getLocation().getDirectionToward(foodLoc);
        }
        else{
           return getDirection();
        }
        }
 
    @Override
        public String toString(){
                return super.toString() + "FQty" + isCarrying + "FLoc" + foodLoc + "QLoc" + queenLoc;
        }
}
