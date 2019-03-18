import java.util.EventObject;


public class DetailEvent extends EventObject {
    
    private String[] userInfo;
    
    public DetailEvent(Object source, String[] userInfo) {
        super(source);
        
        this.userInfo = userInfo;
    }
    
    public String[] getData() 
    {
        return userInfo;
    }
}