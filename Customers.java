public class Customers{
    private static int lastCustomerId = 0;

    private int customer_id;
    private String name;
    private String address;
    private String contact_number;

    public Customers(int customer_id, String name , String address, String contact_number ){
        this.customer_id= getNextCustomerId();
        this.name= name;
        this.address= address;
        this.contact_number=contact_number;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact_number() {
        return contact_number;
    }

    private synchronized static int getNextCustomerId() {
        return ++lastCustomerId;
    }
    public String toString(){
        return customer_id+" name: "+name+" address:"+address;
    }

}