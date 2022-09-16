
package store.management.system;


public class Users {
    protected String name;
    protected static int ID_start = 1000;
     protected  int ID;

    public Users() {
        this.name = null;


    }

    public Users(String name) {
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
      public void setID() {
         ID=ID_start++;
    }
     public int getID() {
        return this.ID;
        
    }
      
    
}
