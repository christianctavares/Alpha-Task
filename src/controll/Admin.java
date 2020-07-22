package controll;

import java.util.List;

import model.MQuadro;

public class Admin{

	public List<Quadros> listarQuadros(){
		MQuadro q = new MQuadro();
		List<Quadros> qAux = q.listarQuadros();
		if(qAux != null) {
			return qAux;
		}
		return null;
	}
	
}
