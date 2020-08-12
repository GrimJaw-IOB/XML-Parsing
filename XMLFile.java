import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class XML_demo {
	
	public static String getElementXPath(Element elt, Element relativeTo) {
	    String path = ""; 

	    do {
	        String xname =elt.getParentNode().getNodeName()+"/"+ elt.getTagName() + "[" + getElementIndex(elt) + "]";
	        path = "/" + xname + path;

	        if(elt.getParentNode() != null && elt.getParentNode().getNodeType() == Element.ELEMENT_NODE)
	            elt = (Element) elt.getParentNode();
	        else
	            elt = null;
	    } while(elt != null && !elt.equals(relativeTo));

	    return path;                            
	}

	/**
	 * @param original
	 * @return the index this element is among its siblings, only accounts for siblings with the same tag name as itself. Used for xpath indexing
	 */
	private static int getElementIndex(Element original) {
	    int count = 1;

	    for (Node node = original.getPreviousSibling(); node != null; node = node.getPreviousSibling()) {
	        if (node.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) node;
	            if (element.getTagName().equals(original.getTagName()) && 
	                    (element.getNamespaceURI() == original.getNamespaceURI() || (element.getNamespaceURI() != null && element.getNamespaceURI().equals(original.getNamespaceURI())))) {
	                count++;
	            }
	        }
	    }

	    return count;
	}

	public static void main(String[] args) {
		try {
			String XML = "<Application>\r\n" + "    <Biogen>\r\n"
					+ "	    <title>IOBridge</title>\r\n" + "		<projectID>\r\n" + "		</projectID>\r\n"
					+ "		<startdatetime>2020-01-02T11:19:42+00:00</startdatetime>\r\n"
					+ "		<Subscription>2015</Subscription>\r\n" + "		<Billingdate>2020</Billingdate>\r\n"
					+ "		<BillingID>IOB87654321AW</BillingID>\r\n" + "		<ProductOwner>Vakku</ProductOwner>\r\n"
					+ "		<Getcdrid root=\"ttt\">MRN129786</Getcdrid>\r\n"
					+ "		<Getcdridrepeat>MRN77786</Getcdridrepeat>\r\n" + "		<Datetest>2015</Datetest>\r\n"
					+ "		<Date>1999</Date>\r\n" + "	</Biogen>\r\n" + "	<Biogen>\r\n"
					+ "	    <title>IOBridge</title>\r\n" + "		<projectID>29599</projectID>\r\n"
					+ "		<startdatetime>2020-01-02T11:19:42+00:00</startdatetime>\r\n"
					+ "		<Subscription>2015</Subscription>\r\n" + "		<Billingdate>2020</Billingdate>\r\n"
					+ "		<BillingID>IOB87654321AW</BillingID>\r\n" + "		<ProductOwner>Vakku</ProductOwner>\r\n"
					+ "		<Getcdrid root=\"ttt\">MRN129786</Getcdrid>\r\n"
					+ "		<Getcdridrepeat>MRN77786</Getcdridrepeat>\r\n" + "		<Datetest>2015</Datetest>\r\n"
					+ "		<Date>1999</Date>\r\n" + "	</Biogen>\r\n" + "	<Biogen>\r\n"
					+ "	    <title>IOBridge</title>\r\n" + "		<projectID>29599</projectID>\r\n"
					+ "		<startdatetime>2020-01-02T11:19:42+00:00</startdatetime>\r\n"
					+ "		<Subscription>2015</Subscription>\r\n" + "		<Billingdate>2020</Billingdate>\r\n"
					+ "		<BillingID>IOB87654321AW</BillingID>\r\n" + "		<ProductOwner>Vakku</ProductOwner>\r\n"
					+ "		<Getcdrid root=\"ttt\">MRN129786</Getcdrid>\r\n"
					+ "		<Getcdridrepeat>MRN77786</Getcdridrepeat>\r\n" + "		<Datetest>2015</Datetest>\r\n"
					+ "		<Date>1999</Date>\r\n" + "	</Biogen>\r\n" + "</Application>";

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(new InputSource(new StringReader(XML)));
			doc.getDocumentElement().normalize();

			//System.out.println(doc.getFirstChild().getNodeName());

			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/Application/Biogen/Getcdrid";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				//System.out.println(nNode.getParentNode().getParentNode().getNodeName());
				//if(nodeList.item(i).getNodeType()== Node.ELEMENT_NODE) {
				System.out.println(getElementXPath((Element)nodeList.item(i), doc.getDocumentElement()));
				//}
				//System.out.println(nNode.getBaseURI());
				//System.out.println("\nCurrent Element :" + nNode.getTextContent()); 
				//nNode.setTextContent("koko");
				//System.out.println("\nCurrent Element :" + nNode.getTextContent());
				//System.out.println(nNode.toString());
				/*
				 * 
				 * if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				 * 
				 * Element eElement = (Element) nNode; System.out.println("Student roll no :" +
				 * eElement);
				 * 
				 * System.out.println("First Name : " + eElement
				 * .getElementsByTagName("firstname") .item(0) .getTextContent());
				 * System.out.println("Last Name : " + eElement
				 * .getElementsByTagName("lastname") .item(0) .getTextContent());
				 * System.out.println("Nick Name : " + eElement
				 * .getElementsByTagName("nickname") .item(0) .getTextContent());
				 * System.out.println("Marks : " + eElement .getElementsByTagName("marks")
				 * .item(0) .getTextContent());
				 * 
				 * }
				 */
				
				
				 
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = null;
			try {
				trans = tf.newTransformer();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringWriter sw = new StringWriter();
			try {
				trans.transform(new DOMSource(doc), new StreamResult(sw));
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return sw.toString();
		//System.out.println(sw.toString());
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
