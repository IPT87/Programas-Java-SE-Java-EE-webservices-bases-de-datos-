package principal;

public class Lanzador {

	public static void main(String[] args) {
		
		lanzador(new TareaAscendente());
		lanzador(new TareaDescendente());
		
		for (int i = 1; i <= 100; i++) {
			System.out.println("Tarea del main.");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	// Lanzamos las tareas
	private static void lanzador(Runnable r) {
		new Thread(r).start();
	}

}
