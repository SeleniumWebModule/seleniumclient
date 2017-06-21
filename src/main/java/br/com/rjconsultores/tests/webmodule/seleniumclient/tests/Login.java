package br.com.rjconsultores.tests.webmodule.seleniumclient.tests;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeID;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.ComponentType;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.FindBy;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.Tag;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.WaitFor;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.keyboard.KeyPressEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.mouse.MouseClickEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.System;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.rules.view.implem.RuleLogin;

public class Login {
	// SERÁ GERADA PELO APP WEB
	public static void main(String[] args) throws InterruptedException {
		System system = new System();
		processLogin(system.getLoginView());
		system.getViews().add(getUserView());
		system.getViews().add(getUserAdd());
		
		/*View usuario = openUserView(system);
		system.getViews().add(usuario);*/
		system.validate();
		
	}

	private static void processLogin(View viewLogin) {

		View view = viewLogin;
		view.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.LOGIN.name());
		view.getRulesPosLoad().add(new RuleLogin());
		

		Component user = new Component();
		user.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "j_username");
		user.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "gleimar");
		user.getEvents().add(new KeyPressEvent());
		view.getComponents().add(user);

		Component pass = new Component();
		pass.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "j_password");
		pass.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "gleimar");
		pass.getEvents().add(new KeyPressEvent());
		view.getComponents().add(pass);

		Component btnLogin = new Component();

		btnLogin.getAttributes().put(AttributeKey.FIND_BY, FindBy.TAG_NAME.name());
		btnLogin.getAttributes().put(AttributeKey.COMPONENT_NAME, AttributeID.INPUT.name());
		btnLogin.getAttributes().put(AttributeKey.COMPONENT_TYPE, ComponentType.BUTTON_SUBMIT.name());
		btnLogin.getAttributes().put(AttributeKey.ATTRIBUTE_ID, AttributeID.VALUE.name());
		btnLogin.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Acesso");
		btnLogin.getEvents().add(new MouseClickEvent());
		view.getComponents().add(btnLogin);
	}

	private static View getUserView() {
		View view = new View();
		view.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.VIEW.name());
		view.getAttributes().put(AttributeKey.VIEW_NAME, "Usuário");
		view.getAttributes().put(AttributeKey.FIND_BY, FindBy.CLASS_NAME.name());
		view.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-window-overlapped-header");
		
		Component menuSeguranca = new Component();
		menuSeguranca.getAttributes().put(AttributeKey.FIND_BY, FindBy.TAG_NAME.name());
		menuSeguranca.getAttributes().put(AttributeKey.COMPONENT_NAME, Tag.BUTTON.name());
		menuSeguranca.getAttributes().put(AttributeKey.COMPONENT_TYPE, ComponentType.MENU.name());
		menuSeguranca.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Segurança");
		menuSeguranca.getEvents().add(new MouseClickEvent());
		view.getComponents().add(menuSeguranca);
		
		Component menuUsuario = new Component();
		menuUsuario.getAttributes().put(AttributeKey.FIND_BY, FindBy.CLASS_NAME.name());
		//Quando o tipo de componente for um class-name o component name deverá-ser o nome da class, nesse caso component_name deverá ser entendido como class_name
		menuUsuario.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-menu-item-cnt");
		menuUsuario.getAttributes().put(AttributeKey.COMPONENT_TYPE, ComponentType.MENU.name());
		menuUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_ID, AttributeID.TEXT.name());
		menuUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Usuário");
		menuUsuario.getEvents().add(new MouseClickEvent());
		view.getComponents().add(menuUsuario);		
		
		return view;
	}
	
	private static View getUserAdd() {
		View view = new View();
		view.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.VIEW.name());
		view.getAttributes().put(AttributeKey.VIEW_NAME, "Usuário");
		view.getAttributes().put(AttributeKey.FIND_BY, FindBy.CLASS_NAME.name());
		view.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-window-overlapped-header");
		
		
		Component btnIncluirUsuario = new Component();
		btnIncluirUsuario.getAttributes().put(AttributeKey.FIND_BY, FindBy.TAG_NAME.name());
		btnIncluirUsuario.getAttributes().put(AttributeKey.COMPONENT_NAME, Tag.BUTTON.name());
		btnIncluirUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_ID, AttributeID.TITLE.name());
		btnIncluirUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Incluir");
		btnIncluirUsuario.getEvents().add(new MouseClickEvent());
		view.getComponents().add(btnIncluirUsuario);
		
		return view;
	}

	private static View validateTabsUserAdd() {
		/*View view = new View();
		Attribute attr = new Attribute(name, value);
		
		
		view.getAttributes().add(new Attribute("z-window-highlighted-header", "Usuário", ComponentAttributeKey.XPATH_INPUT_VALUE));
		
		Component tabUsuario = new Component();
		tabUsuario.getAttributes().add(new Attribute(identifier, value, type))*/
		
		return null;
	}
}
