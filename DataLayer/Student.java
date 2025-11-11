package DataLayer;
public class Student{
  private String id,name,major;
  public Student(String id,String name,String major){
    this.id=id;
    this.name=name;this.major=major;
  }
  public String getId(){return id;} 
  public String getName(){return name;} 
  public String getMajor(){return major;}
  public String toString(){return "ID: "+id+"   |  Name: "+name+"  |  Major: "+major;}
}
