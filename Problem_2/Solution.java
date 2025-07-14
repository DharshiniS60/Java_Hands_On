import java.util.Scanner;
public class Solution
{

 public static void main(String[] args){
 
    Scanner sc=new Scanner(System.in);
    Theatre[] theaters=new Theatre[4];
    
    for(int i=0;i<4;i++){
        int id=sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();
        int capacity=sc.nextInt();
        double rate=sc.nextDouble();
        int rating=sc.nextInt();
        sc.nextLine();
        theaters[i]=new Theatre(id,name,capacity,rate,rating);
    }
    int searchId=sc.nextInt();
    sc.close();
    
    String category=findTheatreCategory(theaters,searchId);
    
    if(category != null){
        System.out.println(category);
    }else{
        System.out.println("There is no Theatre with the given theatreId");
    }
    
    
    Theatre secondHighest=findSecondHighestTicket(theaters);
    if(secondHighest != null){
        System.out.println(secondHighest.getTheatreName());
    }
    else{
        System.out.println("No valid theatres are available");
        
    }
    
}

    public static String findTheatreCategory (Theatre[] theaters,int id){
        for(Theatre t:theaters){
            if(t.getTheatreId() == id){
                if(t.getSeatCapacity()>1000 && t.getTHeatreRating() >=4){
                    return "Premium";
                }else{
                    return "Non Premium";
                }
            }
        }
        return null;
    }
    
    
    public static Theatre findSecondHighestTicket(Theatre[] theaters){
      Theatre[] valid=new Theatre[theaters.length];
      int count =0;
      for(int i=0;i< theaters.length;i++){
        if(theaters[i].getTHeatreRating()>=2){
            valid[count]=theaters[i];
            count++;
        }
      }
      if(count<2){
        return null;
      }
      Theatre highest=valid[0];
      Theatre secondHighest=null;
      for(int i=1;i<count;i++){
        Theatre current=valid[i];
      if(current.getTicketRate() > highest.getTicketRate()){
        secondHighest=highest;
        highest=current;
      }else if(secondHighest == null || current.getTicketRate() > secondHighest.getTicketRate()){
        secondHighest=current;
      }
      }
      return secondHighest;
    }

static class Theatre{
    private int theatreid;
    private String theatreName;
    private int seatCapacity;
    private double ticketRate;
    private int theatreRating;
    
    public Theatre(int theatreid,String theatreName,int seatCapacity,double ticketRate,int theatreRating){
        this.theatreid=theatreid;
        this.theatreName=theatreName;
        this.seatCapacity=seatCapacity;
        this.ticketRate=ticketRate;
        this.theatreRating=theatreRating;
    }
    public int getTheatreId(){
        return theatreid;
        
    }
    public String getTheatreName(){
        return theatreName;
    }
    public int getSeatCapacity(){
        return seatCapacity;
    }
    public double getTicketRate(){
        return ticketRate;
    }
    public int getTHeatreRating(){
        return theatreRating;
    }
}
}
