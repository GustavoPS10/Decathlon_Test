package DECATHLON.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

public class App_Main {

	public static void main(String[] args) throws Exception {
		Xml_output c3 = new Xml_output();
		c3.xml_creation();
		System.out.println("XML generated");
		System.out.println("Done");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = (Document) db.parse(new FileInputStream(new File("results_OUTPUT.xml")));
		prettyPrint(doc);

	}

	public static final void prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource((Node) xml), new StreamResult(out));
		System.out.println(out.toString());
	}

}
