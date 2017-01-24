

import info.gridworld.actor.Actor;

import java.awt.Color;

public class QueenAnt extends Actor implements Processable
{
private int foodQuantity;

public QueenAnt(){
    foodQuantity = 0;
    setColor(Color.MAGENTA);
}

public void process(WorkerAnt ant){
    foodQuantity += ant.giveFood();
    ant.shareQueenLocation(getLocation());
   
}
public void act(){
}

public String toString(){
  return super.toString() + ", FQty=" + foodQuantity;
   
  }
}
