package com.aequilibrium.transformer.app.filter;


import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.common.TransformerFault;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TransformerUnhandledErrorFilter implements Filter {

    private static Log logger = LogFactory.getLog(TransformerUnhandledErrorFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        TransformerError transformerError = null;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (TransformerError te) {
            transformerError = te;
        } catch (Exception exc) {
            if (exc.getCause() instanceof TransformerError) {
                transformerError = (TransformerError) exc.getCause();
            } else {
                logger.error("Unhandled exception caught.", exc);
                transformerError= Util.coordinateException(exc);
            }
        }

        if (transformerError != null) {
            Gson gson = new Gson();
            servletResponse.setContentType(MediaType.APPLICATION_JSON.toString());
            ((HttpServletResponse) servletResponse).setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            TransformerFault bf = new TransformerFault(transformerError.getCode(), transformerError.getParams(), transformerError.getMessage());
            servletResponse.getWriter().write(gson.toJson(bf));
        }
    }

    @Override
    public void destroy() {

    }
    static class Util {

        public static TransformerError coordinateException(Exception exc) {
            return new TransformerError(TransformerErrorStatic.ERROR_TRANSFORMER_GENERAL_INTERNAL_ERROR);
        }
    }


}