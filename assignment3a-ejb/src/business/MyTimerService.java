package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {
	@Resource
	TimerService timerService;
	
	private static final Logger logger = Logger.getLogger("business.MyTimerService");
	
	public MyTimerService() {
		
	}

	public void setTimer(long interval) {
		timerService.createTimer(interval, "Setting a programmatic timer");
	}
	
	@Timeout
	public void programmaticTimeout(Timer timer) {
		logger.info("@Timeoug in programmitic timer at " + new java.util.Date());
	}
	
	@Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="Mon-Fri", dayOfMonth="*", month="*", year="*", info="MyTimer")
	private void scheduleTimeout(final Timer t) {
		logger.info("@Schedule timer triggered @ " + new java.util.Date());
	}
	
}
