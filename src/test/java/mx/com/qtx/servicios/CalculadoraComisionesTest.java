package mx.com.qtx.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import mx.com.qtx.entidades.Operacion;
import mx.com.qtx.entidades.Venta;

public class CalculadoraComisionesTest {
	
	@Test
	public void testCalcularComision_ventaDebajoMinimo(){
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMenorQueMinimo = calculadora.getImporteMinimo() - 1;
		char tipoVenta = 'N';
		//entonces 
		double comision = calculadora.calcularComision(importeMenorQueMinimo, tipoVenta);
		//validar
		assertEquals(comision, 0);
	}
	@Test
	public void testCalcularComision_ventaNormal_importeMayQueMin() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = calculadora.getImporteMinimo() + 1;
		char tipoVenta = 'N';
		//entonces
		double comision = calculadora.calcularComision(importe, tipoVenta);
		double comisionEsperada = importe * calculadora.getPorcComisionNormal() / 100;
		//validar
		assertEquals(comisionEsperada, comision, "La comision de la venta normal esta equivocada");
	}
	@Test
	public void testCalcularComision_vtaExtraordinaria_importeMayQueMin() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = calculadora.getImporteMinimo() + 1;
		char tipoVenta = 'X';
		//entonces
		double comision = calculadora.calcularComision(importe, tipoVenta);
		double comisionEsperada = importe * calculadora.getPorcComisionExtraordinario() / 100;
		//validar
		assertEquals(comisionEsperada, comision, "La comision de la venta extraordinaria esta equivocada");
	}
	@Test
	public void testCalcularComision_vtaTipoInexistente() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = calculadora.getImporteMinimo() + 1;
		char tipoVenta = 'T';
		//entonces
		double comision = calculadora.calcularComision(importe, tipoVenta);
		double comisionEsperada = -1;
		//validar
		assertEquals(comisionEsperada, comision, "Manejo incorrecto de tipo de Vta inexistente");
	}
	@Test
	public void testCalcularComision_vtaTipoInexistente_SeGuardaExcepcion() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = calculadora.getImporteMinimo() + 1;
		char tipoVenta = 'T';
		String emisor = "testCalcularComision_vtaTipoInexistente_SeGuardaExcepcion";
		
		//entonces
		Comision comision = calculadora.calcularComision(importe, tipoVenta, emisor);
		double comisionEsperada = -1;
		Operacion operacion = calculadora.getOperacion(comision.getFolio());
		
		//validar
		assertNotNull(operacion.getExLanzada(), "No se registro Excepcion para una venta inexistente");
		assertEquals(comisionEsperada, comision.getImporte(), "Manejo incorrecto de tipo de Vta inexistente");
	}
	@Test
	public void testCalcularComision_ventaNormal_Nminus() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = calculadora.getImporteMinimo() + 1;
		char tipoVenta = 'n';
		//entonces
		double comision = calculadora.calcularComision(importe, tipoVenta);
		double comisionEsperada = importe * calculadora.getPorcComisionNormal() / 100;
		//validar
		assertEquals(comisionEsperada, comision, "NO se soporta tipo vta en minusculas");
	}
	@Test
	public void testCalcularComision_ventaNormal_Xminus() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = calculadora.getImporteMinimo() + 1;
		char tipoVenta = 'x';
		//entonces
		double comision = calculadora.calcularComision(importe, tipoVenta);
		double comisionEsperada = importe * calculadora.getPorcComisionExtraordinario() / 100;
		//validar
		assertEquals(comisionEsperada, comision, "NO se soporta tipo vta en minusculas");
	}
	@Test
	public void testCalcularComision_ventaImporteCero() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importe = 0;
		char tipoVenta = 'N';
		//entonces
		double comision = calculadora.calcularComision(importe, tipoVenta);
		double comisionEsperada = -2;
		//validar
		assertEquals(comisionEsperada, comision, "NO se valida importeVenta = 0");
	}
	
	@Test
	public void testCalcularComision_ConObjVenta_nulo() {
		//Dados
		Venta vtaNula = null;
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double comisionEsperada = -3;
		
		//entonces
		double comision = calculadora.calcularComision(vtaNula);
		//validar
		assertEquals(comisionEsperada, comision, "No se valida correctamente una venta nula");
	}
	
	@Test
//	@Disabled
	public void testRegistroOperaciones_foliadoOk() {
		//Dados
		double importes[]= {1000,2000,-1, 1500,5000};
		char tiposVta[]= {'N','n','X','X','R'};
		String emisor = "testRegistroOperaciones_foliadoOk";
		int nCalculos = importes.length;
		List<Long> folios = new ArrayList<>();
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		
		//Entonces		
		for(int i=0; i<nCalculos; i++) {
			Comision comisionI = calculadora.calcularComision(importes[i], tiposVta[i], emisor);
			folios.add(comisionI.getFolio());
		}
		
		List<Operacion> operaciones = calculadora.getOperacionesDesdeHasta(folios.get(0),folios.get(nCalculos-1));
		List<Long> foliosRegistrados = new ArrayList<>();
		operaciones.forEach(oper -> foliosRegistrados.add(oper.getFolio()));
		
		long folioInicial = folios.get(0);
		long folioFinal = operaciones.get(nCalculos - 1).getFolio();
		long folioFinalEsperado = folioInicial + nCalculos - 1;
		long difFolios = operaciones.get(nCalculos - 1).getFolio() - operaciones.get(0).getFolio();
		
		//Validar
		assertIterableEquals(folios, foliosRegistrados, "Los folios registrados no coinciden con los generados");
		assertEquals(operaciones.size(), nCalculos, "No se registraron todas los calculos de comision ");
		assertEquals(difFolios, nCalculos - 1, "Los folios están mal calculados");
		assertEquals(folioFinal, folioFinalEsperado, "Los folios están mal calculados");
	}
	

}
