package Test;

import modelo.SistemaAgenda;

public class TestAgenda {

	public static void main(String[] args) {
		SistemaAgenda agendas = new SistemaAgenda();
		try {
			agendas.agregarContacto("Cristian", "1128641787");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			agendas.agregarContacto("Yanet", "1128271204");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			agendas.agregarContacto("pepe", "1125252565");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			agendas.agregarContacto("Juan", "1123233365");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(agendas.toString());

		try {
			agendas.agregarContacto("Marcos", "1178899558");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("telefono encontrado "+ agendas.traerTelefono("pepe"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("ORDENADO ALFABETICAMENTE");
		agendas.ordenar();
		System.out.println(agendas.toString());
	}
	
	

}
