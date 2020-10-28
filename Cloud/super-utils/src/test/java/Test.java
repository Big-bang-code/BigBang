import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Test {

    Logger logger = LoggerFactory.getLogger(getClass());

    @org.junit.Test
    public void contextLoads(){
        logger.trace("trace日志");
        logger.debug("bug日志");
        logger.info("info日志");
        logger.warn("warn日志");
        logger.error("error日志");
    }



}
