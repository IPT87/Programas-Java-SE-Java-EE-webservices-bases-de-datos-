package patrones;

public class Singleton {
	//atributo estatico privado
	private static Singleton myObject;
	
	//constructor privado vacio
	private Singleton() {
		
	}
	
	//metodo para recibir la unica instancia de este objeto
	public static Singleton getInstance() {
		if(myObject == null) {
			myObject = new Singleton();
		}
		return myObject;
	}
}
