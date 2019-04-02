package s4testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import s4clase.EFacultate;
import s4clase.Student;
import s4exceptii.ExceptieAddSuma;

public class TestAddSuma {
	Student s;

	@Before
	public void setUp() throws Exception {
		s = new Student("Popovici", 20, EFacultate.CSIE);
	}

	@Test
	public void testRight() throws ExceptieAddSuma {
		s.addToSuma(20);
		assertEquals("Testare adaugare in cont", 20, s.getSumaDisponibila(), 0.01);
	}
	
	@Test
	public void testBoundary1() throws ExceptieAddSuma {
		s.addToSuma(0.001f);
		assertEquals("Verificare suma minima", 0.001f, s.getSumaDisponibila(), 0.01);
	}
	
	@Test
	public void testBoundary2() throws ExceptieAddSuma {
		s.addToSuma(Float.MAX_VALUE);
		assertEquals("Verificare suma maxima", Float.MAX_VALUE, s.getSumaDisponibila(), 0.01);
	}
	
	@Test(expected = ExceptieAddSuma.class)
	public void testBoundaryError() throws ExceptieAddSuma {
		s.addToSuma(0);
	}
	
	@Test(expected = ExceptieAddSuma.class)
	public void testError1() throws ExceptieAddSuma {
		s.addToSuma(-1);
	}

	@Test
	public void testInverse() throws ExceptieAddSuma {
		s.addToSuma(20);
		s.removeTosuma(20);
		assertEquals("Verificare testare inverse", 0, s.getSumaDisponibila(), 0.01);
	}
	
	@Test
	public void testInverse1() throws ExceptieAddSuma {
		s.addToSuma(50);
		assertNotEquals("Verificare ca nu mai este 0", 0, s.getSumaDisponibila(), 0.01);
	}

}
