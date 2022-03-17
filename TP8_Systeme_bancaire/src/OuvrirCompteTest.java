import java.util.ArrayList;

import junit.framework.TestCase;

public class OuvrirCompteTest extends TestCase {
	
	// Junit 3 obligation de constructeur
    public OuvrirCompteTest(String testMethodName) {
        super(testMethodName);
    }
    // Convention nom methode test suivi du nom voulu
    public void testOuvrirCompte() throws Exception {
		System.out.println("Test de la méthode OuvrirCompte (Cas normal)");
		int size = Client.mesComptes.size();
		Client.ouvrirCompte("Individuel");
        assertEquals(size+1, Client.mesComptes.size()); 
		System.out.printf("Attendu  : %d => Resultat : %d \n", size+1, Client.mesComptes.size());
        Client.mesComptes = new ArrayList<>();
    }
    
    // Convention nom methode test suivi du nom voulu
    public void testOuvrirCompte2() throws Exception {
		System.out.println("Test de la méthode OuvrirCompte (Cas anormal)");
		System.out.println("Type de compte inconnue donc aucun compte n'est ouvert");
		int size = Client.mesComptes.size();
		Client.ouvrirCompte("Inconnue");
        assertEquals(size, Client.mesComptes.size()); 
		System.out.printf("Attendu  : %d => Resultat : %d \n", size, Client.mesComptes.size());
        Client.mesComptes = new ArrayList<>();
    }
}
