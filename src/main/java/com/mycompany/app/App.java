package com.mycompany.app;

import java.io.IOException;

import com.mycompany.controller.ApplicationController;

public class App {

	public static void main(String[] args) throws IOException {

		ApplicationController applicationController = new ApplicationController();
		applicationController.init();
	}

}
