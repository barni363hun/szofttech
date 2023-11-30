package classes.user_courier;

import java.util.LinkedList;

import classes.user.User;

public class CourierController {
    
    public CourierModel courier; 

    public LinkedList<CourierModel> couriers = new LinkedList<CourierModel>();

    public CourierController() {
        
    }
    public CourierController(User user) {
         courier = new CourierModel(user);
    }
    
    public void addToCourier(CourierModel u) {
        couriers.add(u);
    }
}
