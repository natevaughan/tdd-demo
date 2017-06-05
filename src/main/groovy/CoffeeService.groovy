import groovy.transform.CompileStatic

/**
 * Created by nate on 6/5/17
 */
@CompileStatic
class CoffeeService {

    ContestWinnerService contestWinnerService
    NotificationService emailService

    static final double COST_PER_CUP = 2.15
    static final double DISCOUNT = 0.10

    Double calculateCost(Integer i) {
        if (!i) {
            return
        }

        for (int j = 0; j < i; ++j) {
            if (contestWinnerService.incrementAndGetWinner()) {
                // a bunch of other business logic
                emailService.sendNotification("Congrats! The ${j + 1} cup of coffee was a winner!")

            }

        }

        return i * COST_PER_CUP - DISCOUNT
    }
}
