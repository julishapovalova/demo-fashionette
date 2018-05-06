import com.codeborne.selenide.Selenide;
import com.epam.reportportal.service.ReportPortal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.screenshot;


public class CustomListener extends TestListenerAdapter {
    final static Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

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
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String path = screenshot(tr.getMethod().getMethodName() + timeStamp);
        File file = new File(path);
        ReportPortal.emitLog("Test " + tr.getMethod().getMethodName() + " failed", "FATAL", Calendar.getInstance().getTime(), file);
        LOGGER.info("Test " + tr.getMethod().getMethodName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        LOGGER.info("Test" + tr.getMethod().getMethodName() + " skipped");
    }
}

