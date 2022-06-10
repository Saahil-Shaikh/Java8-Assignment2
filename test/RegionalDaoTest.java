import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ds.MySqlDataSource;
import trade.RegionalDao;
import trade.TradeDetails;

@ExtendWith(MockitoExtension.class)
class RegionalDaoTest {

	
	@Mock public RegionalDao regionalDao;
	 

	@Mock
	public Connection con;

	@Mock
	public PreparedStatement ps;

	@Mock
	public ResultSet rs;

	@Test
	public void getTradeDetailsFailsRuntime() {
		RegionalDao regionalDao = Mockito.mock(RegionalDao.class);
		Mockito.when(regionalDao.getTradeDetails(Mockito.anyLong())).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, () -> regionalDao.getTradeDetails(1111111));
	}
	
	@Test
	public void getTradeDetailsPasses() throws SQLException {
		Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenReturn(new TradeDetails());
        TradeDetails tradeDetails = regionalDao.getTradeDetails(12345678);
        assertNotNull(tradeDetails);
		
	};

}
