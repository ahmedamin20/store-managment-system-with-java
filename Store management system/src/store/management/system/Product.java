
package store.management.system;


public class Product {

    private String pro_name;
    private double price;
    static int ID_start = 0;
    private int ID ;
   
    private String Kind;

    public Product(){
        
        this.pro_name=null;
        this.price=0.0;
        this.Kind=null;
    setID();
    }
    
    
    public Product(String name, double price, String kind) {
        this.pro_name = name;
        this.price = price;
        this.Kind = kind;
      setID();
    }

  

    public void setName(String name) {
        this.pro_name = name;
    }

    public String getName() {
        return this.pro_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }


    public void setKind(String Kind) {

        this.Kind =Kind;
    }

    public String getKind() {

        return this.Kind;
    }

    public void setID() {

      this.ID=ID_start++;
    }

    public int getID() {
        return this.ID;
    }

    

    @Override
     public String toString(){
        return    "Product"+"("+getID()+")"+getName()+" costs "+getPrice()+" RS.";
     }
}
