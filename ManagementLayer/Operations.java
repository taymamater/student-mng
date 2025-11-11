package ManagementLayer;
import DataLayer.*;
import java.util.Vector;
public class Operations{

  Repository repo=new Repository();
  public boolean addStudent(String id,String name,String major){
    if(id==null||!id.matches("\\d+")) return false;
    if(repo.searchById(id)!=null) return false;
    repo.addStudent(new Student(id,name,major)); return true;
  }
  public Student viewStudent(String id){
    return repo.searchById(id);
  }
  public Vector<Student> searchByName(String q){
    return repo.searchByName(q);
  }
  public Vector<Student> getAll(){
    return repo.getAll();
  }
}

