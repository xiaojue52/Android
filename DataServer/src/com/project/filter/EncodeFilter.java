package com.project.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	private String encoding = "";
	private boolean enable = false;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		if (this.enable) {
			request.setCharacterEncoding(this.encoding);
		}
		chain.doFilter(request, response);
		//System.out.print(this.encoding);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = arg0.getInitParameter("encoding");
		String able = arg0.getInitParameter("enable");
		if (able.equals("true")) {
			this.enable = true;
		}
	}
}
