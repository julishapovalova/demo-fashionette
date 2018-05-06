import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.service.ReportPortal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.screenshot;


public class ListenerClass extends TestListenerAdapter {
    final static Logger LOGGER = LoggerFactory.getLogger(ListenerClass.class);

    @Override
    public void onTestStart(ITestResult tr) {
//        String path = screenshot(tr.getMethod().getMethodName() + "Start");
//        File file = new File(path);
//        LOGGER.error(String.valueOf(ReportPortal.emitLog("Test" + tr.getMethod().getMethodName() + " failed", "ERROR", Calendar.getInstance().getTime(), file)));
        LOGGER.info("Test start" + tr.getMethod().getMethodName() + " start");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        LOGGER.info("Test " + tr.getMethod().getMethodName() + " finished success");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        String path = screenshot(tr.getMethod().getMethodName() + "Failed");
        File file = new File(path);
        ReportPortal.emitLog("Test " + tr.getMethod().getMethodName() + " failed", "FATAL", Calendar.getInstance().getTime(), file);
        LOGGER.info(String.valueOf(ReportPortal.emitLog("Test " + tr.getMethod().getMethodName() + " failed", "FATAL", Calendar.getInstance().getTime(), file)));
        LOGGER.info("Test " + tr.getMethod().getMethodName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        String path = screenshot(tr.getMethod().getMethodName() + "Skipped");
        File file = new File(path);
        LOGGER.info(String.valueOf(ReportPortal.emitLog("Test" + tr.getMethod().getMethodName() + " skipped", "INFO", Calendar.getInstance().getTime(), file)));
    }
}

