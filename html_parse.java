import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class HTML_Parse{
	
	public static void main(String[] args) {
		try {
			
			String html_str = "<!DOCTYPE html>\r\n" + 
					"<html id=\"document-root\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"	<title>Rhapsody Lookup Tables</title>\r\n" + 
					"\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"		href=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/reset-fonts-grids/reset-fonts-grids.css\" />\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"		href=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/assets/skins/hive/skin.css\" />\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"		href=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/fontawesome/fa/font-awesome.css\" />\r\n" + 
					"	<script type=\"text/javascript\" src=\"/yui-3/yui.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/yuiloader/yuiloader.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/common-web/base.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/legacy/Window.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/event/event.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/datasource/datasource.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/dom/dom.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/orchestral/orchestral.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/event-mouseenter/event-mouseenter.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/selector/selector.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/logger/logger.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/element/element.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/animation/animation.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/form/form.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/locale.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/calendar/calendar.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/datatable/datatable.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/dom/dom.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\" src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/button/button.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/yui-2.8/paginator/paginator.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/button/button.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/datetime/datetime.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/autorefresh/autorefresh.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/button/button-aria.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/button/button-rollup.js\"></script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/common-web/datatable/datatable.js\"></script>\r\n" + 
					"\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"		href=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/css/rhapsodyCommon.css\" />\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"		href=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/admin/css/admin.css\" />\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"		href=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/SlickGrid-2.2/slick.grid.css\" />\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/SlickGrid-2.2/lib/jquery-1.7.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/SlickGrid-2.2/lib/jquery.event.drag-2.2.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/SlickGrid-2.2/slick.core.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/SlickGrid-2.2/slick.grid.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/SlickGrid-2.2/plugins/slick.autotooltips.js\">\r\n" + 
					"	</script>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.8.3/jquery.flot.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.8.3/excanvas.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.8.3/jquery.flot.time.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.8.3/jquery.flot.selection.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.8.3/jquery.flot.resize.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.8.3/jquery.flot.pie.min.js\">\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/rhapsodycommon/lib/flot-0.7/jquery.flot.threshold.linefill.js\">\r\n" + 
					"	</script>\r\n" + 
					"\r\n" + 
					"	<script type=\"text/javascript\">\r\n" + 
					"		var RHAPSODY = RHAPSODY || {};\r\n" + 
					"\r\n" + 
					"(function() {\r\n" + 
					"\r\n" + 
					"	/** The Rhapsody common global object */\r\n" + 
					"	RHAPSODY.common = RHAPSODY.common || {};\r\n" + 
					"\r\n" + 
					"	/**\r\n" + 
					"	 * The CSRF token to use for any write requests. This token is initialised by calling\r\n" + 
					"	 * RHAPSODY.common.init().\r\n" + 
					"	 */\r\n" + 
					"	RHAPSODY.common.csrfToken = '';\r\n" + 
					"\r\n" + 
					"	/**\r\n" + 
					"	 * Initialises any global state required by the common JavaScript modules.\r\n" + 
					"	 *\r\n" + 
					"	 * @param parameters {Object} an object containing the following members:\r\n" + 
					"	 * 			- csrfToken {String} the CSRF token to use for write requests\r\n" + 
					"	 */\r\n" + 
					"	RHAPSODY.common.init = function(parameters) {\r\n" + 
					"		RHAPSODY.common.csrfToken = parameters.csrfToken || RHAPSODY.common.csrfToken;\r\n" + 
					"\r\n" + 
					"		// Provide the CSRF token to all requests using the resource module\r\n" + 
					"		YUI().use('event', function(Y) {\r\n" + 
					"			Y.Global.on('*:resourcePreRequest', function(e) {\r\n" + 
					"				if (e.request && e.request.config) {\r\n" + 
					"					if (!e.request.config.headers) {\r\n" + 
					"						e.request.config.headers = {};\r\n" + 
					"					}\r\n" + 
					"					e.request.config.headers['X-CSRF-Token'] = RHAPSODY.common.csrfToken;\r\n" + 
					"				}\r\n" + 
					"			});\r\n" + 
					"		});\r\n" + 
					"	};\r\n" + 
					"}());\r\n" + 
					"	</script>\r\n" + 
					"	<script type=\"text/javascript\"\r\n" + 
					"		src=\"/web/s/6.4.1.1ca0c5373a38a79a8442ca303e92e7c0931406c6/admin/javascript/admin.js\"></script>\r\n" + 
					"\r\n" + 
					"	<script type=\"text/javascript\">\r\n" + 
					"		RHAPSODY.admin.initialise({\r\n" + 
					"					csrfToken: 'NTPJIX5QIYzFTWKuWHubbMpUulnvV17mtsqRCyxQEQ7kay3WGkSf8JJHoGxK9TG4V+i9D21H98W6drinNpDmLg=='\r\n" + 
					"				});\r\n" + 
					"	</script>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"	<div id=\"doc3\">\r\n" + 
					"\r\n" + 
					"		<div id=\"lookupTables-container\">\r\n" + 
					"			<h1>Lookup Tables</h1>\r\n" + 
					"			<table cellpadding=\"5\" border=\"2\" cellspacing=\"5\">\r\n" + 
					"				<tr>\r\n" + 
					"					<th>\r\n" + 
					"						<h2>Uuid </h2>\r\n" + 
					"					</th>\r\n" + 
					"					<th>\r\n" + 
					"						<h2>Name </h2>\r\n" + 
					"					</th>\r\n" + 
					"					<th>\r\n" + 
					"						<h2>Description</h2>\r\n" + 
					"					</th>\r\n" + 
					"					<th>\r\n" + 
					"						<h2>Row Count</h2>\r\n" + 
					"					</th>\r\n" + 
					"					<th>\r\n" + 
					"						<h2>Recoding Failures</h2>\r\n" + 
					"					</th>\r\n" + 
					"					<th>\r\n" + 
					"						<h2>Column Names</h2>\r\n" + 
					"					</th>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">4482f67b-63f7-4428-8d97-5257862b11b8</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V1_DeIdentification_Configuration</td>\r\n" + 
					"					<td valign=\"middle\">Configure Xpath, Rules and Values for the Sources.</td>\r\n" + 
					"					<td valign=\"middle\">12</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[SourceId, Xpath, Rule, Value]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">df8cd619-6a9e-48af-aab9-2f91e079b3ba</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V1_SourceID_To_ClientMapping_Lookup</td>\r\n" + 
					"					<td valign=\"middle\">This lookup table maps the sourceID to Client name</td>\r\n" + 
					"					<td valign=\"middle\">25</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[TenantName, ClientName, API, BillingID]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">07f822b2-c6da-446a-b8cd-5562f628c2f1</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V1_Supported_Interfaces_Lookup</td>\r\n" + 
					"					<td valign=\"middle\">This lookup table identifies the interfaces that are interested in receiving the\r\n" + 
					"						data from the source system</td>\r\n" + 
					"					<td valign=\"middle\">7</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[SourceSystem, EMR, eCC, Toolkit, CDR, DefaultTimeZone]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">2c151a87-3ca7-493c-8601-935bc0246bc5</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V2_Provenance_FHIR_Codes_Lookup</td>\r\n" + 
					"					<td valign=\"middle\">Lookup table to check for FHIR Enumeration values for a field for Provenance\r\n" + 
					"						resource.</td>\r\n" + 
					"					<td valign=\"middle\">10</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[FieldName, Text_To_Be_Looked_Up, Code, Display, System, FHIRCodeSetID]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">99258774-5dcb-4d27-bddc-24499502ee2b</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V2_QuestionnaireResponse_FHIR_Codes_Lookup</td>\r\n" + 
					"					<td valign=\"middle\">Lookup table to check for FHIR Enumeration values for a field for\r\n" + 
					"						QuestionnaireResponse resource.</td>\r\n" + 
					"					<td valign=\"middle\">12</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[FieldName, Text_To_Be_Looked_Up, Code, Display, System, FHIRCodeSetID]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">5ee1cfa5-4888-4e7f-b292-03c82fe118a5</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V2_Questionnaire_FHIR_Codes_Lookup</td>\r\n" + 
					"					<td valign=\"middle\">Lookup table to check for FHIR Enumeration values for a field for\r\n" + 
					"						QuestionnaireResponse resource</td>\r\n" + 
					"					<td valign=\"middle\">247</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[FieldName, Text_To_Be_Looked_Up, Code, Display, System, FHIRCodeSetID]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"				<tr>\r\n" + 
					"					<td valign=\"middle\">0993420f-bbbd-457d-8f74-835153a382f0</td>\r\n" + 
					"					<td valign=\"middle\">IBE_HSDP_V2_ReferralRequest_FHIR_Codes_Lookup</td>\r\n" + 
					"					<td valign=\"middle\">Lookup table to check for FHIR Enumeration values for a field for\r\n" + 
					"						ReferralRequest resource.\r\n" + 
					"						New STU3 fields added : ReferralIntent</td>\r\n" + 
					"					<td valign=\"middle\">70</td>\r\n" + 
					"					<td valign=\"middle\">true</td>\r\n" + 
					"					<td valign=\"middle\">[FieldName, Text_To_Be_Looked_Up, Code, Display, System, FHIRCodeSetID]</td>\r\n" + 
					"				</tr>\r\n" + 
					"\r\n" + 
					"			</table>\r\n" + 
					"		</div>\r\n" + 
					"\r\n" + 
					"	</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>";
			
			
			Document doc = Jsoup.parse(html_str);
			Element el = doc.getElementById("lookupTables-container");
			
			Elements table = el.getElementsByTag("tr");
			
			for(Element input: table) {
				
				System.out.println(input.getElementsContainingText("IBE_HSDP_V1_DeIdentification_Configuration"));
				//System.out.println(input.select("tr > td").);
				//input.get
				
			}
			
			//System.out.println(table);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}