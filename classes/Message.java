package classes;
import java.util.ArrayList;
import java.util.List;

import classes.json.JsonDataClass;


public class Message extends JsonDataClass {
    public String message;
    public String timestamp;
    public int senderId;
    public int orderId;
    
    @Override
    public List<Object> getArrayList() {
        List<Object> itemData = new ArrayList<>();
        itemData.add(id);
        itemData.add(message);
        itemData.add(timestamp);
        itemData.add(senderId);
        itemData.add(orderId);
        return itemData;
    }
    
    public void printData(){
        System.out.print("Message: " + message);
        System.out.print("| timestamp: " + timestamp);
        System.out.print(" | Sender ID: " + senderId);
        System.out.print(" | Order ID: " + orderId);
        System.out.println("\n-------------------------");
    }

    static public void printOutMessages(List<Message> ml){
        for (Message m : ml) {
            System.out.print("Message: " + m.message);
            System.out.print("| timestamp: " + m.timestamp);
            System.out.print(" | Sender ID: " + m.senderId);
            System.out.print(" | Order ID: " + m.orderId);
        }
        System.out.println("\n-------------------------");
    }
    
    public Message(int _id, String _message,String _timestamp, int _senderId,int _orderId) {
        id = _id;
        message = _message;
        timestamp = _timestamp;
        senderId = _senderId;
        orderId = _orderId;
    }

    public Message(ArrayList t) {
        this(
            ((Number) t.get(0)).intValue(),
            (String) t.get(1),
            (String) t.get(2),
            ((Number) t.get(3)).intValue(),
            ((Number) t.get(4)).intValue()
        );
    }
}