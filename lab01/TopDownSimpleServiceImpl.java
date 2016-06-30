package au.edu.unsw.soacourse.topdown;

import javax.jws.WebService;

@WebService(endpointInterface = "au.edu.unsw.soacourse.topdown.TopDownSimpleService")
public class TopDownSimpleServiceImpl implements TopDownSimpleService {
	
    //TODO: create an ObjectFactory
	
    public ImportMarketDataResponse importMarketData(ImportMarketDataRequest req) {

    //TODO: create and set ImportMarketResponse object 

      //  StringBuilder sbf = new StringBuilder();
      //  sbf.append("Security Code: ").append(req.sec).append("\r\n");
      //  sbf.append("Start date: ").append(req.startDate).append("\r\n");
      //  sbf.append("End date: ").append(req.endDate).append("\r\n");
      //  sbf.append("Data source: ").append(req.dataSource).append("\r\n");

   //TODO: return the above as response data
        
    }

    public DownloadFileResponse downloadFile(DownloadFileRequest req) {
        
      //TODO: create and set ImportMarketResponse object and return the following as response data
      // "EventSet Id: " + req.eventSetId;
    	
    }
}
