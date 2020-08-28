import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class JavaOpenFile 
{

    public static void main(String[] args) throws IOException 
    {
        //text file, should be opening in default text editor
        File file = new File("D:/programming/avl_trees/avl_trees_using_recursion/avlMain.java");
        
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported())
        {
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        //if(file.exists()) desktop.open(file);
        
        //let's try to open PDF file
        
        //if(file.exists()) desktop.open(file);

        //now to get boolean value for whether the file is readable or not
        System.out.println("readable :"+file.canRead());
        //now to get boolean value for whether the file is writeable or not
        System.out.println("writeable :"+file.canWrite());
        //file size in bytes
        System.out.println("file  size in bytes :"+file.length());
        //absolute path
        System.out.println("Absolute path :"+file.getAbsolutePath());

    }

}