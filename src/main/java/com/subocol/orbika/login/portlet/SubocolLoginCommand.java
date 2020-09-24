package com.subocol.orbika.login.portlet;

import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.subocol.orbika.login.constants.SubocolLoginPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + SubocolLoginPortletKeys.SUBOCOLLOGIN,
		"mvc.command.name=/login" }, service = MVCActionCommand.class)
public class SubocolLoginCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		String login = ParamUtil.getString(actionRequest, "email");
		String password = ParamUtil.get(actionRequest, "password", "");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "cconectado", false);
		String authType = CompanyConstants.AUTH_TYPE_EA;
		try {
			AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
			
			actionResponse.sendRedirect("/");
		}catch (Exception e) {
			actionRequest.setAttribute("ERROR", "1");
		}
		

	}

}
