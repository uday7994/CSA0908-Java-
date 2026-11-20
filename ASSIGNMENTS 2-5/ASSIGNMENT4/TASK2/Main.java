import java.util.*;
public class Main {
 static Map<String,List<String>> doctors=Map.of("Cardiology",List.of("Dr Rao","Dr Mehta"),"Orthopaedics",List.of("Dr Kumar","Dr Das"));
 static void book(String patient,String dept,String doctor,String slot){
  if(patient.isBlank()||slot.isBlank())throw new IllegalArgumentException("Patient ID and slot are required");
  if(!doctors.getOrDefault(dept,List.of()).contains(doctor))throw new IllegalArgumentException("Select a doctor for the chosen department");
  System.out.println("Appointment confirmed: "+patient+" | "+dept+" | "+doctor+" | "+slot);
 }
 public static void main(String[] args){System.out.println("Department changed -> doctor list refreshed: "+doctors.get("Cardiology"));
  try{book("P1001","Cardiology","Dr Rao","10:30 AM");}catch(Exception e){System.out.println(e.getMessage());}
 }
}
