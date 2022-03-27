package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamentos;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
		FactoriaMedicamentos FM = FactoriaMedicamentos.parse("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(FM);

	}

}
