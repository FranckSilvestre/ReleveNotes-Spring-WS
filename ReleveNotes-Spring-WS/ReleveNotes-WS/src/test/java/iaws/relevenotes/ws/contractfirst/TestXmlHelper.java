package iaws.relevenotes.ws.contractfirst;

import junit.framework.TestCase;
import org.w3c.dom.Element;

/**
 * @author franck Silvestre
 */
public class TestXmlHelper extends TestCase {

    private static final String filePath = "ReleveNotes.xml";

    public void testGetRootElementFromFileInClasspath() {
        try {
            Element  element = XmlHelper.getRootElementFromFileInClasspath(filePath);
            assert element != null;
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }



    }
}
