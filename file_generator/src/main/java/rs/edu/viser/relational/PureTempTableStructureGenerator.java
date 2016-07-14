package rs.edu.viser.relational;

import rs.edu.viser.relational.generator.FileGenerator;
import rs.edu.viser.relational.generator.SqlFileGenerator;

public class PureTempTableStructureGenerator implements TempTableStructureGenerator {

	FileGenerator fileGenerator;
	
	public PureTempTableStructureGenerator() {
		this.fileGenerator = new SqlFileGenerator();
	}
	
	@Override
	public void generate() {
		
	}
	
}
