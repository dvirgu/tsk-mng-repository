package org.tsk.mng.frontend.filters;


import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedRequestWrapper extends HttpServletRequestWrapper {
	private final static Logger logger = Logger.getLogger(BufferedRequestWrapper.class);

    ByteArrayInputStream bais;
    ByteArrayOutputStream baos;
    BufferedServletInputStream bsis;
    byte[] buffer;

    public BufferedRequestWrapper(HttpServletRequest req) throws IOException {
        super(req);
// Read InputStream and store its content in a buffer.
        InputStream is = req.getInputStream();
        baos = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int letti;
        while ((letti = is.read(buf)) > 0) baos.write(buf, 0, letti);
        buffer = baos.toByteArray();
    }

    public ServletInputStream getInputStream() {
        try {
// Generate a new InputStream by stored buffer
            bais = new ByteArrayInputStream(buffer);
// Instantiate a subclass of ServletInputStream
// (Only ServletInputStream or subclasses of it are accepted by the servlet engine!)
            bsis = new BufferedServletInputStream(bais);
        }
        catch (Exception ex) {
            logger.error(ex);
        }
        finally {
            return bsis;
        }
    }

}
