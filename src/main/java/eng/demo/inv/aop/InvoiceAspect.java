//package eng.demo.inv.aop;
//
//import java.util.Date;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import eng.demo.inv.dto.InvoiceDto;
//
//@Aspect
//@Component
//public class InvoiceAspect {
//
//	@Before(value = "execution(* eng.demo.inv.controller.InvoiceController.*(..))")
//	public void beforeAdvice(JoinPoint joinPoint) {
//
//		System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
//
//	}
//
//	@After(value = "execution(* eng.demo.inv.controller.InvoiceController.*(..))")
//	public void afterAdvice(JoinPoint joinPoint) {
//
//		System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
//
//	}
//
//	@Before(value = "execution(* eng.demo.inv.service.InvoiceService.*(..))")
//	public void beforeAdviceForService(JoinPoint joinPoint) {
//
//		System.out.println("Request to service layer " + joinPoint.getSignature() + " started at " + new Date());
//
//	}
//
//	@After(value = "execution(* eng.demo.inv.service.InvoiceService.*(..))")
//	public void afterAdviceForService(JoinPoint joinPoint) {
//
//		System.out.println("Request to service layer " + joinPoint.getSignature() + " ended at " + new Date());
//
//	}
//
//	@AfterReturning(value = "execution(* eng.demo.inv.service.InvoiceService.createInvoice(..))", returning = "invoice")
//	public void afterReturningAdviceForCreateInvService(JoinPoint joinPoint, InvoiceDto invoice) {
//
//		System.out.println("Invoice is saved with Id " + invoice.getId() + new Date());
//
//	}
//
//	@AfterThrowing(value = "execution(* eng.demo.inv.service.InvoiceService.createInvoice(..))", throwing = "exception")
//	public void afterThrowingAdviceForCreateInvService(JoinPoint joinPoint, Exception exception) {
//
//		System.out.println("To save an invoice throw an exception " + exception.getMessage() + new Date());
//
//	}
//	
//	@Around(value = "execution(* eng.demo.inv.service.InvoiceService.createInvoice(..))")
//	public InvoiceDto aroundAdviceForCreateInvService(ProceedingJoinPoint joinPoint) {
//
//		System.out.println("Inside Around Advice in Aspect : To save an invoice started at " + new Date());
//		InvoiceDto invoice = null;
//		try {
//			 invoice=  (InvoiceDto)joinPoint.proceed();
//			
//		}catch(Throwable e) {
//			System.out.println("Around Advice in Aspect : to save an invoice failed  " + e.getMessage());
//		}
//		
//		System.out.println("Inside Around Advice in Aspect : To save an invoice ended at " + new Date());
//		return invoice;
//	}
//	
//	
//
//}
