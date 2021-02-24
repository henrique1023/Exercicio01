package view;

import controller.RedeController;

public class Principal {

	public static void main(String[] args) {
		RedeController procIp = new RedeController();
		String os = procIp.os();
		procIp.ip(os);
		procIp.ping(os);
	}

}
