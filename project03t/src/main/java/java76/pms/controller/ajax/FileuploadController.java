package java76.pms.controller.ajax;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.Board;
import java76.pms.util.MultipartHelper;

@Controller("ajax.FileuploadController")
@RequestMapping("/fileupload/ajax/*")
public class FileuploadController { 
  
  public static final String SAVED_DIR = "/attachfile";
  @Autowired ServletContext servletContext;
      
  @RequestMapping(value="add", method=RequestMethod.POST)
  public AjaxResult add(Board board, @RequestParam("files") MultipartFile[] files) throws Exception {
    ArrayList<String> filenames = new ArrayList<>();
    
    for (MultipartFile file : files) {
      if (file.getSize() > 0) {
        String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
        File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
                                    + "/" + newFileName);
        file.transferTo(attachfile);
        filenames.add(newFileName);
      }
    }
    
    return new AjaxResult("success", filenames);
  }
 
}
