package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class data {
   public static ObservableList year(){
       ObservableList<Integer> years = FXCollections.<Integer>observableArrayList();
       years.add(1); years.add(2);
       return years;
   }
   public static ObservableList speed(){
       ObservableList<Integer> speed = FXCollections.<Integer>observableArrayList();
       speed.add(2); speed.add(5); speed.add(10); speed.add(20); speed.add(50);speed.add(100);
       return speed;
   }
   public static ObservableList flow(){
       ObservableList<Integer> flow = FXCollections.<Integer>observableArrayList();
       flow.add(1); flow.add(5); flow.add(10); flow.add(100);
       return flow;
   }
}
