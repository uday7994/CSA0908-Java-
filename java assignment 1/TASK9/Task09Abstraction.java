interface PassHolder {boolean hasValidPass();}
abstract class CampusUser implements PassHolder {private final String name;private final boolean valid;
CampusUser(String n,boolean v){name=n;valid=v;}public String getName(){return name;}public boolean hasValidPass(){return valid;}abstract String userType();}
class StudentUser extends CampusUser {StudentUser(String n,boolean v){super(n,v);}String userType(){return "Student";}}
public class Task09Abstraction {public static void main(String[] a){CampusUser u=new StudentUser("Asha",true);
System.out.println(u.userType()+": "+u.getName());System.out.println("Valid monthly pass: "+u.hasValidPass());}}