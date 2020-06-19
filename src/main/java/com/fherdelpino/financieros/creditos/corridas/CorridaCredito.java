package com.fherdelpino.financieros.creditos.corridas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CorridaCredito {
	
	static int count = 1;
	static int PRECIO = 484900;

	public static void main(String[] args) {
		CorridaCredito r = new CorridaCredito();
		
		int enganche = 200000;
		float tasa = 0.11f;
		int plazo = 24;
		
		System.out.println("Precio del vehiculo: " + PRECIO);
		System.out.println("Enganche: " + enganche);
		System.out.print("Tasa: " + tasa*100);
		System.out.print("\t");
		System.out.println("Plazo: " + plazo);
		
		r.run(PRECIO-enganche,tasa, plazo);
		
	}
	
	public void run(float monto, float tasa, int plazo) {		
		BigDecimal montoBD = new BigDecimal(monto);
		BigDecimal tasaBD = new BigDecimal(tasa);
		
		int mensualidad = montoBD.intValue()/plazo;
		int ultimoMonto = 0;
		
		do {			
			ultimoMonto = calculo(montoBD,tasaBD,plazo,++mensualidad,false);
		} while (mensualidad - ultimoMonto < 0);
		
		System.out.println("mensualidad: " + mensualidad);

		calculo(montoBD,tasaBD,plazo,mensualidad,true);
		
	}
	
	private BigDecimal corrida(BigDecimal monto, BigDecimal tasaAnual, BigDecimal mensualidad, boolean print) {
		BigDecimal tasaMensual = tasaAnual.divide(new BigDecimal(12), 10, RoundingMode.CEILING);
				
		BigDecimal interes = monto.multiply(tasaMensual);
		
		BigDecimal iva = interes.multiply(new BigDecimal(.16));
		
		BigDecimal seguro = new BigDecimal(263.73);
		
		BigDecimal amortizacion = mensualidad.subtract(interes).subtract(iva).subtract(seguro);

		if (print) {
			String output = String.format("%d,%g,%g,%g,%g,%g,%g",count++, monto.doubleValue(),interes.doubleValue(),iva.doubleValue(),seguro.doubleValue(),amortizacion.doubleValue(),mensualidad.doubleValue());
			System.out.println(output);
		}
		
		return monto.subtract(amortizacion);
	}
	
	private int calculo(BigDecimal monto, BigDecimal tasa, int plazo, int probableMensualidad, boolean print) {
		
		BigDecimal mensualidad = new BigDecimal(probableMensualidad);
		
		BigDecimal newMonto = monto;
		
		for (int i = print? 0:1 ; i < plazo ; i++) {
			newMonto = corrida(newMonto,tasa,mensualidad,print);
		}
		
		return newMonto.intValue();
		
	}

}
