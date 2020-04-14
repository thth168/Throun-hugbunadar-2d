import org.junit.Assert.*;

/*
 * Tests the getUser method in our primitive Users implementation
 * using our currently pre-determined, fixed, non-editable database structure class
 * The method returns a the first name of the first entry from the result set mathcing
 * the search query parameters
 */
class UsersTest {
    Users users;

    @Before
    void setUp() {
        users = new Users(new Database());
    }

    @After
    void tearDown() {
        users = null;
    }

    @Test
    void testName() {
        assertEquals("Snorri", users.getUser("Snorri"));
    }

    @Test
    void testName2() {
        assertEquals("", users.getUser("Snorrri"));
    }

    @Test
    void testName3() {
        assertEquals("Invalid Query", users.getUser("Snorri "));
    }
}
