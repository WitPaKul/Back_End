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

    private static final String IMAGE_PATH = "./pictures/";

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
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("id")String id) throws IOException{

            if (file.getOriginalFilename() == "") {
                throw new ExceptionRequest("ADD Image not Found OK Try it again");
            }
        File myFile = new File(IMAGE_PATH + id );
        System.out.println("Successfully");
        if(myFile.createNewFile()) {
            FileOutputStream fos = new FileOutputStream(myFile);
            fos.write(file.getBytes());
            fos.close();

        }
        return  new ResponseEntity<>("Uploaded Successfully", HttpStatus.OK);

    }

    @PutMapping("/edit/{id:.+}")
    public ResponseEntity<Object> changeImage(@RequestParam("file")MultipartFile file,@PathVariable("id")String id)   {

        try {

            FileOutputStream fo = new FileOutputStream(IMAGE_PATH +  id   + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            fo.write(file.getBytes());
            fo.close();
            return  new ResponseEntity<>("Edit Successfully", HttpStatus.OK);
        } catch(Exception e) {

            throw new ExceptionRequest("edit Image not Found OK Try it again");
        }

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

    }

}
