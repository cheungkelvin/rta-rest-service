package kel.datapower.rta;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RTAController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("**/v1/accounts/{accountId}/products/{loanId}/rlp")
    public Greeting greeting(
    		@PathVariable("accountId") String accountId,
    		@PathVariable("loanId") String loanId
    		) {

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, accountId));
    }
}
