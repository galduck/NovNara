package novNara;


public class OrderBean {

	private int no;//�ֹ���ȣ
	private int productNo;//�ֹ��� ��ǰ��ȣ
	private int quantity;//�ֹ�����
	private String date;//�ֹ���¥
	private String state;//�ֹ�����(�Ա�Ȯ����,�����,��ۿϷ�)
	private String id;//�ֹ���

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
