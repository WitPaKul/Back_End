package Witpakul_back_end.Controllers;

import Witpakul_back_end.Exception.ExceptionRequest;
import Witpakul_back_end.Models.Product;
import Witpakul_back_end.Repositories.Products_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class Image_Controller {
    @Autowired
    private Products_Repository Products_Repository;

    private static final String IMAGE_PATH = "./public/pictures/";



    @GetMapping("/get/{id:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id)  {

        try {
        FileInputStream file  = new FileInputStream(IMAGE_PATH + id  );
        byte[] image = file.readAllBytes();
        file.close();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        } catch(Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
            throw new ExceptionRequest("Image not Found OK Try it again");
        }
        }

    @PostMapping ("/add/{id}")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("id")String id) {

        try {
            // เพราะถ้าไม่ใส่ExceptionRequest ไม่เกิด
            // + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        File myFile = new File(IMAGE_PATH + id );
        System.out.println("Successfully");
        if(myFile.createNewFile()) {
            FileOutputStream fos = new FileOutputStream(myFile);
            fos.write(file.getBytes());
            fos.close();

        }
        return  new ResponseEntity<>("Uploaded Successfully", HttpStatus.OK);
        } catch(Exception e) {

            throw new ExceptionRequest("ADD Image not Found OK Try it again");
        }

    }
//เปลื่ยนทั้งฺbackend และ fronten Test ไม่ต้องใส่ .png
    @PutMapping("/edit/{id:.+}")
    public ResponseEntity<Object> changeImage(@RequestParam("file")MultipartFile file,@PathVariable("id")String id)   {

        try {
            // เพราะถ้าไม่ใส่ExceptionRequest ไม่เกิด
            // + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            FileOutputStream fo = new FileOutputStream(IMAGE_PATH +  id   + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            fo.write(file.getBytes());
            fo.close();
            return  new ResponseEntity<>("Edit Successfully", HttpStatus.OK);
        } catch(Exception e) {

            throw new ExceptionRequest("edit Image not Found OK Try it again");
        }
//        try {
//        String IdString[] = id.split("\\.(?=[^\\.]+$)");
//           int hasId = parseInt(IdString[0]);
//            if(hasFoundId(hasId)){
//                FileOutputStream fo = new FileOutputStream(IMAGE_PATH +  id  + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
//                fo.write(file.getBytes());
//                fo.close();
//                return  new ResponseEntity<>("Change Successfully", HttpStatus.OK);
//            }
//        }  catch(Exception e) {
//
//            throw new ExceptionRequest("edit Image not Found OK Try it again");
//        }
//        return null;

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Object> deleteImage(@PathVariable String id) {
        try{
            File myFile = new File(IMAGE_PATH + id  );
            if(myFile.delete()){
                return new ResponseEntity<>(" Delete Successfully", HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);

        }
        throw new ExceptionRequest("NOT Delete File");


//        File myFile = new File(IMAGE_PATH + id  );
//        myFile.delete();
//
//        System.out.println("OK Successfully");

//            String IdString[] = id.split("\\.(?=[^\\.]+$)");
//            int hasId = parseInt(IdString[0]);
//            if (hasFoundId(hasId)) {
//                File myFile = new File(IMAGE_PATH + id);
//                myFile.delete();
//
//                System.out.println("OK Successfully");
//            } else {
//                System.out.println("NO delete");
//            }
//        return null;
    }


//ใช้เชร็คว่า IDรูปเท่าproductไหม
//    public boolean hasFoundId(int id){
//        List<Product> product = Products_Repository.findAll();
//        for (int i = 0; i < product.size(); i++) {
//            if(product.get(i).getProduct_code() == id){
//                return true;
//            }
//        }
//        return false;
//    }

}
