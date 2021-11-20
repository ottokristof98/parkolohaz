package service;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Exceptiondata;
import model.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExceptionDataService {
    
    /**Kilistázza az összes kivételt, bizonyos lépésközzel.
    * @param page 20 darabot listáz az itt megadott szám * 20-as kezdőértéktől.
    */
    public List<Exceptiondata> getAllException(Integer page){
        Integer start = (page - 1) * 20;//TODO: db-hez igazítani
        List<Exceptiondata> data = new ArrayList<>();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File(Exceptiondata.exceptionXmlFilename);
            Document xml = db.parse(f);
            NodeList nodes = xml.getElementsByTagName("exception");
            for(Integer i = 0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
                Element ex = (Element)node;
                Integer exceptiondataid = Integer.parseInt(ex.getElementsByTagName("exceptiondataid").item(0).getTextContent());
                SimpleDateFormat formatter5 = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
                //Timestamp ts = Timestamp.valueOf(ex.getElementsByTagName("createdon").item(0).getTextContent());
                Date createdon =  Calendar.getInstance().getTime();//formatter5.parse(ex.getElementsByTagName("createdon").item(0).getTextContent());
                String groupname = ex.getElementsByTagName("groupname").item(0).getTextContent();
                String stacktrace = ex.getElementsByTagName("stacktrace").item(0).getTextContent();
                String description = ex.getElementsByTagName("description").item(0).getTextContent();
                //String state = ex.getElementsByTagName("state").item(0).getTextContent();
                Exceptiondata exData = new Exceptiondata(exceptiondataid, createdon, groupname, stacktrace, description);
                data.add(exData);
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return data;
    }
    
    public Exceptiondata getOneException(Integer id){
        Exceptiondata exd = new Exceptiondata();
        try{
            List<Exceptiondata> data = this.getAllException(1);
            for(Exceptiondata e : data){
                if(e.getExceptiondataid().equals(id)){
                    exd = e;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return exd;
    }
    
    public void createException(Exceptiondata ex){
        try{
            //String filename = Exceptiondata.exceptionXmlFilename;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File(Exceptiondata.exceptionXmlFilename);
            Document xml = db.parse(f);
            Element exceptions = (Element)xml.getFirstChild();
            Element exception = xml.createElement("exception");
            
            Element createdon = xml.createElement("createdon");
            Element groupname = xml.createElement("groupname");
            Element stacktrace = xml.createElement("stacktrace");
            Element description = xml.createElement("description");
            Element exceptiondataid = xml.createElement("exceptiondataid");
            
            createdon.setTextContent(ex.getCreatedon().toString());
            groupname.setTextContent(ex.getGroupname());
            stacktrace.setTextContent(ex.getStacktrace());
            description.setTextContent(ex.getDescription());
            exceptiondataid.setTextContent(ex.getExceptiondataid().toString());
            
            exception.appendChild(createdon);
            exception.appendChild(groupname);
            exception.appendChild(stacktrace);
            exception.appendChild(description);
            exception.appendChild(exceptiondataid);
            
            
            Element state = xml.createElement("state");
            exception.appendChild(state);
            for(Integer i = 0; i < ex.getStateSize(); i++){
                Item item = ex.getState(i);
                Element stKey = xml.createElement("stateElementKey");
                stKey.setTextContent(item.key);
                state.appendChild(stKey);
                Element stValue = xml.createElement("stateElementValue");
                stValue.setTextContent(String.valueOf(item.value));
                state.appendChild(stValue);
            }
            
            exceptions.appendChild(exception);
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(f);
            t.transform(source, result);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public Boolean save(Integer id, String newDescription){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File(Exceptiondata.exceptionXmlFilename);
            Document xml = db.parse(f);
            NodeList nodes = xml.getElementsByTagName("exception");
            for(Integer i = 0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
                Element ex = (Element)node;
                Integer exceptiondataid = Integer.parseInt(ex.getElementsByTagName("exceptiondataid").item(0).getTextContent());
                if(exceptiondataid.equals(id)){
                    SimpleDateFormat formatter5 = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
                    //Timestamp ts = Timestamp.valueOf(ex.getElementsByTagName("createdon").item(0).getTextContent());
                    Date createdon =  Calendar.getInstance().getTime();//formatter5.parse(ex.getElementsByTagName("createdon").item(0).getTextContent());
                    String groupname = ex.getElementsByTagName("groupname").item(0).getTextContent();
                    String stacktrace = ex.getElementsByTagName("stacktrace").item(0).getTextContent();
                    String description = ex.getElementsByTagName("description").item(0).getTextContent();
                    //String state = ex.getElementsByTagName("state").item(0).getTextContent();
                    Exceptiondata exData = new Exceptiondata(exceptiondataid, createdon, groupname, stacktrace, description);
                    exData.setDescription(newDescription);
                    ex.getElementsByTagName("description").item(0).setTextContent(exData.getDescription());
                }
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(f);
            t.transform(source, result);
            return Boolean.TRUE;
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return Boolean.FALSE;
    }
    
}
