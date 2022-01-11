package novNara;

import java.util.Hashtable;

//��ٱ��� ��� : DB���� X, ���ǿ� ���
public class CartMgr {

	//key:��ǰ��ȣ, value : �ֹ���ü
	private Hashtable<Integer, OrderBean> hCart =
			new Hashtable<Integer, OrderBean>();
	
	//Cart Add : ������ ��ٱ��� �ִ� ����� �������, ���� ��츦 �������� ����
	public void addCart(OrderBean order) {
		int productNo = order.getProductNo();
		int quantity = order.getQuantity();
		if(quantity>0) {
			if(hCart.containsKey(productNo)) {//������ ��ٱ��Ͽ� ��ǰ�� �ִ� ���
				//��ٱ��Ͽ� ���� �ֹ� ��ü�� ������
				OrderBean temp = hCart.get(productNo);
				//������ ������ ���ο� �ֹ��� ������ ���Ѵ�.
				quantity +=temp.getQuantity();
				order.setQuantity(quantity);
				//������ ������ ��ü�� ��ٱ��� ����
				hCart.put(productNo, order);
			}else {//������ ��ٱ��Ͽ� ��ǰ�� ���� ���
				hCart.put(productNo, order);
			}
		}
	}
	
	//Cart Update
	public void updateCart(OrderBean order) {
		//int -> Integer : AutoBoxing
		hCart.put(order.getProductNo(), order);
	}
	//Cart Delete
	public void deleteCart(OrderBean order) {
		//��ǰ��ȣ�� hCart�� ��ü�� ã�Ƽ� ����
		hCart.remove(order.getProductNo());
	}
	//Cart List
	public Hashtable<Integer, OrderBean> getCartList(){
		return hCart;
	}
}








