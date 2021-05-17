import java.util.LinkedList;

import javax.swing.JTextArea;

public class GrammarGeneratedArithmetic {
	ArithmeticAnalyzer analyzer;
	JTextArea txt;
	LinkedList<String> gen ;
	public GrammarGeneratedArithmetic(JTextArea ta) {
		analyzer = new ArithmeticAnalyzer();
		txt = ta;
	}

	public void gen(String s) {
		gen = new LinkedList<String>();
		gen.add("S");
		String[] split = s.split("");
		String bank="";
		String par="";
		for(int i=0;i<split.length;i++) {

			if(analyzer.isNumber(split[i])) {
				bank=bank+split[i];

			}else if(split[i].equals("(")) {
				i++;
				while(!split[i].equals(")")){
					par=par+split[i];
					i++;
				}
			}else {
				if(split[i].equals("-")&&bank.length()==0) {
					bank="-";
				}else {
//					txt.append(gen+"\n");
					int j=0;
					while(!gen.get(j).equals("S")) {
						j++;
					}

					gen.remove(j);
					gen.add(j,"A");
					gen.add(j,split[i]);
					gen.add(j,"A");
					txt.append(gen+"\n");
					if(par.isEmpty()) {
						gen.remove(j);
						gen.add(j, bank);
						bank="";
					}else {
						gen.remove(j);
						gen.add(j,")");
						gen.add(j,"S");
						gen.add(j,"(");
						
					}
					gen.removeLast();
					if(i+1==split.length-1) {
						gen.add(split[i+1]);
					}else {
						gen.add("S");						
					}
					txt.append(gen+"\n");
				}
			}	
		}
	}
}