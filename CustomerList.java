package �ͻ���Ϣ����;
/* �����װ������Ϣ��
  Customer[] customers����������ͻ����������
  int total = 0                 ����¼�ѱ���ͻ����������
  ���������ṩ���¹������ͷ�����
  public CustomerList(int totalCustomer)
  public boolean addCustomer(Customer customer)
  public boolean replaceCustomer(int index, Customer cust)
  public boolean deleteCustomer(int index)
  public Customer[] getAllCustomers()
  public Customer getCustomer(int index)
  public int getTotal()*/
public class CustomerList {
    Customer[] customers;//��������ͻ����������
    int total = 0;//��¼�ѱ���ͻ����������
    int totalCustomer=0;//�ͻ�����
    public CustomerList(){
        customers = new Customer[100];
        for (int i = 0; i < customers.length; i++) customers[i] = new Customer();
    }
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
        for (int i = 0; i < customers.length; i++) customers[i] = new Customer();
        this.totalCustomer=totalCustomer;
    }
    public boolean addCustomer(Customer customer){
        if (customer == null) {
            System.out.println("�ͻ��������޷���ӣ�");
            return false;
        }
        customers[total++] = customer;
        return true;

    }
    public boolean replaceCustomer(int index, Customer customer){
        if (customer == null) {
            return false;
        }
        customers[index]=customer;
        return true;
    }
    public boolean deleteCustomer(int index){
        for (int i = index; i < total-1; i++) {
            customers[i]=customers[i+1];
        }
            total--;
            return true;
    }
    public Customer[] getAllCustomers(){
           return customers;
    }
    public Customer getCustomer(int index){
            return customers[index];
    }
    public int getTotal(){
        return total;
    }
}
