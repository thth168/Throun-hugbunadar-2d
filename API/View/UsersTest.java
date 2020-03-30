import static org.junit.Assert.*;

/*
 * Tests the getUser method in our primitive Users implementation
 * using our currently pre-determined, fixed, non-editable database structure class
 * The method returns a the first name of the first entry from the result set mathcing
 * the search query parameters
 */
public class UsersTest {
    private Users users;

    @Before
    public void setUp() {
        users = new Users(new Database());
    }

    @After
    public void tearDown() {
        users = null;
    }

    @Test
    public void testName() {
        assertEquals("Snorri", users.getUser("Snorri"));
    }

    @Test
    public void testName2() {
        assertEquals("", users.getUser("Snorrri"));
    }

    @Test
    public void testName3() {
        assertEquals("Invalid Query", users.getUser("Snorri "));
    }
}
