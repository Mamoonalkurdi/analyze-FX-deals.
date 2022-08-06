package com.progresssoft.mamoun.alkurdi.task.resources;

import com.ProgresssSoft.Data.FXdealsResponse;
import com.ProgresssSoft.Data.FXdealsResquest;
import com.progresssoft.DataBase.DataBaseFunctions;
import com.progresssoft.mamoun.alkurdi.task.JakartaRestConfiguration;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;
/**
 *
 * @author Mamoun-Alkurdi
 */
@Path("Service")
public class Service extends JakartaRestConfiguration {

    static final Logger log1 = Logger.getLogger(Service.class);
    @Path("acceptdeals1")
    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @POST
    @Path("/acceptdeals")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FXdealsResponse acceptdeals(FXdealsResquest fXdealsResquest) throws Exception {
        FXdealsResponse fXdealsResponse = new FXdealsResponse();
        DataBaseFunctions DBF = new DataBaseFunctions();
//         DateTimeFormatter timestamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
         java.util.Date date=new java.util.Date();  
        try {
            if (fXdealsResquest.getDealAmount() != null && ! fXdealsResquest.getDealAmount().equals("")
                    && fXdealsResquest.getDealId() != null && ! fXdealsResquest.getDealId().equals("")
                    && fXdealsResquest.getFromCurrency() != null && ! fXdealsResquest.getFromCurrency().equals("")
                    && fXdealsResquest.getToCurrency() != null && ! fXdealsResquest.getToCurrency().equals("")) {
                
               
                
                
                String cur1 = DBF.checkCurrancy(fXdealsResquest.getFromCurrency(),
                         fXdealsResquest.getToCurrency());

                if (cur1.equals("success")) {                

                    fXdealsResquest.setTimestamp(date+"");
                    String status = DBF.acceptdeals(fXdealsResquest);
                    if (status.equals("Successful")) {
                        fXdealsResponse.setErrorCode("200");
                        fXdealsResponse.setErrorMessage("The Deal created Successfully");
                        fXdealsResponse.setStatus("200");
                    } else if (status.equals("java.sql.SQLIntegrityConstraintViolationException: Duplicate entry")) {
                        fXdealsResponse.setErrorMessage("This is Duplicate Deal.");
                        
                    }

                } else {

                    
                    fXdealsResponse.setErrorMessage(cur1);
                    
                    
                }

            } else {
                log1.error("Error : Request can not be null");
                fXdealsResponse.setErrorMessage("All Values is requird.");

            }

        } catch (Exception exception) {

            log1.error("Error :" ,exception);

        }

        return fXdealsResponse;

    }

}
