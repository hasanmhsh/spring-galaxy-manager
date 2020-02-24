package galaxy.manager.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class FPLController {
    
    @GetMapping(value="/fpl", produces =  {"application/json"})//?callsign=xxxx&ssr-code=xxxx&from=yyyy-mm-dd_hh:mm&to=yyyy-mm-dd_hh:mm&q=xxxx&columns=col1,col2,col3...&order-by=col1,col,col...
    public ResponseEntity<?> getMethodName(
        @RequestParam(value = "callsign",required = false, defaultValue = "") String callsign,
        @RequestParam(value = "ssr-code",required = false, defaultValue = "") String ssrCode,
        @RequestParam(value = "from",required = false, defaultValue = "1970-01-01_00:00") String from,
        @RequestParam(value = "to",required = false, defaultValue = "now") String to,
        @RequestParam(value = "q",required = false, defaultValue = "") String query,
        @RequestParam(value = "columns",required = false, defaultValue = "") String [] columns,
        @RequestParam(value = "order-by",required = false, defaultValue = "callsign,ssr-code") String orderBy[]
    ) {

        System.out.println("callsign : "+callsign);
        System.out.println("ssr-code : " + ssrCode);
        System.out.println("from : " + from);
        System.out.println("to : " + to);
        System.out.println("q : " + query);
        System.out.println("columns");
        if(columns != null){
            for(int i = 0 ; i < columns.length ; i++){
                System.out.println("  col"+String.valueOf(i)+" : "+columns[i]);
            }
        }

        System.out.println("order-by");
        if(orderBy != null){
            for(int i = 0 ; i < orderBy.length ; i++){
                System.out.println("  col"+String.valueOf(i)+" : "+orderBy[i]);
            }
        }

        return new ResponseEntity<>("message:hello",HttpStatus.OK);
    }
    
}