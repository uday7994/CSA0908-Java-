import java.util.*;
abstract class ChallengeVehicle {final String reg;ChallengeVehicle(String r){reg=r;}abstract double fee(int hours,int hourOfDay);}
class ChallengeCar extends ChallengeVehicle {ChallengeCar(String r){super(r);}double fee(int h,int t){return h*30.0;}}
class EBike extends ChallengeVehicle {EBike(String r){super(r);}double fee(int h,int t){return 25.0;}}
class DeliveryVan extends ChallengeVehicle {DeliveryVan(String r){super(r);}double fee(int h,int t){return h*((t>=9&&t<17)?60.0:30.0);}}
class DayPass {private final String visitor;DayPass(String v){visitor=v;}boolean isValid(){return visitor!=null&&!visitor.isBlank();}}
public class Task12DesignChallenge {public static void main(String[] a){ChallengeVehicle[] vs={new ChallengeCar("TN01CAR"),new EBike("TN02EBK"),new DeliveryVan("TN03VAN")};
for(ChallengeVehicle v:vs)System.out.println(v.getClass().getSimpleName()+" "+v.reg+" -> Rs "+v.fee(2,10));
System.out.println("Visitor one-day pass valid: "+new DayPass("Visitor One").isValid());
int[] caps={20,25,30,35,40};System.out.println("Jagged floor capacities: "+Arrays.toString(caps));}}