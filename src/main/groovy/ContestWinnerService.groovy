/**
 * Created by nate on 6/5/17
 */
class ContestWinnerService {

    private static final long MAGIC_NUMBER = 100000L
    long globalCount = 0

    synchronized boolean incrementAndGetWinner() {
        ++globalCount
        return globalCount == MAGIC_NUMBER
    }
}
