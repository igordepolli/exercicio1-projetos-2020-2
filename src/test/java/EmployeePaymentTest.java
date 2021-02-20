import com.pss.exercicio1.model.Employee;
import com.pss.exercicio1.model.Occupation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author igor
 */
public class EmployeePaymentTest {
    
    public EmployeePaymentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void CT001() {
        Occupation oc1 = new Occupation(1, "Gerente Imediato", 500.00);
        Employee emp1 = new Employee(4, "Carlos", oc1);
    }
}
