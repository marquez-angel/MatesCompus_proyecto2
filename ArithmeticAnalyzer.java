//Angel Marquez Hernendez A01351408


/*
 * esta clase es para poder ver si una operacion aritmetica es valida. 
 * para elo utilizaremos la gramatica:
 * S -> A+A|A-A|A*A
 * 
 * A-> S|(S)|#
 * 
 * donde # ∊ Z(enteros)
 * 
 */
public class ArithmeticAnalyzer {
	
	public ArithmeticAnalyzer() {
		
	}

	public boolean analyze(String s) {
		String[] values = s.split("");
		String a="";
		for(int i=0;i<values.length;i++) {
			if(values[i].equals("(")){
				i++; 							//nos saltamos
				while(!values[i].equals(")")) {
					if(i==values.length-1) {
						return false;
					}
					a=a+values[i];
					i++;
				}
				if(!analyze(a)) {  		//si es falso regresamos falso, si no, debemos continuar
					return false;
				}
				a="";		//borrar lo guardado
			}else if(values[i].equals("+")||values[i].equals("x")) {
				if(i>0 && i<values.length-1) {		//no se acepta "+5" ni "5+" ya que no estan completos
					if(!(isNumber(values[i+1])||values[i+1].equals("("))) {
						return false;  
					}
				}else {
					return false;
				}
			}else if(values[i].equals("-")) {
				if(i<values.length-1) {		//no se acepta "5-" ya que no esta completo, "-5" se acepta
					if(!(isNumber(values[i+1])||values[i+1].equals("("))) {
						return false;  
					}
				}else {
					return false;
				}
			}else if(values[i].equals(")")) { 	//solo nos topamos este valor si no nos encontramos un ")" primero
				return false;
			}
		}
		return true;
	}
	
	public boolean isNumber(String s) {
		try {
			Integer.valueOf(s);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
//	public static void main(String[] args) {
//		String ejemplo= "3-4+(2x8)+4()";
//		
//		System.out.println(analyze(ejemplo));
//
//	}

}
