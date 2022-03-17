import java.util.ArrayList;

import junit.framework.TestCase;

public class CloturerCompteTest extends TestCase {
	
	// Junit 3 obligation de constructeur
    public CloturerCompteTest(String testMethodName) {
        super(testMethodName);
    }
    // Convention nom methode test suivi du nom voulu
    public void testCloturerCompte() throws Exception {
		System.out.println("Test de la méthode CloturerCompte (Cas normal)");
		Client.ouvrirCompte("Individuel");
		int id = Client.mesComptes.get(Client.mesComptes.size()-1).getId();
		int size = Client.mesComptes.size();
		Client.cloturerCompte(id);
        assertEquals(size-1, Client.mesComptes.size());		
        System.out.printf("Attendu  : %d => Resultat : %d \n", size-1, Client.mesComptes.size());
        Client.mesComptes = new ArrayList<>();
    }
    
    // Convention nom methode test suivi du nom voulu
    public void testCloturerCompte2() throws Exception {
		System.out.println("Test de la méthode CloturerCompte (Cas anormal)");
		System.out.println("Id du compte inconnue donc aucun compte ne peut être cloturer");
		Client.ouvrirCompte("Individuel");
		int id = 999;
		int size = Client.mesComptes.size();
		Client.cloturerCompte(id);
        assertEquals(size, Client.mesComptes.size());		
        System.out.printf("Attendu  : %d => Resultat : %d \n", size, Client.mesComptes.size());
        Client.mesComptes = new ArrayList<>();
    }
}
