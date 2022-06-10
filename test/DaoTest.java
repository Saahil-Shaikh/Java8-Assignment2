import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import trade.LondonDao;
import trade.NewyorkDao;
import trade.TokyoDao;

class DaoTest {

	@Test
	void TestAllDao() {
		TokyoDao td = new TokyoDao();
		LondonDao ld = new LondonDao();
		NewyorkDao nd = new NewyorkDao();
		
		assertAll(
				() -> assertNotNull(td.getDataSource()),
				() -> assertNotNull(ld.getDataSource()),
				() -> assertNotNull(nd.getDataSource())
				);
	}

}
