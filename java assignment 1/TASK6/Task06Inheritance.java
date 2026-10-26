class VehicleBase {protected final String reg; VehicleBase(String r){reg=r;System.out.println("VehicleBase constructor");}}
class CarBase extends VehicleBase {CarBase(String r){super(r);System.out.println("CarBase constructor");}}
class ElectricCarBase extends CarBase {ElectricCarBase(String r){super(r);System.out.println("ElectricCarBase constructor");}}
public class Task06Inheritance {public static void main(String[] a){ElectricCarBase e=new ElectricCarBase("TN03C3");
System.out.println("Created EV registration: "+e.reg);System.out.println("Hierarchy: VehicleBase -> CarBase -> ElectricCarBase");}}