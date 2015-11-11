<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<jsp:directive.include file="includes/top.jsp" />


<div class="box" id="login">
	<form:form method="post" id="fm1" commandName="${commandName}"
		htmlEscape="true">

		<form:errors path="*" id="msg" cssClass="errors" element="div"
			htmlEscape="false" />

		<section class="row">
			<label for="username"><spring:message
					code="screen.welcome.label.netid" /></label>
			<c:choose>
				<c:when test="${not empty sessionScope.openIdLocalId}">
					<strong>${sessionScope.openIdLocalId}</strong>
					<input type="hidden" id="username" name="username"
						value="${sessionScope.openIdLocalId}" />
				</c:when>
				<c:otherwise>
					<spring:message code="screen.welcome.label.netid.accesskey"
						var="userNameAccessKey" />
					<form:input cssClass="required" cssErrorClass="error" id="username"
						size="25" tabindex="1" accesskey="${userNameAccessKey}"
						path="username" autocomplete="off" htmlEscape="true" />
				</c:otherwise>
			</c:choose>
		</section>

		<section class="row">
			<label for="password"><spring:message
					code="screen.welcome.label.password" /></label>
			<%--
      NOTE: Certain browsers will offer the option of caching passwords for a user.  There is a non-standard attribute,
      "autocomplete" that when set to "off" will tell certain browsers not to prompt to cache credentials.  For more
      information, see the following web page:
      http://www.technofundo.com/tech/web/ie_autocomplete.html
      --%>
			<spring:message code="screen.welcome.label.password.accesskey"
				var="passwordAccessKey" />
			<form:password cssClass="required" cssErrorClass="error"
				id="password" size="25" tabindex="2" path="password"
				accesskey="${passwordAccessKey}" htmlEscape="true"
				autocomplete="off" />
		</section>


		<section>

			<label for="captcha"><spring:message
					code="screen.welcome.label.captcha" />:</label>

			<form:input cssClass="required" cssErrorClass="error" id="captcha"
				size="22" tabindex="3" path="captcha" autocomplete="off"
				htmlEscape="true" /><div>"${error}" </div>

			<img alt="必须输入验证码" src="Kaptcha.jpg"
				onclick="this.src='Kaptcha.jpg?'+Math.random();">



		</section>


		<section class="row btn-row">
			<input type="hidden" name="lt" value="${loginTicket}" /> <input
				type="hidden" name="execution" value="${flowExecutionKey}" /> <input
				type="hidden" name="_eventId" value="submit" /> <input
				class="btn-submit" name="submit" accesskey="l"
				value="<spring:message code="screen.welcome.button.login" />"
				tabindex="4" type="submit" /> <input class="btn-reset" name="reset"
				accesskey="c"
				value="<spring:message code="screen.welcome.button.clear" />"
				tabindex="5" type="reset" />
		</section>
	</form:form>
</div>