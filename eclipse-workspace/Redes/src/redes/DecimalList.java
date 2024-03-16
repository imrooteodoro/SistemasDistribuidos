package redes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DecimalList{
	private ArrayList<Decimal> dec = new ArrayList<Decimal>();
	
	public DecimalList() {
		super();
		this.dec = dec;
	}

	public void createDecList() {
		for(int i = 0; i<4;i++) {
			String decim = JOptionPane.showInputDialog("Insira o endereço");
			Decimal n = new Decimal(Integer.parseInt(decim));
			dec.add(n);
		}
	}
	public void exibirendereço() {
		for(int i = 0; i<dec.size();i++) {
			System.out.println(dec.get(i).getDecimal());
		}
	}
	public void calcdecimal() {
		for(int i = 0; i<dec.size();i++) {
			int n = dec.get(i).getDecimal();
			while(n>=1) {
				if(n>=128) {
					n-=128;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=64) {
					n-=64;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=32) {
					n-=32;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=16) {
					n-=16;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=8) {
					n-=8;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=4) {
					n-=4;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=2) {
					n-=2;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
				if(n>=1) {
					n-=1;
					System.out.print("1");
				}else {
					System.out.print("0");
				}
			}
			System.out.print(" . ");
		}
	}

}
