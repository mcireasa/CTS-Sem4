package s4clase;

import java.util.ArrayList;

import s4exceptii.ExceptieAddSuma;
import s4exceptii.ExceptieSetVarsta;

public class Student {
	String nume;
	int varsta;
	EFacultate facultate;
	ArrayList<String> listaMaterii;
	float sumaDisponibila;

	public void addToSuma(float s) throws ExceptieAddSuma {
		if (s <= 0) {
			throw new ExceptieAddSuma();
		}
		this.sumaDisponibila += s;
	}

	public void removeTosuma(float s) throws ExceptieAddSuma {
		this.sumaDisponibila -= s;
	}
	
	public Student(String nume, int varsta, EFacultate facultate) {
		super();
		this.nume = nume;
		this.varsta = varsta;
		this.facultate = facultate;
		this.listaMaterii = new ArrayList<>();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) throws ExceptieSetVarsta {
		if (varsta < 18 || varsta >= 60) {
			throw new ExceptieSetVarsta();
		}
		this.varsta = varsta;
	}

	public EFacultate getFacultate() {
		return facultate;
	}

	public void setFacultate(EFacultate facultate) {
		this.facultate = facultate;
	}

	public ArrayList<String> getListaMaterii() {
		return listaMaterii;
	}

	public void setListaMaterii(ArrayList<String> listaMaterii) {
		this.listaMaterii = listaMaterii;
	}

	public float getSumaDisponibila() {
		return sumaDisponibila;
	}

	public void setSumaDisponibila(float sumaDisponibila) {
		this.sumaDisponibila = sumaDisponibila;
	}

}
