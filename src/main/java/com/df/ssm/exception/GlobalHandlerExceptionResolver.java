package com.df.ssm.exception;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import com.df.ssm.R;

/**
 * 全局异常处理
 * @author J.L.Zhou
 *
 */
@ControllerAdvice
public class GlobalHandlerExceptionResolver  {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public R handler(Exception ex,HttpServletRequest request){
		R r;
		RequestContext rc = new RequestContext(request);
		if(ex instanceof CodeException){
			CodeException e = (CodeException)ex;
			e.setMessage(rc.getMessage("code."+e.getCode()));
			r = R.error(e.getCode(), e.getMessage());
		}else{
			r = R.error(-1, rc.getMessage("code.0"));
		}
		logger.warn("web全局异常", ex);
		return r;
	}
	

}
