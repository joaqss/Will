package com.joaquinpacete.will.Game.MapLoader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Arrays;

public class GameMap {
    int mapWidth;
    int mapHeight;
    int tileWidth;
    int tileHeight;
    int[] tileNumbers;

    public GameMap() throws IOException {
        InputStream filepath = getClass().getResourceAsStream("/Game/Maps/map1.xml");
        importMap(filepath);
    }

    private void importMap(InputStream filepath)  {


        try {
            // DOM parser, suitable for xml files
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // return a new instance of a DocumentBuilderFactory
            DocumentBuilder builder = factory.newDocumentBuilder(); // return a new instance of a DocumentBuilder
            Document doc = builder.parse(filepath); // return an instance ng document
            NodeList mapData = doc.getElementsByTagName("data"); // will check a tag na may "data" sa xml file

            mapWidth = Integer.parseInt(doc.getDocumentElement().getAttribute("width"));
            mapHeight = Integer.parseInt(doc.getDocumentElement().getAttribute("height"));
            tileWidth = Integer.parseInt(doc.getDocumentElement().getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(doc.getDocumentElement().getAttribute("tileheight"));

            if (mapData.getLength() > 0) {
                Element dataElement = (Element) mapData.item(0); // get the first element
                // remove spaces and new lines and get the text content
                String csvData = dataElement.getTextContent().trim().replaceAll("[\\n\\r\\s]+", "");
                String[] tiles = csvData.split(","); // remove comma and split the string
                tileNumbers = Arrays.stream(tiles).mapToInt(Integer::parseInt).toArray(); // convert to int

                System.out.println("Map Width: " + mapWidth);
                System.out.println("Map Height: " + mapHeight);
                System.out.println("Tile Width: " + tileWidth);
                System.out.println("Tile Height: " + tileHeight);

                // print tileNumbers
                for (int i = 0; i < mapHeight; i++) {
                    for (int j = 0; j < mapWidth; j++) {
                        System.out.print(tileNumbers[i + j] + " ");
                    }
                    System.out.println();
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


    public void drawMap(GraphicsContext gc) {
        InputStream tilesetPath = getClass().getResourceAsStream("/Game/Images/grass.png");
        Image tileset = new Image(tilesetPath, tileWidth, tileHeight, false, false);
        gc.drawImage(tileset, 0, 0, tileWidth, tileHeight, 0, 0, tileWidth, tileHeight);
    }
}
