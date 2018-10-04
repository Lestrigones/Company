import java.util.Date;
import java.util.LinkedList;
import java.util.List;




public class Company {
    private String nameCompany;
    private String description;
    private List<Employee> currantes;


    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getCurrantes() {
        return currantes;
    }

    public void setCurrantes(List<Employee> currantes) {
        this.currantes = currantes;
    }

    // constructor
    public Company(String nameCompany, String description){
        this.nameCompany = nameCompany;
        this.description = description;
        this.currantes = new LinkedList<Employee>(); {
            // me da fallo si pongo list solo
        }


    }
    public void addCurrantes(Employee e){
        this.currantes.add(e);
    }
}
