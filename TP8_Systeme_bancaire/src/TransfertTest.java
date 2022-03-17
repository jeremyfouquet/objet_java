import junit.framework.TestCase;

public class TransfertTest extends TestCase {

    // Junit 3 obligation de constructeur
    public TransfertTest(String testMethodName) {
        super(testMethodName);
    }
    // Convention nom methode test suivi du nom voulu
    public void testTransfert() throws Exception {
		System.out.println("Test de la méthode Transfert (Cas normal)");
    	Compte compteTest = new Compte();
		Compte compteTest2 = new Compte();
    	float credit = 50;
        compteTest.crediter(credit);
		compteTest.transfert(credit, compteTest2);
        float result = compteTest.getSolde();
        assertEquals((credit-credit), result);
        result = compteTest2.getSolde();
        assertEquals(credit, result);
    	compteTest = null;
    	compteTest2 = null;
    }
}