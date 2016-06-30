package au.edu.unsw.soacourse.marketservice;

import javax.jws.WebService;

@WebService(endpointInterface = "au.edu.unsw.soacourse.marketservice.TopDownSimpleService")
public class TopDownSimpleServiceImpl implements TopDownSimpleService {
	
	ObjectFactory factory = new ObjectFactory();
	
    public ImportMarketDataResponse importMarketData(ImportMarketDataRequest parameters)  
    		throws ImportMarketFaultMsg {
    	
    	if (parameters.getSec().length() != 3) {
    		//assume that we only want a SEC value of length 3
    		String msg = "SEC code should be exactly 3 characters long";
    		String code= "ERR_SEC";
    		
    		//TODO: SOAP Fault handling should come here ...
    		//TODO: create a ServieFaultType 'fault' from ObjectFactory
    		//TODO: prepare 'fault' object: set errorcode and errortext
    		//TODO: throw new importMarketFaultMsg(msg,fault)
    	}
    	
    	StringBuilder sbf = new StringBuilder();
    	sbf.append("Security Code: ").append(parameters.sec).append("\r\n");
    	sbf.append("Start date: ").append(parameters.startDate).append("\r\n");
    	sbf.append("End date: ").append(parameters.endDate).append("\r\n");
    	sbf.append("Data source: ").append(parameters.dataSource).append("\r\n");

    	ImportMarketDataResponse res = factory.createImportMarketDataResponse();
    	res.returnData = sbf.toString();
    	return res;

  }

    public DownloadFileResponse downloadFile(DownloadFileRequest parameters) 
    		throws DownloadFileFaultMsg {
   
    	if (!parameters.getEventSetID().equals("abc-abc-111")) {
    		//assume that we only know about an eventSetId abc-abc-111
    		String msg = "Unknonw eventSetId was given";
    		String code = "ERR_EVENT";
 
       		//TODO: SOAP Fault handling should come here ...
    		//TODO: create a ServieFaultType 'fault' from ObjectFactory
    		//TODO: prepare 'fault' object: set errorcode and errortext
    		//TODO: throw new DownloadFaultMsg(msg,fault)
    	}
    	
    	DownloadFileResponse res = factory.createDownloadFileResponse();
    	res.returnData = "EventSet Id: " + parameters.eventSetID;	
    	return res; 	
    }
}
