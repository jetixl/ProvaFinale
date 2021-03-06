package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.sqliteTests.TestCancellazioneHibernateSqlite;
import hibernateClasses.tests.TestCancellazioneHibernate;
import jdbcClasses.sqliteTests.TestCancellazioneJDBCSqlite;
import jdbcClasses.tests.TestCancellazioneJDBC;

public class FactoryTestCancellazione implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestCancellazioneHibernate());
		
		out.add(new TestCancellazioneJDBC());
		
		out.add(new TestCancellazioneHibernateSqlite());
		
		out.add(new TestCancellazioneJDBCSqlite());
		
		return out;
	}

}
