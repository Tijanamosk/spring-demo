package eng.demo.inv.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

	Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut(value = "execution(* eng.demo.inv.*.*.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {

		ObjectMapper objectMapper = new ObjectMapper();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().toString();
		Object[] array = joinPoint.getArgs();
		log.info("Method call " + className + " : " + methodName + "() " + "arguments : "
				+ objectMapper.writeValueAsString(array));
		Object object = joinPoint.proceed();
		log.info(className + " : " + methodName + "() " + "Response : " + objectMapper.writeValueAsString(object));
		return object;

	}

}
