import java.util.*;
public class dsu {
  public static void main(String[] args) {
    int n=10;
    ArrayList<Integer>parent=new ArrayList<>();
    for(int i=0;i<n;i++){
      parent.add(i);
    }
    union(1, 2, parent);
    union(3, 4, parent);
    union(2, 3, parent); 
    System.out.println("Find(1): " + find(1, parent)); 
    System.out.println("Find(4): " + find(4, parent));  
    System.out.println("Find(5): " + find(5, parent));
  }
  public static int find(int i,ArrayList<Integer>arr){
    if(i==arr.get(i)){
      return i;
    }
    return find(arr.get(i),arr);
  }
  public static void union(int x,int y,ArrayList<Integer>arr){
    int x_parent=find(x,arr);
    int y_parent=find(y,arr);
    if(x_parent!=y_parent){
      arr.set(y_parent,x_parent);
    }
  }
}
