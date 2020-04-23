import java.util.*;
import java.io.*;
public class A11{

	public static void main(String[] args) throws Exception{

			StringTokenizer st;
			String s,sr;
			ArrayList<String> s3 = new ArrayList<>();
			
			BufferedReader bf = new BufferedReader(new FileReader(args[0]));
			
			List<String> l = Arrays.asList("ELSE","BEGIN", "IF", "RETURN", "WRITE", "READ", "MAIN", "REAL", "STRING", "END", "INT");

			while((s = bf.readLine()) != null){
								
				st = new StringTokenizer(s.trim(), " ,;,()+-*/:=!#$%^&_\\|>@!<");	

				while(st.hasMoreTokens()){

					sr = st.nextToken();

					if(!(l.contains(sr)|| sr.contains("\"")  || Character.isDigit(sr.charAt(0)))){
										
						if(!s3.contains(sr)){
							s3.add(sr);
						}
					}
				
				}
			}

			bf.close();
			BufferedWriter b = new BufferedWriter(new FileWriter("A1.output"));
			b.write("Identifiers:" + s3.size());
			b.close();
	}
}	
