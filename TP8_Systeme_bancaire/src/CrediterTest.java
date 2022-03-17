import junit.framework.TestCase;

public class CrediterTest extends TestCase {

    // Junit 3 obligation de constructeur
    public CrediterTest(String testMethodName) {
        super(testMethodName);
    }
    // Convention nom methode test suivi du nom voulu
    public void testCrediter() throws Exception {
		System.out.println("Test de la méthode Crediter (Cas normal)");
    	Compte compteTest = new Compte();    	
    	float credit = 50;
        compteTest.crediter(credit);
        float result = compteTest.getSolde();
		System.out.printf("Attendu  : %f => Resultat : %f \n", credit, result);
        assertEquals(credit, result);
    	compteTest = null;
    }
	
}


