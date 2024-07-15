package com.joaquinpacete.will.Game.MapLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class GameMap {

    public GameMap() throws IOException {
        InputStream filepath = getClass().getResourceAsStream("/Game/Maps/map1.xml");
        loadMap(filepath);
    }

    private void loadMap(InputStream filepath)  {
        try {
            // DOM parser, suitable for xml files
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // return a new instance of a DocumentBuilderFactory
            DocumentBuilder builder = factory.newDocumentBuilder(); // return a new instance of a DocumentBuilder
            Document doc = builder.parse(filepath); // return an instance ng document
            NodeList mapData = doc.getElementsByTagName("data"); // will check a tag na may "data" sa xml file

            if (mapData.getLength() > 0) {
                Element dataElement = (Element) mapData.item(0); // get the first element
                String csvData = dataElement.getTextContent().trim().replaceAll("[\\n\\r\\s]+", ""); // get the text content of the element
                String[] tiles = csvData.split(","); // remove comma and split the string
                int[] tileNumbers = Arrays.stream(tiles).mapToInt(Integer::parseInt).toArray(); // convert to int

                // print tileNumbers
                for (int i = 0; i < tileNumbers.length; i++) {
                    System.out.println(tileNumbers[i]);
                }
            }
        } catch (ParserConfigurationException e) {
            System.err.println("Parser Configuration Error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("SAX Exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Number Format Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("General Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
