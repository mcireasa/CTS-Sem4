package s4testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import s4clase.EFacultate;
import s4clase.Student;

public class TestConstructor {

	// Clasificare Right-BICEP
	// Right -> testare in conditii "normale" ca metoda functioneaza

	// B Boundery -> Testare in conditii "limita"" si pt input, dar si pt output
	// I Inverse relationship - Testare de la rezultat spre starting point
	// C Cross Check
	// E Errors/Condition- Testare in conditii generatoare de exceptii
	// P Performance

	@Before
	public void setUp() throws Exception {
	}

	// La nivel de metoda tb sa specificam ce testam si cum (in nume)
	// Aceasta este forma finala agregata

	@Test
	public void testRight() {
		Student s = new Student("Andrei", 20, EFacultate.CSIE);
		assertEquals("Seter nume", "Andrei", s.getNume());
		assertEquals("Seter varsta", 20, s.getVarsta());
		assertEquals("Seter facultate", EFacultate.CSIE, s.getFacultate());
		assertEquals("Seter suma", 0, s.getSumaDisponibila(), 0.01);
		assertEquals("Seter array", 0, s.getListaMaterii().size());
		// O metoda crapa ori de cate ori se arunca o exceptie
		// nullpointerexception cand apelam .size() pt ca in constructor nu
		// initializasem cu = new Arraylist<>()
	}

}
