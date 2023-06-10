package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaAgenda {
	private List<Agenda> lstAgenda;
	
	public SistemaAgenda() {
		lstAgenda = new ArrayList<Agenda>();
	}

	public boolean agregarContacto(String nombre, String telefono) throws Exception {
		if(lstAgenda.size() == 20)
			throw new Exception ("Error, AGENDA LLENA!");
		else if(traerAgenda(telefono)!=null)
			throw new Exception ("Error, NUMERO YA AGENDADO!");
		
		return lstAgenda.add(new Agenda(nombre, telefono));
	}
	
	public Agenda traerAgenda(String telefono) {
		Agenda agenda = null;
		int i = 0;
		while(agenda == null && i < lstAgenda.size()) {
			if(lstAgenda.get(i).getTelefono().equals(telefono)) {
				agenda = lstAgenda.get(i);
			}
			i++;
		}
		return agenda;
	}
	
	public Agenda traerAgendaNombre(String nombre) {
		Agenda agenda = null;
		int i = 0;
		while(agenda == null && i < lstAgenda.size()) {
			if(lstAgenda.get(i).getNombre().equals(nombre)) {
				agenda = lstAgenda.get(i);
			}
			i++;
		}
		return agenda;
	}
	
	public String traerTelefono(String nombre) throws Exception {
		Agenda agenda = traerAgendaNombre(nombre);
		if(agenda == null)
			throw new Exception ("Error, el contacto con  el nombre "+ nombre +" no existe");
		return agenda.getTelefono();
	}

	public List<Agenda> getLstAgenda() {
		return lstAgenda;
	}

	public void setLstAgenda(List<Agenda> lstAgenda) {
		this.lstAgenda = lstAgenda;
	}
	
    public void ordenar() {
    	String auxNombre;
    	String auxNum;
    	for(int i = 0; i < lstAgenda.size(); i++) {
    		for(int j = 0; j < lstAgenda.size()-1; j++) {
    			if(lstAgenda.get(j).getNombre().compareTo(lstAgenda.get(j+1).getNombre()) > 0) {
    				auxNombre = lstAgenda.get(j).getNombre();
    				auxNum = lstAgenda.get(j).getTelefono();
    				
    				lstAgenda.get(j).setNombre(lstAgenda.get(j+1).getNombre());
    				lstAgenda.get(j).setTelefono(lstAgenda.get(j+1).getTelefono());
    				
    				lstAgenda.get(j+1).setNombre(auxNombre);
    				lstAgenda.get(j+1).setTelefono(auxNum);
    			}
    		}
    	}
    }

	@Override
	public String toString() {
		return lstAgenda+"";
	}
}
