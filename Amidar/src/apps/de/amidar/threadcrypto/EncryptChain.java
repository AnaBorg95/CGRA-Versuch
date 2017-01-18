package de.amidar.threadcrypto;


public class EncryptChain {
	public static void main(String[] args) throws InterruptedException{
		byte[] result;
		byte[] key = {
			    (byte)61,  (byte)182, (byte)188, (byte)145, 
			    (byte)64,  (byte)118, (byte)78,  (byte)3,
			    (byte)42,  (byte)171, (byte)130, (byte)235, 
			    (byte)249, (byte)88,  (byte)208, (byte)21,
			    (byte)79,  (byte)63,  (byte)210, (byte)74, 
			    (byte)41,  (byte)88,  (byte)203, (byte)45,
			    (byte)236, (byte)141, (byte)92,  (byte)219,
			    (byte)1,   (byte)63,  (byte)9,   (byte)108
			    };
		byte[] data = {	
			    (byte)17,  (byte)234, (byte)58, (byte)177,
			    (byte)143, (byte)222, (byte)27, (byte)162, 
			    (byte)155, (byte)39,  (byte)49, (byte)174,
			    (byte)241, (byte)10,  (byte)43, (byte)99,
			    (byte)17,  (byte)234, (byte)58, (byte)177,
			    (byte)143, (byte)222, (byte)27, (byte)162,
			    (byte)155, (byte)39,  (byte)49, (byte)174,
			    (byte)241, (byte)10,  (byte)43, (byte)99
			    };
		EncryptNode head, body, tail;
		Thread th, tb, tt;
		
		th = new Thread(head = new EncryptNode(new RC6(key, data)));
		tb = new Thread(body = new EncryptNode(new Serpent(key, null)));
		tt = new Thread(tail = new EncryptNode(new Twofish(key, null)));
		
		head.setPredecessor(null);
		head.setSuccessor(body);
		
		body.setPredecessor(head);
		body.setSuccessor(tail);
		
		tail.setPredecessor(body);
		tail.setSuccessor(null);
		
		tt.start();
		tb.start();
		th.start();
		synchronized(tt){
			while(tt.isAlive()){
				tt.wait(1);
			}
		}
		
		result = tail.getEncrypted();
		for(int i = 0 ; i < result.length; i++){
	    	System.out.print(result[i]);
	    	System.out.print(',');
	    }
	}
}
