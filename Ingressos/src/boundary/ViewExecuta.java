package boundary;

import control.CtrlIngresso;
import entity.Ingresso;

public class ViewExecuta {

	public static void main(String[] args) {
		CtrlIngresso ctrlIngresso = new CtrlIngresso();
		Ingresso ingresso = ctrlIngresso.IngressoCalcula("27/10/2015", "Estudantes", false,8.0);
		System.out.println(ingresso.getDesconto());
		ingresso = ctrlIngresso.IngressoCalcula("27/10/2015", "Idoso", false,6);
		System.out.println(ingresso.getDesconto());
		ingresso = ctrlIngresso.IngressoCalcula("27/10/2015", "Crianca", false,5.6);
		System.out.println(ingresso.getDesconto());
	}
}
