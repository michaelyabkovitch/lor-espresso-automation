package UsefulClasses;

import com.sun.org.glassfish.gmbal.Description;

import java.io.File;

public class DirChecker {
    @Description("check if the directory of the records exist, and create new records directory")
    public void dirCreator() {
        File dir = new File("./records");
        if (!dir.exists()){
            dir.mkdir();
        }
    }
}
