import org.junit.Test

import static org.junit.Assert.*
import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.verifyZeroInteractions
import static org.mockito.Mockito.when

/**
 * Created by nate on 6/5/17.
 */
class CoffeeServiceTest {

    @Test
    void notAWinnerTest() {

        CoffeeService coffeeService = new CoffeeService()

        coffeeService.contestWinnerService = mock(ContestWinnerService.class)
        coffeeService.emailService = mock(NotificationService.class)

        Double cost = coffeeService.calculateCost(5)
        assertNotNull("it should return a cost", cost)
        verifyZeroInteractions(coffeeService.emailService)
    }


    @Test
    void winnerTest() {
        CoffeeService coffeeService = new CoffeeService()
        coffeeService.contestWinnerService = mock(ContestWinnerService.class)
        coffeeService.emailService = mock(NotificationService.class)

        when(coffeeService.contestWinnerService.incrementAndGetWinner()).thenReturn(true)

        coffeeService.calculateCost(1)
        verify(coffeeService.emailService).sendNotification(anyString())
    }
}
