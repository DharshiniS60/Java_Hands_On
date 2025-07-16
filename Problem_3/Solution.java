import java.util.Scanner;
import java.util.Arrays;
public class Solution
{

 public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    DepartmentalStore[] stores =new DepartmentalStore[4];
    for(int i=0;i<4;i++){
        String storeId=sc.nextLine();
        String storeName=sc.nextLine();
        String location=sc.nextLine();
        int noofWorkers=sc.nextInt();
        int rating=sc.nextInt();
        sc.nextLine();
        stores[i]=new DepartmentalStore(storeId,storeName,location,noofWorkers,rating);
    }
    
    String startsWithInput=sc.nextLine();
    String locationInput=sc.nextLine();
    int average=findAverageWorkersInSpecificLocation(stores,startsWithInput);
    if(average >0){
        System.out.println(average);
    }else{
        System.out.println("No stores are available with the given input");
    }
    DepartmentalStore[] filteredStores=findStoreDetailsForGivenLocation(stores,locationInput);
    if(filteredStores !=null){
        for(int i=0;i<filteredStores.length;i++){
            System.out.println(filteredStores[i].getStoreName());
        }
    }else{
        System.out.println("No stores present in the given location");
    }
    sc.close();
    
}
public static int findAverageWorkersInSpecificLocation(DepartmentalStore[] stores,String prefix){
    int sum=0;int count=0;
    for(DepartmentalStore store:stores){
        if(store.getStoreId().startsWith(prefix)){
            sum+=store.getNoofWorkers();
            count++;
        }
    }
    return (count>0)? (sum/count):0;
}

public static DepartmentalStore[] findStoreDetailsForGivenLocation(DepartmentalStore[] stores,String location){
    DepartmentalStore[] temp=new DepartmentalStore[stores.length];
    int idx=0;
    for(int i=0;i<stores.length;i++){
        if(stores[i].getLocation().equals(location)){
            temp[idx++]=stores[i];
        }
    }
    if(idx==0){
        return null;
    }
    for(int i=0;i<idx-1;i++){
        for(int j=0;j<idx-1-i;j++){
            if(temp[j].getRating()>temp[j+1].getRating()){
                DepartmentalStore tmp=temp[j];
                temp[j]=temp[j+1];
                temp[j+1]=tmp;
            }
        }
    }
    DepartmentalStore[] result=new DepartmentalStore[idx];
    for(int i=0;i<idx;i++){
        result[i]=temp[i];
    }
    return result;
} 

  
}
class DepartmentalStore{
    private String storeId;
    private String storeName;
    private String location;
    private int noofWorkers;
    private int rating;
    
    public DepartmentalStore(String storeId,String storeName,String location,int noofWorkers,int rating){
        this.storeId=storeId;
        this.storeName=storeName;
        this.location=location;
        this.noofWorkers=noofWorkers;
        this.rating=rating;
    }
    public String getStoreId(){
        return storeId;
        
    }
    public String getStoreName(){
        return storeName;
        
    }
    public String getLocation(){
        return location;
        
    }
    public int getNoofWorkers(){
        return noofWorkers;
        
    }
    public int getRating(){
        return rating;
        
    }
    
    public void setStoreId(String storeId){
        this.storeId=storeId;
    }
    public void setStoreName(String storeName){
        this.storeName=storeName;
    }
    public void setLocation(String Location){
        this.location=location;
    }
    public void setNoofWorkers(int noofWorkers){
        this.noofWorkers=noofWorkers;
    }
    public void setRating(int rating){
        this.rating=rating;
    }
    
}
