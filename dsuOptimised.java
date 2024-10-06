import java.util.*;
public class dsuOptimised {
  public static void main(String[] args) {
    int n=10;
    ArrayList<Integer>parent=new ArrayList<>();
    ArrayList<Integer>rank=new ArrayList<>();

    for(int i=0;i<n;i++){
      parent.add(i);
      rank.add(1);
    }
    union(1, 2, parent, rank);
    union(3, 4, parent, rank);
    union(2, 3, parent, rank);
    System.out.println("Find(1): " + find(1, parent)); 
    System.out.println("Find(4): " + find(4, parent));  
    System.out.println("Find(5): " + find(5, parent));
  }

  public static int find(int i,ArrayList<Integer>arr){
    if(i==arr.get(i)){
      return i;
    }
   arr.set(i, find(arr.get(i),arr));
   return arr.get(i);
  }

  public static void union(int x,int y,ArrayList<Integer>arr,ArrayList<Integer> rank){
    int x_parent=find(x,arr);
    int y_parent=find(y,arr);
    if(x_parent==y_parent){
      return;
    }
    if (rank.get(x_parent) > rank.get(y_parent)) {
      arr.set(y_parent, x_parent);
    }
    else if (rank.get(x_parent) < rank.get(y_parent)) {
      arr.set(x_parent, y_parent);
    }
  else {
    arr.set(x_parent, y_parent);  
    rank.set(y_parent, rank.get(y_parent) + 1); 
}
  }
}
