package com.example.android1219.socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SocketThread extends Thread {


	private Map<Socket, String> clientMap = new HashMap<Socket, String>();
	private ServerSocket server;
	public static final int port = 12345;


	public SocketThread() {
		try {
			server = new ServerSocket(port);
			System.out.print("server start");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = server.accept();
				this.createClient(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print(e.getMessage());
			}
		}
	}


	private void createClient(Socket arg) {
		this.clientMap.put(arg, null);
		Client client = new Client(arg);
		client.start();
	}


	public void cancel() {
		Iterator<Map.Entry<Socket, String>> iter = this.clientMap.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Map.Entry<Socket, String> entry = iter.next();
			Socket socket = entry.getKey();
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			this.server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	class Client extends Thread {
		private Socket s;


		public Client(Socket arg) {
			this.s = arg;
		}


		@Override
		public void run() {
			try {
				Reader reader = new InputStreamReader(this.s.getInputStream());
				BufferedReader in = new BufferedReader(reader);
				PrintWriter out = new PrintWriter(this.s.getOutputStream());
				out.print("what is your name?\n");
				out.flush();
				String name = in.readLine();
				if (name != null) {
					clientMap.put(s, name);
					out.print("wellcome "+name+"\n");
					out.flush();
				} else
					this.removedClient(in, out, s);
				String arg = "";
				while ((arg = in.readLine()) != null) {
					if (arg.equals("exit")){
						this.removedClient(in, out, s);
						this.sendMes(arg,name);
						return;
					}
					this.sendMes(arg,name);
				}
				this.removedClient(in, out, s);


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		private void removedClient(BufferedReader in, PrintWriter out, Socket s) {
			try {
				in.close();
				out.close();
				s.close();
				clientMap.remove(s);
				System.out.print("remove socket");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


		private void sendMes(String arg,String name) {
			Iterator<Map.Entry<Socket, String>> iter = clientMap.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Map.Entry<Socket, String> entry = iter.next();
				Socket s = entry.getKey();
				//String name = entry.getValue();
				try {
					PrintWriter out = new PrintWriter(s.getOutputStream());
					out.print(name + " say:" + arg + "\n");
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


}

