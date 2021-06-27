package creditcard;

import java.io.FileWriter;
import java.util.Map;

public interface CardHandler {
	
	HandlerResult handle(Map<String, String> cardDetails, FileWriter csvwriter);

}
