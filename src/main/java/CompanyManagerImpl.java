import java.util.*;
import java.lang.Throwable;

public abstract class CompanyManagerImpl implements CompanyManager{//

   private HashMap <String, Company> companyia;
   private List<Employee> empleados;



   //contructor

    public CompanyManagerImpl(){
        this.companyia= new HashMap<String, Company>();
        this.empleados= new LinkedList<Employee>();
    }

   public void addCompany(String nameCompany, String description){

        //añadimos en hashmap
       Company c = new Company(nameCompany, description);
       this.companyia.put(nameCompany, c);

   }
   public List<Employee>findAllEmployeesOrderedByName(){

        List<Employee> empleadosPorNombre = new ArrayList<Employee>();

        empleadosPorNombre.addAll(this.empleados);
        Collections.sort(empleadosPorNombre, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return empleadosPorNombre;
    }

   public void addEmploye(String name, String surname,Date birthday, double salary, String companyName)throws CompanyNotFoundException
   {
       Company company= this.companyia.get(companyName);
       if (companyia==null) {

           throw new CompanyNotFoundException();
       }

       Employee e = new Employee(name, surname, birthday, salary, companyName);
       empleados.add(e);
       this.empleados.add(e);

   }
   public List<Employee> findAllEmployeesOrderedBySalary(){

            List<Employee>ordenarPorSalario = new ArrayList<Employee>();
            ordenarPorSalario.addAll(this.empleados);//

            Collections.sort(ordenarPorSalario, new Comparator<Employee>() {

                public int compare(Employee o1, Employee o2) {
                    return (int)(o1.getSalary()-o2.getSalary());
                }

            });
            return ordenarPorSalario;
    }

    public List<Employee> employees(String company){

        Company asalariados  = this.companyia.get(company);

        return asalariados.getCurrantes();

    }

    //public List<Company> findAllCompanies(){


    //}
}
