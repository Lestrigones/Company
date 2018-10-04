import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CompanyManagerTest {


    private CompanyManager cm;

    @Before
    public void setUp() {
        this.cm= new CompanyManagerImpl() {
            public void addEmployee(String name, String surname, Date birthday, double salary, String companyName) throws CompanyNotFoundException {

            }

            public List<Company> findAllCompanies() {
                return null;
            }
        };

        this.cm.addCompany("REPSOL", "una descripcion");
        this.cm.addCompany("SEAT", "una descripcion");
        this.cm.addCompany("AMAZON", "una descripcion");

        try {
            this.cm.addEmployee("Toni", " ", null, 1000000, "SEAT");
            this.cm.addEmployee("Marc", " ", null, 100, "REPSOL");
            this.cm.addEmployee("Oscar", " ", null, 500000000, "AMAZON");
            this.cm.addEmployee("Hector", " ", null, 1000, "SEAT");
        }
        catch (CompanyNotFoundException cex) {
            // log
        }

    }

    @After
    public void tearDown() {
        this.cm=null;
    }

    @Test
    public void testAddEmployee() {

        List<Employee> employeeList = this.cm.employees("SEAT");


        Assert.assertEquals("Toni", employeeList.get(0).getName());
        Assert.assertEquals("Hector", employeeList.get(1).getName());
        Assert.assertEquals(2, employeeList.size());

        try {
            this.cm.addEmployee("Laia", " ", null, 1000000, "SEAT");
            employeeList = this.cm.employees("SEAT");
            Assert.assertNotEquals(employeeList.size(), 2);
            Assert.assertEquals(employeeList.size(), 3);
            Assert.assertEquals(employeeList.get(2).getName(), "Laia");


        }
        catch (CompanyNotFoundException cex) {
            // log
        }


    }

    @Test
    public void testOrdenSalario() {


        List<Employee> employeesOrd = this.cm.findAllEmployeesOrderedBySalary();



        try {
            this.cm.addEmployee("Laia", " ", null, 1000000, "SEAT");
        }
        catch (CompanyNotFoundException cex) {
            // log
        }

        employeesOrd = this.cm.findAllEmployeesOrderedBySalary();

    }


}
