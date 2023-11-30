package classes.user_depot;

import java.util.LinkedList;

import classes.user.User;

public class DepotController { 

    public LinkedList<DepotModel> depots = new LinkedList<DepotModel>();

    public DepotModel depot; 

    public DepotController() {}    
    
    public DepotController(User user) {
        depot = new DepotModel(user);
    }


    public DepotModel getWareHouse() {
        return depots.getFirst();
    }
    
    public void addToDepot(DepotModel u) {
        depots.add(u);
    }
    
}
