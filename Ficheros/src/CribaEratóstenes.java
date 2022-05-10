import java.util.*;
public class CribaEratóstenes {
	ArrayList <Integer> primos;
	
	public CribaEratóstenes(int n) {
		primos = cribadeEratostenes(n);
	
	}
	
	 ArrayList <Integer> cribadeEratostenes(int n){
		 	ArrayList <Integer> primos = new ArrayList <Integer>();
	        // Crea una matriz booleana "primo" e inicializa todas las entradas como true.
	        // Un valor en primo será finalmente false si i no es un primo (si no es verdadero).
	        boolean primo[] = new boolean[n];
	        for(int i=0;i<n;i++)
	            primo[i] = true;
	        for(int p = 2; p*p <=n; p++)
	        {
	            // Si el primo no cambia, entonces es primo
	            if(primo[p] == true)
	            {
	                // Actualiza todos los múltiplos de p
	                for(int i = p*2; i < n; i += p)
	                    primo[i] = false;
	            }
	        }
	        // Imprimie todos los números primos
	        for(int i = 2; i < n; i++)
	        {
	            if(primo[i] == true)
	                primos.add(i);
	        }
	        return primos;
	 }
}
