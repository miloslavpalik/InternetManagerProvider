package javafxappnetpack2;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NetPack {
    private final StringProperty firstName = new SimpleStringProperty(this,"firstName","");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final IntegerProperty year = new SimpleIntegerProperty(this, "year",0);
    private final IntegerProperty speed = new SimpleIntegerProperty(this, "speed", 0);
    private final IntegerProperty flow = new SimpleIntegerProperty(this, "flow", 0);
    public NetPack(){
        
    }
    public NetPack(String firstName){
        this.firstName.set(firstName);
       
    }
    public NetPack(String firstName,String lastName){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
  
    }
    public NetPack(String firstName,String lastName,Integer year){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.year.set(year);
    }
    public NetPack(String firstName,String lastName,Integer year,Integer speed,Integer flow){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.year.set(year);
        this.speed.set(speed);
        this.flow.set(flow);
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }
    public String getFirstName(){
        return firstName.get();
    }
    public StringProperty firstNameProperty()
    {
        return firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }
    public String getLastName(){
        return lastName.get();
    }
    public StringProperty lastNameProperty()
    {
        return lastName;
    }
    
    public void setYear(Integer year)
    {
        this.year.set(year);
    }
    public Integer getYear(){
        return year.get();
    }
    public IntegerProperty yearProperty()
    {
        return year;
    }
    
    public void setSpeed(int speed)
    {
        this.speed.set(speed);
    }
    public Integer getSpeed(){
        return speed.get();
    }
    public IntegerProperty speedProperty()
    {
        return speed;
    }
    
     public void setFlow(int flow){
        this.flow.set(flow);
    }
    public Integer getFlow()
    {
        return flow.get();
    }
    public IntegerProperty flowProperty()
    {
        return flow;
    }
    
    
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty()
    {
	return errorList;
    }

    
    public boolean isValid()
    {
	boolean isValid = true;
	if(firstName.get() != null && firstName.get().equals(""))
	{
	    errorList.getValue().add("First name can't be empty!");
	    isValid = false;
	}
	if(lastName.get().equals(""))
	{
	    errorList.getValue().add("Last name can't be empty!");
	    isValid = false;
	}
        if(year.get()==0)
        {
            errorList.getValue().add("Year not selected");
            isValid = false;
        }
        if(speed.get()==0)
        {
            errorList.getValue().add("Speed not selected");
            isValid = false;
        }
        if(flow.get()==0)
        {
            errorList.getValue().add("Flow not selected");
            isValid = false;
        }
	return isValid;
    }
}
