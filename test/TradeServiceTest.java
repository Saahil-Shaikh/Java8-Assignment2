import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import trade.LondonDao;
import trade.Region;
import trade.RegionalDao;
import trade.RegionalDaoManager;
import trade.TokyoDao;
import trade.TradeDetails;
import trade.TradeService;

@ExtendWith(MockitoExtension.class)
class TradeServiceTest {
	
    private static TradeService tradeService;

    @InjectMocks
    private TradeService mockTradeService;

    @Mock
    private RegionalDao regionalDao;

    @Mock
    private RegionalDaoManager regionalDaoManager;


    @Mock
    private TradeDetails tradeDetails;
	
	@Spy
    private TradeService spyTradeService = new TradeService();

    @InjectMocks
    private TradeService tradeServiceMock;
	
	@BeforeAll
	public static void init() {
		tradeService = new TradeService();
	}

	@Test
	public void getTradeRegionReturnLondon() {

		assertEquals(tradeService.getTradeRegion(121456903), Region.LONDON);
	}

	@Test
	public void getTradeRegionReturnNewYork() {

		assertEquals(tradeService.getTradeRegion(12232140), Region.NEWYORK);
	}

	@Test
	public void getTradeRegionReturnTokyo() {

		assertEquals(tradeService.getTradeRegion(12345678), Region.TOKYO);
	}

	@Test
	public void getTradeRegionFails() {

		assertThrows(IllegalArgumentException.class, () -> tradeService.getTradeRegion(12045678));
	}


}
