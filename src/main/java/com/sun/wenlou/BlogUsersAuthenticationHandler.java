package com.sun.wenlou;

import java.security.GeneralSecurityException;

import javax.security.auth.login.FailedLoginException;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;

import com.sun.cas.account.service.impl.AccountServiceImpl;

public class BlogUsersAuthenticationHandler extends
		AbstractUsernamePasswordAuthenticationHandler {
	private AccountServiceImpl accountService;

	@Override
	protected HandlerResult authenticateUsernamePasswordInternal(
			UsernamePasswordCredential credential)
			throws GeneralSecurityException, PreventedException {

		String username = credential.getUsername();
		String password = credential.getPassword();

		boolean flag = accountService.checkAccount(username, password);
		if (!flag) {
			throw new FailedLoginException();
		}
		return createHandlerResult(credential, new SimplePrincipal(username),
				null);
	}

	public AccountServiceImpl getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountServiceImpl accountService) {
		this.accountService = accountService;
	}

}
