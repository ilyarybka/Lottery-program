/*Iliya Klishin
 *Dr. Steinberg
 *COP 3503 Summer 2022
 *Programming Assignment1
 */
 
 import java.util.*;
 
 
 public class Lottery{
 
   private String ticket;
   
   public Lottery() // Default Constructor
   {
   
     this.ticket = "";
   
   }
   
   public Lottery(Random obj) // Overloaded constructor which assigns a random ticket
   {
     int ticketnumber = obj.nextInt(1000000);
     this.ticket = Integer.toString(ticketnumber);
   
   }
   
     public static String GenerateRandomWinner(Random obj) // This method generates a random ticket which will be a winner
     {
       int randticketwinner = obj.nextInt(1000000);
       String ticketWinner = Integer.toString(randticketwinner);
     
       return ticketWinner;
     }
     
     public static int GenerateSelectWinner(int maxIndex, Random obj) // This method generates a random index up to maxIndex which will be a winner
     {
       int Winnerindex = obj.nextInt(maxIndex);
       
       return Winnerindex;
     
     }
     
     public static void merge(Lottery []a, int left, int mid, int right) // Merge method for merge sort
     {
     
       int i,j,k;
       
       int l = mid - left + 1;
       int r = right - mid;
       
       String L[] = new String[l];
       String R[] = new String[r];
       
       for(i = 0; i < l; i++)
       {
         L[i] = a[left + i].ticket;
       }
       
       for(j = 0; j < r; j++)
       {
         R[j] = a[mid + 1 + j].ticket;
       }
       
       i = 0;
       j = 0; 
       k = left;

       while(i < l && j < r)
       {
       
         if(L[i].compareTo(R[j]) <= 0)
         {
           a[k].ticket = L[i];
           i++;
         }
         
         else
         {
           a[k].ticket = R[j];
           j++;
         }
         
         k++;
       }
       
       while(i < l)
       {
         a[k].ticket = L[i];
         i++;
         k++;
       }
       
       while(j < r)
       {
         a[k].ticket = R[j];
         j++;
         k++;
       }
     
     }
     
     public static void mergeSort(Lottery a[], int l, int r) // MergeSort method which performs merge sort
     {
     
       if(l < r)
       {
         int mid = (l + r)/2;
         
         mergeSort(a, l, mid);
         mergeSort(a, mid + 1, r);
         
         merge(a, l, mid, r);
       }
     
     }
     
     public static void Sort(Lottery a[]) // Method which calls mergeSort
     {
       mergeSort(a, 0, a.length - 1);
     }
     
     public String GetTicket() // Getter method to access ticket attribute
     {
     
       return this.ticket;
     
     }
     
     public static boolean Solution1(Lottery []a, String Ticket, int index) // This method performs a linear search which finds a winner ticket
     {
       for(int i = 0; i < (index + 1); i++)
       {
       
         if(a[i].ticket == Ticket)
         {
           return true;
         }
       
       }
       
       return false;
     }
     
     public static boolean Solution2(Lottery a[], int left, int right, String Ticket) // This method performs a binary search to find a winner ticket
     {
       if(left <= right) //&& left <= (a.length - 1)
       {
         int mid = left + (right - left) / 2;
         
         if(a[mid].ticket == Ticket)
         {
           return true;
         }
           
         if(Ticket.compareTo(a[mid].ticket) < 0)
         {
           return Solution2(a, left, mid - 1, Ticket);
         }
         
           return Solution2(a, mid + 1, right, Ticket);
         
       }
       
       return false;
     }

 }