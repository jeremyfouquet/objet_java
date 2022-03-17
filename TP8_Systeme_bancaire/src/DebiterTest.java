import junit.framework.TestCase;

public class DebiterTest extends TestCase {
	 // Junit 3 obligation de constructeur
    public DebiterTest(String testMethodName) {
        super(testMethodName);

    }
    // Convention nom methode test suivi du nom voulu
    public void testDebiter() throws Exception {
		System.out.println("Test de la méthode Debiter (Cas normal)");
    	Compte compteTest = new Compte();
    	float credit = 50;
    	float debit = 10;
		compteTest.crediter(credit);
		compteTest.debiter(debit);
		credit -= debit;
        float result = compteTest.getSolde();
        assertEquals(credit, result);
		System.out.printf("Attendu  : %f => Resultat : %f \n", credit, result);
		compteTest.debiter((debit*3));
		credit -= (debit*3);
        result = compteTest.getSolde();
        assertEquals(credit, result); 
		System.out.printf("Attendu  : %f => Resultat : %f \n", credit, result);
        compteTest = null;
    }
}
