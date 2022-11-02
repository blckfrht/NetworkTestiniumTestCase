import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger  implements TestWatcher {


    Log log = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String methodName = context.getDisplayName();
        log.info(methodName + "PASSED");


    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        String methodName = context.getDisplayName();
        String methodFailCause = cause.getMessage();
        log.info(methodName+ "FAILED" + methodFailCause);

    }
}
