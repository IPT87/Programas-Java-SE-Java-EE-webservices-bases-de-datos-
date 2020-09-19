package lanzador;

import mediator.mediador.Sala;
import mediator.usuarios.User;

public class Test {

	public static void main(String[] args) {
		//Creamos una sala de chat
		Sala sala=new Sala();
		//Tenemos tres usuarios en la sala
		User u1=new User(sala,"user1");
		User u2=new User(sala,"user2");
		User u3=new User(sala,"user3");
		/*sala.registrar(u1);
		sala.registrar(u2);
		sala.registrar(u3);*/
		
		u1.enviar("user3", "Hola user 3");
		u2.enviar("user1", "soy user 2");
	}

}
