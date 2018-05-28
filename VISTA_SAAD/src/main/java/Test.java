
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erik
 */
public class Test {
    public static void main(String[] args) {
        String path = Test.class.getClassLoader().getResource(".").getPath();
        File f = new File(path);
        do{
            String parent = f.getParent();
            f = new File(parent);
        }while(!"VISTA_SAAD".equals(f.getName()));
        System.out.println(f.getAbsolutePath());
        
        File res = new File(f.getAbsolutePath() + "/src/main/webapp/resources/");
        
    }
}
