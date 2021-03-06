/*
 * Password Management Servlets (PWM)
 * http://www.pwm-project.org
 *
 * Copyright (c) 2006-2009 Novell, Inc.
 * Copyright (c) 2009-2016 The PWM Project
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package password.pwm.http.tag;

import password.pwm.PwmApplication;
import password.pwm.http.ContextManager;
import password.pwm.http.PwmSession;
import password.pwm.http.PwmSessionWrapper;
import password.pwm.util.java.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Jason D. Rivard
 */
public class UserInfoTag extends TagSupport {
// ------------------------------ FIELDS ------------------------------

    private String attribute;

// --------------------- GETTER / SETTER METHODS ---------------------

    public void setAttribute(final String attribute)
    {
        this.attribute = attribute;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Tag ---------------------

    public int doEndTag()
            throws JspTagException
    {
        try {
            final HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
            final PwmSession pwmSession = PwmSessionWrapper.readPwmSession(req);
            final PwmApplication pwmApplication = ContextManager.getPwmApplication(req);
            final String ldapValue = pwmSession.getSessionManager().getUserDataReader(pwmApplication).readStringAttribute(attribute);
            pageContext.getOut().write(StringUtil.escapeHtml(ldapValue == null ? "" : ldapValue));
        } catch (Exception e) {
            throw new JspTagException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}

