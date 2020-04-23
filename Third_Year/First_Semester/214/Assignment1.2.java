import java.util.*;
import java.util.regex.*;
import java.io.*;

public class A12{

	public static void main(String[] args) throws Exception{	
		
		String[] s;
		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		Pattern p = Pattern.compile("\"[^\"]*\"|[^a-zA-Z0-9]|BEGIN|WRITE|READ|IF|ELSE|RETURN|END|MAIN|STRING|INT|REAL");			
		String str;
		ArrayList<String> I = new ArrayList<String>();
		while((str = bf.readLine()) != null){
			s = p.split(str);

			for(int i = 0; i < s.length; i++){
		
					if(!(s[i].equals("") || I.contains(s[i]) || s[i].matches("[0-9][a-zA-Z0-9]*"))){

						I.add(s[i]);
					}
					
				}
			}

		bf.close();

		BufferedWriter bw = new BufferedWriter(new FileWriter("A1.output"));
		
		bw.write("Identifiers:" + I.size());

		bw.close();


	}


}
