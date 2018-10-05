package clientWS;

import java.math.BigInteger;
import java.util.*;

import com.cdyne.ws.IP2Geo;
import com.cdyne.ws.IP2GeoSoap;
import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;

public class Finder {

	public static void main(String[] args) {	

	}
	
	public String findGeo(String inputStr) {
		String result = new String();
		IP2Geo ipgeo = new IP2Geo(); 
		IP2GeoSoap ipgeoSOAP = ipgeo.getIP2GeoSoap();
        String city = ipgeoSOAP.resolveIP(inputStr, "").getCity();
        result = city;
        return result;
	}
	
	public String convert2word(String inputStr) {
		BigInteger input_N = new BigInteger(inputStr);
		NumberConversion NC_service = new NumberConversion(); //created service object
        NumberConversionSoapType NC_serviceSOAP = NC_service.getNumberConversionSoap(); //create SOAP object (a port of the service)
        String result = NC_serviceSOAP.numberToWords(input_N);  
        return result;
	}
}
