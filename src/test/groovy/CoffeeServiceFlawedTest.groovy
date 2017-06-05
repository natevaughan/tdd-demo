import groovy.transform.CompileStatic
import org.junit.Test

import static org.junit.Assert.*

/**
 * Created by nate on 6/5/17
 */
@CompileStatic
class CoffeeServiceFlawedTest {

    @Test
    void notAWinnerTest() {
        CoffeeService coffeeService = new CoffeeService()
        coffeeService.contestWinnerService = new ContestWinnerService()
        coffeeService.emailService = new EmailService()
        Double price = coffeeService.calculateCost(5)
        assertNotNull(price)
    }

    @Test
    void winnerTest() {
        CoffeeService coffeeService = new CoffeeService()
        coffeeService.contestWinnerService = new ContestWinnerService()
        coffeeService.emailService = new EmailService()
        Double price = coffeeService.calculateCost(42)
        assertNotNull(price)
    }

}
