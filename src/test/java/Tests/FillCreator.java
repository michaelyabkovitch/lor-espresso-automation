package Tests;
import Pages.PageObject;

import java.io.File;


//this claas  check if fill exists and if not he create one
public class FillCreator  {
    public  void Creator (File theDir){
        if (!theDir.exists()){
            theDir.mkdirs();
            System.out.println("fill record created ");
        }

    }
}
