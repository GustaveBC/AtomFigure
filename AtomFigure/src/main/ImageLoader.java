package main;

import java.net.URL;
import java.io.File;
import javax.swing.ImageIcon;

class ImageLoader {
    
    public static ImageIcon getImage(String filename) {

        // will be either 'file' when running from disk, or 'jar' when running from jar
        String protocol = ImageLoader.class.getResource("ImageLoader.class").getProtocol();

        // file:///path/to/Elements.class
        // jar:///path/to/Elements.class

        if (protocol == "file") {
            // works - when running in VS code, and files must exist on disk and at the right place
            String path = System.getProperty("user.dir") + "/AtomFigure/img/" + filename;

            // warn if not found
            if (!(new File(path).exists())) {
                System.out.println("File not found: " + path);
            }
            else {
                return new ImageIcon(path);
            }
        }
        else if (protocol == "jar") {
            // works - when running the jar, and files must exist on disk and at the right place
            //path = System.getProperty("user.dir") + "/img/" + filename;

            // way better - get the image straight from inside the JAR
            String path = "img/" + filename;
            URL url = this.getClass().getResource(path);

            // warn if not found
            if (url == null) {
                System.out.println("Resource not found: " + path);
            }
            else {
                return new ImageIcon(url);
            }

        }
        else {
            System.out.println("Unsupported protocol: " + protocol);
        }     

        // return a dummy, empty image
        return new ImageIcon("");
    }
}
