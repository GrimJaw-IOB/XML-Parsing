
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class JSON_parser{
	
	public static void main(String[] args) {
		
		String json = "{\"data\":{\"lookupTableList\":[{\"uuid\":\"4482f67b\\u002D63f7\\u002D4428\\u002D8d97\\u002D5257862b11b8\",\"name\":\"IBE\\u005FHSDP\\u005FV1\\u005FDeIdentification\\u005FConfiguration\",\"description\":\"Configure\\u0020Xpath\\u002C\\u0020Rules\\u0020and\\u0020Values\\u0020for\\u0020the\\u0020Sources\\u002E\",\"rowCount\":12,\"recordingFailures\":true,\"columnNames\":[\"SourceId\",\"Xpath\",\"Rule\",\"Value\"]},{\"uuid\":\"df8cd619\\u002D6a9e\\u002D48af\\u002Daab9\\u002D2f91e079b3ba\",\"name\":\"IBE\\u005FHSDP\\u005FV1\\u005FSourceID\\u005FTo\\u005FClientMapping\\u005FLookup\",\"description\":\"This\\u0020lookup\\u0020table\\u0020maps\\u0020the\\u0020sourceID\\u0020to\\u0020Client\\u0020name\",\"rowCount\":25,\"recordingFailures\":true,\"columnNames\":[\"TenantName\",\"ClientName\",\"API\",\"BillingID\"]},{\"uuid\":\"07f822b2\\u002Dc6da\\u002D446a\\u002Db8cd\\u002D5562f628c2f1\",\"name\":\"IBE\\u005FHSDP\\u005FV1\\u005FSupported\\u005FInterfaces\\u005FLookup\",\"description\":\"This\\u0020lookup\\u0020table\\u0020identifies\\u0020the\\u0020interfaces\\u0020that\\u0020are\\u0020interested\\u0020in\\u0020receiving\\u0020the\\u0020data\\u0020from\\u0020the\\u0020source\\u0020system\",\"rowCount\":7,\"recordingFailures\":true,\"columnNames\":[\"SourceSystem\",\"EMR\",\"eCC\",\"Toolkit\",\"CDR\",\"DefaultTimeZone\"]},{\"uuid\":\"2c151a87\\u002D3ca7\\u002D493c\\u002D8601\\u002D935bc0246bc5\",\"name\":\"IBE\\u005FHSDP\\u005FV2\\u005FProvenance\\u005FFHIR\\u005FCodes\\u005FLookup\",\"description\":\"Lookup\\u0020table\\u0020to\\u0020check\\u0020for\\u0020FHIR\\u0020Enumeration\\u0020values\\u0020for\\u0020a\\u0020field\\u0020for\\u0020Provenance\\u0020resource\\u002E\",\"rowCount\":10,\"recordingFailures\":true,\"columnNames\":[\"FieldName\",\"Text\\u005FTo\\u005FBe\\u005FLooked\\u005FUp\",\"Code\",\"Display\",\"System\",\"FHIRCodeSetID\"]},{\"uuid\":\"99258774\\u002D5dcb\\u002D4d27\\u002Dbddc\\u002D24499502ee2b\",\"name\":\"IBE\\u005FHSDP\\u005FV2\\u005FQuestionnaireResponse\\u005FFHIR\\u005FCodes\\u005FLookup\",\"description\":\"Lookup\\u0020table\\u0020to\\u0020check\\u0020for\\u0020FHIR\\u0020Enumeration\\u0020values\\u0020for\\u0020a\\u0020field\\u0020for\\u0020QuestionnaireResponse\\u0020resource\\u002E\",\"rowCount\":12,\"recordingFailures\":true,\"columnNames\":[\"FieldName\",\"Text\\u005FTo\\u005FBe\\u005FLooked\\u005FUp\",\"Code\",\"Display\",\"System\",\"FHIRCodeSetID\"]},{\"uuid\":\"5ee1cfa5\\u002D4888\\u002D4e7f\\u002Db292\\u002D03c82fe118a5\",\"name\":\"IBE\\u005FHSDP\\u005FV2\\u005FQuestionnaire\\u005FFHIR\\u005FCodes\\u005FLookup\",\"description\":\"Lookup\\u0020table\\u0020to\\u0020check\\u0020for\\u0020FHIR\\u0020Enumeration\\u0020values\\u0020for\\u0020a\\u0020field\\u0020for\\u0020QuestionnaireResponse\\u0020resource\",\"rowCount\":247,\"recordingFailures\":true,\"columnNames\":[\"FieldName\",\"Text\\u005FTo\\u005FBe\\u005FLooked\\u005FUp\",\"Code\",\"Display\",\"System\",\"FHIRCodeSetID\"]},{\"uuid\":\"0993420f\\u002Dbbbd\\u002D457d\\u002D8f74\\u002D835153a382f0\",\"name\":\"IBE\\u005FHSDP\\u005FV2\\u005FReferralRequest\\u005FFHIR\\u005FCodes\\u005FLookup\",\"description\":\"Lookup\\u0020table\\u0020to\\u0020check\\u0020for\\u0020FHIR\\u0020Enumeration\\u0020values\\u0020for\\u0020a\\u0020field\\u0020for\\u0020ReferralRequest\\u0020resource\\u002E\\u000ANew\\u0020STU3\\u0020fields\\u0020added\\u0020\\u003A\\u0020ReferralIntent\",\"rowCount\":70,\"recordingFailures\":true,\"columnNames\":[\"FieldName\",\"Text\\u005FTo\\u005FBe\\u005FLooked\\u005FUp\",\"Code\",\"Display\",\"System\",\"FHIRCodeSetID\"]}]},\"error\":null}";
		
		String toFind = "IBE_HSDP_V1_DeIdentification_Configuration";
		
		JSONParser parser = new JSONParser();
		String guid = new String();
		
		try {
			//Object obj = parser.parse(json);
			JSONObject arr = (JSONObject) parser.parse(json);
			
			JSONObject data = (JSONObject) arr.get("data");
			
			JSONArray lookuptableList = (JSONArray) data.get("lookupTableList");
			
			//Iterator <Map.Entry>
			Iterator lookuptableIterator = lookuptableList.iterator();
			
			while(lookuptableIterator.hasNext()){
				JSONObject obj = (JSONObject) lookuptableIterator.next();
				if(obj.get("name").equals(toFind)) {
					guid = (String) obj.get("uuid");
				}
				
				
			}
			
			//JSONObject data = 
			System.out.println(guid);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}