package au.edu.unsw.soacourse.topdownclient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MarketServiceController {

   // TODO: Add the TopDownSimpleService interface as a member of the controller
   
   @RequestMapping("/importMarket")
   public String processImportMarketData(ModelMap model) throws Exception {
      // TODO: Add the creation of an impoartMarketData request type and populate it
	   
      // TODO: Call the web service      
      
      // TODO: Replace null with the results from the web service response.
      model.addAttribute("returnData", null);
      
      // View we are returning to, in this case processImportMarketData.jsp 
      return "processImportMarketData";
   }

   @RequestMapping("/downloadFile")
   public String processDownloadFile(ModelMap model) throws Exception {
      // TODO: Add the creation of a DownloadFile request type and populate it

      // TODO: Call the web service      
      
      // TODO: Replace null with the results from the web service response.
      model.addAttribute("returnData", null);
      
      // View we are returning to, in this case processImportMarketData.jsp 
      return "processDownloadFile";
   }

}