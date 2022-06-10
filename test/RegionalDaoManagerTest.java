import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;
import trade.Region;
import trade.RegionalDaoManager;

@ExtendWith(MockitoExtension.class)
class RegionalDaoManagerTest {
	
	public static RegionalDaoManager manager;

	
	@BeforeAll
	public static void init() {
		manager = new RegionalDaoManager();
	}

	@Test
	void getRegionalDaoReturnsLondonDao() {
		 
		assertEquals(manager.getRegionalDao(Region.LONDON).getClass().getSimpleName() , "LondonDao");
		
	}
	
	@Test
	void getRegionalDaoReturnsTokyoDao() {
		 
		assertEquals(manager.getRegionalDao(Region.TOKYO).getClass().getSimpleName() , "TokyoDao");
		
	}
	
	@Test
	void getRegionalDaoReturnsNewyorkDao() {
		 
		assertEquals(manager.getRegionalDao(Region.NEWYORK).getClass().getSimpleName() , "NewyorkDao");
		
	}
	
	@Test
	public void getRegionalDaoFails() {
		assertThrows(IllegalArgumentException.class, () -> manager.getRegionalDao(Region.valueOf("False Value")));
	}
	
	

}
