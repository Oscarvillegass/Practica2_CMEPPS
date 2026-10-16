	package pkg;

public class Empleado {

	public enum TipoEmpleado {
		VENDEDOR, ENCARGADO
	};


	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		
		float sueldo = 0;
		
		//Calculo del sueldo base
		if(tipo==TipoEmpleado.ENCARGADO) {
			sueldo=2500;
		}else if(tipo==TipoEmpleado.VENDEDOR) {
			sueldo=2000;
		}else {
			return -1;
		}
		
		//Calculo de ventas del mes
		if (ventasMes >= 1500) {
			sueldo += 200;
		}else if (ventasMes >= 1000) {
			sueldo += 100;
		}

		return sueldo + horasExtra * 30;
	}

	public float calculoNominaNeta(float nominaBruta) {
		float retencion=0;
		
		if (nominaBruta < 2100f) {
			retencion = 0f;
		} else if (nominaBruta < 2500f) {
			retencion = 0.15f;
		} else {
			retencion = 0.18f;
		}
		return nominaBruta * (1 - retencion);
	}
}

