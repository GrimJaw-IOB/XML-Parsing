
import java.util.*;
import java.io.*;

class TextParser{
	
	public static void main(String[] args) {
		
		String main_str = "SourceId,Xpath,Rule,Value\r" + 
				"\"Toolkit_A\",\"/Application/Biogen/Getcdrid\",\"getID\",\"\"\r" + 
				"\"DeIdentification_A\",\"/Application/Biogen/Getcdrid\",\"Redact\",\"\"\r" + 
				"\"DeIdentification_A\",\"/message/data[*]/site_id\",\"redact\",\"terere\"\r" + 
				"\"DeIdentification_A\",\"/message/data[*]/mpi\",\"doublehash\",\"\"\r" + 
				"\"DeIdentification_A\",\"/message/data[*]/NAME_ty\",\"getid\",\"\"\r" + 
				"\"DeIdentification_A\",\"/message/data[*]/immunosuppress_set_id[@name='fhir']/id\",\"truncateYOB\",\"no\"\r" + 
				"\"DeIdentification_B\",\"/ClinicalDocument/component[*]/structuredBody/component/section/templateId/@root=2.16.840.1.113883.10.20.1.3\",\"redact\",\"EncouterRedact\"\r" + 
				"\"DeIdentification_B\",\"/ClinicalDocument/component/structuredBody/component[*]/section/code/@code\",\"redact\",\"MultipleAttributeRedactTest\"\r" + 
				"\"DeIdentification_B\",\"/ClinicalDocument/legalAuthenticator/signatureCode/@code\",\"getid\",\"\"\r" + 
				"\"DeIdentification_B\",\"/ClinicalDocument/typeId/@extension\",\"doublehash\",\"\"\r" + 
				"\"DeIdentification_B\",\"/ClinicalDocument/effectiveTime/@value\",\"offset\",\"\"\r" + 
				"\"DeIdentification_B\",\"/ClinicalDocument/legalAuthenticator/time/@value\",\"truncateyob\",\"YYYY\"\r" + 
				"";
		
		
		
		String line = "";
        String csvSplitBy = ",";
        
        ArrayList<String[]> arr = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new StringReader(main_str))) {
			
			while((line=br.readLine())!=null) {
				
				String[] temp = line.split(csvSplitBy);
				if(temp[0].contains("DeIdentification_A")) {
					
					arr.add(temp);
				}
				
			}
			
			System.out.println("Array list: ");
			
			ArrayList<String> redactRule = new ArrayList<>();
			ArrayList<String> offsetRule = new ArrayList<>();
			ArrayList<String> truncateYOBRule = new ArrayList<>();
			ArrayList<String> doubleHashRule = new ArrayList<>();
			
			for(String[] t: arr) {
				String rule = t[2].toLowerCase().replace("\"", "");
				//System.out.println(t[2]);
				switch(rule) {
					case "redact":
						//System.out.println(t[1]);
						redactRule.add(t[1].replace("\"",""));
						break;
					case "offset":
						offsetRule.add(t[1].replace("\"",""));
						break;
					case "truncateyob":
						truncateYOBRule.add(t[1].replace("\"",""));
						break;
					case "doublehash":
						doubleHashRule.add(t[1].replace("\"",""));
						break;
					default:
						break;
					
				
				}
			}
			
			
			System.out.println(redactRule);
			System.out.println(offsetRule);
			System.out.println(truncateYOBRule);
			System.out.println(doubleHashRule);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}