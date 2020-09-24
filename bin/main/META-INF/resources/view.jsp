<%@ include file="/init.jsp"%>



<% 
	String errorSubocolLogin = (String)renderRequest.getAttribute("ERROR");
%>

<portlet:actionURL name="/login" var="loginURL">
	<portlet:param name="mvcRenderCommandName" value="/login" />
</portlet:actionURL>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>


<div class="container-fluid">
	<img class="img-p" src="<%=renderRequest.getContextPath() %>/images/CardBaseFlat.png"/>
	<div class="Sign-in-to-Velocity">Ingresa a Orbika</div>

	<%if(errorSubocolLogin!=null){ %>
	<div class="title-error">Usuario o Contraseña incorrectos, por favor verifica</div>
	<%}%>

	<form action="<%=loginURL%>" method="post">
		<div class="Please-enter-your-cr">Por favor ingresa con tu
			correo y contraseña</div>

		<div class="title">USUARIO</div>
		<input class="Rectangle-usuario" name="<portlet:namespace/>email" type="email" />
		<div class="title-contrasena">CONTRASEÑA</div>
		
		<input class="Rectangle-contrasena"
			name="<portlet:namespace/>password" type="password" /> 
		<input class="Checkbox" name="<portlet:namespace/>cconectado" type="checkbox" value="true" />
		<div class="Vehicle-11283">Mantener conectado</div>
		<input class="Checkbox-conectado" name="ccontrasena" type="checkbox" value="" />
		<div class="Vehicle-11283-conectado">Recordar Contraseña</div>
		<!--<div class="recaptchaP">
		  <div class="g-recaptcha" data-sitekey="6Ldwh8wZAAAAALwo_BVwtRRStBo9cULeQhNc3HEe"></div>
		</div>-->
		
		<input class="basebo -Value" name="bingresar" type="submit"
			value="Ingresar" />
			
			 
	</form>
</div>




