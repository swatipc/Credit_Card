package creditcard;
import java.io.File;

public interface FileParsingStrategy {
	
	public CardHandler validCardHandler = new ValidCardHandler();
	
	public void parseFile(File inputFile, File opFile, String opFile_name);
}
