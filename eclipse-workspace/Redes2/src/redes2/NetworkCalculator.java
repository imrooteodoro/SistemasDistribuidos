package redes2;
import java.net.InetAddress;
import java.nio.ByteBuffer;

import javax.swing.JOptionPane;

public class NetworkCalculator {

    public static void main(String[] args) throws Exception {
        
        String ipAddress = JOptionPane.showInputDialog("Insira o endereço ip");
        String prefix = JOptionPane.showInputDialog("Insira o prefixo");
        int prefixLength = Integer.parseInt(prefix);

        InetAddress networkAddress = calculateNetworkAddress(ipAddress, prefixLength);
        InetAddress broadcastAddress = calculateBroadcastAddress(networkAddress, prefixLength);

        JOptionPane.showMessageDialog(null,"Endereço de rede: " + networkAddress.getHostAddress() + "\n"
        		+ "Endereço de Broadcast: " + broadcastAddress.getHostAddress()+ "\n"
        		+ "Número total de endereços: " + (int) Math.pow(2,(32- prefixLength)) + "\n" +
        		"Número de endereços utilizáveis para hosts: " + ((int)Math.pow(2, (32 - prefixLength))-2));
    }

    private static InetAddress calculateNetworkAddress(String ip, int prefixLength) throws Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        byte[] bytes = ipAddress.getAddress();
        int mask = 0xffffffff << (32 - prefixLength);
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(mask);
        byte[] maskBytes = buffer.array();
        byte[] networkBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            networkBytes[i] = (byte) (bytes[i] & maskBytes[i % Integer.BYTES]);
        }
        return InetAddress.getByAddress(networkBytes);
    }

    private static InetAddress calculateBroadcastAddress(InetAddress networkAddress, int prefixLength) throws Exception {
        byte[] bytes = networkAddress.getAddress();
        int mask = (1 << (32 - prefixLength)) - 1;
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(mask);
        byte[] maskBytes = buffer.array();
        byte[] broadcastBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            broadcastBytes[i] = (byte) (bytes[i] | maskBytes[i % Integer.BYTES]);
        }
        return InetAddress.getByAddress(broadcastBytes);
    }
}
