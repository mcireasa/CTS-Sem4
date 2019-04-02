package s4testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import s4clase.EFacultate;
import s4clase.Student;
import s4exceptii.ExceptieSetVarsta;

public class TestSetVarsta {

	private static final String ExceptieSetVarsta = null;
	Student s;

	@Before
	public void setUp() throws Exception {
		s = new Student("Costel", 21, EFacultate.CSIE);
	}

	// Testele trebuie facute astfel incat creaind acel context sa scoata la iveala
	// posibile erori

	@Test
	public void testRight1() {
		try {
			// Testam setterul pe varsta
			s.setVarsta(24);
			assertEquals("Verificare seter vartsa", 24, s.getVarsta());
		} catch (ExceptieSetVarsta e) {
			fail("Arunca exceptie pentru varsta normala");// !!! asta e ca sa vedem noi de ce a picat testul
		}
	}

	@Test
	public void testRight2() throws ExceptieSetVarsta {
		s.setVarsta(24);
		assertEquals("Verificare seter varsta", 24, s.getVarsta());
	}

	// Varsta minima testare Boundery
	@Test
	public void testBoundery1() throws ExceptieSetVarsta {
		s.setVarsta(18);
		assertEquals("Verificare minim varsta", 18, s.getVarsta());
	}

	// Vasta maxima testare Boundery
	@Test
	public void testBoundery2() throws ExceptieSetVarsta {
		s.setVarsta(59);
		assertEquals("Verificare maxim varsta", 59, s.getVarsta());
	}

	// Cum sa gandim - daca tot ce am implement in testare e necesar si suficient
	// pentru a vedea daca metoda este buna
	// pt exceptii alegeti de ex 10 si 70
	// declar ca eu ma astept ca metoda sa treaca testarea daca arunca exceptia...e
	// un fel de assert
	
	@Test(expected = ExceptieSetVarsta.class)
	public void testBounderyErrors1() throws ExceptieSetVarsta {
		s.setVarsta(17);
	}

	@Test
	public void testBounderyErrors2() {
		try {
			s.setVarsta(60);
			fail("Marcheaza ca a picat testul-nu arunca exceptie pt varsta 65");
		} catch (ExceptieSetVarsta e) {
			assertTrue(true);
		}

	}

	@Test(expected = ExceptieSetVarsta.class)
	public void testErrors() throws s4exceptii.ExceptieSetVarsta {
		s.setVarsta(10);
	}

	@Test
	public void testInverse() throws ExceptieSetVarsta {
		s.setVarsta(24);
		assertNotEquals("verific canu ce era CANDVA", 20, s.getVarsta());// e metoda cea mai neleganta pt examen
	}

}
