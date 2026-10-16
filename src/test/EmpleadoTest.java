package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {
	
	Empleado empleado;

	@BeforeAll
	//Antes de todas las pruebas
	static void setUpBeforeClass() throws Exception {
		System.out.println("Inicio de todo");
	}

	@AfterAll
	//Despues de todas las pruebas
	static void tearDownAfterClass() throws Exception {
		System.out.println("Fin de todo");
	}

	@BeforeEach
	//Antes de cada prueba
	void setUp() throws Exception {
		System.out.println("Inicio de uno");
		empleado = new Empleado();
	}

	@AfterEach
	//Despues de cada prueba
	void tearDown() throws Exception {
		System.out.println("Fin de uno");
	}

	@Test
	void testCalculoNominaBruta_VentasMenor1000() {
		TipoEmpleado tipo = TipoEmpleado.VENDEDOR;
		float ventasMes = 999f;
		float horasExtra = 0f;
		float resultado = 2000f;
		float resEmpleado = empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(resultado, resEmpleado);
	}

	@Test
	void testCalculoNominaBruta_VentasEn1000() {
		TipoEmpleado tipo = TipoEmpleado.VENDEDOR;
		float ventasMes = 1000f;
		float horasExtra = 0f;
		float resultado = 2100f;
		float resEmpleado = empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(resultado, resEmpleado);
	}

	@Test
	void testCalculoNominaBruta_VentasJustoPorDebajo1500() {
		TipoEmpleado tipo = TipoEmpleado.VENDEDOR;
		float ventasMes = 1499f;
		float horasExtra = 0f;
		float resultado = 2100f;
		float resEmpleado = empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(resultado, resEmpleado);
	}

	@Test
	void testCalculoNominaBruta_VentasEn1500Encargado() {
		TipoEmpleado tipo = TipoEmpleado.ENCARGADO;
		float ventasMes = 1500f;
		float horasExtra = 1f;
		float resultado = 2730f; // 2500 base + 200 prima + 30 extra
		float resEmpleado = empleado.calculoNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(resultado, resEmpleado);
	}

	@Test
	void testCalculoNominaNeta_Menor2100() {
		float nominaBruta = 2099f;
		float resultado = 2099f;
		float resEmpleado = empleado.calculoNominaNeta(nominaBruta);
		
		assertEquals(resultado, resEmpleado);
	}

	@Test
	void testCalculoNominaNeta_En2100() {
		float nominaBruta = 2100f;
		float resultado = 1785f; // 2100 * 0.85
		float resEmpleado = empleado.calculoNominaNeta(nominaBruta);
		
		assertEquals(resultado, resEmpleado);
	}

	@Test
	void testCalculoNominaNeta_Menor2500() {
		float nominaBruta = 2499f;
		float resultado = 2124.15f; // 2499 * 0.85
		float resEmpleado = empleado.calculoNominaNeta(nominaBruta);
		
		assertEquals(resultado, resEmpleado, 0.01f);
	}

	@Test
	void testCalculoNominaNeta_En2500() {
		float nominaBruta = 2500f;
		float resultado = 2050f; // 2500 * 0.82
		float resEmpleado = empleado.calculoNominaNeta(nominaBruta);
		
		assertEquals(resultado, resEmpleado);
	}
}