package br.com.rjconsultores.tests.webmodule.seleniumclient.tests;

import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeID;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.AttributeKey;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.IdentifyBy;
import br.com.rjconsultores.tests.webmodule.seleniumcore.enums.WaitFor;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.keyboard.KeyPressEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.events.implem.component.mouse.MouseClickEvent;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.Component;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.System;
import br.com.rjconsultores.tests.webmodule.seleniumcore.system.View;

public class Login {
	// SERÁ GERADA PELO APP WEB
	public static void main(String[] args) throws InterruptedException {
		System system = new System();
		processLogin(system.getLoginView());
		
		//system.getViews().add(getUserView());
		/*system.getViews().add(getUserAdd());
		system.getViews().add(validateTabsUserAdd());*/
		
		system.validate();
	}

	private static void processLogin(View viewLogin) {

		View view = viewLogin;
		
		Component user = new Component();
		user.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.TAG_NAME.getDescription());
		user.getAttributes().put(AttributeKey.VALUE_FIND_COMPONENT_BY, "input");
		user.getAttributes().put(AttributeKey.FIND_ATTRIBUTE_BY, "name");
		user.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "j_username");
		user.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "gleimar");
		user.getEvents().add(new KeyPressEvent());
		view.getComponents().add(user);

		Component pass = new Component();
		pass.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.TAG_NAME.getDescription());
		pass.getAttributes().put(AttributeKey.VALUE_FIND_COMPONENT_BY, "input");
		pass.getAttributes().put(AttributeKey.FIND_ATTRIBUTE_BY, "name");
		pass.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "j_password");
		pass.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "gleimar");
		pass.getEvents().add(new KeyPressEvent());
		view.getComponents().add(pass);

		Component btnLogin = new Component();
		btnLogin.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.TAG_NAME.getDescription());
		btnLogin.getAttributes().put(AttributeKey.VALUE_FIND_COMPONENT_BY, "input");
		btnLogin.getAttributes().put(AttributeKey.FIND_ATTRIBUTE_BY, "value");
		btnLogin.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "Acesso");
		btnLogin.getEvents().add(new MouseClickEvent());
		view.getComponents().add(btnLogin);
	}

	private static View getUserView() {
		View view = new View();
		//view.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.COMPONENT.name());
		//view.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-menubar-hor");
		
		Component menuSeguranca = new Component();
		menuSeguranca.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.COMPONENT.name());
		menuSeguranca.getAttributes().put(AttributeKey.VALUE_WAIT_FOR, "z-menubar-hor");
		menuSeguranca.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.CLASS_NAME.getDescription());
		menuSeguranca.getAttributes().put(AttributeKey.VALUE_FIND_COMPONENT_BY, "z-menu-btn");
		menuSeguranca.getAttributes().put(AttributeKey.FIND_ATTRIBUTE_BY, "text");
		menuSeguranca.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "Segurança");
		menuSeguranca.getEvents().add(new MouseClickEvent());
		view.getComponents().add(menuSeguranca);
		
	/*	Component menuUsuario = new Component();
		menuUsuario.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.CLASS_NAME.name());
		//Quando o tipo de componente for um class-name o component name deverá-ser o nome da class, nesse caso component_name deverá ser entendido como class_name
		//menuUsuario.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-menu-item-cnt");
		menuUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_ID, AttributeID.TEXT.name());
		menuUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Usuário");
		menuUsuario.getEvents().add(new MouseClickEvent());
		view.getComponents().add(menuUsuario);		*/
		
		return view;
	}
	
	private static View getUserAdd() {
		View view = new View();
		view.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.VIEW.name());
		view.getAttributes().put(AttributeKey.VIEW_NAME, "Usuário");
		view.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.CLASS_NAME.name());
		//view.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-window-overlapped-header");
		
		
		Component btnIncluirUsuario = new Component();
		btnIncluirUsuario.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.TAG_NAME.name());
		//btnIncluirUsuario.getAttributes().put(AttributeKey.COMPONENT_NAME, Tag.BUTTON.name());
		btnIncluirUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_ID, AttributeID.TITLE.name());
		btnIncluirUsuario.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Incluir");
		btnIncluirUsuario.getEvents().add(new MouseClickEvent());
		view.getComponents().add(btnIncluirUsuario);
		
		return view;
	}

	private static View validateTabsUserAdd() {
		View view = new View();
		view.getAttributes().put(AttributeKey.WAIT_FOR, WaitFor.COMPONENT.name());
		//view.getAttributes().put(AttributeKey.COMPONENT_NAME, "Usuário");
		view.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.CLASS_NAME.name());
		//view.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-tab-text");
		
		Component inputBoxLogin = new Component();
		inputBoxLogin.getAttributes().put(AttributeKey.FIND_PARENT_BY, IdentifyBy.TAG_NAME.name());
		inputBoxLogin.getAttributes().put(AttributeKey.PARENT_ELEMENT,"td");
		inputBoxLogin.getAttributes().put(AttributeKey.FIND_CHILD_BY, IdentifyBy.CLASS_NAME.name());
		inputBoxLogin.getAttributes().put(AttributeKey.CHILD_VALUE, "Login");
		inputBoxLogin.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "z-textbox");
		inputBoxLogin.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "seleniumuser");
		inputBoxLogin.getEvents().add(new KeyPressEvent());
		view.getComponents().add(inputBoxLogin);
		
		Component inputBoxUserName = new Component();
		inputBoxUserName.getAttributes().put(AttributeKey.FIND_PARENT_BY, IdentifyBy.TAG_NAME.name());
		inputBoxUserName.getAttributes().put(AttributeKey.PARENT_ELEMENT,"td");
		inputBoxUserName.getAttributes().put(AttributeKey.FIND_CHILD_BY, IdentifyBy.CLASS_NAME.name());
		inputBoxUserName.getAttributes().put(AttributeKey.SIBLING_VALUE, "Nome Usuário");
		inputBoxUserName.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "z-textbox");
		inputBoxUserName.getAttributes().put(AttributeKey.CHILD_VALUE, "User Selenium Boot");
		inputBoxUserName.getEvents().add(new KeyPressEvent());
		view.getComponents().add(inputBoxUserName);
		
		String senha = "abc123ABC";
		
		Component inputBoxPassword = new Component();
		inputBoxPassword.getAttributes().put(AttributeKey.FIND_PARENT_BY, IdentifyBy.TAG_NAME.name());
		inputBoxPassword.getAttributes().put(AttributeKey.PARENT_ELEMENT,"td");
		inputBoxPassword.getAttributes().put(AttributeKey.FIND_CHILD_BY, IdentifyBy.CLASS_NAME.name());
		inputBoxPassword.getAttributes().put(AttributeKey.SIBLING_VALUE, "Senha");
		inputBoxPassword.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "z-textbox");
		inputBoxPassword.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, senha);
		inputBoxPassword.getEvents().add(new KeyPressEvent());
		view.getComponents().add(inputBoxPassword);
		
		Component inputBoxPasswordAgain = new Component();
		inputBoxPasswordAgain.getAttributes().put(AttributeKey.FIND_PARENT_BY, IdentifyBy.TAG_NAME.name());
		inputBoxPasswordAgain.getAttributes().put(AttributeKey.PARENT_ELEMENT,"td");
		inputBoxPasswordAgain.getAttributes().put(AttributeKey.FIND_CHILD_BY, IdentifyBy.CLASS_NAME.name());
		inputBoxPasswordAgain.getAttributes().put(AttributeKey.SIBLING_VALUE, "Confirmar senha");
		inputBoxPasswordAgain.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "z-textbox");
		inputBoxPasswordAgain.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, senha);
		inputBoxPasswordAgain.getEvents().add(new KeyPressEvent());
		view.getComponents().add(inputBoxPasswordAgain);
		
		Component selectPerfilAdministrador = new Component();
		selectPerfilAdministrador.getAttributes().put(AttributeKey.FIND_PARENT_BY, IdentifyBy.TAG_NAME.name());
		selectPerfilAdministrador.getAttributes().put(AttributeKey.PARENT_ELEMENT,"td");
		selectPerfilAdministrador.getAttributes().put(AttributeKey.FIND_CHILD_BY, IdentifyBy.TAG_NAME.name());
		selectPerfilAdministrador.getAttributes().put(AttributeKey.SIBLING_VALUE, "Perfil");
		selectPerfilAdministrador.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "input");
		selectPerfilAdministrador.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "ADMINISTRADOR");
		selectPerfilAdministrador.getAttributes().put(AttributeKey.SELECT_IDXVALUE, "2");
		//selectPerfilAdministrador.getEvents().add(new ListBoxEvent());
		view.getComponents().add(selectPerfilAdministrador);
		
		/*Component btnSalvar = new Component();
		btnSalvar.getAttributes().put(AttributeKey.FIND_BY, IdentifyBy.TAG_NAME.name());
		btnSalvar.getAttributes().put(AttributeKey.COMPONENT_NAME, Tag.BUTTON.name());
		btnSalvar.getAttributes().put(AttributeKey.ATTRIBUTE_ID, AttributeID.TITLE.name());
		btnSalvar.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Salvar");
		btnSalvar.getEvents().add(new MouseClickEvent());
		view.getComponents().add(btnSalvar);*/
		
		Component tabLocalizacao = new Component();
		tabLocalizacao.getAttributes().put(AttributeKey.FIND_COMPONENT_BY, IdentifyBy.CLASS_NAME.name());
		//tabLocalizacao.getAttributes().put(AttributeKey.COMPONENT_NAME, "z-tab-text");
		tabLocalizacao.getAttributes().put(AttributeKey.ATTRIBUTE_ID, "text");
		tabLocalizacao.getAttributes().put(AttributeKey.ATTRIBUTE_VALUE, "Localização");
		tabLocalizacao.getEvents().add(new MouseClickEvent());
		view.getComponents().add(tabLocalizacao);
				
		return view;
	}
}
