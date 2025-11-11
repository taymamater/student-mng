package DataLayer;
import java.util.Vector;
public class Repository{

  private Vector<Student> v=new Vector<>();
  public void addStudent(Student s){
    v.add(s);
  }

  public Student searchById(String id){
     for(Student s:v) 
        if(s.getId().equals(id)) 
          return s; 
        return null;
    }
  public Vector<Student> searchByName(String q){
     Vector<Student> r=new Vector<>();
     if(q==null) return r; q=q.toLowerCase(); 
     for(Student s:v) if(s.getName().toLowerCase().contains(q)) r.add(s); return r;
    }
  public Vector<Student> getAll(){
    return v;
  }
  
}
