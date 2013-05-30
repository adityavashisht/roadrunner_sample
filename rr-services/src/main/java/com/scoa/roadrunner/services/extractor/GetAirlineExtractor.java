package com.scoa.roadrunner.services.extractor;

import com.scoa.roadrunner.common.dto.KeyValueDropDown;
import org.springframework.ws.client.core.SourceExtractor;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 */
public class GetAirlineExtractor implements SourceExtractor {


    /**
     *
     * @param source
     * @return
     * @throws IOException
     * @throws TransformerException
     */
    @Override
    public Object extractData(Source source) throws IOException, TransformerException {
        DOMSource domSource = (DOMSource) source;
        Node node = domSource.getNode();
        NodeList nodeList = node.getFirstChild().getFirstChild().getChildNodes();
        List<KeyValueDropDown> keyValueDropDowns = new ArrayList<>();
        if (nodeList.getLength() != 0) {
            int length = nodeList.getLength();
            for (int index = 0; index <= length; index++) {
                Node value = nodeList.item(index);
                if (value != null && "AirLine".equals(value.getNodeName())) {
                    NamedNodeMap attributeMap = value.getAttributes();
                    String airline = attributeMap.getNamedItem("Airline").getNodeValue();
                    String id = attributeMap.getNamedItem("id").getNodeValue();
                    KeyValueDropDown dropDown = new KeyValueDropDown(id,airline);
                    keyValueDropDowns.add(dropDown);
                }
            }
        }
        return keyValueDropDowns;
    }
}
