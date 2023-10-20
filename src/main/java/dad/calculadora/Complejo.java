package dad.calculadora;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	DoubleProperty real = new SimpleDoubleProperty();
	DoubleProperty imaginario = new SimpleDoubleProperty();
	
	public Complejo() {}
	
	public Complejo(Double real, Double imaginario) {
	
		super();
		setReal(real);
		setImaginario(imaginario);

	}
	
	public Double getReal() {
		return real.get();
	}
	
	public void setReal(Double real) {
		this.real.set(real);
	}
	
	public DoubleProperty realProperty() {
		return real;
		
	}
	
	public Double getImaginario() {
		return imaginario.get();
	}
	
	public void setImaginario(Double imaginario) {
		this.imaginario.set(imaginario);
	}
	
	public DoubleProperty imaginarioProperty() {
		return imaginario;
		
	}
	
}
